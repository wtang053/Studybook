package com.hhs.studybook.swing;

import com.google.gson.internal.LinkedTreeMap;
import com.hhs.studybook.util.ActionResult;
import com.hhs.studybook.util.SwingUtil;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.List;

public class ChatRoom {

    private JFrame frame;
    private JTextArea textArea;
    private JTextField textField;
    private JButton btn_send;
    private JPanel southPanel;
    private JScrollPane rightScroll;

    private DefaultListModel listModel;
    private boolean isRunning = true;


    // 构造方法

    /**
     * Home page of the program
     *
     * @param roomTitle One of the four chat rooms (Math, Science, English, or Elective)
     * @param userId    Student ID
     */
    public ChatRoom(String roomTitle, Integer userId) {
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setForeground(Color.blue);
        textField = new JTextField();
        btn_send = new JButton("Send");
        listModel = new DefaultListModel();


        rightScroll = new JScrollPane(textArea);
        rightScroll.setBorder(new TitledBorder("Chat"));
        southPanel = new JPanel(new BorderLayout());
        southPanel.add(textField, "Center");
        southPanel.add(btn_send, "East");
        southPanel.setBorder(new TitledBorder("Write Message"));

        frame = new JFrame(roomTitle);
        frame.setLayout(new BorderLayout());
        frame.add(rightScroll, "Center");
        frame.add(southPanel, "South");
        frame.setSize(600, 400);
        int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;
        frame.setLocation((screen_width - frame.getWidth()) / 2,
                (screen_height - frame.getHeight()) / 2);
        frame.setVisible(true);

        textField.addActionListener(arg0 -> {
            HashMap<String, String> parameters = new HashMap<>();
            parameters.put("roomTitle", roomTitle);
            parameters.put("userId", userId + "");
            parameters.put("chatText", textField.getText());
            try {
                textField.setText("");
                SwingUtil.sendPost(SwingUtil.SERVER_URL + "addChat", parameters);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        btn_send.addActionListener(e -> {
            HashMap<String, String> parameters = new HashMap<>();
            parameters.put("roomTitle", roomTitle);
            parameters.put("userId", userId + "");
            parameters.put("chatText", textField.getText());
            try {
                SwingUtil.sendPost(SwingUtil.SERVER_URL + "addChat", parameters);
                textField.setText("");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                isRunning = true;
                System.exit(0);
            }
        });


        new Thread(() -> {

            while (isRunning) {
                try {
                    ActionResult result = null;
                    try {
                        result = SwingUtil.sendGet(SwingUtil.SERVER_URL + "listAllStudents");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    List<LinkedTreeMap> studentLinkedTreeMaps = (List<LinkedTreeMap>) result.getData();
                    HashMap<Integer, String> studentMap = new HashMap<>();
                    for (LinkedTreeMap student : studentLinkedTreeMaps) {
                        studentMap.put((int) Double.parseDouble(student.get("id").toString()), student.get(
                                "studentName").toString());
                    }

                    HashMap<String, String> parameters = new HashMap<>();
                    parameters.put("roomTitle", roomTitle);
                    ActionResult result2 = SwingUtil.getFromPost(SwingUtil.SERVER_URL + "getAllChats", parameters);
                    List<LinkedTreeMap> mathChatRooms = (List<LinkedTreeMap>) result2.getData();
                    textArea.setText("");
                    for (LinkedTreeMap mathChatRoom : mathChatRooms) {
                        textArea.append(studentMap.get((int) Double.parseDouble(mathChatRoom.get("studentId").toString())) + "--" + mathChatRoom.get("date").toString().replace("PDT　2019", "") + "\n" + mathChatRoom.get("text") + "\n\n");
                    }
                    Thread.sleep(2000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }


            }

        }).start();

    }

    // 主方法,程序入口
    // Test case
    public static void main(String[] args) {
        new ChatRoom("Math", 1);
    }

}
