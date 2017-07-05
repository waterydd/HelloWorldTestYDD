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

public class Map_test {

        public static void main(String[] args) {
                // TODO Auto-generated method stub
                
                Map<String, String> map = new HashMap<>();
                map.put("01","liming");
                map.put("02","yangdd");
                map.put("03","qiurc");
                
                Set<String> set = map.keySet();         //返回 map 集合所有 key 对象形成的集合
                Iterator<String> it = set.iterator();
                System.out.println("key集合中的元素：");
                while (it.hasNext()){
                        System.out.println(it.next());
                }
                
                Collection<String> coll = map.values();
                it = coll.iterator();
                System.out.println("values集合中的元素：");
                while(it.hasNext()){
                        System.out.println(it.next());
                }
                                
        }

}
