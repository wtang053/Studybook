package com.hhs.studybook.swing;

import com.hhs.studybook.util.SwingUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;

public class Register extends JFrame {
    private JPanel contentPane;
    private JTextField user;
    private JPasswordField pass;
    private JTextField textFieldName;
    private JTextField textFieldAge;


    /**
     * Create the frame.
     */
    public Register() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblRegister = new JLabel("Register");
        lblRegister.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        lblRegister.setBounds(160, 11, 124, 52);
        contentPane.add(lblRegister);

        user = new JTextField();
        user.setBounds(152, 71, 244, 20);
        contentPane.add(user);
        user.setColumns(10);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(25, 181, 74, 14);
        contentPane.add(lblName);
        textFieldName = new JTextField();
        textFieldName.setColumns(10);
        textFieldName.setBounds(152, 181, 244, 20);
        contentPane.add(textFieldName);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(25, 77, 74, 14);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(25, 115, 74, 14);
        contentPane.add(lblPassword);

        pass = new JPasswordField();
        pass.setColumns(10);
        pass.setEchoChar('*');
        pass.setBounds(152, 112, 244, 20);
        contentPane.add(pass);

        JLabel lblAge = new JLabel("Age");
        lblAge.setBounds(25, 181 + 35, 74, 14);
        contentPane.add(lblAge);
        textFieldAge = new JTextField();
        textFieldAge.setColumns(10);
        textFieldAge.setBounds(152, 181 + 35, 244, 20);
        contentPane.add(textFieldAge);

        JComboBox jbGender = new JComboBox();
        jbGender.addItem("Male");
        jbGender.addItem("Female");
        jbGender.setBounds(152, 143, 244, 20);
        contentPane.add(jbGender);


        JLabel lblClass = new JLabel("Gender");
        lblClass.setBounds(25, 146, 46, 14);
        contentPane.add(lblClass);


        JButton btnCreateAccount = new JButton("Create Account!");//String sql = "Select * from tb_student where
        // student_username='" + user.getText().toString() + "' and student_password = '" + pass.getText().toString()
        // + "'"; // tbLogin     // Username Password
        btnCreateAccount.addActionListener(e -> {
            try {

                HashMap<String, String> parameters = new HashMap<>();
                parameters.put("studentName", textFieldName.getText());
                parameters.put("studentGender", String.valueOf(jbGender.getSelectedItem()));
                parameters.put("studentAge", textFieldAge.getText());
                parameters.put("studentUsername", user.getText().toString());
                parameters.put("studentPassword", String.valueOf(pass.getPassword()));

                try {
                    int code = SwingUtil.sendPost(SwingUtil.SERVER_URL + "addstudent", parameters);
                    if (code == 233) {
                        JOptionPane.showMessageDialog(this, "Account created");
                        this.dispose();
                    } else if (code == 411) {
                        JOptionPane.showMessageDialog(this, "Username exists");

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            } catch (Exception exc) {
                exc.printStackTrace();

            }
        });
        btnCreateAccount.setBounds(136, 370, 124, 23);
        contentPane.add(btnCreateAccount);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Register frame = new Register();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


}

