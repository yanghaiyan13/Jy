package  oop.ui;

/**
 * Created by Administrator on 2018/7/12.
 */

        import java.awt.Color;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import javax.swing.JButton;
        import javax.swing.JOptionPane;

/**
 * Created by zn on 2018/7/12.
 * 实现了监听器接口
 */
public class ActionListenerImpl implements ActionListener {
       private JButton button;
   public ActionListenerImpl(JButton button) {
        this.button = button;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        JButton button = (JButton) e.getSource();

        if(command.equals("east")) {
            button.setBackground(Color.BLUE);
        } else if(command.equals("west")) {
            button.setForeground(Color.red);
        } else if(command.equals("center")) {
            JOptionPane.showMessageDialog(button.getParent(),"大家好");
        }
    }



}

