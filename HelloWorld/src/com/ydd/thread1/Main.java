package com.ydd.thread1;
/**
 * 
 * Ҫ�������̷ֱ߳��ӡ100���ڵ�������ż��������ʵ��100���ڵ�����������ӡ��
 * ���˼·���������趨Ϊ������Դ���������̶߳Թ�����Դ���мӷ�������������flag��ʶ�����̵߳��Ƿ����ȴ���
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
