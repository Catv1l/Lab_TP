package lab4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGUI3 extends JFrame
{
    private JButton button = new JButton("Скрыть поле");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Введите число:");
    public SimpleGUI3 ()
    {
        super("Простая программа");
        this.setBounds(600, 100, 300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2, 2, 2, 2));
        container.add(label);
        container.add(input);
        ButtonGroup group = new ButtonGroup();
        container.add(button);
        button.addActionListener(new ButtonEventListener ());
        input.setBackground(Color.green);
    }
    class ButtonEventListener implements ActionListener
    {
        int a = -1;
        public void actionPerformed (ActionEvent e)
        {
            a++;
            if (a % 2 == 0)
            {
                input.setVisible(false);
                button.setText("Показать поле");
            }
            else
            {
                input.setVisible(true);
                button.setText("Скрыть поле");
            }
        }

    }
}
