package com.hhs.studybook.swing;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends JFrame {

    private JPanel contentPane;
    private JTextField user;
    private JPasswordField pass;

    /**
     * Create the frame.
     */
    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 468, 309);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblLogin = new JLabel("Login");
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        lblLogin.setBounds(21, 11, 403, 73);
        contentPane.add(lblLogin);

        JLabel lblUsername = new JLabel("USERNAME");
        lblUsername.setBounds(31, 95, 131, 14);
        contentPane.add(lblUsername);

        user = new JTextField();
        user.setBounds(28, 120, 396, 28);
        contentPane.add(user);
        user.setColumns(10);

        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setBounds(31, 162, 131, 14);
        contentPane.add(lblPassword);

        JButton btnLogin = new JButton("LOGIN");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int i = 0;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://3.14.88.111:3306/studybook", "root", "StudY@BooK!2019");
                    Statement stmt = con.createStatement();
                    String sql = "Select * from tb_student where student_username='" + user.getText().toString() + "' and student_password = '" + pass.getText().toString() + "'"; // tbLogin     // Username Password
                    ResultSet rs = stmt.executeQuery(sql);
                    System.out.println(sql);
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Login succesfully");
                    } else {
                    //	if(sql.equals("")) {
                    	//	JOptionPane.showMessageDialog(null, "Empty Login");
                    	//}
                        JOptionPane.showMessageDialog(null, "Login incorrect");

                    }
                    con.close();

                } catch (Exception e) {
                    System.out.print(e);
                }
            }
        });
        btnLogin.setBounds(335, 226, 89, 23);
        contentPane.add(btnLogin);

        pass = new JPasswordField();
        pass.setBounds(31, 192, 393, 28);
        contentPane.add(pass);

        JButton btnRegister = new JButton("REGISTER");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Register r = new Register();
                r.main(null);
            }
        });
        btnRegister.setBounds(31, 226, 89, 23);
        contentPane.add(btnRegister);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        //SpringApplication.run(StudybookApplication.class, args);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
