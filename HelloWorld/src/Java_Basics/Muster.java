package Java_Basics;

/*
 * ������ı���
 * 
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * ���͵ı������ϵķ�����ͨ���������ϣ�����ͨ����������Iterator��
 * 
 * ����Ҫ������������ʵ�������϶��󣬲��򼯺������Ԫ�أ���󽫼����еĶ����� String ��ʽ���
 */
public class Muster {   //���� Muster ��

        public static void main(String[] args) {
                // TODO Auto-generated method stub

                Collection<String> list = new ArrayList<>();    //ʵ�������������
                list.add("a");          //�򼯺��������
                list.add("b");
                list.add("c");
                
                //ʹ�õ�������������
                Iterator<String> it = list.iterator();          //����������
                while(it.hasNext()){            //�ж��Ƿ�����һ��Ԫ��
                        String str = (String)it.next();         //��ȡ������Ԫ��
                        System.out.println(str);
                }
        }

}
