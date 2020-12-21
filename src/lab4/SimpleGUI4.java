package lab4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGUI4 extends JFrame
{
    private JButton button = new JButton("Отобразить");
    private JTextField input = new JTextField("", 5);
    public SimpleGUI4 ()
    {
        super("Простая программа");
        this.setBounds(400, 350, 500, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1, 2, 2, 2));
        container.add(input);
        ButtonGroup group = new ButtonGroup();
        container.add(button);
        button.addActionListener(new ButtonEventListener ());
    }
    class ButtonEventListener implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            String message = "";
            message += input.getText();
            if (message.length() != 0)
                JOptionPane.showMessageDialog(null, message, "Информация", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
