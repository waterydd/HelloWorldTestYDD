package Java_Basics;

/*
 * ��ȡ�����ļ������ݣ��������
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
                
//����Ŀ����·���£�����FileTest�࣬�жϸ�·�����Ƿ���� ydd.txt �ļ���������ڽ���ɾ�����������򴴽����ļ���
                File file = new File("F:/eclipse/workspace/HelloWorld/hello.txt");      //��ָ��·���£������ļ�����hello.txt
                System.out.println("(����Ŀ����·���£�����FileTest�࣬�жϸ�·�����Ƿ���� ydd.txt �ļ���������ڽ���ɾ�����������򴴽����ļ�)");
                if(file.exists()){      //�ж��ļ��Ƿ���ڣ�������ɾ��
                        file.delete();
                        System.out.println("ԭ hello.txt �ļ���ɾ��");
                }else{
                        try{    // try ���鲶׽���ܳ��ֵ��쳣
                                file.createNewFile();   //�������ļ�hello.txt
                                System.out.println("hello.txt �ļ��Ѵ���");
                        }catch(Exception e){
                                e.printStackTrace();
                        }
                }
                             
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
                
                //��ȡ��ǰ�ļ����µ� hello.txt �ļ����ļ������ļ����Ȳ��жϸ��ļ��Ƿ�Ϊ�����ļ���
                if (file.exists()){
                        String name = file.getName();   //��ȡ�ļ�����
                        long length = file.length();    //��ȡ�ļ�����
                        boolean hidden = file.isHidden();       //�ж��ļ��Ƿ�Ϊ�����ļ�
                        System.out.println(name+":");
                        System.out.println("�ļ����ȣ�" + length);
                        System.out.println("�ļ��Ƿ�Ϊ�����ļ�����"+ hidden);
                }else{
                        System.out.println("hello.txt �ļ������ڣ�");
                }
                
                
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
                
//ʹ�� FileOutputStream �����ļ�д����Ϣ��Ȼ��ͨ�� FileInputStream �ཫ�ļ��е����ݶ�ȡ������̨�ϡ�
                File file2 = new File("ydd.txt");
                try{
                        //���� FileOutputStream ����
                        FileOutputStream out = new FileOutputStream(file2);
                        //���� byte ��������
                        // String.getBytes( ) �������� String ����Ϊ byte ���У���������洢��һ���µ� byte �����С�
                        byte byt[] = "hello ydd!".getBytes();           //���� byte ������������Ϣ     
                        out.write(byt);         //��������Ϣд�뵽�����ļ��У��� byt.length ���ֽڴ�ָ�� byte ����д�뵽���ļ�������С�
                        out.close();    //�����ر�
                }catch(Exception e){    //�����쳣��Ϣ
                        e.printStackTrace();     
                }
                
                try{
                        //���� FileInputStream ����
                        FileInputStream in = new FileInputStream(file2);
                        byte byt[] = new byte[1024];    //���� byte ��������
                        int len = in.read(byt);         //���ļ��ж�ȡ��Ϣ���Ӵ��������н���� byt.length ���ֽڵ����ݶ��뵽һ�� byte �����С�
                        System.out.println("(ʹ�� FileOutputStream �����ļ�д����Ϣ��Ȼ��ͨ�� FileInputStream �ཫ�ļ��е����ݶ�ȡ������̨��)");
                       //String(byte[] bytes, int offset, int length) 
                        //ͨ��ʹ��ƽ̨��Ĭ���ַ�������ָ���� byte �����飬����һ���µ� String���������
                        System.out.println("ydd.txt�ļ��е���Ϣ�ǣ�\n"+ new String(byt,0,len));
                        in.close();     //�ر���
                }catch(Exception e){    // �����쳣��Ϣ
                        e.printStackTrace();
                }
 /*
  * �ַ����������
  */
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
//ʹ�� FileReader �� FileWirter ��д���ݵ������ļ���
                File file3 = new File("helloydd.txt");
                try{
                        //���� FileWriter ����
                        FileWriter out = new FileWriter(file3);
                        String s ="��ã�����java��" ;                  //��ȡ String ���ı�
                        out.write(s);            //����Ϣд������ļ���
                        out.close();
                                  
                }catch(Exception e){
                        e.printStackTrace();
                }
                
               try{
                       //���� FileReader ����
                       FileReader in = new FileReader(file3);
                       char[] s = new char[1024];                //���� char ������
                       int len =in.read(s);             //���ֽڶ�������
                       System.out.println("(ʹ�� FileReader �� FileWirter ��д���ݵ������ļ���)");
                       System.out.println(new String(s,0,len));         //���������Ϣ�����ļ���Ϣ��
                       in.close();
               }catch(Exception e){
                       e.printStackTrace();
               }
               
//��ָ���Ĵ����ļ���д�����ݣ���ͨ�� BufferedReader �ཫ�ļ��е���Ϣ������ʾ��
               System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
                String content[ ] ={"�þò�����","�������","����ϵ��"};
                File file4 = new File("BufferIO.txt");
                try{
                        //���� FileWriter �����
                        FileWriter fw = new FileWriter(file4);
                        //���� BufferedWriter �����
                        BufferedWriter bufw= new BufferedWriter(fw);
                        for(int i = 0; i < content.length; i++){                //ѭ������ content[ ] ����
                                bufw.write(content[i]);         //���ַ��������е�Ԫ��д�뵽�����ļ���
                                bufw.newLine();                 //�������еĵ���Ԫ���Ե��е���ʽд�뵽�ļ���
                        }                                               
                        bufw.close();           //�ر� BufferedWriter ��
                        fw.close();             //�ر� FileWriter ��
                }catch(Exception e){            //�����쳣
                        e.printStackTrace();
                }
                
                try{
                        //���� FileReader �����
                        FileReader fr = new FileReader(file4);
                      //���� BufferedReader �����
                        BufferedReader bufr = new BufferedReader(fr);
                        String s = null;        //���� String ����
                        int i = 0;
                        System.out.println("(��ָ���Ĵ����ļ���д�����ݣ���ͨ�� BufferedReader �ཫ�ļ��е���Ϣ������ʾ)");
                        while((s = bufr.readLine( )) != null){          //����ļ����ı�������Ϊ null�������ѭ��
                                i++;
                                System.out.println("��"+i+"�У�"+s);       //����ļ�����
                        }
                        bufr.close();   //�ر� BufferedReader ��
                        fr.close();      //�ر� FileReader ��
                }catch(Exception e){            //�����쳣
                        e.printStackTrace();
                }
               
        }
}
