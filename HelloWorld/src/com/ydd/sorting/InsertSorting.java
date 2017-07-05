package com.ydd.sorting;

public class InsertSorting {
        
        public static void Sort(int array[]){
                for(int i=1; i<array.length; i++){
                        int temp = array[i];    
                        int j = i;       
                        if(array[j-1] > temp){
                                while(j>=1 && array[j-1] > temp){
                                        array[j] = array[j-1];
                                        j--;
                                }
                        }
                        array[j] = temp;  
                }  
        }

        public static void main(String[] args) {
                // TODO Auto-generated method stub
                int arr[] = {5,4,9,8,7,6,0,1,3,2};
                Sort(arr); 
                System.out.println("InsertSorting:");
                for(int x : arr){
                        System.out.println(x);
                }
        }
}
