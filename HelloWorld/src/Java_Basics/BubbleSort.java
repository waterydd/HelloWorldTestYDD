package Java_Basics;

/*
 * ð������
 * 
 */
public class BubbleSort {

        public static void main(String[] args) {
                // TODO Auto-generated method stub
                
              //����һ����������
                int [] array={63, 4, 24, 1, 3, 15};
                for(int i =0; i<array.length; i++){
                        System.out.print (array[i]+" ");
                }
                System.out.println();
                //����ð��������Ķ���
                BubbleSort sorter = new BubbleSort();
                //�������򷽷�����������
                sorter.sort(array);
                
                //������ӡ����
                for(int i =0; i<array.length; i++){
                        System.out.print (array[i]+" ");
                }

        }

        /**
         * ð������
         * 
         * @param array
         * Ҫ���������array
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
