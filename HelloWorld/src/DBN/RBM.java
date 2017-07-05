package DBN;
import java.util.Random;




public class RBM {
	public int N;
	public int n_visible;
	public int n_hidden;
	public double[][] W;
	public double[] hbias;
	public double[] vbias;
	public Random rng;
	
	public double uniform(double min, double max) {
		return rng.nextDouble() * (max - min) + min;
	}
	
	public int binomial(int n, double p) {
		if(p < 0 || p > 1) return 0;
		
		int c = 0;
		double r;
		
		for(int i=0; i<n; i++) {
			r = rng.nextDouble(); //ȡһ�������
			if (r < p) c++;  //��������Ը���p ����0������1
		}
		
		return c;
	}
	
	public static double sigmoid(double x) {
		return 1.0 / (1.0 + Math.pow(Math.E, -x));
	}
	
	//RBM �Ĺ��캯��
	public RBM(int N, int n_visible, int n_hidden, 
			double[][] W, double[] hbias, double[] vbias, Random rng) {
		this.N = N;  // �����ĸ���
		this.n_visible = n_visible;  // ���ӽڵ�ĸ��� �� ���ӽڵ�ĸ���������һ������
		this.n_hidden = n_hidden;   // ���ؽڵ�ĸ��� �� ���ؽڵ�ĸ���������һ��Ľڵ����
	
		if(rng == null)	this.rng = new Random(1234); //��ȡ���ֵ
		else this.rng = rng;
		
		if(W == null) {  // ��ʼ�� RBM�� W ��  ��Ϊ�ڹ�����ʱ���ǰ����ز�� W������������W����NULL����sigmoid_layers[i].W
			this.W = new double[this.n_hidden][this.n_visible];
			double a = 1.0 / this.n_visible;
			
			for(int i=0; i<this.n_hidden; i++) {
				for(int j=0; j<this.n_visible; j++) {
					this.W[i][j] = uniform(-a, a); 
				}
			}	
		} else {
			this.W = W;
		}
		
		if(hbias == null) {  //��ʼ��RBM ��ƫ��b �� ͬ���ڳ�ʼ��RBM��ʱ��hbias����sigmoid_layers�����
			this.hbias = new double[this.n_hidden];
			for(int i=0; i<this.n_hidden; i++) this.hbias[i] = 0;
		} else {
			this.hbias = hbias;
		}
		
		if(vbias == null) {   //�����ʼ�������Ӳ��ƫ� ������Ϊ0�Ͷ���
			this.vbias = new double[this.n_visible];
			for(int i=0; i<this.n_visible; i++) this.vbias[i] = 0;
		} else {
			this.vbias = vbias;
		}
	}
	
	//ִ�� CD ������   w  b  c �����ݶ��½��ĵ���
	public void contrastive_divergence(int[] input, double lr, int k) {
		double[] ph_mean = new double[n_hidden];// n-hidden����һ��Ľڵ����
		int[] ph_sample = new int[n_hidden]; // ����������ز��0-1 ֵ
		double[] nv_means = new double[n_visible];  //������ ������ǿ��Ӳ�� wx+bֵ
		int[] nv_samples = new int[n_visible];  //������ ������ǿ��Ӳ��0-1ֵ
		double[] nh_means = new double[n_hidden];  // ������ ���ز�� wx+b ֵ
		int[] nh_samples = new int[n_hidden];  // ������ ���Ӳ��0-1ֵ
		
		/* CD-k */
		sample_h_given_v(input, ph_mean, ph_sample); //ph_mean ��wx+b , ph_sample�ǹ�һ����01֮��
		
		for(int step=0; step<k; step++) { // k = 1 ������ʵҲ��ִ����һ�β���
			if(step == 0) { // ִ��Gibbs ������ �����ز㵽���Ӳ㣬Ȼ��ӿ��Ӳ��ڷ������ز�
				gibbs_hvh(ph_sample, nv_means, nv_samples, nh_means, nh_samples);
			} else {  
				gibbs_hvh(nh_samples, nv_means, nv_samples, nh_means, nh_samples);
			}
		}
		
		// �����ݶ��½��� w ��ֵ���е��� ph_meanΪ���μ�������ز��ֵwx+b�� input ��ԭ���Ӳ��ֵ��01���� nh_meansΪ����������ز��ֵwx+b�� nvΪ������Ŀ��Ӳ��ֵ��01��
		for(int i=0; i<n_hidden; i++) {
			for(int j=0; j<n_visible; j++) {
				// W[i][j] += lr *(ph_sample[i] * input[j] - nh_means[i] * nv_samples[j]) / N;
				W[i][j] += lr *(ph_mean[i] * input[j] - nh_means[i] * nv_samples[j]) / N;
			}
			// �����ز��ƫ����е���
			hbias[i] += lr * (ph_sample[i] - nh_means[i]) / N; //ph_sample Ϊ���ز��ֵ01 �� nh_means Ϊ�����󷵻����ز��ֵwx+b
		}
		
        // �Կ��Ӳ��ƫ����е���
		for(int i=0; i<n_visible; i++) {
			vbias[i] += lr * (input[i] - nv_samples[i]) / N;
		}

	}
	
	//����v ���� h , ��ʵ����sigmoid(wx+b)
	public void sample_h_given_v(int[] v0_sample, double[] mean, int[] sample) { //mean��wx+b , sample �ǹ�һ����0��1֮��
		for(int i=0; i<n_hidden; i++) {  // n-hidden Ϊ��һ��Ľڵ����
			mean[i] = propup(v0_sample, W[i], hbias[i]);  //w[i]Ϊ��i���ڵ��Ȩ�أ� �����������W*x �� ͬʱ���Ͷ�Ӧ��ƫ��
			sample[i] = binomial(1, mean[i]);
		}
	}
   
	//���� h ����v 
	public void sample_v_given_h(int[] h0_sample, double[] mean, int[] sample) {
		for(int i=0; i<n_visible; i++) { // n-visible Ϊ���Ӳ�Ľڵ����
			mean[i] = propdown(h0_sample, i, vbias[i]);//h-sample �Ǵ����ز㴫������ֵ
			sample[i] = binomial(1, mean[i]);   // sample �����ֵ��0-1�Ĺ�һ�����
		}
	}
	
	//�������� sigmoid(wx+b) 
	public double propup(int[] v, double[] w, double b) {
		double pre_sigmoid_activation = 0.0;
		for(int j=0; j<n_visible; j++) { //n-visible Ϊ��һ������ά��
			pre_sigmoid_activation += w[j] * v[j]; //  ����forѭ������w[i][j]*x[j] �������ڻ�
		}
		pre_sigmoid_activation += b; // �������ڻ����ʵֵ����һ��ƫ��
		return sigmoid(pre_sigmoid_activation); //����sigmoid �����ֵ
	}
	
	//��������ز㷵�ؿ��Ӳ��wx+b  ??? Ϊʲô����wc+c
	public double propdown(int[] h, int i, double b) {
	  double pre_sigmoid_activation = 0.0;
	  for(int j=0; j<n_hidden; j++) {
	    pre_sigmoid_activation += W[j][i] * h[j]; // �����ز�Ľ����Ϊ���룬 ����wx+b 
	  }
	  pre_sigmoid_activation += b;
	  return sigmoid(pre_sigmoid_activation);
	}
	
	public void gibbs_hvh(int[] h0_sample, double[] nv_means, int[] nv_samples, double[] nh_means, int[] nh_samples) {
	  sample_v_given_h(h0_sample, nv_means, nv_samples);  // ��������ز㵽���Ӳ�Ľ��
	  sample_h_given_v(nv_samples, nh_means, nh_samples);  // �ڼ���ӿ��Ӳ㵽���ز�Ľ��
	}


	public void reconstruct(int[] v, double[] reconstructed_v) {
	  double[] h = new double[n_hidden];
	  double pre_sigmoid_activation;
	
	  for(int i=0; i<n_hidden; i++) {
	    h[i] = propup(v, W[i], hbias[i]);
	  }
	
	  for(int i=0; i<n_visible; i++) {
	    pre_sigmoid_activation = 0.0;
	    for(int j=0; j<n_hidden; j++) {
	      pre_sigmoid_activation += W[j][i] * h[j];
	    }
	    pre_sigmoid_activation += vbias[i];
	
	    reconstructed_v[i] = sigmoid(pre_sigmoid_activation);
	  }	
	}
}



