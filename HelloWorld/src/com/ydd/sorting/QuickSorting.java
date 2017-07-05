package com.ydd.sorting;

public class QuickSorting {
        
        public static void Sort(int array[ ], int low, int high){
                int i, j;
                int index;
                if(low > high){
                        return;
                }
                i = low; j = high;
                index = array[i];
                while(i < j){
                        while(i < j && array[j] >= index)
                                j--;
                        if (i < j)
                                array[i++] = array[j];
                        while(i < j && array[i] <index)
                                i++;
                        if (i < j)
                                array[j--] = array[i];
                }
                array[i] = index;
                Sort(array, low, i-1);
                Sort(array, i+1, high);
        }
        
        public static void quickSort(int array[ ]){
                Sort(array, 0, array.length-1);
        }

        public static void main(String[] args) {
                // TODO Auto-generated method stub

                int arr[] = {5,4,9,8,7,6,0,1,3,2};
                quickSort(arr);
                System.out.println("QuickSorting:");
                for(int x : arr){       //foreach Óï¾ä±éÀúÊý×é
                        System.out.println(x);
                }
        }

}
