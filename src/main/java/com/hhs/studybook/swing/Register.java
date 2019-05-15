package com.hhs.studybook.swing;

import com.google.gson.Gson;
import com.hhs.studybook.util.ActionResult;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class Register extends JFrame {
    private final static String USER_AGENT = "Mozilla/5.0";
    private JPanel contentPane;
    private JTextField user;
    private JTextField pass;

    /**
     * Create the frame.
     */
    public Register() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
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

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(25, 77, 74, 14);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(25, 115, 74, 14);
        contentPane.add(lblPassword);

        pass = new JTextField();
        pass.setColumns(10);
        pass.setBounds(152, 112, 244, 20);
        contentPane.add(pass);

        JComboBox class1 = new JComboBox();
        class1.addItem("MATH");
        class1.addItem("ENGLISH");
        class1.setBounds(152, 143, 244, 20);
        contentPane.add(class1);

        JLabel lblClass = new JLabel("Class 1");
        lblClass.setBounds(25, 146, 46, 14);
        contentPane.add(lblClass);

        JLabel lblClass_1 = new JLabel("Class 2");
        lblClass_1.setBounds(25, 177, 46, 14);
        contentPane.add(lblClass_1);

        JComboBox class2 = new JComboBox();
        class2.addItem("MATH");
        class2.addItem("ENGLISH");
        class2.setBounds(152, 174, 244, 20);
        contentPane.add(class2);

        JButton btnCreateAccount = new JButton("Create Account!");
        btnCreateAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int i = 0;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://3.14.88.111:3306/studybook", "root", "StudY@BooK!2019");
                    Statement stmt = con.createStatement();
                    String sql = "Select * from tb_student where student_username='" + user.getText().toString() + "' and student_password = '" + pass.getText().toString() + "'"; // tbLogin     // Username Password
                    ResultSet rs = stmt.executeQuery(sql);
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Username exists");

                    } else {
                        // add the account into the SQL Server
                        btnCreateAccount.addActionListener(e -> {
                            HashMap<String, String> parameters = new HashMap<>();
                            parameters.put("studentName", "S1");
                            parameters.put("studentGender", "male");
                            parameters.put("studentAge", "11");
                            parameters.put("studentUsername", user.getText().toString());
                            parameters.put("studentPassword", pass.getText().toString());
                            try {
                                sendPost("http://127.0.0.1/addstudent", parameters);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnCreateAccount.setBounds(136, 228, 124, 23);
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

    private static ActionResult sendGet(String url) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        Gson g = new Gson();
        return g.fromJson(response.toString(), ActionResult.class);
    }

    private static void sendPost(String url, HashMap<String, String> parameters) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "";
        for (String key : parameters.keySet()) {
            String value = parameters.get(key);
            urlParameters += key + "=" + value + "&";
        }
        urlParameters.substring(0, urlParameters.length() - 1);

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }
}

