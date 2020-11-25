package table;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StudentTable extends JFrame implements ActionListener {

    private Container c;
    private Font f;
    private JLabel titleLabel, firstLabel, lastLabel, phoneLabel, gpLabel;
    private JTextField firstField, lastField, phoneField, gpField;
    private JButton addbutton, updatebutton, deletbutton, clearbutton;
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;

    private String[] colum = {"First name", " Last name", " Phone number ", "GPA"};
    private String[] row = new String[4];

    StudentTable() {
        display();
    }

    public void display() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(300, 40, 800, 700);
        this.setTitle(" Student Management ");

        c = this.getContentPane();
        c.setLayout(null);
        f = new Font("Arial", Font.BOLD, 16);

        titleLabel = new JLabel(" Student Registration");
        titleLabel.setBounds(130, 20, 200, 50);
        titleLabel.setFont(f);
        c.add(titleLabel);

        // 1 number  JLabel , First JTextField and  First JButton Start
        firstLabel = new JLabel(" First Name");
        firstLabel.setBounds(10, 100, 200, 30);
        firstLabel.setFont(f);
        c.add(firstLabel);

        firstField = new JTextField();
        firstField.setBounds(110, 100, 200, 30);
        c.add(firstField);

        addbutton = new JButton("Add");
        addbutton.setBounds(350, 100, 80, 30);
        c.add(addbutton);

        // 2 number JLabel , JTextField and   JButton Start
        lastLabel = new JLabel(" Last Name");
        lastLabel.setBounds(10, 140, 200, 30);
        lastLabel.setFont(f);
        c.add(lastLabel);

        lastField = new JTextField();
        lastField.setBounds(110, 140, 200, 30);
        c.add(lastField);

        updatebutton = new JButton("Update");
        updatebutton.setBounds(350, 140, 80, 30);
        c.add(updatebutton);

        // 3 number  JLabel ,  JTextField and  JButton Start
        phoneLabel = new JLabel(" Phone");
        phoneLabel.setBounds(10, 180, 200, 30);
        phoneLabel.setFont(f);
        c.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(110, 180, 200, 30);
        c.add(phoneField);

        deletbutton = new JButton("Delet");
        deletbutton.setBounds(350, 180, 80, 30);
        c.add(deletbutton);

        // 4 number  JLabel ,  JTextField and  JButton Start
        gpLabel = new JLabel(" GPA");
        gpLabel.setBounds(10, 220, 200, 30);
        gpLabel.setFont(f);
        c.add(gpLabel);

        gpField = new JTextField();
        gpField.setBounds(110, 220, 200, 30);
        c.add(gpField);

        clearbutton = new JButton("Clear");
        clearbutton.setBounds(350, 220, 80, 30);
        c.add(clearbutton);

        table = new JTable();

        model = new DefaultTableModel();
        model.setColumnIdentifiers(colum);

        table.setModel(model);
        table.setFont(f);
        table.setSelectionBackground(Color.lightGray);
        table.setBackground(Color.white);
        table.setRowHeight(30);

        scroll = new JScrollPane(table);
        scroll.setBounds(10, 280, 740, 265);
        c.add(scroll);

        addbutton.addActionListener(this);
        clearbutton.addActionListener(this);
        deletbutton.addActionListener(this);
        updatebutton.addActionListener(this);

        // udate part start
        table.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                int numberRow = table.getSelectedRow();

                String Fname = model.getValueAt(numberRow, 0).toString();
                String Lname = model.getValueAt(numberRow, 1).toString();
                String phone = model.getValueAt(numberRow, 2).toString();
                String gpa = model.getValueAt(numberRow, 3).toString();

                firstField.setText(Fname);
                lastField.setText(Lname);
                phoneField.setText(phone);
                gpField.setText(gpa);

            }

        });

    }

    // add part start ,Clear button and update button part start
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addbutton) {

            row[0] = firstField.getText();
            row[1] = lastField.getText();
            row[2] = phoneField.getText();
            row[3] = gpField.getText();

            model.addRow(row);

        } else if (e.getSource() == clearbutton) {

            firstField.setText(" ");
            lastField.setText(" ");
            phoneField.setText(" ");
            gpField.setText(" ");

        } else if (e.getSource() == deletbutton) {

            int numberRow = table.getSelectedRow();

            if (numberRow >= 0) {
                model.removeRow(numberRow);
            } else {
                JOptionPane.showMessageDialog(null, " no row has selected or row exits");
            }

        } else if (e.getSource() == updatebutton) {

            int numberRow = table.getSelectedRow();

            String Fname = firstField.getText();
            String Lname = lastField.getText();
            String phone = phoneField.getText();
            String gpa = gpField.getText();

            model.setValueAt(Fname, numberRow, 0);
            model.setValueAt(Lname, numberRow, 1);
            model.setValueAt(phone, numberRow, 2);
            model.setValueAt(gpa, numberRow, 3);

        }

    }

    public static void main(String[] args) { 

        StudentTable ob = new StudentTable();
        ob.setVisible(true);

    }

}
