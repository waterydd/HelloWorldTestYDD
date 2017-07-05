package Java_Basics;

/*
 * 集合类的遍历
 * 
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * 典型的遍历集合的方法：通常遍历集合，都是通过迭代器（Iterator）
 * 
 * 代码要求：在主方法中实例化集合对象，并向集合中添加元素，最后将集合中的对象以 String 形式输出
 */
public class Muster {   //创建 Muster 类

        public static void main(String[] args) {
                // TODO Auto-generated method stub

                Collection<String> list = new ArrayList<>();    //实例化集合类对象
                list.add("a");          //向集合添加数据
                list.add("b");
                list.add("c");
                
                //使用迭代器遍历集合
                Iterator<String> it = list.iterator();          //创建迭代器
                while(it.hasNext()){            //判断是否有下一个元素
                        String str = (String)it.next();         //获取集合中元素
                        System.out.println(str);
                }
        }

}
