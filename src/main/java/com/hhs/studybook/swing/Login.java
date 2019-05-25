package com.hhs.studybook.swing;


import com.hhs.studybook.util.SwingUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Login extends JFrame {


    private JPanel contentPane;
    private JTextField user;
    private JPasswordField pass;
    private Image image;

    /**
     * Create the frame.
     */
    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 468, 609);
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
        btnLogin.addActionListener(e -> {
            try {
                String username = user.getText();
                String password = String.valueOf(pass.getPassword());
                HashMap<String, String> parameters = new HashMap<>();
                parameters.put("studentUsername", username);
                parameters.put("studentPassword", password);

                int code = SwingUtil.sendPost("http://127.0.0.1:8080/login", parameters);
                if (code == 234) {
                    JOptionPane.showMessageDialog(this, "Logged in");
                } else if (code == 410) {
                    JOptionPane.showMessageDialog(this, "Login failed, please check your username and password");
                } else {
                    JOptionPane.showMessageDialog(this, "Login failed, please check your network status");
                }
            } catch (Exception ex) {
                System.out.print(ex);
            }
        });
        btnLogin.setBounds(335, 226, 89, 23);
        contentPane.add(btnLogin);

        pass = new JPasswordField();
        pass.setBounds(31, 192, 393, 28);
        pass.setEchoChar('*');
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


        JLabel j = new JLabel(new ImageIcon("file:///Users/waltertang/git/Studybook/lib/logo.png"));
        j.setBounds(0, 0, 468, 609);
        contentPane.add(j);

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
