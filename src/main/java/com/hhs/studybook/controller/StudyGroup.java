package com.hhs.studybook.controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudyGroup {

	private JButton createGroup;
	
	public StudyGroup() {
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
}
