package Java_Basics;

/*
 * ���� List ���϶���
ͨ�� Math ��� random( )���������ȡ�����е�ĳ��Ԫ��
Ȼ���Ƴ�����������λ���ǡ�2����Ԫ��
���������飨���ϣ�
 * 
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class List_test {        //������

        public static void main(String[] args) {
                // TODO Auto-generated method stub
                
                List<String> list = new ArrayList<>();  //��������ʵ������
                list.add("a");          //�򼯺����Ԫ��
                list.add("b");
                list.add("b");
                list.add("b");
                list.add("c");
                int i = (int) (Math.random()+(list.size()-1));          //���0~2��������
                System.out.println("����Ԫ�أ�"+list.get(i));
                list.remove(2);         //�Ƴ�ָ������λԪ��
                System.out.println("������Ϊ2��Ԫ���Ƴ���������Ԫ�أ�");
//                for(int j= 0; j < list.size(); j++){            //ѭ����������
//                        System.out.println(list.get(j));
//                }
                Iterator<String> it = list.iterator();          //ʹ�õ�������������
                while(it.hasNext()){
                        System.out.println(it.next());
                }

        }

}
