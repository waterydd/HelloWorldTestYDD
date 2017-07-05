package com.ydd.thread;

public class PrintOdd implements Runnable{
        Num num;
        public PrintOdd(Num num){
                this.num=num;
        }
        public void run(){
                while(num.i<=100){
                        synchronized(num){
                                if(!num.flag){
                                        try{
                                                num.wait();
                                        }catch(Exception e){
                                                e.printStackTrace();
                                        }
                                }else{
                                        System.out.println("Å¼Êý£º"+num.i);
                                        num.i++;
                                        num.flag=false;
                                        num.notify();
                                }
                        }
                }
        }
}