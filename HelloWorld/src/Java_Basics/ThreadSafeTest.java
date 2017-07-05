package Java_Basics;

/*
 * �̰߳�ȫ
 * 
 */
public class ThreadSafeTest implements Runnable{

        int num = 10;
/*1��û��ͬ�����ƣ�������Դ���ʳ�ͻ
 */
//        public void run(){
//                while(true){
//                        if (num > 0){
//                                try{
//                                        Thread.sleep(100);
//                                }catch(Exception e){
//                                        e.printStackTrace();
//                                }
//                                System.out.println("tickets "+ num--);
//                        }
//                }
//        }
        
                
  /*    2��ͬ�����ƣ���1��ͬ����
   * ���� run( ) ���������Ĵ���������ͬ������� synchronized(Object) { }��;
   */
//        public void run(){
//                while(true){
//                        synchronized ("") {           //��������Դ�������� synchronized(Object) { }ͬ���������
//                                if (num > 0){
//                                      try{
//                                              Thread.sleep(100);
//                                      }catch(Exception e){
//                                              e.printStackTrace();
//                                      }
//                                      System.out.println("tickets "+ --num);
//                              }
//                        }
//                }
//        }
        
        
/*      3��ͬ�����ƣ���2��ͬ������
 * ��������Դ��������һ��ͬ������ synchronized void f( ){ }��;
 */
        public synchronized void doit(){                //����ͬ������
                if (num > 0){
                        try{
                                Thread.sleep(100);
                        }catch(Exception e){
                                e.printStackTrace();
                        }
                        System.out.println("tickets "+ --num);
                }
        }
        
        public void run(){
                while(true){
                        doit();         //�� run( )�����е��ø�ͬ������
                }
        }
        

        public static void main(String[] args) {
                // TODO Auto-generated method stub
                ThreadSafeTest t = new ThreadSafeTest();
                Thread A= new Thread(t);
                Thread B= new Thread(t);
                Thread C= new Thread(t);
                Thread D= new Thread(t);
                A.start();
                B.start();
                A.start();
                A.start();  
        }

}
