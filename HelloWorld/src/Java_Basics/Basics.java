package Java_Basics;

/*
 * 多个基础知识的应用
 * 
 */
import java.util.Date;

public class Basics {
        static String s1 = "hello ";
        public static void main(String[] args) {
                // TODO Auto-generated method stub
                String s2 = "JAVA ";
                float n = 45.56f;
                int n2=152;
                String s3 = s2.replace("A", "a");
                System.out.println(s3);
                
                String str1= "WE are student ";
                
                String  size = str1.toLowerCase();
                String  size2=str1.toUpperCase();
                String size3 = str1.substring(3);
                
                String str2 = new String ("abc,def,ghi,gkl");
                String[] newstr = str2.split(",");
                for(int i=0; i<newstr.length; i++){
                        System.out.println(newstr[i]);
                }
                String[] newstr2 = str2.split(",",2);
                for (int i=0; i<newstr2.length; i++){
                        System.out.println(newstr2[i]);
                }
                
                System.out.println(size);
                System.out.println(size2);
                System.out.println(size3);
                
                Date date = new Date();
                String s = String.format("%tF",date);
                System.out.print(s);


        }

}
