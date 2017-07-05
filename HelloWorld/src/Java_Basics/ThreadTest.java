package Java_Basics;

/*
 * 创建线程
 * 
 */

/*方法一
 * 继承 Thread 类方法创建线程
 */
public class ThreadTest  extends Thread{

        private int count =10;
        public void run(){      //重写 run( )方法
                while(true){
                        System.out.print(count+" ");  //打印 count 变量
                        if (--count ==0){       //使 count 变量自减，直到自减为0时，退出循环
                                return;
                        }
                }
        }
           
        public static void main(String[] args) {
                // TODO Auto-generated method stub
                new ThreadTest().start();       //启动线程
                
                //在 main 方法中，使线程执行需要调用 start( )方法，该方法调用被覆盖的 run( )方法。
                //如果不调用 start( ) 方法，线程永远不会启动，调用 start( ) 之前，Thread 对象只是一个实例，不是真正的线程。
//                ThreadTest thread =new ThreadTest();  //效果同23行代码。
//                thread.start();         //开启线程
                
                MyThread thread = new MyThread();       //实例化 Runnable 对象
                Thread t = new Thread (thread);             //实例化 Thread 对象
                t.start();
        }
}

/*方法二
 * 实现 Runnable 接口创建线程
 */

class MyThread implements Runnable{
        public void run() {
                System.out.println("\nThread body");
        }
}








