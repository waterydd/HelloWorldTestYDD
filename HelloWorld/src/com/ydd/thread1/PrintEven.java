package com.ydd.thread1;
/**
 * 实现奇数打印
 * @author YDD
 */
public class PrintEven implements Runnable{ 
        Num num;
        public PrintEven(Num num) {
                this.num = num;
        }
        public void run() {
                while (num.i <= 100) {
                        //锁定共享资源
                        synchronized (num) {
                                if(num.flag){
                                        try {
                                                num.wait();//进程进入等待，并释放对象锁
                                        } catch (InterruptedException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                        }
                                }else{
                                        System.out.println("PrintEven:" + num.i);
                                        num.i++;
                                        num.notify();//唤醒等待进程
                                        num.flag = true;
                                }     
                       }
               }
       }
}
