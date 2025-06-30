package pg11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class Representative extends JFrame implements ActionListener {
    JTextField repnoField, repnameField, stateField, commField, rateField;
    JTextField custnoField, custnameField, creditField;
    JButton submitButton, displayButton;
    Connection con;

    Representative() {
        setTitle("Representative and Customer Entry");

        // Labels and Fields
        JLabel repnoLabel = new JLabel("RepNo:");
        repnoField = new JTextField(15);

        JLabel repnameLabel = new JLabel("RepName:");
        repnameField = new JTextField(15);

        JLabel stateLabel = new JLabel("State:");
        stateField = new JTextField(15);

        JLabel commLabel = new JLabel("Commission:");
        commField = new JTextField(15);

        JLabel rateLabel = new JLabel("Rate:");
        rateField = new JTextField(15);

        JLabel custnoLabel = new JLabel("CustNo:");
        custnoField = new JTextField(15);

        JLabel custnameLabel = new JLabel("CustName:");
        custnameField = new JTextField(15);

        JLabel creditLabel = new JLabel("Credit Limit:");
        creditField = new JTextField(15);

        submitButton = new JButton("Submit");
        displayButton = new JButton("Display");

        setLayout(new GridLayout(9, 2, 5, 5));
        add(repnoLabel); add(repnoField);
        add(repnameLabel); add(repnameField);
        add(stateLabel); add(stateField);
        add(commLabel); add(commField);
        add(rateLabel); add(rateField);
        add(custnoLabel); add(custnoField);
        add(custnameLabel); add(custnameField);
        add(creditLabel); add(creditField);
        add(submitButton); add(displayButton);

        submitButton.addActionListener(this);
        displayButton.addActionListener(this);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Rep1", "root", "Akshay07@123");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database Connection Error: " + e.getMessage());
        }

        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submitButton) {
            try {
                int repno = Integer.parseInt(repnoField.getText());
                String repname = repnameField.getText();
                String state = stateField.getText();
                int commission = Integer.parseInt(commField.getText());
                String rate = rateField.getText();

                int custno = Integer.parseInt(custnoField.getText());
                String custname = custnameField.getText();
                int creditLimit = Integer.parseInt(creditField.getText());

                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Representative VALUES (?, ?, ?, ?, ?)");
                ps.setInt(1, repno);
                ps.setString(2, repname);
                ps.setString(3, state);
                ps.setInt(4, commission);
                ps.setString(5, rate);
                ps.executeUpdate();

                PreparedStatement ps1 = con.prepareStatement(
                    "INSERT INTO Customer VALUES (?, ?, ?, ?, ?)");
                ps1.setInt(1, custno);
                ps1.setString(2, custname);
                ps1.setString(3, state);
                ps1.setInt(4, creditLimit);
                ps1.setInt(5, repno);
                ps1.executeUpdate();

                JOptionPane.showMessageDialog(this, "Data Inserted Successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        } else if (ae.getSource() == displayButton) {
            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(
                    "SELECT * FROM Representative WHERE RepNo IN " +
                    "(SELECT RepNo FROM Customer WHERE Credit_Limit > 15000)");

                JFrame tableFrame = new JFrame("Representatives with Credit_Limit > 15000");
                String[] columns = {"RepNo", "RepName", "State", "Commission", "Rate"};
                DefaultTableModel model = new DefaultTableModel(columns, 0);

                while (rs.next()) {
                    Object[] row = {
                        rs.getInt("RepNo"),
                        rs.getString("RepName"),
                        rs.getString("State"),
                        rs.getInt("Commission"),
                        rs.getString("Rate")
                    };
                    model.addRow(row);
                }

                JTable table = new JTable(model);
                JScrollPane scrollPane = new JScrollPane(table);
                tableFrame.add(scrollPane);
                tableFrame.setSize(600, 400);
                tableFrame.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Representative();
    }
}
