package jdbc;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.protocol.a.result.ResultsetRowsStreaming;
import java.sql.*;
import java.util.Scanner;
import java.lang.String;

/**
 * Created by Administrator on 2018/7/14.
 */
//演示通过jdbc增加、删除，数据库数据
public class JDBCDemo {
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

    private  void close(Connection connection,Statement statement){
        try{

            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void testInsertData(int i, String accountValue, String password) throws SQLException {
        //1、创建数据库连接
        Statement Statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hnb11?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "1234");
                //2、构建添加数据
                String sql = "insert into account1(User_account,User_password) " + "values('" + accountValue + "','" + password + "')";
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

    private void testDeleteData(int id) throws SQLException {
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
            String sql = "delete from account1 where id=" + id;
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

    private void testUpdateData(int id ,String account,String password) throws SQLException {
        Statement Statement = null;
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
        }finally {
            if (Statement != null) {
                Statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }}

    private  String [][] bestFindAllData(){
        String [][] datas = new String[100][3];//以二维数组的形式在数据库中查找数据
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
        String sql = "select * from account1 ";
        statement = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            int index = 0;
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String account = resultSet.getString(2);
                String password = resultSet.getString(3);
                datas [index] [0] = id + "";
                datas [index] [1] = account + "";
                datas [index] [2] = password + "";
                index++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datas;
    }

    private  void findAllDataFormatOutput(){
        String [][] datas = bestFindAllData();//以表格形式显示出找到的数据
        StringBuffer buffer = new StringBuffer();
        buffer.append(" ========================================" + System.lineSeparator());
        buffer.append("|id\t\t|\taccount\t\t|\t password\t|"+System.lineSeparator());
        buffer.append(" ========================================" + System.lineSeparator());
        for (int i = 0; i < datas.length;i++){
            String [] values = datas[i];
            if(values[0] != null && values[1] != null && values[2] != null){
                buffer.append(String.format(" %s\t\t  %s\t\t%s",values[0],values[1],values[2]));
                buffer.append(System.lineSeparator());

            }
        }
        System.out.println(buffer.toString());
    }

    private void findAccountDateById(int id) throws SQLException {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hnb11?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true",
                "root","1234");
        //2、构建查询的SQL语句
        String sql = "select * from account1 where id="+id;
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
        buffer.append("id\t\t\t\t\t\taccount\t\t\t\t\t\t\tpassword\t\t\t" + System.lineSeparator());
        buffer.append("---------------------" + System.lineSeparator());

        while (resultSet.next()) {
            int id1 = resultSet.getInt("id");
            String account = resultSet.getString("User_account");
            String password = resultSet.getString("User_password");
            buffer.append(id1+ "\t|" + account + "|\t|" + password + "|" + System.lineSeparator());
        }
        System.out.println(buffer.toString());
    }

    private void findAccountDateLikeKey(String keyWord) throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hnb11?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true",
                "root","1234");
        //2、构建查询的SQL语句
        String sql = "select id,User_account,User_password  from account1 "+"where User_account like '%"+keyWord+"%'or User_password like '%"+keyWord+"%'or id like '%"+keyWord+"%'";
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
        buffer.append("id\t\t\t\t\t\taccount\t\t\t\t\t\t\tpassword\t\t\t" + System.lineSeparator());
        buffer.append("---------------------" + System.lineSeparator());

        while (resultSet.next()) {
            int id1 = resultSet.getInt("id");
            String account = resultSet.getString("User_account");
            String password = resultSet.getString("User_password");
            buffer.append(id1+ "\t|" + account + "|\t|" + password + "|" + System.lineSeparator());
        }
        System.out.println(buffer.toString());
    }

    public  static void main(String [] args) throws SQLException {
        JDBCDemo demo=new  JDBCDemo();
        Scanner scanner=new Scanner(System.in);
        JDBCDemo jdbcDemo=new   JDBCDemo();
        jdbcDemo.findAllDataFormatOutput();
        jdbcDemo.findAccountDateById(2);
        jdbcDemo.findAccountDateLikeKey("2");

        while(true){
            System.out.println("=====================================================");
            System.out.println("|===         欢迎使用hnb11人工智能系统            ===|");
            System.out.println("|  1、添加数据  2、修改数据 3、删除数据 4、退出系统  |");
            System.out.println("=====================================================");
            System.out.println("请选择你要进行的操作：");
            int select=0;
            select=scanner.nextInt();
            while(select<1||select>4){
                System.out.println("选择的操作系统不能识别，请重新选择：");
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
            // demo.testUpdate(27,"wangfang","1245");
        }
    }}
