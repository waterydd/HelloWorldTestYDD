package Java_Basics;

/*
 * 反序排序
 * 
 */

public class ReverseSort {

        public static void main(String[] args) {
                // TODO Auto-generated method stub
                
              //创建一个乱序数组
                int [] array={63, 4, 24, 1, 3, 15};
                for(int i =0; i<array.length; i++){
                        System.out.print (array[i]+" ");
                }
                System.out.println();
                //创建冒泡排序类的对象
                ReverseSort sorter = new ReverseSort();
                //调用排序方法将数组排序
                sorter.sort(array);
                
                //遍历打印数组
                for(int i =0; i<array.length; i++){
                        System.out.print (array[i]+" ");
                }

        }

        public  void sort(int[] array) {
                // TODO Auto-generated method stub
                
                for(int i=0; i<array.length/2; i++){
                        int temp =array[i];
                        array[i] = array[array.length-1-i];
                        array[array.length-1-i] = temp;
                        
                }
        }
        

}
