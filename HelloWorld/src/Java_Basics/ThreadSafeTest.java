package Java_Basics;

/*
 * 线程安全
 * 
 */
public class ThreadSafeTest implements Runnable{

        int num = 10;
/*1、没有同步机制，出现资源访问冲突
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
        
                
  /*    2、同步机制：（1）同步块
   * 将对 run( ) 方法操作的代码设置在同步代码块 synchronized(Object) { }中;
   */
//        public void run(){
//                while(true){
//                        synchronized ("") {           //将共享资源操作放在 synchronized(Object) { }同步代码块中
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
        
        
/*      3、同步机制：（2）同步方法
 * 将共享资源操作放在一个同步方法 synchronized void f( ){ }中;
 */
        public synchronized void doit(){                //定义同步方法
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
                        doit();         //在 run( )方法中调用该同步方法
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
