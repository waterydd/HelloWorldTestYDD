package com.ydd.thread1;
/**
 * 实现偶数打印
 * @author YDD
 */
public class PrintOdd implements Runnable{
        Num num;
        public PrintOdd(Num num) {
                this.num = num;
        }
        public void run() {
                while (num.i <= 100) {
                      //锁定共享资源
                        synchronized (num) {
                                if(!num.flag){
                                        try {
                                                num.wait();//进程进入等待，并释放对象锁
                                        } catch (InterruptedException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                        }
                                }else{
                                        System.out.println("PrintOdd  :" + num.i);
                                        num.i++;
                                        num.notify();  //唤醒等待进程
                                        num.flag = false;
                                }                       
                        }
                }
        }
}
