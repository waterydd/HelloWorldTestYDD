package Java_Basics;

/*
 * 在主方法中创建 Map 集合，并获取 Map 集合中的所有 key 对象集合和所有 values 值集合
 * 最后遍历集合
 * 
 */
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class Set_test {

        public static void main(String[] args) {
                // TODO Auto-generated method stub
                
                Set<String> map = new TreeSet<>();
                map.add("liming");
                map.add("bb");
                map.add("yangdd");
                map.add("angdd");
                map.add("angdd");
                map.add("qiurc");
                
                Iterator<String> it = map.iterator();
                System.out.println("key集合中的元素：");
                while (it.hasNext()){
                        System.out.println(it.next());
                }
        }

}
