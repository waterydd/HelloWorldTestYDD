package com.ydd.thread;

public class Main{
        public static void main(String[] args){
                Num num = new Num();
                PrintEven printeven = new PrintEven(num);
                PrintOdd printodd = new PrintOdd(num);
                
                Thread thread1 = new Thread(printeven);
                Thread thread2 = new Thread(printodd);
                
                thread1.start();
                thread2.start();
        }
}