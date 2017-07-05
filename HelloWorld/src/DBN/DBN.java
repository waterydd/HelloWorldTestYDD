package DBN;
import java.util.Random;
import DBN.RBM;


public class DBN {
	public int N;
	public int n_ins;
	public int[] hidden_layer_sizes;
	public int n_outs;
	public int n_layers;
	public HiddenLayer[] sigmoid_layers;
	public RBM[] rbm_layers;
	public LogisticRegression log_layer;
	public Random rng;

	public static double sigmoid(double x) {
		return 1.0 / (1.0 + Math.pow(Math.E, -x));
	}
	
	//DBN 的构造函数  N 为样本的个数， n-ins 为特征个数， hidden_layer_sizes 为 隐藏层的结构， n-outs 为输出维数， n-layers 为隐藏层个数， rng 为随机数实例
	public DBN(int N, int n_ins, int[] hidden_layer_sizes, int n_outs, int n_layers, Random rng) {
		int input_size;
		
		this.N = N;  // 赋值样本数目
		this.n_ins = n_ins; //赋值特征个数
		this.hidden_layer_sizes = hidden_layer_sizes;  //赋值隐藏层结构
		this.n_outs = n_outs;   // 赋值输出维数
		this.n_layers = n_layers;   // 赋值隐藏层数目
		
		this.sigmoid_layers = new HiddenLayer[n_layers]; // 声明两个隐藏层
		this.rbm_layers = new RBM[n_layers];    //声明两个RBM对应每个隐藏层

		if(rng == null)	this.rng = new Random(1234);  // 获取一个随机数值
		else this.rng = rng;		
		
		// construct multi-layer  初始化每个隐藏层
		for(int i=0; i<this.n_layers; i++) {
			if(i == 0) {
				input_size = this.n_ins;   //第一层隐藏层的输入为样本的特征的个数
			} else {
				input_size = this.hidden_layer_sizes[i-1]; // 后面的隐藏层的输入为上一层隐藏层的输出，也就是上一层的隐藏层节点的个数。
			}
			 // sigmoid 层是用来计算的， rbm 是用来调整 w , b , c 的
			// construct sigmoid_layer  初始化每个隐藏层  ， 初始化做的事情就是给W和b赋随机值
			this.sigmoid_layers[i] = new HiddenLayer(this.N, input_size, this.hidden_layer_sizes[i], null, null, rng);
			
			// construct rbm_layer   初始化玻尔兹曼机，其实也就是初始化，W， b , c 其中，w , b 用的是hiddenlayer的
			this.rbm_layers[i] = new RBM(this.N, input_size, this.hidden_layer_sizes[i], this.sigmoid_layers[i].W, this.sigmoid_layers[i].b, null, rng);
		}
		//在完成每一层的构建之后，构建一个输出的逻辑回归层
		// layer for output using LogisticRegression， 参数为样本个数N， 输入为网络结构最后一层的输出数， 输出为DBM网络设置的输出维数
		this.log_layer = new LogisticRegression(this.N, this.hidden_layer_sizes[this.n_layers-1], this.n_outs);
	}
	
	//对DBN网络进行一个预训练，目的是为每一层先构造更好的W和b， 先使得网络更好的拟合样本的分布，类似于先把点放在最后值的附近
	public void pretrain(int[][] train_X, double lr, int k, int epochs) {
		//输入训练样本， 学习率lr ， CD-k =1 , epochs=1000
		int[] layer_input = null ;
		int prev_layer_input_size;
		int[] prev_layer_input;
				
		for(int i=0; i<n_layers; i++) {  // layer-wise	迭代每一个层	 
			for(int epoch=0; epoch<epochs; epoch++) {  // training epochs  每个层都迭代优化epochs次 
				for(int n=0; n<N; n++) {  // input x1...xN  每一层都遍历每个训练样本 ， 这种方式相当于是随机梯度下降
					// layer input
					for(int l=0; l<=i; l++) { //从前面训练好的每一层开始迭代 ，假设有3层，i=2 ， 0，1，2 迭代3次
						if(l == 0) { // l=0 的时候只是获取数据的特征
							layer_input = new int[n_ins]; //第一层的输入维度为样本的特征数
							for(int j=0; j<n_ins; j++) layer_input[j] = train_X[n][j]; //遍历第i个样本的第j个特征赋值给layer _input
							// 也就是第一层处理的数据是样本的原始的特征。
						} else {    // 如果不是第一层的话，本层处理的数据是上一层的输出
							if(l == 1) prev_layer_input_size = n_ins; // l = 1 的时候输入的维度为原始数据的特征数
							else prev_layer_input_size = hidden_layer_sizes[l-2];
							
							prev_layer_input = new int[prev_layer_input_size]; // 声明这一层的输入数据维度
							for(int j=0; j<prev_layer_input_size; j++) prev_layer_input[j] = layer_input[j];
							//这一层的输入数据是上一层的输出，l=0的时候pre_layer_input 为 traning data
							
							layer_input = new int[hidden_layer_sizes[l-1]]; // layer_input其实就是这一层的输出
							
							//给定上一层的输出数据作为本层的输入数据，计算出本层的输出， 就只是单纯的利用rb,修改后的w ,b来作出计算
							sigmoid_layers[l-1].sample_h_given_v(prev_layer_input, layer_input);
						}
					}
					// 在rbm 层上 ， 根据输入 layer_input 和学习率lr ，对　 w  b  c 进行调整  , 同时每一个数据都要进行调整
					rbm_layers[i].contrastive_divergence(layer_input, lr, k);
				} // end for every training data
			}//end for epochs
		}// end for layer-wise
	}
	
	// 使用finetune 进行微调 ， 这里是有监督学习
	public void finetune(int[][] train_X, int[][] train_Y, double lr, int epochs) {
		int[] layer_input = new int[0];
		// int prev_layer_input_size;
		int[] prev_layer_input = null ;
		
		for(int epoch=0; epoch<epochs; epoch++) {//迭代epochs 次
			for(int n=0; n<N; n++) {  //遍历所有的输入数据样本
				// layer input
				for(int i=0; i<n_layers; i++) {
					if(i == 0) {
						prev_layer_input = new int[n_ins]; // 如果是第一层的话，输入就是数据样本的维度
						for(int j=0; j<n_ins; j++) prev_layer_input[j] = train_X[n][j]; //获取输入数据
					} else {
						prev_layer_input = new int[hidden_layer_sizes[i-1]];
						for(int j=0; j<hidden_layer_sizes[i-1]; j++) prev_layer_input[j] = layer_input[j];
					}
					
					layer_input = new int[hidden_layer_sizes[i]];
					//第i层的sigmoid 层计算出本层的输出，作为下一层的输入layer_input
					sigmoid_layers[i].sample_h_given_v(prev_layer_input, layer_input);
				} // end for iter layer 
				//一个样本从头扫到尾， 遍历所有的层最后的输出保存在layer_input当中
				log_layer.train(layer_input, train_Y[n], lr); //log_layer是逻辑回归的对象， 用layer_input 和label 来做逻辑回归
			}  // end for iter data
			// lr *= 0.95;
		}// end for epochs 
	}
	
	public void predict(int[] x, double[] y) {  // 这里一次只处理一个样本
		double[] layer_input = new double[0];
		// int prev_layer_input_size;
		double[] prev_layer_input = new double[n_ins];
		for(int j=0; j<n_ins; j++) prev_layer_input[j] = x[j]; //最开始的输入是特征x
	
		double linear_output;
		
		
		// layer activation  迭代每一层
		for(int i=0; i<n_layers; i++) {  
			layer_input = new double[sigmoid_layers[i].n_out]; //后面层的输入是该层的输出
			
			for(int k=0; k < sigmoid_layers[i].n_out; k++) {  //遍历的是一个[n-out][n-in]的数组
				linear_output = 0.0; 
				for(int j=0; j<sigmoid_layers[i].n_in; j++) {
					linear_output += sigmoid_layers[i].W[k][j] * prev_layer_input[j];
				}
				linear_output += sigmoid_layers[i].b[k];
				layer_input[k] = sigmoid(linear_output);
			}
			
			if(i < n_layers-1) { // 上层的输出是layer_input , 做为下一层的输入
				prev_layer_input = new double[sigmoid_layers[i].n_out];
				for(int j=0; j<sigmoid_layers[i].n_out; j++) prev_layer_input[j] = layer_input[j];
			}
		} // end for iter layer
		
		for(int i=0; i<log_layer.n_out; i++) { //到最后一层的时候，做一个逻辑回归
			y[i] = 0;
			for(int j=0; j<log_layer.n_in; j++) {
				y[i] += log_layer.W[i][j] * layer_input[j];
			}
			y[i] += log_layer.b[i];
		}
		
		log_layer.softmax(y); //然后softmax 获得一个归一话的结果
	}
	
	private static void test_dbn() {
		Random rng = new Random(123);
		
		double pretrain_lr = 0.1; //pre-training 的学习率初始的时候设置为0.1
		int pretraining_epochs = 1000;  
		int k = 1;
		double finetune_lr = 0.1; // fine-tune 的学习率为0。1
		int finetune_epochs = 500;   //fine-turne 的迭代次数
		
		int train_N = 6;  // 训练数据集的个数,实际使用的时候最好不要用硬编码
		int test_N = 4;   // 测试数据集的个数
		int n_ins = 6;   //  特征的维数
		int n_outs = 2;   // 输出的维数
		int[] hidden_layer_sizes = {10, 9,8,7,6 };  //隐藏层的节点个数
		int n_layers = hidden_layer_sizes.length;  //设置了两个隐藏层
		
		// training data
		int[][] train_X = {
			{1, 1, 1, 0, 0, 0},
			{1, 0, 1, 0, 0, 0},
			{1, 1, 1, 0, 0, 0},
			{0, 0, 1, 1, 1, 0},
			{0, 0, 1, 1, 0, 0},
			{0, 0, 1, 1, 1, 0}
		};
		
		 
		int[][] train_Y = { // 用这样的表示来做二分类， 如果是多维的就是多分类，我他妈真是太聪明了
			{1, 0},
			{1, 0},
			{1, 0},
			{0, 1},
			{0, 1},
			{0, 1},
		};
		
		
		// construct DBN  初始化DBN网络 
		DBN dbn = new DBN(train_N, n_ins, hidden_layer_sizes, n_outs, n_layers, rng);
		
		// pretrain  初始化构造好网络进入pre-traning 阶段， 就是一层一层训练网络 , k=1 是CD 抽样只做一次
		dbn.pretrain(train_X, pretrain_lr, k, pretraining_epochs);
		
		// finetune  在pre-training 构造整个网络之后，用finetune 进行一次微调
		dbn.finetune(train_X, train_Y, finetune_lr, finetune_epochs);
		
		
		// test data
		int[][] test_X = {
			{1, 1, 0, 0, 0, 0},
			{1, 1, 1, 1, 0, 0},
			{0, 0, 0, 1, 1, 0},
			{0, 0, 1, 1, 1, 0},
		};
		
		double[][] test_Y = new double[test_N][n_outs];
		
		// test
		for(int i=0; i<test_N; i++) {
			dbn.predict(test_X[i], test_Y[i]); // 对每个输入数据test_x[i]和对应的label 进行预测 ， 值保存在test_Y数组中
			for(int j=0; j<n_outs; j++) {
				System.out.print(test_Y[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		test_dbn();
	}
}



