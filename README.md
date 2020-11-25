# New-project
package multiplicationJarfile;

import Multiplication.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Table extends JFrame {

    private Container c;
    private Font f;
    private ImageIcon img;
    private JLabel imglabel, textlabel;

    private JTextField textField;
    private JButton ClearButton;

    private JTextArea textArea;

    Table() {

        c = this.getContentPane();
        c.setLayout(null);

        f = new Font("Arial ", Font.BOLD, 17);

        img = new ImageIcon(getClass().getResource("pic.png"));
        this.setIconImage(img.getImage());

        imglabel = new JLabel(img);
        imglabel.setBounds(20, 30, 350, 220);
        c.add(imglabel);

        textlabel = new JLabel("Enter any number: ");
        textlabel.setBounds(20, 270, 250, 50);
        textlabel.setFont(f);
        c.add(textlabel);

        textField = new JTextField();
        textField.setBounds(170, 270, 90, 50);

        textField.setFont(f);
        c.add(textField);

        ClearButton = new JButton("Clear");
        ClearButton.setBounds(280, 270, 90, 50);
        ClearButton.setForeground(java.awt.Color.white);
        ClearButton.setOpaque(true);
        ClearButton.setBackground(java.awt.Color.DARK_GRAY);
        ClearButton.setFont(f);
        c.add(ClearButton);

        textArea = new JTextArea();
        textArea.setBounds(20, 350, 350, 250);
        textArea.setFont(f);
        textArea.setForeground(java.awt.Color.black);
        textArea.setOpaque(true);
        textArea.setBackground(java.awt.Color.ORANGE);
        c.add(textArea);

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = textField.getText();

                if (value.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "you didn't  put any number");
                } else {

                    textArea.setText(" ");

                    int num = Integer.parseInt(textField.getText());

                    for (int i = 1; i <= 10; i++) {

                        int result = num * i;
                        String r = String.valueOf(result);
                        String n = String.valueOf(num);
                        String incre = String.valueOf(i);

                        textArea.append(n + "x" + incre + "=" + r + "\n");

                    }

                }

            }

        });

        ClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                textArea.setText(" ");

                //   textField.setText(" ");
            }

        });

    }

    public static void main(String args[]) {

        Table ob = new Table();
        ob.setVisible(true);
        ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ob.setBounds(330, 10, 400, 650);
        ob.setTitle("Multiplication Table");
        ob.setResizable(true);

    }
}
