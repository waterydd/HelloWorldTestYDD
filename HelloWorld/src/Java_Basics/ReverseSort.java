package Java_Basics;

/*
 * ��������
 * 
 */

public class ReverseSort {

        public static void main(String[] args) {
                // TODO Auto-generated method stub
                
              //����һ����������
                int [] array={63, 4, 24, 1, 3, 15};
                for(int i =0; i<array.length; i++){
                        System.out.print (array[i]+" ");
                }
                System.out.println();
                //����ð��������Ķ���
                ReverseSort sorter = new ReverseSort();
                //�������򷽷�����������
                sorter.sort(array);
                
                //������ӡ����
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
