package DBN;
import java.util.Random;


public class HiddenLayer {
	public int N;  //�����ĸ���
	public int n_in;  // ���ز������ά��
	public int n_out;  //���ز�����ά��
	public double[][] W;  // ���ز��Ȩ��
	public double[] b;   // ���ز��ƫ��
	public Random rng;   
	
	public double uniform(double min, double max) {  // ����  min �� max�����ֵ
		return rng.nextDouble() * (max - min) + min;
	}
	
	// ���ݸ���p , ��ȡ0-1
	public int binomial(int n, double p) {
		if(p < 0 || p > 1) return 0;
		
		int c = 0;
		double r;
		
		for(int i=0; i<n; i++) {
			r = rng.nextDouble();
			if (r < p) c++;
		}
		
		return c;
	}
	
	// sigmoid
	public static double sigmoid(double x) {
		return 1.0 / (1.0 + Math.pow(Math.E, -x));
	}
	
	
	//���ز�Ĺ�������
	public HiddenLayer(int N, int n_in, int n_out, double[][] W, double[] b, Random rng) {
		this.N = N;  // ������Ŀ 
		this.n_in = n_in;   // ������ز��������Ŀ
		this.n_out = n_out;   // ������ز�������Ŀ �� ��ʵ������һ��Ľڵ���� hidden_layer_size[i]
		
		if(rng == null)	this.rng = new Random(1234);  // ��ȡ�����
		else this.rng = rng;
	
		if(W == null) { // ���ﹹ�����ز��Ȩ�أ� ���W��ֵ�Ļ����͸�ֵ���������û��ֵ�Ļ��������ʼ��
			this.W = new double[n_out][n_in];  //�ڼ����ʱ����һ�����������һ���W�����ڻ�����
			//W*x , W[n-out][n-in] , x[n-in] ,��˺���һ�� n-out ά��������Ҳ������һ�����ز�Ľڵ��������Ϊ��һ�������
			double a = 1.0 / this.n_in;  
			
			for(int i=0; i<n_out; i++) {
				for(int j=0; j<n_in; j++) {
					this.W[i][j] = uniform(-a, a);  //ΪȨֵ����W��ֵ �����ȡһ��-a , a ֮�����ֵ
				}
			}
		} else {
			this.W = W;
		}
		
		if(b == null) this.b = new double[n_out];  // ƫ���ά�Ⱥ����������ά��Ӧ����Ҫһ����
		else this.b = b;
	}
	
	//�����RBM ��propup ��һ����
	public double output(int[] input, double[] w, double b) {
		double linear_output = 0.0;
		for(int j=0; j<n_in; j++) {
			linear_output += w[j] * input[j];
		}
		linear_output += b;
		return sigmoid(linear_output);
	}
	
	// �����RBM ��wx+b ��һ���� , ����input��ά��Ϊn-in �����������sample��n-out������
	public void sample_h_given_v(int[] input, int[] sample) {
		for(int i=0; i<n_out; i++) {  // n-out���ǲ��ж��ٸ��ڵ㣬Ҳ�����������ά��
			sample[i] = binomial(1, output(input, W[i], b[i])); //����input����һ������,W[i]�����W�ĵ�i��, Ҳ�������
		}
	}
}




