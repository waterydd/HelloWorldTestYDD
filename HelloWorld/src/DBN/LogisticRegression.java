package DBN;



public class LogisticRegression {
	public int N;
	public int n_in;
	public int n_out;
	public double[][] W;
	public double[] b;
	
	//�߼��ع�Ĺ������� 
	public LogisticRegression(int N, int n_in, int n_out) {
		this.N = N;// N Ϊ�����ĸ���
		this.n_in = n_in; // i_in Ϊ�����ά��������hidden_layer���һ��������
		this.n_out = n_out;  // n-out Ϊ֮ǰ�趨��DBN�����ά��
		
		W = new double[this.n_out][this.n_in];// [n-out][n-in]* [n-in] = [n-out]
		b = new double[this.n_out];
	}
	
	// ����������x , label ��y , lr��ѧϰ�� �� һ�μ���һ������
	public void train(int[] x, int[] y, double lr) {
		double[] p_y_given_x = new double[n_out]; //�������������ݵ�ά����������
		double[] dy = new double[n_out];
		
		for(int i=0; i<n_out; i++) { //���㲻ͬά���ϵĸ���ֵ
			p_y_given_x[i] = 0;
			for(int j=0; j<n_in; j++) { //�����߼��ع�� wx+b��
				p_y_given_x[i] += W[i][j] * x[j];
			}
			p_y_given_x[i] += b[i]; //����ƫ��
		}
		softmax(p_y_given_x); //Ȼ����������ֵ��softmax
		
		for(int i=0; i<n_out; i++) {
			dy[i] = y[i] - p_y_given_x[i];  //����ʵ��label
			
			for(int j=0; j<n_in; j++) {
				W[i][j] += lr * dy[i] * x[j] / N;  // ����ƫ�����ݶ��½��޸�W , �߼��ع��W��ʼ��ʱ����0
			}
			
			b[i] += lr * dy[i] / N;  // ͬʱ�޸� ƫ��
		}
	}
	
	public void softmax(double[] x) {
		double max = 0.0;
		double sum = 0.0;
		
		for(int i=0; i<n_out; i++) { // x ��ά��Ϊ n_out , �ҵ�����ֵ
			if(max < x[i]) {
				max = x[i];
			}
		}
		
		for(int i=0; i<n_out; i++) {
			x[i] = Math.exp(x[i] - max);
			sum += x[i];
		}
		
		for(int i=0; i<n_out; i++) { //��һ��
			x[i] /= sum;
		}
	}
	
	public void predict(int[] x, double[] y) {
		for(int i=0; i<n_out; i++) {
			y[i] = 0;
			for(int j=0; j<n_in; j++) {
				y[i] += W[i][j] * x[j];
			}
			y[i] += b[i];
		}
		
		softmax(y);
	}		
}