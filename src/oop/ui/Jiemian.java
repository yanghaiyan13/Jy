package oop.ui;

/**
 * Created by Administrator on 2018/7/13.
 */
import oop.ui.ui.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Jiemian extends JFrame implements ActionListener
{
    JButton login = new JButton("添加");
    JButton exit = new JButton("退出");
    JLabel  name = new JLabel("user：");
    JLabel password = new JLabel("password：");
    JTextField JName = new JTextField("GridLayout"); //账号

    JPasswordField JPassword = new JPasswordField("1234"); // 密码

    private Object Diaoyong;

    public Jiemian()
    {
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(3,2));  //3行2列的面板jp（网格布局）
        jp.setBounds(20, 40, 40, 30);
        name.setHorizontalAlignment(SwingConstants.LEFT);  //设置该组件的对齐方式为向左对齐
        password.setHorizontalAlignment(SwingConstants.LEFT);

        jp.add(name);   //将内容加到面板jp上
        jp.add(JName);
        jp.add(password);
        jp.add(JPassword);
        jp.add(login);
        jp.add(exit);

        login.addActionListener(this); //登录增加事件监听
        exit.addActionListener(this);   //退出增加事件监听

        this.add(jp);   //将整块面板定义在中间

        this.setBounds(300, 400, 400, 300);
        this.setTitle("accoun-log");
        this.setLocation(500,300);  //设置初始位置

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)  // 对时间进行处理
    {
        if(e.getSource() == exit)
        {


            exit.setActionCommand("CANCEL");
            oop.ui.ui.ActionListenerImpl actionListener = new oop.ui.ui.ActionListenerImpl(this);
            AccountFrame  acountFrame=new  AccountFrame();

            // 将事件监听器对象添加到事件源(按钮)
            exit.addActionListener(actionListener);

            // 显示选择对话框
           this.setVisible(false);
        }
        else
        {
            if(JName.getText().equals("admin")&& String.valueOf(JPassword.getPassword()).equals("admin"))
            {
                JOptionPane.showMessageDialog(null, "登录成功，欢迎到来！");
                //显示信息提示框
                System.exit(0);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "GridLayout,1234");
                //显示信息提示框
                JName.setText("");
                JPassword.setText("");
            }
        }
    }
    public static void main(String[] args)
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
       new Jiemian();

    }}



