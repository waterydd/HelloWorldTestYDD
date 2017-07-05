package com.ydd.sorting;

public class BubbleSorting {
        
        public  static void Sort(int array[ ]){         //定义为static，不需要实例化 BubbleSorting 类，就可以直接调用 Sort( ) 方法
                int temp ;
                for(int i=1;  i<array.length; i++){
                        for(int j=0; j<array.length-1; j++){
                                //升序排序
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
                Sort(arr);            //直接调用静态方法
                System.out.println("BubbleSorting:");
                for(int i=0; i<arr.length; i++){        //for 循环遍历数组
                        System.out.println(arr[i]);
                }
                /*
                for(int x: arr){        //foreach 语句遍历数组，int x 引用的变量， arr指定要循环遍历的数组，最后将 x 输出
                        System.out.println(x);
                }
                */
        }

}
