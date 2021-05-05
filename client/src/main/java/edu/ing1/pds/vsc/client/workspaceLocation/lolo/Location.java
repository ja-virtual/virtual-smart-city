package edu.ing1.pds.vsc.client.workspaceLocation.lolo;


import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Location extends JFrame implements ActionListener{

	public  JLabel image;
	public JPanel header;
	public Color color;
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



	public Location()
	{
		setSize(new Dimension(850,850));
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		Color color = new Color(190,245,116);
		this.color = color;
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


		JLabel welcome_phrase = new JLabel("Vos criteres");
		this.welcome_phrase = welcome_phrase;
		welcome_phrase.setFont(new Font("Serif", Font.BOLD, 25));
		welcome_phrase.setPreferredSize(new Dimension(60,80));
		welcome_phrase.setBackground(color);
		header.add(welcome_phrase);
		header.setBackground(color);
		

		JPanel criterias = new JPanel(new GridLayout(4,2));
		this.criterias = criterias;
		
		JPanel p = new JPanel();
		JLabel label_1 = new JLabel("Taille");
		label_1.setPreferredSize(new Dimension(60,40));
		criterias.setBackground(color);
		
		JTextField criteria_1 = new JTextField();
		this.criteria1 =criteria_1;
		criteria_1.addActionListener(this);
		criteria_1.setText("entrez la taille en m2");
		criteria_1.setColumns(20);
		criteria_1.setPreferredSize(new Dimension(60,40));
		p.setBackground(color);
		p.add(label_1);
		p.add(criteria_1);
		criterias.add(p);


		p=new JPanel();
		label_1 = new JLabel("Prix max");
		label_1.setPreferredSize(new Dimension(60,40));
		
		JTextField criteria_2 = new JTextField();
		this.criteria2 =criteria_2;
		criteria_2.addActionListener(this);
		criteria_2.setText("en euro");
		criteria_2.setColumns(20);
		criteria_2.setPreferredSize(new Dimension(60,40));
		p.setBackground(color);
		p.add(label_1);
		p.add(criteria_2);
		criterias.add(p);

		p=new JPanel();
		label_1 = new JLabel("Employés");
		label_1.setPreferredSize(new Dimension(80,40));

		JTextField criteria_3 = new JTextField();
		this.criteria3 = criteria_3;
		criteria_3.addActionListener(this);
		criteria_3.setText("entrez le nombre d'employé");
		criteria_3.setColumns(20);
		criteria_3.setPreferredSize(new Dimension(60,40));
		p.setBackground(color);
		p.add(label_1);
		p.add(criteria_3);
		criterias.add(p);

		p = new JPanel();
		label_1 = new JLabel("Etage");
		label_1.setPreferredSize(new Dimension(60,40));

		JComboBox criteria_4 = new JComboBox();
		this.criteria4 = criteria_4;
		criteria_4.addActionListener(this);
		criteria_4.addItem("haut" );
		criteria_4.addItem("bas" );
		criteria_4.addItem("sans importance" );
		criteria_4.setPreferredSize(new Dimension(200,40));
		p.setBackground(color);
		p.add(label_1);
		p.add(criteria_4);
		criterias.add(p);

		p=new JPanel();
		label_1 = new JLabel("Openspace");
		label_1.setPreferredSize(new Dimension(80,40));

		JTextField criteria_5 = new JTextField();
		//System.out.println(criteria_5 == null);
		this.criteria5 = criteria_5;
		criteria_5.addActionListener(this);
		criteria_5.setText("Entrez le nombre d'Openspace");
		criteria_5.setColumns(20);
		criteria_5.setPreferredSize(new Dimension(80,40));
		p.setBackground(color);
		p.add(label_1);
		p.add(criteria_5);
		criterias.add(p);
		
		p=new JPanel();
		label_1 = new JLabel("Bureau");
		label_1.setPreferredSize(new Dimension(60,40));

		JTextField criteria_6= new JTextField();
		this.criteria6 = criteria_6;
		criteria_6.addActionListener(this);
		criteria_6.setText("Entrez le nombre de bureau");
		criteria_6.setColumns(20);
		criteria_6.setPreferredSize(new Dimension(100,40));
		p.setBackground(color);
		p.add(label_1);
		p.add(criteria_6);
		criterias.add(p);
		
		p=new JPanel();
		label_1 = new JLabel("Salle Réunion");
		label_1.setPreferredSize(new Dimension(150,40));

		JTextField criteria_7 = new JTextField();
		this.criteria7 = criteria_7;
		criteria_7.addActionListener(this);
		criteria_7.setText("Entrez le nombre de salle de Reunion");
		criteria_7.setColumns(20);
		criteria_7.setPreferredSize(new Dimension(80,40));
		p.setBackground(color);
		p.add(label_1);
		p.add(criteria_7);
		criterias.add(p);


		p=new JPanel();
		JButton check= new JButton("Valider");
		this.check = check;
		check.addActionListener(this);
		check.setPreferredSize(new Dimension(100,40));
		p.setBackground(color);
		p.add(check, BorderLayout.CENTER);
	
		
		this.add(header, BorderLayout.NORTH);
		this.add(criterias, BorderLayout.CENTER);
		this.add(p, BorderLayout.SOUTH);


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
	

		this.add(criterias);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public void actionPerformed(ActionEvent event) {
	
		if (event.getSource() == check) {
			area = Integer.parseInt(criteria1.getText());
			price = Integer.parseInt(criteria2.getText());
			employee_nbr = Integer.parseInt(criteria3.getText());
			floor = criteria4.getSelectedItem().toString();
			openspace_nbr =Integer.parseInt(criteria5.getText());
			individual_office_nbr=Integer.parseInt(criteria6.getText());
			meetingroom_nbr=Integer.parseInt(criteria7.getText());
			
			/*System.out.println(area);
			System.out.println(price);
			System.out.println(employee_nbr);
			System.out.println(floor);
			System.out.println(openspace_nbr);
			System.out.println(individual_office_nbr);
			System.out.println(meetingroom_nbr);*/
			OfferCreator ofCrt = new OfferCreator(openspace_nbr,individual_office_nbr, meetingroom_nbr, floor);
			OfferManager ofMng = new OfferManager(ofCrt.final_offers_array, price, area, employee_nbr);
			
			
			for (int i = 0; i < Math.min(10, ofMng.Offers.size()); i++)
				System.out.println(ofMng.Offers.get(i).toString());
		}

	 }	


	public static void main(String[] args) {
	//TODO Auto-generated method stub
		Location location1 = new Location();
		//System.out.print(location1.direction);
	 }
}