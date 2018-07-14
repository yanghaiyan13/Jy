package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 2018/7/14.
 */
public class JDBCDemo {
    //演示通过jdbc连接到数据库
    private  void testconnection(){
           //1.加载驱动
        try{
        Class.forName("com.mysql.jdbc.Driver");
            //2.创建连接字符串
            String dbURL="jdbc:mysql://127.0.0.1:3306/hnb11";
        //3.创立数据库连接
            try{
         Connection connection= DriverManager.getConnection(dbURL,"root","1234");
            }catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public  static void main(String [] args){
    JDBCDemo demo=new  JDBCDemo();
    demo.testconnection();
    }
}
