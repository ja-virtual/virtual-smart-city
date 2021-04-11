package edu.ing1.pds.vsc.client;

import javax.imageio.ImageIO;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Accueil extends JFrame  {
	
	
	static JLabel j3;
	 static JFrame frame; 
	    

	    public static void main(String[] args) throws IOException 
	    {
	    	
	    		frame = new JFrame("frame"); 
	 	        BufferedImage img = ImageIO.read(new File("logo-ja-virtual.png"));
	 	        JLabel pic = new JLabel(new ImageIcon(img));
	 	        frame.add(pic);
	 	        JPanel jp = new JPanel(); 
	 	        j3 = new JLabel("Accueil");
	 	        jp.add(j3);
	 	        
	 	        
	 	        frame.show();
	 		    frame.setSize(300,300);
	 	        frame.setLayout(null);
	 	        frame.setVisible(true);
	    	
	    
    } 
 	    	
}