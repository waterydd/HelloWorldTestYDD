package Java_Basics;

/*
 * �����߳�
 * 
 */

/*����һ
 * �̳� Thread �෽�������߳�
 */
public class ThreadTest  extends Thread{

        private int count =10;
        public void run(){      //��д run( )����
                while(true){
                        System.out.print(count+" ");  //��ӡ count ����
                        if (--count ==0){       //ʹ count �����Լ���ֱ���Լ�Ϊ0ʱ���˳�ѭ��
                                return;
                        }
                }
        }
           
        public static void main(String[] args) {
                // TODO Auto-generated method stub
                new ThreadTest().start();       //�����߳�
                
                //�� main �����У�ʹ�߳�ִ����Ҫ���� start( )�������÷������ñ����ǵ� run( )������
                //��������� start( ) �������߳���Զ�������������� start( ) ֮ǰ��Thread ����ֻ��һ��ʵ���������������̡߳�
//                ThreadTest thread =new ThreadTest();  //Ч��ͬ23�д��롣
//                thread.start();         //�����߳�
                
                MyThread thread = new MyThread();       //ʵ���� Runnable ����
                Thread t = new Thread (thread);             //ʵ���� Thread ����
                t.start();
        }
}

/*������
 * ʵ�� Runnable �ӿڴ����߳�
 */

class MyThread implements Runnable{
        public void run() {
                System.out.println("\nThread body");
        }
}








