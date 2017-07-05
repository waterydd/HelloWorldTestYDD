package Java_Basics;

/*
 * 创建 List 集合对象
通过 Math 类的 random( )方法随机获取集合中的某个元素
然后移除数组中索引位置是“2”的元素
最后遍历数组（集合）
 * 
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class List_test {        //创建类

        public static void main(String[] args) {
                // TODO Auto-generated method stub
                
                List<String> list = new ArrayList<>();  //创建集合实例对象
                list.add("a");          //向集合添加元素
                list.add("b");
                list.add("b");
                list.add("b");
                list.add("c");
                int i = (int) (Math.random()+(list.size()-1));          //获得0~2间的随机数
                System.out.println("集合元素："+list.get(i));
                list.remove(2);         //移除指定索引位元素
                System.out.println("将索引为2的元素移除后，数组中元素：");
//                for(int j= 0; j < list.size(); j++){            //循环遍历集合
//                        System.out.println(list.get(j));
//                }
                Iterator<String> it = list.iterator();          //使用迭代器遍历集合
                while(it.hasNext()){
                        System.out.println(it.next());
                }

        }

}
