package Java_Basics;

/*
 * 选择排序
 * 
 */
public class SelectSort {

        public void sort(int[] array) {
                // TODO Auto-generated method stub   
                int temp;
                for(int i=0; i<array.length-1; i++){
                        int min = array[i];
                        int index=i;
                        for (int j=i+1; j <= array.length-1; j++){
                                if (min> array[j]){
                                        min = array[j];
                                        index = j;
                                 }
                        }
                        temp = array[i];       //把第一个元素值保存到临时变量中
                        array[i] = array[index];   //把第二个元素值保存到第一个元素单元中
                        array[index] = temp;    //把临时变量也就是第一个元素值保存到第二个元素中
                }
        }

        public static void main(String[] args) {
                // TODO Auto-generated method stub
                
                int []array={63, 4, 24, 1, 3, 15};      //创建一个乱序数组
                System.out.println("before sorting：");
                for(int x : array){
                        System.out.print (+x+"\t");
                }
                System.out.println();
                
                SelectSort sorter = new SelectSort();   //创建直接排序类的对象
                sorter.sort(array);
                System.out.println("after sorting：");
                for(int x : array){
                        System.out.print (x+"\t");
                }

        }
       
}
