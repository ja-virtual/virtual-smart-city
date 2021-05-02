package edu.ing1.pds.vsc.client;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
	ImageIcon  img= new ImageIcon("logo_ja_virtual.png");
	image.setIcon( new ImageIcon(img.getImage().getScaledInstance(75,75, Image.SCALE_SMOOTH)));
	JLabel c1= new JLabel("Bienvenue %username% sur la pateforme de Virtual Smart City\n");
	JLabel c2= new JLabel("La maitrise, l'expérience, vous êtes chez vous !");
	c1.setFont(new Font("Serif", Font.BOLD, 25));
	
	
	
	setResizable(false);
	setVisible(true);


}
public static void main (String[] args )
{
	new Interface1();}
}
