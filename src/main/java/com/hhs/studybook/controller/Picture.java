package com.hhs.studybook.controller;
import java.awt.geom.Rectangle2D;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
public class Picture extends Rectangle2D.Double {
	
	//fields
	private Image image;
	
	//constructor
	public Picture(String filename, int x, int y, int w, int h) {
		this((new ImageIcon(filename)).getImage(),x,y,w,h);
	}
	
	
	//constructor
	public Picture(Image img, int x, int y, int w, int h) {
		super(x, y, w, h);
		image = img;
	}
	/**
	 * draws the image
	 * @param g
	 * @param io
	 */
	public void draw(Graphics g, ImageObserver io) {
		g.drawImage(image,(int)x,(int)y,(int)width,(int)height,io);
	}

	public static void main(String[] args) throws IOException {
		
	}
	
	
	
}
