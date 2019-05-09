package com.hhs.studybook.swing;

import com.google.gson.Gson;
import com.hhs.studybook.entity.Student;
import com.hhs.studybook.util.ActionResult;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;

public class FirstSwingExample {
    private final static String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) {
        JFrame f = new JFrame();//creating instance of JFrame
        JButton b_add = new JButton("AddStudent");//creating instance of JButton
        b_add.setBounds(100, 100, 100, 40);
        JButton b = new JButton("List Students");//creating instance of JButton
        b.setBounds(130, 100, 100, 40);//x axis, y axis, width, height
        f.add(b);//adding button in JFrame
        f.add(b_add);
        f.setSize(400, 500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible

        b_add.addActionListener(e -> {
            HashMap<String, String> parameters = new HashMap<>();
            parameters.put("studentName", "S1");
            parameters.put("studentGender", "male");
            parameters.put("studentAge", "11");
            try {
                sendPost("http://127.0.0.1/addstudent", parameters);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

        b.addActionListener(e -> {
            try {
                ActionResult actionResult = sendGet("http://127.0.0.1/listAllStudents");
                Student[] students = new Gson().fromJson(actionResult.getData().toString().trim().replace(", ", ",").replace(" ", "　"), Student[].class);
                Arrays.sort(students);
                for (Student s : students) {
                    System.out.println(s.toString());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
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