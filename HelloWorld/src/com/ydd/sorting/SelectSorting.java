package com.ydd.sorting;

public class SelectSorting {
        
        public static void sort(int array[]){
                int temp;
                for(int i=0; i<array.length-1; i++){
                        //认为第一个数最小
                        int min = array[i];
                        //记下最小数的下标
                        int minIndex = i;
                        for (int j = i+1; j<array.length; j++){
                                if ( min > array[j]){
                                        //修改最小值
                                        min = array[j];
                                        minIndex = j;
                                }
                        }
                        //当退出 for循环时，就找到了本次的最小值
                        temp = array[i];
                        array[i] = array[minIndex];
                        array[minIndex] = temp;
                }
        }

        public static void main(String[] args) {
                // TODO Auto-generated method stub

                int arr[] = {5,4,9,8,7,6,0,1,3,2};
                sort(arr);
                System.out.println("SelectSorting:");
                for(int x : arr){       //foreach 语句遍历数组
                        System.out.println(x);
                }
        }

}
