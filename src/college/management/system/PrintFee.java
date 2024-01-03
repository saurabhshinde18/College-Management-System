package college.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class PrintFee extends JFrame implements ActionListener {

    private Choice rollNoChoice;
    private JTable feeTable;
    private JButton searchButton, printButton, cancelButton;

    public PrintFee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        rollNoChoice = new Choice();
        rollNoChoice.setBounds(180, 20, 150, 20);
        add(rollNoChoice);

        try {
            Conn connection = new Conn();
            ResultSet resultSet = connection.s.executeQuery("select * from student");
            while (resultSet.next()) {
                rollNoChoice.add(resultSet.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        feeTable = new JTable();

        try {
            Conn connection = new Conn();
            ResultSet resultSet = connection.s.executeQuery("select * from collegefee");
            feeTable.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(feeTable);
        scrollPane.setBounds(0, 100, 900, 600);
        add(scrollPane);

        searchButton = new JButton("Search");
        searchButton.setBounds(20, 70, 80, 20);
        searchButton.addActionListener(this);
        add(searchButton);

        printButton = new JButton("Print");
        printButton.setBounds(120, 70, 80, 20);
        printButton.addActionListener(this);
        add(printButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(220, 70, 80, 20);
        cancelButton.addActionListener(this);
        add(cancelButton);

        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == searchButton) {
            String query = "select * from collegefee where rollno = '" + rollNoChoice.getSelectedItem() + "'";
            try {
                Conn connection = new Conn();
                ResultSet resultSet = connection.s.executeQuery(query);
                feeTable.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == printButton) {
            try {
                feeTable.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new PrintFee();
    }
}
