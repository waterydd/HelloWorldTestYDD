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
                System.out.println("key�����е�Ԫ�أ�");
                while (it.hasNext()){
                        System.out.println(it.next());
                }
        }

}
