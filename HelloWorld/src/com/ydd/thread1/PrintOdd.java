package com.ydd.thread1;
/**
 * ʵ��ż����ӡ
 * @author YDD
 */
public class PrintOdd implements Runnable{
        Num num;
        public PrintOdd(Num num) {
                this.num = num;
        }
        public void run() {
                while (num.i <= 100) {
                      //����������Դ
                        synchronized (num) {
                                if(!num.flag){
                                        try {
                                                num.wait();//���̽���ȴ������ͷŶ�����
                                        } catch (InterruptedException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                        }
                                }else{
                                        System.out.println("PrintOdd  :" + num.i);
                                        num.i++;
                                        num.notify();  //���ѵȴ�����
                                        num.flag = false;
                                }                       
                        }
                }
        }
}
