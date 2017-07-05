package Java_Basics;

/*
 * 正则表达式
 * 
 */

public class Jude {

        public static void main(String[] args) {
                // TODO Auto-generated method stub

                String regex = "\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
                
                StringBuilder bf = new StringBuilder("hello world ");
                 bf.delete(3, 7);
                System.out.println(bf);
                
                int a[][] = new int[3][4];
                for(int i=0; i<a.length; i++){
                        for (int j=0; j< a[i].length; j++){
                                System.out.print(a[i][j]);
                        }
                        System.out.println();
                }
        }

}
