package Java_Basics;

/*
 * 冒泡排序法
 * 
 */
public class BubbleSort {

        public static void main(String[] args) {
                // TODO Auto-generated method stub
                
              //创建一个乱序数组
                int [] array={63, 4, 24, 1, 3, 15};
                for(int i =0; i<array.length; i++){
                        System.out.print (array[i]+" ");
                }
                System.out.println();
                //创建冒泡排序类的对象
                BubbleSort sorter = new BubbleSort();
                //调用排序方法将数组排序
                sorter.sort(array);
                
                //遍历打印数组
                for(int i =0; i<array.length; i++){
                        System.out.print (array[i]+" ");
                }

        }

        /**
         * 冒泡排序
         * 
         * @param array
         * 要排序的数组array
         * 
         */
        public   void sort(int[] array) {
                // TODO Auto-generated method stub
                for(int i =1; i<array.length; i++){
                        for (int j=0; j<array.length-1; j++){
                                if (array[j+1]<array[j]){
                                        int temp = array[j];
                                        array[j] = array[j+1];
                                        array[j+1] = temp;
                                 }
                         }
                }
        }
}
