package Java_Basics;

/*
 * ѡ������
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
                        temp = array[i];       //�ѵ�һ��Ԫ��ֵ���浽��ʱ������
                        array[i] = array[index];   //�ѵڶ���Ԫ��ֵ���浽��һ��Ԫ�ص�Ԫ��
                        array[index] = temp;    //����ʱ����Ҳ���ǵ�һ��Ԫ��ֵ���浽�ڶ���Ԫ����
                }
        }

        public static void main(String[] args) {
                // TODO Auto-generated method stub
                
                int []array={63, 4, 24, 1, 3, 15};      //����һ����������
                System.out.println("before sorting��");
                for(int x : array){
                        System.out.print (+x+"\t");
                }
                System.out.println();
                
                SelectSort sorter = new SelectSort();   //����ֱ��������Ķ���
                sorter.sort(array);
                System.out.println("after sorting��");
                for(int x : array){
                        System.out.print (x+"\t");
                }

        }
       
}
