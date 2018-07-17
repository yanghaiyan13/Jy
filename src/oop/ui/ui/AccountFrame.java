package oop.ui.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Administrator on 2018/7/13.
 */
public class AccountFrame extends JFrame {

    //上半部分面板
    private JPanel panelsearch=new JPanel();
//下半部分面板提供add,del,modify操作的面板
    private JPanel panelprocess=new JPanel();
    private JPanel jPanel=new JPanel();

   // private JTable jtable=new JTable(4,2);
    private JLabel jlable1=new JLabel("学号");
    private JLabel jlable2=new JLabel("姓名");
    private JLabel jlable3=new JLabel("身份证号码");
    private JLabel jlable4=new JLabel("家庭住址");

    //JScrollPane scrollPane=new JScrollPane(jtable);


    private JTextField jTextField=new JTextField();

    //搜索框
    private JTextField txtSearch=new JTextField();
    //搜索按钮
    private JButton btnSearch=new JButton("search");


    private JButton btnadd=new JButton("add");
    private JButton btndelete=new JButton("delete");
    private JButton btnmodify=new JButton("modify");
    //private  JLabel jLabel=new JLabel("显示");

   // private JLabel labAccount=new JLabel("账号：");
    //private JTextField txtAccount=new JTextField();
    private Object panelContent;

    public AccountFrame(){


        //jPanel.add(labAccount);
       // jPanel.add(txtAccount);

       // jPanel.add(jtable);
        //jPanel.setVisible(false);




    //初始化组建
        panelsearch.setLayout(new BorderLayout());//设置布局
        panelsearch.add(txtSearch);//添加搜索框到中间部分
        panelsearch.add(btnSearch,BorderLayout.EAST);//添加搜索按钮到右边
        panelprocess.setBackground(Color.gray);
        panelprocess.add( btnadd);
        panelprocess.add( btndelete);
        panelprocess.add( btnmodify);

        btnadd.setActionCommand("ADD");
        btndelete.setActionCommand("delete");
        ActionListenerImpl actionListener = new ActionListenerImpl(this);

        // 将事件监听器对象添加到事件源(按钮)
        btnadd.addActionListener(actionListener);
        btndelete.addActionListener(actionListener);


    this.add(panelsearch, BorderLayout.NORTH);//将搜索面板添加到上方
        this.add(panelprocess, BorderLayout.SOUTH);//将操作面板添加到下方
        this.add(jPanel, BorderLayout.CENTER);
       //jPanel.add(jLabel);





    //设定窗体相关属性
        this.setSize(800,600);
        this.setTitle("账号首页");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


}
    public static void main(String [] args) {

        AccountFrame accountFrame= new AccountFrame();

    }


}
