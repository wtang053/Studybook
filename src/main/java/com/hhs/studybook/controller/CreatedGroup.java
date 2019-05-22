package com.hhs.studybook.controller;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.hhs.studybook.entity.Student;
import com.hhs.studybook.swing.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class CreatedGroup extends JFrame{
	private JButton b1;
	private Student s;
	private JPanel contentPane;
	private JPanel classPane;
	public CreatedGroup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblcreate = new JLabel("Choose Class");
        lblcreate.setHorizontalAlignment(SwingConstants.CENTER);
        lblcreate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblcreate.setBounds(21, 11, 403, 73);
        contentPane.add(lblcreate);
        
        JComboBox class1 = new JComboBox();
        class1.addItem("MATH");
        class1.addItem("ENGLISH");
        class1.addItem("SCIENCE");
        class1.addItem("LANGUAGE");
        class1.setBounds(41, 61, 403, 73);
        contentPane.add(class1);
        
        b1 = new JButton("Select");
        b1.setBounds(41, 111, 400, 53);
        contentPane.add(b1);
		b1.setBackground(Color.LIGHT_GRAY);
		JPanel right = new JPanel(new GridLayout(1,2));
	  	JPanel top = new JPanel();
	  	JPanel bottom = new JPanel();
	  	b1.addActionListener(new ActionListener() {
        	public void ActionPerformed(ActionEvent arg0) {
        		try  {
        	        CreatedGroup c = new CreatedGroup();
        	        c.main(null);
        		} catch(Exception e) {
        			System.out.println(e);
        		}
        	}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}

        });
      
	}
	
	
	
	/**
     * Launch the application.
     */
    public static void main(String[] args) {
        //SpringApplication.run(StudybookApplication.class, args);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CreatedGroup frame = new CreatedGroup();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
