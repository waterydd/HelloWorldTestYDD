package Java_Basics;

/*
 * ����̳�ʱ���������࣬�������Զ�����ǰ�������ࣩ�Ĺ��췽����
 * 
 */
 class Test0 {
        Test0(){
                System.out.println("���ø��� Test0 �Ĺ��췽��");
        }

}

class Test1 extends Test0{       //�̳и���
        Test1(){
                System.out.println("�������� Test1 �Ĺ��췽��");
        }
        
}

public class ExtendsTest extends Test1{

        ExtendsTest(){
                System.out.println("�������� Test �Ĺ��췽��");
        }
        
        public static void main(String[] args){
                ExtendsTest a = new ExtendsTest();


        }

}