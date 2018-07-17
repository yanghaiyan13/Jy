package ui1;


import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2018/7/15.
 */
public class Wanggebuju  extends JFrame {

    public Wanggebuju(){
        this.setSize(300,400);

        this.setTitle("user jiemian.....");
        //在窗体中增加面板
        JPanel jPanel=new JPanel();
        JTable jTable=new JTable(4,2);
        JLabel name=new JLabel("姓名：");
        JLabel account=new JLabel("账号：");
        JLabel password=new JLabel("密码：");
        JLabel introduced=new JLabel("基本信息：");
        JTextField textname=new JTextField();
        JTextField textaccount=new JTextField();
        JTextField textpassword=new JTextField();
        JTextField textintroduce=new JTextField();
         jTable.add(name);
        jTable.add(textname);
        jTable.add(account);
        jTable.add(textaccount);
        jTable.add(password);
        jTable.add(introduced);
        jTable.add(textintroduce);
        jPanel.add(jTable);
          this.add(jPanel);
          this.setvisible(true);
       this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);


    }

    private void setDefaultCloseOperation(int exitOnClose) {
    }

    public static void main(String [] args) {

         new Wanggebuju();

    }
}





