package Java_Basics;

/*
 * 读取磁盘文件的数据：输入输出
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.text.html.HTMLDocument.Iterator;

public class FileIO_Test {
        public static void main(String[] args){
                
//在项目所在路径下，创建FileTest类，判断该路径下是否存在 ydd.txt 文件，如果存在将其删除，不存在则创建该文件。
                File file = new File("F:/eclipse/workspace/HelloWorld/hello.txt");      //在指定路径下，创建文件对象：hello.txt
                System.out.println("(在项目所在路径下，创建FileTest类，判断该路径下是否存在 ydd.txt 文件，如果存在将其删除，不存在则创建该文件)");
                if(file.exists()){      //判断文件是否存在，存在则删除
                        file.delete();
                        System.out.println("原 hello.txt 文件已删除");
                }else{
                        try{    // try 语句块捕捉可能出现的异常
                                file.createNewFile();   //创建该文件hello.txt
                                System.out.println("hello.txt 文件已创建");
                        }catch(Exception e){
                                e.printStackTrace();
                        }
                }
                             
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
                
                //获取当前文件夹下的 hello.txt 文件的文件名、文件长度并判断该文件是否为隐藏文件。
                if (file.exists()){
                        String name = file.getName();   //获取文件名称
                        long length = file.length();    //获取文件长度
                        boolean hidden = file.isHidden();       //判断文件是否为隐藏文件
                        System.out.println(name+":");
                        System.out.println("文件长度：" + length);
                        System.out.println("文件是否为隐藏文件？："+ hidden);
                }else{
                        System.out.println("hello.txt 文件不存在！");
                }
                
                
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
                
//使用 FileOutputStream 类向文件写入信息，然后通过 FileInputStream 类将文件中的数据读取到控制台上。
                File file2 = new File("ydd.txt");
                try{
                        //创建 FileOutputStream 对象
                        FileOutputStream out = new FileOutputStream(file2);
                        //创建 byte 类型数组
                        // String.getBytes( ) 方法将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
                        byte byt[] = "hello ydd!".getBytes();           //创建 byte 类型数组存放信息     
                        out.write(byt);         //将数组信息写入到磁盘文件中！将 byt.length 个字节从指定 byte 数组写入到此文件输出流中。
                        out.close();    //将流关闭
                }catch(Exception e){    //处理异常信息
                        e.printStackTrace();     
                }
                
                try{
                        //创建 FileInputStream 对象
                        FileInputStream in = new FileInputStream(file2);
                        byte byt[] = new byte[1024];    //创建 byte 类型数组
                        int len = in.read(byt);         //从文件中读取信息！从此输入流中将最多 byt.length 个字节的数据读入到一个 byte 数组中。
                        System.out.println("(使用 FileOutputStream 类向文件写入信息，然后通过 FileInputStream 类将文件中的数据读取到控制台上)");
                       //String(byte[] bytes, int offset, int length) 
                        //通过使用平台的默认字符集解码指定的 byte 子数组，构造一个新的 String，并输出！
                        System.out.println("ydd.txt文件中的信息是：\n"+ new String(byt,0,len));
                        in.close();     //关闭流
                }catch(Exception e){    // 处理异常信息
                        e.printStackTrace();
                }
 /*
  * 字符流输入输出
  */
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
//使用 FileReader 和 FileWirter 读写数据到磁盘文件中
                File file3 = new File("helloydd.txt");
                try{
                        //创建 FileWriter 对象
                        FileWriter out = new FileWriter(file3);
                        String s ="你好，我是java！" ;                  //获取 String 型文本
                        out.write(s);            //将信息写入磁盘文件！
                        out.close();
                                  
                }catch(Exception e){
                        e.printStackTrace();
                }
                
               try{
                       //创建 FileReader 对象
                       FileReader in = new FileReader(file3);
                       char[] s = new char[1024];                //创建 char 型数组
                       int len =in.read(s);             //将字节读入数组
                       System.out.println("(使用 FileReader 和 FileWirter 读写数据到磁盘文件中)");
                       System.out.println(new String(s,0,len));         //输出数组信息，即文件信息！
                       in.close();
               }catch(Exception e){
                       e.printStackTrace();
               }
               
//向指定的磁盘文件中写入数据，并通过 BufferedReader 类将文件中的信息分行显示。
               System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
                String content[ ] ={"好久不见？","最近好吗？","常联系！"};
                File file4 = new File("BufferIO.txt");
                try{
                        //创建 FileWriter 类对象
                        FileWriter fw = new FileWriter(file4);
                        //创建 BufferedWriter 类对象
                        BufferedWriter bufw= new BufferedWriter(fw);
                        for(int i = 0; i < content.length; i++){                //循环遍历 content[ ] 数组
                                bufw.write(content[i]);         //将字符串数组中的元素写入到磁盘文件中
                                bufw.newLine();                 //将数组中的单个元素以单行的形式写入到文件中
                        }                                               
                        bufw.close();           //关闭 BufferedWriter 流
                        fw.close();             //关闭 FileWriter 流
                }catch(Exception e){            //处理异常
                        e.printStackTrace();
                }
                
                try{
                        //创建 FileReader 类对象
                        FileReader fr = new FileReader(file4);
                      //创建 BufferedReader 类对象
                        BufferedReader bufr = new BufferedReader(fr);
                        String s = null;        //创建 String 对象
                        int i = 0;
                        System.out.println("(向指定的磁盘文件中写入数据，并通过 BufferedReader 类将文件中的信息分行显示)");
                        while((s = bufr.readLine( )) != null){          //如果文件的文本行数不为 null，则进入循环
                                i++;
                                System.out.println("第"+i+"行："+s);       //输出文件数据
                        }
                        bufr.close();   //关闭 BufferedReader 流
                        fr.close();      //关闭 FileReader 流
                }catch(Exception e){            //处理异常
                        e.printStackTrace();
                }
               
        }
}
