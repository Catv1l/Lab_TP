package lab4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGUI2 extends JFrame
{
    private JButton button = new JButton("Все готово");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Введите имя:");
    private JCheckBox check = new JCheckBox("Согласны?", false);
    public SimpleGUI2 ()
    {
        super("Простая программа");
        this.setBounds(300, 100, 300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2, 2, 2, 2));
        container.add(label);
        container.add(input);
        ButtonGroup group = new ButtonGroup();
        container.add(button);
        button.addActionListener(new ButtonEventListener ());
        container.add(check);
    }
    class ButtonEventListener implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            String message = "";
            message += "Вас зовут " + input.getText() + ".";
            message += ((check.isSelected()) ? " Вы согласились с именем." : " Вы не согласились с именем.");
            JOptionPane.showMessageDialog(null, message, "Ваше имя", JOptionPane.PLAIN_MESSAGE);
        }

    }
}