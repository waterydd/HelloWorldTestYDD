package Java_Basics;

/*
 * 分别通过 DataOutputStream 类的 writeUTF ( ) 、writeChars ( )、writeBytes ( )方法向指定的磁盘文件中写入数据，
 * 并通过 DataInputStream 类的 readUTF( ) 方法将写入的数据输出到控制台上。
 * 
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.List;

public class DataIO_test {

        public static void main(String[] args) {
                // TODO Auto-generated method stub

                File file5 = new File("DataIO.txt");
                try{
                        //创建 FileOutputStream 对象
                        FileOutputStream fs = new FileOutputStream(file5);
                      //创建 DataOutputStream 对象
                        DataOutputStream ds = new DataOutputStream(fs);
                        ds.writeUTF("使用 writeUTF ( )方法写入数据；");          //写入磁盘文件数据
                        ds.writeChars("使用 writeChars ( )方法写入数据；");
                        ds.writeBytes("使用 writeBytes ( )方法写入数据；");
                        ds.close();             //关闭流
                        
                      //创建 FileInputStream 对象
                        FileInputStream fis = new FileInputStream(file5);
                      //创建 DataInputStream 对象
                        DataInputStream dis = new DataInputStream(fis);
                        
                        System.out.println(dis.readUTF());              //将文件数据输出
                        
                }catch(Exception e){            //处理异常
                        e.printStackTrace();
                }
        }

}
