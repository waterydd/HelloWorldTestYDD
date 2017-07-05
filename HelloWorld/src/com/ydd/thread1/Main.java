package com.ydd.thread1;
/**
 * 
 * 要求：两个线程分别打印100以内的奇数和偶数，最终实现100以内的有序连续打印。
 * 解决思路：将数字设定为共享资源，用两个线程对共享资源进行加法操作，其中用flag标识两个线程的是否进入等待。
 * @author YDD
 *
 */
public class Main {
        public static void main(String[] args) {
                // TODO Auto-generated method stub
               Num num = new Num();
               PrintOdd printodd = new PrintOdd(num);
               PrintEven printeven = new PrintEven(num);
               
               Thread thread1 = new Thread(printodd);
               Thread thread2 = new Thread(printeven);

               thread1.start();
               thread2.start();
               
        }
}
