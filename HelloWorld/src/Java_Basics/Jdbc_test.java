package Java_Basics;

import java.sql.*;

public class Jdbc_test {
        public static void main(String[] args) throws Exception{
                String user = "root";
                String password = "yangdandan";
                String url = "jdbc:mysql://localhost:3306/test";
                String driver = "com.mysql.jdbc.Driver";
                
                Connection cn = null;   //���� Connection �������ݿ������ cn = DriverManager.getConnection( ) ������������
                Statement stmt = null;  //���� Statement ִ�� SQL ������
                ResultSet rs = null;    //���� ResultSet ���󣬴�����ݿ��ѯ���������
                
                try{
                        Class.forName(driver);  //����JDBC��������ע�ᵽDriverManager��
                        cn = DriverManager.getConnection(url, user, password);       //�������ݿ����ӣ�����ȡ Connection ����
                        stmt = cn.createStatement();  //��ȡ Statement ���󣬵��ö��󷽷���ִ�� SQL ���
                        stmt.execute("insert into person values(1,'yangdandan',18)");   //ִ�� SQL ���
                        stmt.execute("insert into person values(2,'qiurunchao',22)");
                        stmt.execute("insert into person values(3,'hebohan',23)");
                       rs = stmt.executeQuery("select * from person");       //��ȡ��ѯ�����
                        
                        //�������ݿ��ѯ���������ʾ
                       while (rs.next()){
                               System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
                           }
                           System.out.println("-------------------");
                       }catch (ClassNotFoundException e){
                           //���ݿ��������쳣����
                           System.out.println("sorry, can`t find the Driver!");
                           e.printStackTrace();
                       }
                       catch (SQLException e1){
                           //���ݿ�����ʧ���쳣����
                           System.out.println("���ݿ�����ʧ�ܣ�");
                           e1.printStackTrace();
                       }finally {
                           System.out.println("���ݿ����ݳɹ���ȡ����");
                           try{
                               if(rs != null) rs.close();//�ͷ�������Ż�ȡ�Ľ������ResultSet����
                               if(stmt != null) stmt.close();//�ر�����ʱ�����ͷ�Statement����
                               if(cn != null) cn.close();//�ر����ݿ����ӡ�
                           }catch (SQLException e){
                               System.out.println(e.getMessage());
                           }
                       }
        }

}
