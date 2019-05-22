package com.hhs.studybook.controller;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.hhs.studybook.entity.Student;
import com.hhs.studybook.swing.Login;

import java.awt.*;
import java.awt.event.*;

public class StudyGroup extends JFrame{

	private JButton createGroup;
	private Student s;
	private JPanel contentPane;
	private JPanel classPane;
	
	public StudyGroup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
      
        JLabel lblcreate = new JLabel("Create Group!");
        lblcreate.setHorizontalAlignment(SwingConstants.CENTER);
        lblcreate.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        lblcreate.setBounds(21, 11, 403, 73);
        contentPane.add(lblcreate);
        
         
		createGroup = new JButton("Create Group!");
		createGroup.setBackground(Color.LIGHT_GRAY);
		JPanel right = new JPanel(new GridLayout(1,2));
	  	JPanel top = new JPanel();
	  	JPanel bottom = new JPanel();
	  	
	  	
	  	JPanel buttonBox = new JPanel(new GridLayout(3,1));
	  	
	  	

	  	
	  	buttonBox.add(createGroup);
	  	top.add(buttonBox);
	  	right.add(top);
	  	
	  	createGroup.setBounds(21, 81, 403, 53);
        contentPane.add(createGroup);
        createGroup.addActionListener(new ActionListener() {
        	public void ActionPerformed(ActionEvent arg0) {
        	
        	        CreatedGroup c = new CreatedGroup();
        	        //c.main(null);
        		
        	}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CreatedGroup c = new CreatedGroup();
				c.main(null);
				
			}

        });
	  	
	}
	public void createGroup() {
		
		
	}
	/**
	 * 
	 * Launch the application
	 */
	 public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    StudyGroup frame = new StudyGroup();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }
}
