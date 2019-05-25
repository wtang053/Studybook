package com.hhs.studybook.swing;

import javax.swing.*;
import java.awt.*;

public class RoomSelection extends JFrame {
    private Integer userId;

    public RoomSelection(Integer userId) {
        this.userId = userId;

        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(2, 2);
        layout.setHgap(10);
        layout.setVgap(10);

        JButton jbMath = new JButton("Math");
        JButton jbEnglish = new JButton("English");
        JButton jbScience = new JButton("Science");
        JButton jbElective = new JButton("Elective");

        jbMath.addActionListener(e -> {
            ChatRoom frame = new ChatRoom("Math", userId);
            this.dispose();
        });
        jbEnglish.addActionListener(e -> {
            ChatRoom frame = new ChatRoom("English", userId);
            this.dispose();
        });
        jbScience.addActionListener(e -> {
            ChatRoom frame = new ChatRoom("Science", userId);
            this.dispose();
        });
        jbElective.addActionListener(e -> {
            ChatRoom frame = new ChatRoom("Elective", userId);
            this.dispose();
        });
        panel.setLayout(layout);
        panel.add(jbMath);
        panel.add(jbEnglish);
        panel.add(jbScience);
        panel.add(jbElective);
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 468, 609);


    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        //SpringApplication.run(StudybookApplication.class, args);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RoomSelection frame = new RoomSelection(1);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
