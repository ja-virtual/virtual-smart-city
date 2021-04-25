package edu.ing1.pds.vsc.client.accessCardManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class AccessManagementMain extends JFrame {

	private JPanel right=new JPanel();
	JPanel left = new JPanel(new GridLayout(5,1));
	Color color=new Color(190,245,116);

	private void Interface()
	{

	}
	public AccessManagementMain()
	{
		setLayout(new BorderLayout());

		//Left menu creation

		left.setMinimumSize(new Dimension(250, 480));
		left.setPreferredSize(new Dimension(250, 480));
		left.setMaximumSize(new Dimension(250, 480));

		JPanel p=new JPanel();
		JLabel image = new JLabel();
		ImageIcon  img= new ImageIcon("https://upecnumerique.sharepoint.com/:i:/s/EPISEN-SI-ING12020-2021-PdsGroup6/EXg1vMxVXN5BvDjaNMnr0a8BVBVLGC0CygC4SMZWy6QXNg?e=PwQPSc");
		image.setIcon( new ImageIcon(img.getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH)));
		JLabel phrase_acceuil = new JLabel("Bienvenue JUTT MILL");
		phrase_acceuil.setFont(new Font("Serif", Font.BOLD, 13));
		p.add(image);
		p.add(phrase_acceuil);
		p.setBackground(color);
		left.add(p);


		p=new JPanel();
		image = new JLabel();
		img= new ImageIcon("http://4.bp.blogspot.com/-gOjC9BYmNLw/U5f97P5O7sI/AAAAAAAAAhs/WnXb0QbxN24/s1600/green-home-icon.png");
		image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));


		JLabel use_case = new JLabel("Acceuil");
		use_case.setFont(new Font("Serif", Font.BOLD, 15));
		p.add(image);
		p.add(use_case);
		p.setBackground(color);
		left.add(p);


		image = new JLabel();
		img= new ImageIcon("lien de l’image");
		image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));

		use_case = new JLabel("Services");
		use_case.setFont(new Font("Serif", Font.BOLD, 15));
		p.add(image);
		p.add(use_case);
		p.setBackground(color);
		left.add(p);

		p=new JPanel();
		image = new JLabel();
		img= new ImageIcon(" ");
		image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));


		use_case = new JLabel("Gestion des accès");
		use_case.setFont(new Font("Serif", Font.BOLD, 15));
		p.add(image);
		p.add(use_case);
		p.setBackground(color);
		left.add(p);
		image = new JLabel();
		img= new ImageIcon("");
		image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));

		use_case = new JLabel("Contacts");
		use_case.setFont(new Font("Serif", Font.BOLD, 15));
		p.add(image);
		p.add(use_case);
		p.setBackground(color);
		left.add(p);

		//creation of the right menu
		right.setBackground(Color.white);
		right.setLayout(new BorderLayout());

		JMenuBar menuBar=new JMenuBar();

		menuBar.setBorderPainted(isDoubleBuffered());
		menuBar.setSize(750,45);
		JMenu list=new JMenu("menu");
		list.setSize(750,45);

		JMenuItem menuItem1=new JMenuItem("Statut des badges");
		JMenuItem menuItem2=new JMenuItem("Créer un badge");

		menuBar.add(list);
		list.add(menuItem1);
		list.add(menuItem2);
		right.add(menuBar, BorderLayout.NORTH);

		this.getContentPane().add(left,BorderLayout.WEST);
		this.getContentPane().add(right,BorderLayout.CENTER);
		left.setBackground(color);

		setSize(new Dimension(950,780));
		setLocationRelativeTo(null);
		setResizable(false);

		setVisible(true);
	}
	public static void main(String[] args) {
		new AccessManagementMain();

	}

}