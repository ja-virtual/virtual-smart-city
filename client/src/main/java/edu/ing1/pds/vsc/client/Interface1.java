package edu.ing1.pds.vsc.client;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Interface1 extends JFrame{
	
 public Interface1() {
	
	setSize(new Dimension(450,450));
	setLocationRelativeTo(null);
	setLayout(new FlowLayout());


	JLabel image = new JLabel();
	ImageIcon  img= new ImageIcon("logo-ja-virtual.png");
	image.setIcon( new ImageIcon(img.getImage().getScaledInstance(75,75, Image.SCALE_SMOOTH)));



}}
