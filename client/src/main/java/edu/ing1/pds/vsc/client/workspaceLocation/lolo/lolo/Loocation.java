package edu.ing1.pds.vsc.client.workspaceLocation.lolo.lolo;


import java.awt.*;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.General_Services;
import edu.ing1.pds.vsc.client.HomePage;
import edu.ing1.pds.vsc.client.WelcomePage;
import edu.ing1.pds.vsc.client.MappingManagement.List_Position;
import edu.ing1.pds.vsc.client.MappingManagement.Map_Full;
import edu.ing1.pds.vsc.client.MappingManagement.MappingUC;
import edu.ing1.pds.vsc.client.MappingManagement.WorkSpace;
import edu.ing1.pds.vsc.client.electroChromaticWindowsManagement.Welcome;
import edu.ing1.pds.vsc.client.workspaceLocation.lolo.lolo.OfferCreator;
import edu.ing1.pds.vsc.client.workspaceLocation.lolo.lolo.OfferManager;
import edu.ing1.pds.vsc.client.workspaceLocation.lolo.lolo.Selection;

import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Loocation extends JFrame implements ActionListener{

	public  JLabel image;
	public JPanel header;
	public JLabel welcome_phrase;
	public JPanel criterias;
	public JTextField criteria1;
	public JTextField criteria2;
	public JTextField criteria3;
	public JComboBox criteria4;
	public JTextField criteria5;
	public JTextField criteria6;
	public JTextField criteria7;
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
	public General_Services company = null;


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
		ImageIcon  img= new ImageIcon("C:\\Users\\elori\\Downloads\\logo_ja_virtual.png");
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
				Loocation t = new Loocation(company);
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
		p=new JPanel(new GridLayout());
		JLabel use_case2 = new JLabel("Mappage Capteur/Equipement");
		use_case2.setHorizontalAlignment(JLabel.CENTER);
		use_case2.setFont(new Font("Serif", Font.BOLD,17));;
		p.add(use_case2,BorderLayout.CENTER);
		p.setBackground(color);
		left.add(p);
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
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{ ClientToServer connection=new ClientToServer();
			ArrayList<Map>ws=WorkSpace.allRentedWorkSpace(connection, company.getId_generalservices());
			try {
				connection.client.close();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
			if(ws==null )
			{
				JOptionPane.showMessageDialog(new JFrame(),
						"Pas d'espace loue pour pouvoir utiliser cette fonctionnalite","Mappage impossible pour le moment",
						JOptionPane.ERROR_MESSAGE);
			}
			else if(ws.isEmpty())
			{
				JOptionPane.showMessageDialog(new JFrame(),
						"Pas d'espace loue pour pouvoir utiliser cette fonctionnalite","Mappage impossible pour le moment",
						JOptionPane.ERROR_MESSAGE);
			}
			else
			{

				MappingUC t = new MappingUC(company);
				t.setVisible(true);
				dispose();
			}

			}});
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
				ClientToServer connection=new ClientToServer();
				ArrayList<Map>ws=WorkSpace.allRentedWorkSpace(connection, company.getId_generalservices());
			if(ws==null )
			{
				JOptionPane.showMessageDialog(new JFrame(),
						"Veuillez d'abord louer un espace","Configuration fenetres, impossible pour le moment",
						JOptionPane.ERROR_MESSAGE);
			}
			else if(ws.isEmpty())
			{
				
				JOptionPane.showMessageDialog(new JFrame(),
						"Veuillez d'abord louer un espace","Configuration fenetres, impossible pour le moment",
						JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				
				Welcome welcome = new Welcome(company);
				//t.setVisible(true);
				dispose();
			}


		}});
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				e.getComponent().setBackground(Color.white);
				use_case3.setForeground(color);
			}
			public void mouseExited(MouseEvent e)
			{
				e.getComponent().setBackground(color);
				use_case3.setForeground(Color.black);
			}
		});

		p=new JPanel(new GridLayout());
		image = new JLabel();
		img= new ImageIcon("C:\\Users\\elori\\Downloads\\use_case_icon.png");
		image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));


		JLabel use_case4 = new JLabel("Gestion Acces");
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
				use_case4.setForeground(color);
			}
			public void mouseExited(MouseEvent e)
			{
				e.getComponent().setBackground(color);
				use_case4.setForeground(Color.black);
			}
		});

		//creation of the right menu
		right.setBackground(Color.white);
		right.setLayout(new BorderLayout());

		JMenuBar menuBar=new JMenuBar();

		menuBar.setBorderPainted(isDoubleBuffered());
		menuBar.setSize(750,45);
		menuBar.add(Box.createHorizontalGlue());
		JMenu homePage=new JMenu("Acceuil");
		homePage.addMenuListener(new MenuListener() {


			@Override
			public void menuSelected(MenuEvent e) {

				WelcomePage hp=new WelcomePage(company);
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

				HomePage t = new HomePage();
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

	public Loocation(General_Services gs)
	{
		company = gs;
		Interface();


		JPanel p3 = new JPanel(new BorderLayout());
		right.add(p3, BorderLayout.CENTER);

		JPanel header = new JPanel(new GridLayout(1,1));
		this.header = header;
		JLabel image = new JLabel();
		this.image = image;
		ImageIcon  img= new ImageIcon("/home/amal/Documents/PDS/virtual-smart-city/client/src/main/java/edu/ing1/pds/vsc/client/logo-ja-virtual.png");
		image.setIcon( new ImageIcon(img.getImage().getScaledInstance(90,90, Image.SCALE_SMOOTH)));
		image.setBackground(color);
		header.add(image);


		JLabel welcome_phrase = new JLabel("Vos criteres");
		this.welcome_phrase = welcome_phrase;
		welcome_phrase.setFont(new Font("Serif", Font.BOLD, 25));
		welcome_phrase.setPreferredSize(new Dimension(60,80));
		welcome_phrase.setBackground(Color.white);
		header.add(welcome_phrase);
		header.setBackground(color);


		JPanel criterias = new JPanel(new GridLayout(15,1));
		this.criterias = criterias;

		JPanel p = new JPanel();
		JLabel label_1 = new JLabel("Taille");
		label_1.setPreferredSize(new Dimension(150,40));
		//		criterias.setBackground(Color.white);

		JTextField criteria_1 = new JTextField();
		this.criteria1 =criteria_1;
		criteria_1.addActionListener(this);

		criteria_1.setText("entrez la taille en m2");
		criteria_1.setColumns(20);
		criteria_1.setPreferredSize(new Dimension(60,40));
		//		p.setBackground(Color.white);
		p.add(label_1);
		p.add(criteria_1);
		criterias.add(p);


		p=new JPanel();
		label_1 = new JLabel("Prix max");
		label_1.setPreferredSize(new Dimension(150,40));

		JTextField criteria_2 = new JTextField();
		this.criteria2 =criteria_2;
		criteria_2.addActionListener(this);

		criteria_2.setText("en euro");
		criteria_2.setColumns(20);
		criteria_2.setPreferredSize(new Dimension(60,40));
		//		p.setBackground(Color.white);
		p.add(label_1);
		p.add(criteria_2);
		criterias.add(p);

		p=new JPanel();
		label_1 = new JLabel("Employes");
		label_1.setPreferredSize(new Dimension(150,40));

		JTextField criteria_3 = new JTextField();
		this.criteria3 = criteria_3;
		criteria_3.addActionListener(this);

		criteria_3.setText("entrez le nombre d'employe");
		criteria_3.setColumns(20);
		criteria_3.setPreferredSize(new Dimension(60,40));
		//		p.setBackground(Color.white);
		p.add(label_1);
		p.add(criteria_3);
		criterias.add(p);

		p = new JPanel();
		label_1 = new JLabel("Etage");
		label_1.setPreferredSize(new Dimension(150,40));

		JComboBox criteria_4 = new JComboBox();
		this.criteria4 = criteria_4;
		criteria_4.addActionListener(this);
		criteria_4.addItem("haut" );
		criteria_4.addItem("bas" );
		criteria_4.addItem("sans importance" );
		criteria_4.setPreferredSize(new Dimension(225,40));
		//		p.setBackground(Color.white);
		p.add(label_1);
		p.add(criteria_4);
		criterias.add(p);

		p=new JPanel();
		label_1 = new JLabel("Openspace");
		label_1.setPreferredSize(new Dimension(150,40));

		JTextField criteria_5 = new JTextField();

		this.criteria5 = criteria_5;
		criteria_5.addActionListener(this);

		criteria_5.setText("Entrez le nombre d'Openspace");
		criteria_5.setColumns(20);
		criteria_5.setPreferredSize(new Dimension(150,40));
		//		p.setBackground(Color.white);
		p.add(label_1);
		p.add(criteria_5);
		criterias.add(p);

		p=new JPanel();
		label_1 = new JLabel("Bureau");
		label_1.setPreferredSize(new Dimension(150,40));

		JTextField criteria_6= new JTextField();
		this.criteria6 = criteria_6;
		criteria_6.addActionListener(this);

		criteria_6.setText("Entrez le nombre de bureau");
		criteria_6.setColumns(20);
		criteria_6.setPreferredSize(new Dimension(150,40));
		//		p.setBackground(Color.white);
		p.add(label_1);
		p.add(criteria_6);
		criterias.add(p);

		p=new JPanel();
		label_1 = new JLabel("Salle Reunion");
		label_1.setPreferredSize(new Dimension(150,40));

		JTextField criteria_7 = new JTextField();
		this.criteria7 = criteria_7;
		criteria_7.addActionListener(this);

		criteria_7.setText("Entrez le nombre de salle de Reunion");
		criteria_7.setColumns(20);
		criteria_7.setPreferredSize(new Dimension(150,40));
		//		p.setBackground(Color.white);
		p.add(label_1);
		p.add(criteria_7);
		criterias.add(p);


		p=new JPanel();
		JButton check= new JButton("Valider");
		this.check = check;
		check.addActionListener(this);
		check.setPreferredSize(new Dimension(100,40));
		//		p.setBackground(Color.white);
		p.add(check, BorderLayout.CENTER);


		p3.add(header, BorderLayout.NORTH);
		p3.add(criterias, BorderLayout.CENTER);
		p3.add(p, BorderLayout.SOUTH);



		criteria_1.setEditable(true);
		criteria_1.setFont(new Font("Serif", Font.ITALIC, 16));
		criteria_1.setBackground(Color.white);


		criteria_2.setEditable(true);
		criteria_2.setFont(new Font("Serif", Font.ITALIC, 16));
		criteria_2.setBackground(Color.white);


		criteria_3.setEditable(true);
		criteria_3.setFont(new Font("Serif", Font.ITALIC, 16));
		criteria_3.setBackground(Color.white);


		criteria_4.setEditable(true);
		criteria_4.getEditor().getEditorComponent().setBackground(Color.white);
		criteria_4.setFont(new Font("Serif", Font.ITALIC, 16));
		criteria_4.setBackground(Color.white);


		criteria_5.setEditable(true);
		criteria_5.setFont(new Font("Serif", Font.ITALIC, 16));
		criteria_5.setBackground(Color.white);


		criteria_6.setEditable(true);
		criteria_6.setFont(new Font("Serif", Font.ITALIC, 16));
		criteria_6.setBackground(Color.white);


		criteria_7.setEditable(true);
		criteria_7.setFont(new Font("Serif", Font.ITALIC, 16));
		criteria_7.setBackground(Color.white);


		this.add(p3);

		this.setVisible(true);


	}

	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == check) {
			if(bad_input(criteria1.getText()) || bad_input(criteria2.getText()) || bad_input(criteria3.getText()) || bad_input(criteria5.getText()) 
					|| bad_input(criteria6.getText()) || bad_input(criteria7.getText())) {


				JOptionPane.showMessageDialog(new JPanel(), "Tous les champs ne sont pas bien renseignes", "Erreur", JOptionPane.ERROR_MESSAGE);
			}else{

				area = Integer.parseInt(criteria1.getText());
				price = Integer.parseInt(criteria2.getText());
				employee_nbr = Integer.parseInt(criteria3.getText());
				floor = criteria4.getSelectedItem().toString();
				openspace_nbr =Integer.parseInt(criteria5.getText());
				individual_office_nbr=Integer.parseInt(criteria6.getText());
				meetingroom_nbr=Integer.parseInt(criteria7.getText());


				OfferCreator ofCrt = new OfferCreator(openspace_nbr,individual_office_nbr, meetingroom_nbr, floor,company.getId_generalservices());
				OfferManager ofMng = new OfferManager(ofCrt.final_offers_array, price, area, employee_nbr);



				if (ofMng.offfers.isEmpty()) {
					JOptionPane.showMessageDialog(new JPanel(), "Aucune offre ne correspond à vos criteres de recherche, veuillez en saisir de nouveaux", "Erreur", JOptionPane.ERROR_MESSAGE);

				}
				else {
					Selection s = new Selection(ofMng.offfers, company);
					dispose();
				}


			}
		}
	}
	public static boolean bad_input(String str) {
		try {
			Integer.parseInt(str);
			return false;
		}catch(NumberFormatException eo){
			return true;
		}
	}

}