package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/7/14.
 */
//演示通过jdbc增加、删除，数据库数据



public class JDBCDemo {
    //获取一个数据库的连接对象
    private Connection getconnection(){
           //1.加载驱动
        try{
        Class.forName("com.mysql.jdbc.Driver");
            //2.创建连接字符串
            String dbURL="jdbc:mysql://17.0.0.1:3306/hnb11?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        //3.创立数据库连接2
            try{
         Connection connection= DriverManager.getConnection(dbURL,"root","1234");
            }catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }




    private void testInsertData(int i, String accountValue, String password){
        //1、创建数据库连接
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hnb11?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true","root","1234");
                //2、构建添加数据
                String sql="insert into account1(User_account,User_password) "+"values('"+accountValue+"','"+password+"')";
                //3、执行sql语句
                Statement  Statement=connection.createStatement();
                //4、得到执行后的结果，确定是否添加成功
                int rows=Statement.executeUpdate(sql);
                System.out.println("所影响的行数为："+rows);


            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void testDeleteData(int id){
        //1、创建数据库连接
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hnb11?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true",
                    "root","1234");
                //2、构建删除的sql语句
                String sql="delete from account1 where id="+id;
                //3、执行删除语句
                Statement  Statement=connection.createStatement();
                //4、获取执行所影响的行数，判断是否执行成功
                int rows=Statement.executeUpdate(sql);
                System.out.println("有：："+rows+"被删除");
            } catch (SQLException e) {
                e.printStackTrace();
            }



    }

    private void testUpdateData(int id ,String account,String password){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hnb11?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true",
                    "root","1234");
            String sql = "update account1 set user_account='"+ account + "',user_password = '" + password + "' where id=" + id;
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            System.out.println("更新结果为："+ (rows>0));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  static void main(String [] args){
             JDBCDemo demo=new  JDBCDemo();
             Scanner scanner=new Scanner(System.in);
             while(true){
             System.out.println("====================================================");
             System.out.println("|           欢迎使用hnb11人工智能系统                |");
             System.out.println("|  1、添加数据  2、修改数据 3、删除数据 4、退出系统   |");
             System.out.println("=====================================================");
             System.out.println("请选择你要进行的操作。。。。。");
             int select=0;
             select=scanner.nextInt();
            while(select<1||select>4){
                     System.out.println("选择的操作系统不能识别，请重新选择：");
                     select=scanner.nextInt();
            }

             String value=null;
             JDBCDemo jdbcdemo=new   JDBCDemo();
             if(select==1){
                 System.out.println("请输入要添加的账号和密码，中间用逗号分隔。举例：124.com.3445");
                 value=scanner.next();
                 String [] values=value.split(",");
                 jdbcdemo.testInsertData((int)System.currentTimeMillis(),
                 values[0],values[1]);
             }else if(select==2){//修改数据
                 System.out.println("请输入要修改的账号和密码和id，系统将根据id进行更新，id不会进行更新。");
                 value=scanner.next();
                 String [] values=value.split(",");
                 jdbcdemo.testUpdateData(Integer.parseInt( values[0]), values[1],values[2]);
             }else if(select==3){//删除数据
                 System.out.println("请输入要删除的id");
                 value=scanner.next();
                 String [] values=value.split(",");
                 jdbcdemo.testDeleteData(Integer.parseInt(value));

             }else if(select==4){//退出系统
                 System.out.println("退出系统");
                 System.exit(-1);

             }
           // demo.testInsertData("yahoo.com","4567");
            // demo.testDeleteData(27);
             //demo.testUpdate(27,"wangfang","1245");
    }
}}
