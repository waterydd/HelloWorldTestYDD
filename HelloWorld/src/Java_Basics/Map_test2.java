package Java_Basics;

/*
 * 创建一个用于测试的主类，首先新建一个 Map 集合，并添加集合对象。
 * 分别遍历由 HashMap 类与 TreeMap 类实现的 Map 集合，观察两者的不同点：HashMap 是无序的，TreeMap 是键对象升序的。
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class EMP{
        private String e_id;
        private String e_name;
        
        public EMP(String e_id, String e_name) {
                this.e_id = e_id;
                this.e_name = e_name;
        }
        public String getE_id() {
                return e_id;
        }
        public void setE_id(String e_id) {
                this.e_id = e_id;
        }
        public String getE_name() {
                return e_name;
        }
        public void setE_name(String e_name) {
                this.e_name = e_name;
        }
        
        
}

public class Map_test2 {

        public static void main(String[] args) {
                // HashMap类实现Map集合
                Map<String, String> map = new HashMap<>();
                
                EMP emp1 = new EMP("01","aa");
                EMP emp2 = new EMP("05","bb");
                EMP emp3 = new EMP("03","cc");
                EMP emp4 = new EMP("04","dd");
                map.put(emp1.getE_id(),emp1.getE_name());
                map.put(emp2.getE_id(),emp2.getE_name());
                map.put(emp3.getE_id(),emp3.getE_name());
                map.put(emp4.getE_id(),emp4.getE_name());
                
                Set<String> set = map.keySet();
                Iterator<String> it = set.iterator();
                System.out.println("HashMap类实现Map集合，无序：");
                while(it.hasNext()){
                        String str = it.next();
                        String name = map.get(str);
                        System.out.println(str+":"+name);
                }
                //TreeMap类实现Map集合
                Map<String, String> tr = new TreeMap<>();
                tr.putAll(map);
                Iterator<String> iter = tr.keySet().iterator();
                System.out.println("TreeMap类实现Map集合，键对象升序：");
                while(iter.hasNext()){
                        String str = iter.next();
                        String name = map.get(str);
                        System.out.println(str+":"+name);
                }
                
                
                

        }

}
