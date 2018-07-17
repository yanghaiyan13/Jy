package oop.ui.ui;

import jdbc.JDBCDemo;

import java.sql.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/7/17.
 */
public class Lianxi {
    private static Random scanner;
    private Connection connection;
    //获取一个数据库的连接对象
    private Connection getconnection(){
        //1.加载驱动
        Statement Statement = null;
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
    private void InsertData(String namevalue, String publishers, String author) throws SQLException {
        //1、创建数据库连接
        Statement Statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hnb11?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "1234");
                //2、构建添加数据
                String sql = "insert into xinxi(Book_name,Book_publishers, Book_author) " + "values('" + publishers + "','" + author + "','"+namevalue+"')";
                //3、执行sql语句
                Statement = connection.createStatement();
                //4、得到执行后的结果，确定是否添加成功
                int rows = Statement.executeUpdate(sql);
                System.out.println("所影响的行数为：" + rows);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (Statement != null) {
                Statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    private void UpdateData(int id ,String namevalue,String publishers,String author) throws SQLException {
        Statement Statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hnb11?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true",
                    "root","1234");
            String sql = "update xinxi set Book_name='"+ namevalue + "', Book_publishers = '" + publishers+ "' ,Book_author='" + author+ "'where id=" + id;
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            System.out.println("更新结果为："+ (rows>0));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (Statement != null) {
                Statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }}

    private void DeleteData(int id) throws SQLException {
        //1、创建数据库连接
        Statement Statement = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hnb11?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "1234");
            //2、构建删除的sql语句
            String sql = "delete from xinxi where id=" + id;
            //3、执行删除语句
            Statement = connection.createStatement();
            //4、获取执行所影响的行数，判断是否执行成功
            int rows = Statement.executeUpdate(sql);
            System.out.println("有：：" + rows + "被删除");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (Statement != null) {
                Statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }}
    private  String [][] FindAllData(){
        String [][] datas = new String[100][5];//以二维数组的形式在数据库中查找数据
        Connection connection = null;
        Statement  statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hnb11?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true",
                    "root","1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "select * from xinxi ";
        statement = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            int index = 0;
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String namevalue = resultSet.getString(2);
                String publishers = resultSet.getString(3);
                String author = resultSet.getString(4);
                datas [index] [0] = id + "";
                datas [index] [1] = namevalue + "";
                datas [index] [2] = publishers + "";
                datas [index] [3] = author + "";
                index++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datas;
    }

    private  void findAllDataFormat(){
        String [][] datas = FindAllData();//以表格形式显示出找到的数据
        StringBuffer buffer = new StringBuffer();
        buffer.append(" ========================================" + System.lineSeparator());
        buffer.append("|id\t\t|\tnamevalue\t\t|\tpublishers \t\t|\tauthor\t|"+System.lineSeparator());
        buffer.append(" ========================================" + System.lineSeparator());
        for (int i = 0; i < datas.length;i++){
            String [] values = datas[i];
            if(values[0] != null && values[1] != null && values[2] != null&& values[3] != null){
                buffer.append(String.format(" %s\t\t  %s\t\t%s",values[0],values[1],values[2],values[3]));
                buffer.append(System.lineSeparator());

            }
        }
        System.out.println(buffer.toString());
    }

    private void findBooktDate(String keyWord) throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hnb11?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true",
                "root","1234");
        //2、构建查询的SQL语句
        String sql = "select id,Book_name,Book_publishers  from xinxi "+"where Book_name like '%"+keyWord+"%'or Book_publishers like '%"+keyWord+"%'or id like '%"+keyWord+"%'";
        //3、执行SQL语句，并获得结果集

        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //4、遍历结果集，输出每条记录的信息

        StringBuffer buffer = new StringBuffer();
        buffer.append("---------------------" + System.lineSeparator());
        buffer.append("|id\t\t|\tnamevalue\t\t|\tpublishers \t\t|\tauthor\t|"+System.lineSeparator());
        buffer.append("---------------------" + System.lineSeparator());

        while (resultSet.next()) {
            int id1 = resultSet.getInt("id");
            String namevalue = resultSet.getString("Book_name");
            String publishers= resultSet.getString("Book_publishers");

            buffer.append(id1+ "\t|" + namevalue + "|\t|" + publishers + "|" + System.lineSeparator());
        }
        System.out.println(buffer.toString());
    }
    public  static void main(String [] args) throws SQLException {
        Lianxi lianxi=new Lianxi();
        // lianxi.InsertData("yufeng","5467","juhonh");
        // lianxi.DeleteData(4);
        //  lianxi.UpdateData(3,"lifeng","6789","yihu");
        //   lianxi.findAllDataFormat();
        // lianxi.findBooktDate("4");
        while(true){
            System.out.println("=====================================================");
            System.out.println("|===         欢迎使用hnb11人工智能系统            ===|");
            System.out.println("|  1、添加数据  2、修改数据 3、删除数据  4、退出系统  |");
            System.out.println("=====================================================");
            System.out.println("请选择你要进行的操作：");
            long select=0;
            select=scanner.nextInt();
            while(select<1||select>4){
                System.out.println("选择的操作系统不能识别，请重新选择：");
            }

            String value=null;
            JDBCDemo jdbcdemo=new   JDBCDemo();
            if(select==1){
                System.out.println("请输入要添加书籍名和出版社，中间用逗号分隔。");
                value= String.valueOf(scanner.nextInt());
                String [] values=value.split(",");
                lianxi.InsertData(String.valueOf((int)System.currentTimeMillis()),
                        values[0],values[1]);

            }else if(select==2){//修改数据
                System.out.println("请输入要修改的书籍名和出版社和id，系统将根据id进行更新，id不会进行更新。");
                value= String.valueOf(scanner.nextInt());
                String [] values=value.split(",");
                lianxi.UpdateData(Integer.parseInt( values[0]), values[1],values[2],values[3]);
            }else if(select==3){//删除数据
                System.out.println("请输入要删除的id");
                value= String.valueOf(scanner.nextInt());
                String [] values=value.split(",");
                lianxi.DeleteData(Integer.parseInt(value));

            }
            else if(select==6){//退出系统
                System.out.println("退出系统");
                System.exit(-1);

            }

        }}}
