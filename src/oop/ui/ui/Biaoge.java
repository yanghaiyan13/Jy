package oop.ui.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Biaoge extends JFrame {

    public Biaoge()
    {



        JFrame f=new JFrame();
        Object[][] playerInfo={
                {"王鹏",new Integer(180),new Integer(80),new Boolean(true)},
                {"李鹏",new Integer(20),new Integer(30),new Boolean(false)},
                {"张鹏",new Integer(89),new Integer(60),new Boolean(true)}
        };
        String[] Names={"姓名","英语","数学","blue"};
        JTable table=new JTable(playerInfo,Names);
        table.setPreferredScrollableViewportSize(new Dimension(550,60));//设置此表视口的首选大小。
        JScrollPane scrollPane=new JScrollPane(table);
        f.setContentPane(scrollPane);

        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[]){

        new Biaoge();


    }
    private void Biaoge() {
        // TODO Auto-generated method stub

    }}
