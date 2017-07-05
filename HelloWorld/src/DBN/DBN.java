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
	
	//DBN �Ĺ��캯��  N Ϊ�����ĸ����� n-ins Ϊ���������� hidden_layer_sizes Ϊ ���ز�Ľṹ�� n-outs Ϊ���ά���� n-layers Ϊ���ز������ rng Ϊ�����ʵ��
	public DBN(int N, int n_ins, int[] hidden_layer_sizes, int n_outs, int n_layers, Random rng) {
		int input_size;
		
		this.N = N;  // ��ֵ������Ŀ
		this.n_ins = n_ins; //��ֵ��������
		this.hidden_layer_sizes = hidden_layer_sizes;  //��ֵ���ز�ṹ
		this.n_outs = n_outs;   // ��ֵ���ά��
		this.n_layers = n_layers;   // ��ֵ���ز���Ŀ
		
		this.sigmoid_layers = new HiddenLayer[n_layers]; // �����������ز�
		this.rbm_layers = new RBM[n_layers];    //��������RBM��Ӧÿ�����ز�

		if(rng == null)	this.rng = new Random(1234);  // ��ȡһ�������ֵ
		else this.rng = rng;		
		
		// construct multi-layer  ��ʼ��ÿ�����ز�
		for(int i=0; i<this.n_layers; i++) {
			if(i == 0) {
				input_size = this.n_ins;   //��һ�����ز������Ϊ�����������ĸ���
			} else {
				input_size = this.hidden_layer_sizes[i-1]; // ��������ز������Ϊ��һ�����ز�������Ҳ������һ������ز�ڵ�ĸ�����
			}
			 // sigmoid ������������ģ� rbm ���������� w , b , c ��
			// construct sigmoid_layer  ��ʼ��ÿ�����ز�  �� ��ʼ������������Ǹ�W��b�����ֵ
			this.sigmoid_layers[i] = new HiddenLayer(this.N, input_size, this.hidden_layer_sizes[i], null, null, rng);
			
			// construct rbm_layer   ��ʼ����������������ʵҲ���ǳ�ʼ����W�� b , c ���У�w , b �õ���hiddenlayer��
			this.rbm_layers[i] = new RBM(this.N, input_size, this.hidden_layer_sizes[i], this.sigmoid_layers[i].W, this.sigmoid_layers[i].b, null, rng);
		}
		//�����ÿһ��Ĺ���֮�󣬹���һ��������߼��ع��
		// layer for output using LogisticRegression�� ����Ϊ��������N�� ����Ϊ����ṹ���һ���������� ���ΪDBM�������õ����ά��
		this.log_layer = new LogisticRegression(this.N, this.hidden_layer_sizes[this.n_layers-1], this.n_outs);
	}
	
	//��DBN�������һ��Ԥѵ����Ŀ����Ϊÿһ���ȹ�����õ�W��b�� ��ʹ��������õ���������ķֲ����������Ȱѵ�������ֵ�ĸ���
	public void pretrain(int[][] train_X, double lr, int k, int epochs) {
		//����ѵ�������� ѧϰ��lr �� CD-k =1 , epochs=1000
		int[] layer_input = null ;
		int prev_layer_input_size;
		int[] prev_layer_input;
				
		for(int i=0; i<n_layers; i++) {  // layer-wise	����ÿһ����	 
			for(int epoch=0; epoch<epochs; epoch++) {  // training epochs  ÿ���㶼�����Ż�epochs�� 
				for(int n=0; n<N; n++) {  // input x1...xN  ÿһ�㶼����ÿ��ѵ������ �� ���ַ�ʽ�൱��������ݶ��½�
					// layer input
					for(int l=0; l<=i; l++) { //��ǰ��ѵ���õ�ÿһ�㿪ʼ���� ��������3�㣬i=2 �� 0��1��2 ����3��
						if(l == 0) { // l=0 ��ʱ��ֻ�ǻ�ȡ���ݵ�����
							layer_input = new int[n_ins]; //��һ�������ά��Ϊ������������
							for(int j=0; j<n_ins; j++) layer_input[j] = train_X[n][j]; //������i�������ĵ�j��������ֵ��layer _input
							// Ҳ���ǵ�һ�㴦���������������ԭʼ��������
						} else {    // ������ǵ�һ��Ļ������㴦�����������һ������
							if(l == 1) prev_layer_input_size = n_ins; // l = 1 ��ʱ�������ά��Ϊԭʼ���ݵ�������
							else prev_layer_input_size = hidden_layer_sizes[l-2];
							
							prev_layer_input = new int[prev_layer_input_size]; // ������һ�����������ά��
							for(int j=0; j<prev_layer_input_size; j++) prev_layer_input[j] = layer_input[j];
							//��һ���������������һ��������l=0��ʱ��pre_layer_input Ϊ traning data
							
							layer_input = new int[hidden_layer_sizes[l-1]]; // layer_input��ʵ������һ������
							
							//������һ������������Ϊ������������ݣ���������������� ��ֻ�ǵ���������rb,�޸ĺ��w ,b����������
							sigmoid_layers[l-1].sample_h_given_v(prev_layer_input, layer_input);
						}
					}
					// ��rbm ���� �� �������� layer_input ��ѧϰ��lr ���ԡ� w  b  c ���е���  , ͬʱÿһ�����ݶ�Ҫ���е���
					rbm_layers[i].contrastive_divergence(layer_input, lr, k);
				} // end for every training data
			}//end for epochs
		}// end for layer-wise
	}
	
	// ʹ��finetune ����΢�� �� �������мලѧϰ
	public void finetune(int[][] train_X, int[][] train_Y, double lr, int epochs) {
		int[] layer_input = new int[0];
		// int prev_layer_input_size;
		int[] prev_layer_input = null ;
		
		for(int epoch=0; epoch<epochs; epoch++) {//����epochs ��
			for(int n=0; n<N; n++) {  //�������е�������������
				// layer input
				for(int i=0; i<n_layers; i++) {
					if(i == 0) {
						prev_layer_input = new int[n_ins]; // ����ǵ�һ��Ļ��������������������ά��
						for(int j=0; j<n_ins; j++) prev_layer_input[j] = train_X[n][j]; //��ȡ��������
					} else {
						prev_layer_input = new int[hidden_layer_sizes[i-1]];
						for(int j=0; j<hidden_layer_sizes[i-1]; j++) prev_layer_input[j] = layer_input[j];
					}
					
					layer_input = new int[hidden_layer_sizes[i]];
					//��i���sigmoid ������������������Ϊ��һ�������layer_input
					sigmoid_layers[i].sample_h_given_v(prev_layer_input, layer_input);
				} // end for iter layer 
				//һ��������ͷɨ��β�� �������еĲ��������������layer_input����
				log_layer.train(layer_input, train_Y[n], lr); //log_layer���߼��ع�Ķ��� ��layer_input ��label �����߼��ع�
			}  // end for iter data
			// lr *= 0.95;
		}// end for epochs 
	}
	
	public void predict(int[] x, double[] y) {  // ����һ��ֻ����һ������
		double[] layer_input = new double[0];
		// int prev_layer_input_size;
		double[] prev_layer_input = new double[n_ins];
		for(int j=0; j<n_ins; j++) prev_layer_input[j] = x[j]; //�ʼ������������x
	
		double linear_output;
		
		
		// layer activation  ����ÿһ��
		for(int i=0; i<n_layers; i++) {  
			layer_input = new double[sigmoid_layers[i].n_out]; //�����������Ǹò�����
			
			for(int k=0; k < sigmoid_layers[i].n_out; k++) {  //��������һ��[n-out][n-in]������
				linear_output = 0.0; 
				for(int j=0; j<sigmoid_layers[i].n_in; j++) {
					linear_output += sigmoid_layers[i].W[k][j] * prev_layer_input[j];
				}
				linear_output += sigmoid_layers[i].b[k];
				layer_input[k] = sigmoid(linear_output);
			}
			
			if(i < n_layers-1) { // �ϲ�������layer_input , ��Ϊ��һ�������
				prev_layer_input = new double[sigmoid_layers[i].n_out];
				for(int j=0; j<sigmoid_layers[i].n_out; j++) prev_layer_input[j] = layer_input[j];
			}
		} // end for iter layer
		
		for(int i=0; i<log_layer.n_out; i++) { //�����һ���ʱ����һ���߼��ع�
			y[i] = 0;
			for(int j=0; j<log_layer.n_in; j++) {
				y[i] += log_layer.W[i][j] * layer_input[j];
			}
			y[i] += log_layer.b[i];
		}
		
		log_layer.softmax(y); //Ȼ��softmax ���һ����һ���Ľ��
	}
	
	private static void test_dbn() {
		Random rng = new Random(123);
		
		double pretrain_lr = 0.1; //pre-training ��ѧϰ�ʳ�ʼ��ʱ������Ϊ0.1
		int pretraining_epochs = 1000;  
		int k = 1;
		double finetune_lr = 0.1; // fine-tune ��ѧϰ��Ϊ0��1
		int finetune_epochs = 500;   //fine-turne �ĵ�������
		
		int train_N = 6;  // ѵ�����ݼ��ĸ���,ʵ��ʹ�õ�ʱ����ò�Ҫ��Ӳ����
		int test_N = 4;   // �������ݼ��ĸ���
		int n_ins = 6;   //  ������ά��
		int n_outs = 2;   // �����ά��
		int[] hidden_layer_sizes = {10, 9,8,7,6 };  //���ز�Ľڵ����
		int n_layers = hidden_layer_sizes.length;  //�������������ز�
		
		// training data
		int[][] train_X = {
			{1, 1, 1, 0, 0, 0},
			{1, 0, 1, 0, 0, 0},
			{1, 1, 1, 0, 0, 0},
			{0, 0, 1, 1, 1, 0},
			{0, 0, 1, 1, 0, 0},
			{0, 0, 1, 1, 1, 0}
		};
		
		 
		int[][] train_Y = { // �������ı�ʾ���������࣬ ����Ƕ�ά�ľ��Ƕ���࣬����������̫������
			{1, 0},
			{1, 0},
			{1, 0},
			{0, 1},
			{0, 1},
			{0, 1},
		};
		
		
		// construct DBN  ��ʼ��DBN���� 
		DBN dbn = new DBN(train_N, n_ins, hidden_layer_sizes, n_outs, n_layers, rng);
		
		// pretrain  ��ʼ��������������pre-traning �׶Σ� ����һ��һ��ѵ������ , k=1 ��CD ����ֻ��һ��
		dbn.pretrain(train_X, pretrain_lr, k, pretraining_epochs);
		
		// finetune  ��pre-training ������������֮����finetune ����һ��΢��
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
			dbn.predict(test_X[i], test_Y[i]); // ��ÿ����������test_x[i]�Ͷ�Ӧ��label ����Ԥ�� �� ֵ������test_Y������
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



