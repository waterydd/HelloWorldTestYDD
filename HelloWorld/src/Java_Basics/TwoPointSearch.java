package Java_Basics;

import java.util.Scanner;

public class TwoPointSearch {
        
        public static void Search(int leftInedx, int rightIndex, int key, int array[]){
                //�����ҵ��м����
                int index = (rightIndex + leftInedx) /2;
                int midlle = array[index];
                if (rightIndex >= leftInedx){
                        //��� key �� midlle ��
                        if (midlle > key){
                                Search(leftInedx, index -1, key,array);
                        }else if (midlle < key){
                                Search(index +1, rightIndex, key, array);
                        }else if (midlle == key){
                                System.out.println("����arr["+ index+"]��"+ midlle);
                        }
                }else{
                        System.out.println("û���ҵ�ָ�����֣�");
                }
        }

        public static void main(String[] args) {
                // TODO Auto-generated method stub

                int arr[] = {2 ,5, 7, 12, 25, 30};
                System.out.println("��������Ҫ���ҵ����֣�");
                Scanner sr = new Scanner(System.in);
                int key = sr.nextInt();
                Search(0, arr.length-1, key, arr);
        }
}
