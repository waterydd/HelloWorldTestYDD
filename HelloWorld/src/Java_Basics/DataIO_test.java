package Java_Basics;

/*
 * �ֱ�ͨ�� DataOutputStream ��� writeUTF ( ) ��writeChars ( )��writeBytes ( )������ָ���Ĵ����ļ���д�����ݣ�
 * ��ͨ�� DataInputStream ��� readUTF( ) ������д����������������̨�ϡ�
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
                        //���� FileOutputStream ����
                        FileOutputStream fs = new FileOutputStream(file5);
                      //���� DataOutputStream ����
                        DataOutputStream ds = new DataOutputStream(fs);
                        ds.writeUTF("ʹ�� writeUTF ( )����д�����ݣ�");          //д������ļ�����
                        ds.writeChars("ʹ�� writeChars ( )����д�����ݣ�");
                        ds.writeBytes("ʹ�� writeBytes ( )����д�����ݣ�");
                        ds.close();             //�ر���
                        
                      //���� FileInputStream ����
                        FileInputStream fis = new FileInputStream(file5);
                      //���� DataInputStream ����
                        DataInputStream dis = new DataInputStream(fis);
                        
                        System.out.println(dis.readUTF());              //���ļ��������
                        
                }catch(Exception e){            //�����쳣
                        e.printStackTrace();
                }
        }

}
