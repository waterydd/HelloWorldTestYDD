package com.ydd.thread1;
/**
 * ʵ��������ӡ
 * @author YDD
 */
public class PrintEven implements Runnable{ 
        Num num;
        public PrintEven(Num num) {
                this.num = num;
        }
        public void run() {
                while (num.i <= 100) {
                        //����������Դ
                        synchronized (num) {
                                if(num.flag){
                                        try {
                                                num.wait();//���̽���ȴ������ͷŶ�����
                                        } catch (InterruptedException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                        }
                                }else{
                                        System.out.println("PrintEven:" + num.i);
                                        num.i++;
                                        num.notify();//���ѵȴ�����
                                        num.flag = true;
                                }     
                       }
               }
       }
}
