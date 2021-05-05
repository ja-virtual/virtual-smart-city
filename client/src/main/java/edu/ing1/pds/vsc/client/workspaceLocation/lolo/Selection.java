package edu.ing1.pds.vsc.client.workspaceLocation.lolo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import edu.ing1.pds.vsc.client.General_Services;
import edu.ing1.pds.vsc.client.HomePage;
import edu.ing1.pds.vsc.client.MappingManagement.List_Position;
import edu.ing1.pds.vsc.client.MappingManagement.Map_Full;
import edu.ing1.pds.vsc.client.MappingManagement.MappingUC;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Selection extends JFrame{
	
	public  JLabel image;
	public JPanel header;
	public Color colorr;
	public JLabel welcome_phrase;
	public JPanel criterias;
	public JLabel criteria1;
	public JButton check;
	public int area;
	public int price;
	public int employee_nbr;
	public String floor;
	public int openspace_nbr;
	public int individual_office_nbr;
	public int meetingroom_nbr;


	private JPanel right=new JPanel(new BorderLayout());
	JPanel left = new JPanel(new GridLayout(5,1));
	Color color=new Color(190,245,116);
	General_Services company = null;
	
	
	private void Interface()
	{
		setLayout(new BorderLayout());
this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//Left menu creation

		left.setMinimumSize(new Dimension(250, 480));
		left.setPreferredSize(new Dimension(250, 480));
		left.setMaximumSize(new Dimension(250, 480));

		JPanel p=new JPanel(new BorderLayout());
		JLabel image = new JLabel();
		ImageIcon  img= new ImageIcon("/home/amal/Documents/PDS/virtual-smart-city/client/src/main/java/edu/ing1/pds/vsc/client/logo-ja-virtual.png");
		image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));
		image.setHorizontalAlignment(JLabel.CENTER);
		JLabel welcome_sentence = new JLabel("Bienvenue "+company.getCompany_name());
		welcome_sentence.setHorizontalAlignment(JLabel.CENTER);
		welcome_sentence.setFont(new Font("Serif", Font.ITALIC, 20));
		p.add(image,BorderLayout.NORTH);
		p.add(welcome_sentence,BorderLayout.CENTER);
		p.setBackground(color);
		left.add(p);
		p=new JPanel(new GridLayout());
		JLabel use_case1 = new JLabel("Gestion de Location");
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				
				HomePage t = new HomePage();
				t.setVisible(true);
				dispose();
			}
		});
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				e.getComponent().setBackground(Color.white);
			}
			public void mouseExited(MouseEvent e)
			{
				e.getComponent().setBackground(color);
			}
		});
		use_case1.setHorizontalAlignment(JLabel.CENTER);
		use_case1.setFont(new Font("Serif", Font.BOLD,17));
		p.add(use_case1,BorderLayout.CENTER);
		p.setBackground(color);
		left.add(p);
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{

			
				HomePage t = new HomePage();
				t.setVisible(true);
				dispose();
			}
		});
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				e.getComponent().setBackground(Color.white);
			}
			public void mouseExited(MouseEvent e)
			{
				e.getComponent().setBackground(color);
			}
		});


		p=new JPanel(new GridLayout());
		JLabel use_case2 = new JLabel("Mappage Capteur/Equipement");
		use_case2.setHorizontalAlignment(JLabel.CENTER);
		use_case2.setFont(new Font("Serif", Font.BOLD,17));;
		p.add(use_case2,BorderLayout.CENTER);
		p.setBackground(color);
		left.add(p);
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				
				MappingUC t = new MappingUC(company);
				t.setVisible(true);
				dispose();
			}
		});
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				e.getComponent().setBackground(Color.white);
				use_case2.setForeground(color);
			}
			public void mouseExited(MouseEvent e)
			{
				e.getComponent().setBackground(color);
				use_case2.setForeground(Color.black);
			}
		});

		p=new JPanel(new GridLayout());

		JLabel use_case3 = new JLabel("Configuration Fenetre EC");
		use_case3.setHorizontalAlignment(JLabel.CENTER);
		use_case3.setFont(new Font("Serif", Font.BOLD,17));
		p.add(use_case3,BorderLayout.CENTER);
		p.setBackground(color);
		left.add(p);
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
					
				
				HomePage t = new HomePage();
				t.setVisible(true);
				dispose();
			}
		});
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				e.getComponent().setBackground(Color.white);
			}
			public void mouseExited(MouseEvent e)
			{
				e.getComponent().setBackground(color);
			}
		});

		p=new JPanel(new GridLayout());
		image = new JLabel();
		img= new ImageIcon("/home/amal/Documents/PDS/virtual-smart-city/client/src/main/java/edu/ing1/pds/vsc/client/logo-ja-virtual.png");
		image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));


		JLabel use_case4 = new JLabel("Gestion Acc�s");
		use_case4.setHorizontalAlignment(JLabel.CENTER);
		use_case4.setFont(new Font("Serif", Font.BOLD,17));
		p.add(use_case4,BorderLayout.CENTER);
		p.setBackground(color);
		left.add(p);
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
			
				HomePage t = new HomePage();
				t.setVisible(true);
				dispose();
			}
		});
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				e.getComponent().setBackground(Color.white);
			}
			public void mouseExited(MouseEvent e)
			{
				e.getComponent().setBackground(color);
			}
		});

		//creation of the right menu
//		right.setBackground(Color.white);
		right.setLayout(new BorderLayout());

		JMenuBar menuBar=new JMenuBar();

		menuBar.setBorderPainted(isDoubleBuffered());
		menuBar.setSize(750,45);
		JMenu list=new JMenu("Liste des emplacements ");
		list.setSize(750,45);
		list.addMenuListener(new MenuListener() {
	          
			 
	           @Override
	           public void menuSelected(MenuEvent e) {

	             List_Position lp=new List_Position(company);
	        	   
	            	dispose();
	           }
	 
	           @Override
	           public void menuDeselected(MenuEvent e) {
	           }
	 
	           @Override
	           public void menuCanceled(MenuEvent e) {
	             
	           }
	       });
		JMenu map=new JMenu("Plan");
		map.addMenuListener(new MenuListener() {
	          
			 
	           @Override
	           public void menuSelected(MenuEvent e) {
	        	 
					Map_Full hp=new Map_Full(company);
	            	dispose();

	           }
	 
	           @Override
	           public void menuDeselected(MenuEvent e) {
	           }
	 
	           @Override
	           public void menuCanceled(MenuEvent e) {
	             
	           }
	       });
		map.setSize(150,45);
		menuBar.add(list);
		menuBar.add(map);
		menuBar.add(Box.createHorizontalGlue());
		JMenu homePage=new JMenu("Acceuil");
		homePage.addMenuListener(new MenuListener() {
	          
			 
	           @Override
	           public void menuSelected(MenuEvent e) {
	        	
	              HomePage hp=new HomePage();
	              dispose();
	           }
	 
	           @Override
	           public void menuDeselected(MenuEvent e) {
	           }
	 
	           @Override
	           public void menuCanceled(MenuEvent e) {
	             
	           }
	       });
		menuBar.add(homePage);
		JMenu leave=new JMenu("Quitter");
		leave.addMenuListener(new MenuListener() {
 	          
  			 
	           @Override
	           public void menuSelected(MenuEvent e) {
	              dispose();
	           }
	 
	           @Override
	           public void menuDeselected(MenuEvent e) {
	           }
	 
	           @Override
	           public void menuCanceled(MenuEvent e) {
	             
	           }
	       });
		menuBar.add(leave);
		right.add(menuBar, BorderLayout.NORTH);

		this.getContentPane().add(left,BorderLayout.WEST);
		this.getContentPane().add(right,BorderLayout.CENTER);
		left.setBackground(color);

		setSize(new Dimension(950,780));
		setLocationRelativeTo(null);
		setResizable(false);

	}

	public Selection(ArrayList<Offer> ofr, General_Services gs)
	{
		company = gs;
		Interface();
		
		JPanel p3 = new JPanel(new BorderLayout());
		right.add(p3, BorderLayout.CENTER);

		
		setSize(new Dimension(850,850));
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		
		getContentPane().setBackground(color);
		setResizable(true);
		setVisible(true);
		
		JPanel header = new JPanel(new GridLayout(1,1));
		this.header = header;
		JLabel image = new JLabel();
		this.image = image;
		ImageIcon  img= new ImageIcon("/home/amal/Documents/PDS/virtual-smart-city/client/src/main/java/edu/ing1/pds/vsc/client/logo-ja-virtual.png");
		image.setIcon( new ImageIcon(img.getImage().getScaledInstance(90,90, Image.SCALE_SMOOTH)));
		image.setBackground(color);
		header.add(image);
	
	
		JLabel welcome_phrase = new JLabel("Vos Offres");
		this.welcome_phrase = welcome_phrase;
		welcome_phrase.setFont(new Font("Serif", Font.BOLD, 25));
		welcome_phrase.setPreferredSize(new Dimension(100,80));
		welcome_phrase.setBackground(color);
		header.add(welcome_phrase);
		header.setBackground(color);
		
	
		
		JPanel bigPan = new JPanel();
		bigPan.setLayout(new BoxLayout(bigPan, BoxLayout.PAGE_AXIS));
		
		for (int i = 0; i < Math.min(10, ofr.size()); i++) {
			bigPan.add(ofr.get(i));
			//JLabel a = new JLabel("Vos criteres");
			//bigPan.add(a);
		}
	
		
		JPanel p=new JPanel();
		JButton check= new JButton("Valider");
		this.check = check;
		//check.addActionListener(this);
		check.setPreferredSize(new Dimension(100,40));
		p.setBackground(color);
		p.add(check, BorderLayout.CENTER);
	
		p3.add(p);
		p3.add(header);
		p3.add(bigPan);
		right.add(p3, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(right);
}
//	public static void main(String[] args) {
//		
//		Selection s = new Selection();
//	}
} 
