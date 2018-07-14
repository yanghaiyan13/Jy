package oop.ui.ui;

/**
 * Created by Administrator on 2018/7/12.
 */

import oop.ui.Jiemian;
import oop.ui.ui.AccountFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
     * Created by zn on 2018/7/12.
     * 实现了监听器接口
     */
    public class ActionListenerImpl implements ActionListener {
        private JFrame accountFrame = null;
    private JFrame jiemian = null;
        public ActionListenerImpl(JFrame frame) {
            accountFrame = frame;

        }


    public ActionListenerImpl() {

    }
        //    private JButton button;
//    public ActionListenerImpl(JButton button) {
//        this.button = button;
//    }
        @Override
       public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            JButton button = (JButton) e.getSource();
           if(command.equals("CANCEL")) {
               //JOptionPane.showMessageDialog(button.getParent(), new AccountFrame());
              AccountFrame  acountFrame=new  AccountFrame();
              jiemian.setVisible(false);

           } else if(command.equals("ADD")) {
               //JOptionPane.showMessageDialog(button.getParent(),new Jiemian());
               Jiemian jiemian = new Jiemian();
               accountFrame.setVisible(false);
            }
        }



    }


