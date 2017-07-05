package Java_Basics;

import java.sql.*;

public class Jdbc_test {
        public static void main(String[] args) throws Exception{
                String user = "root";
                String password = "yangdandan";
                String url = "jdbc:mysql://localhost:3306/test";
                String driver = "com.mysql.jdbc.Driver";
                
                Connection cn = null;   //声明 Connection 连接数据库对象，用 cn = DriverManager.getConnection( ) 方法建立连接
                Statement stmt = null;  //声明 Statement 执行 SQL 语句对象
                ResultSet rs = null;    //声明 ResultSet 对象，存放数据库查询操作结果集
                
                try{
                        Class.forName(driver);  //加载JDBC驱动，并注册到DriverManager中
                        cn = DriverManager.getConnection(url, user, password);       //建立数据库连接，并获取 Connection 对象
                        stmt = cn.createStatement();  //获取 Statement 对象，调用对象方法来执行 SQL 语句
                        stmt.execute("insert into person values(1,'yangdandan',18)");   //执行 SQL 语句
                        stmt.execute("insert into person values(2,'qiurunchao',22)");
                        stmt.execute("insert into person values(3,'hebohan',23)");
                       rs = stmt.executeQuery("select * from person");       //获取查询结果集
                        
                        //遍历数据库查询结果集并显示
                       while (rs.next()){
                               System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
                           }
                           System.out.println("-------------------");
                       }catch (ClassNotFoundException e){
                           //数据库驱动类异常处理
                           System.out.println("sorry, can`t find the Driver!");
                           e.printStackTrace();
                       }
                       catch (SQLException e1){
                           //数据库连接失败异常处理
                           System.out.println("数据库连接失败！");
                           e1.printStackTrace();
                       }finally {
                           System.out.println("数据库数据成功获取！！");
                           try{
                               if(rs != null) rs.close();//释放用来存放获取的结果集的ResultSet对象。
                               if(stmt != null) stmt.close();//关闭连接时，先释放Statement对象。
                               if(cn != null) cn.close();//关闭数据库连接。
                           }catch (SQLException e){
                               System.out.println(e.getMessage());
                           }
                       }
        }

}
