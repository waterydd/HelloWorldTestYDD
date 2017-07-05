package Java_Basics;

/*
 * ����һ�����ڲ��Ե����࣬�����½�һ�� Map ���ϣ�����Ӽ��϶���
 * �ֱ������ HashMap ���� TreeMap ��ʵ�ֵ� Map ���ϣ��۲����ߵĲ�ͬ�㣺HashMap ������ģ�TreeMap �Ǽ���������ġ�
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
                // HashMap��ʵ��Map����
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
                System.out.println("HashMap��ʵ��Map���ϣ�����");
                while(it.hasNext()){
                        String str = it.next();
                        String name = map.get(str);
                        System.out.println(str+":"+name);
                }
                //TreeMap��ʵ��Map����
                Map<String, String> tr = new TreeMap<>();
                tr.putAll(map);
                Iterator<String> iter = tr.keySet().iterator();
                System.out.println("TreeMap��ʵ��Map���ϣ�����������");
                while(iter.hasNext()){
                        String str = iter.next();
                        String name = map.get(str);
                        System.out.println(str+":"+name);
                }
                
                
                

        }

}
