package Java_Basics;

/*
 * ���������д��� Map ���ϣ�����ȡ Map �����е����� key ���󼯺Ϻ����� values ֵ����
 * ����������
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
                
                Set<String> set = map.keySet();         //���� map �������� key �����γɵļ���
                Iterator<String> it = set.iterator();
                System.out.println("key�����е�Ԫ�أ�");
                while (it.hasNext()){
                        System.out.println(it.next());
                }
                
                Collection<String> coll = map.values();
                it = coll.iterator();
                System.out.println("values�����е�Ԫ�أ�");
                while(it.hasNext()){
                        System.out.println(it.next());
                }
                                
        }

}
