package com.ydd.sorting;

public class SelectSorting {
        
        public static void sort(int array[]){
                int temp;
                for(int i=0; i<array.length-1; i++){
                        //��Ϊ��һ������С
                        int min = array[i];
                        //������С�����±�
                        int minIndex = i;
                        for (int j = i+1; j<array.length; j++){
                                if ( min > array[j]){
                                        //�޸���Сֵ
                                        min = array[j];
                                        minIndex = j;
                                }
                        }
                        //���˳� forѭ��ʱ�����ҵ��˱��ε���Сֵ
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
                for(int x : arr){       //foreach ����������
                        System.out.println(x);
                }
        }

}
