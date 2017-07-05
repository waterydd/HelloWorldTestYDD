package Java_Basics;

import java.util.Scanner;

public class TwoPointSearch {
        
        public static void Search(int leftInedx, int rightIndex, int key, int array[]){
                //首先找到中间的数
                int index = (rightIndex + leftInedx) /2;
                int midlle = array[index];
                if (rightIndex >= leftInedx){
                        //如果 key 比 midlle 大
                        if (midlle > key){
                                Search(leftInedx, index -1, key,array);
                        }else if (midlle < key){
                                Search(index +1, rightIndex, key, array);
                        }else if (midlle == key){
                                System.out.println("数组arr["+ index+"]："+ midlle);
                        }
                }else{
                        System.out.println("没有找到指定数字！");
                }
        }

        public static void main(String[] args) {
                // TODO Auto-generated method stub

                int arr[] = {2 ,5, 7, 12, 25, 30};
                System.out.println("请输入需要查找的数字：");
                Scanner sr = new Scanner(System.in);
                int key = sr.nextInt();
                Search(0, arr.length-1, key, arr);
        }
}
