package com.ydd.thread;

public class PrintEven implements Runnable{
        Num num ;
        public PrintEven(Num num){
                this.num=num;
        }
        public void run(){
                while(num.i<=100){
                        synchronized(num){
                                if(num.flag){
                                        try{
                                                num.wait();
                                        }catch(Exception e){
                                                e.printStackTrace();
                                        }
                                }else{
                                        System.out.println("ÆæÊý£º"+ num.i);
                                        num.i++;
                                        num.flag=true;
                                        num.notify();
                                }
                        }
                }
        }
}