package com.ydd.sorting;

public class BubbleSorting {
        
        public  static void Sort(int array[ ]){         //����Ϊstatic������Ҫʵ���� BubbleSorting �࣬�Ϳ���ֱ�ӵ��� Sort( ) ����
                int temp ;
                for(int i=1;  i<array.length; i++){
                        for(int j=0; j<array.length-1; j++){
                                //��������
                                if(array[j] > array[j+1]){
                                        temp = array[j];
                                        array[j] = array[j+1];
                                        array[j+1] = temp;
                                }
                        }
                }
        }

        public static void main(String[] args) {
                // TODO Auto-generated method stub
                int arr[] = {1,6,0,-1,9,-100,90};
                Sort(arr);            //ֱ�ӵ��þ�̬����
                System.out.println("BubbleSorting:");
                for(int i=0; i<arr.length; i++){        //for ѭ����������
                        System.out.println(arr[i]);
                }
                /*
                for(int x: arr){        //foreach ���������飬int x ���õı����� arrָ��Ҫѭ�����������飬��� x ���
                        System.out.println(x);
                }
                */
        }

}
