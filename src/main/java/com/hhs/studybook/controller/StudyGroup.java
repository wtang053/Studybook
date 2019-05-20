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

import java.awt.*;
import java.awt.event.*;

public class StudyGroup {

	private JButton createGroup;
	private Student s;
	private JPanel contentPane;
	
	public StudyGroup() {
		
      
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        contentPane.setLayout(null);
        
        
		createGroup = new JButton("Create Group!");
		createGroup.setBackground(Color.LIGHT_GRAY);
		JPanel right = new JPanel(new GridLayout(1,2));
	  	JPanel top = new JPanel();
	  	JPanel bottom = new JPanel();
	  	
	  	JPanel buttonBox = new JPanel(new GridLayout(3,1));

	  	
	  	buttonBox.add(createGroup);
	  	top.add(buttonBox);
	  	right.add(top);
	  	
	  	
	}
	
	public void createGroup() {
		
		
	}
}
