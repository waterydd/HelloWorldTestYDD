package Java_Basics;

/*
 * 联结继承时，创建子类，会依次自动调用前辈（父类）的构造方法。
 * 
 */
 class Test0 {
        Test0(){
                System.out.println("调用父类 Test0 的构造方法");
        }

}

class Test1 extends Test0{       //继承父类
        Test1(){
                System.out.println("调用子类 Test1 的构造方法");
        }
        
}

public class ExtendsTest extends Test1{

        ExtendsTest(){
                System.out.println("调用子类 Test 的构造方法");
        }
        
        public static void main(String[] args){
                ExtendsTest a = new ExtendsTest();


        }

}