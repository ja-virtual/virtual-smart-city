package edu.ing1.pds.vsc.client;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.*;
import edu.ing1.pds.vsc.client.General_Services;
import edu.ing1.pds.vsc.client.MappingManagement.InfoMapping;
import edu.ing1.pds.vsc.client.MappingManagement.Map_Full;
import edu.ing1.pds.vsc.client.MappingManagement.MappingUC;
import edu.ing1.pds.vsc.client.MappingManagement.Positions;


public class HomePage extends JFrame implements ActionListener  {
	//private Mairie fen;
	ClientToServer connection=new ClientToServer();
	ArrayList<Map> company_names=General_Services.All_GeneralServices(connection);
	General_Services my_company=new General_Services(1," Saisir le nom de votre entreprise.....");
	public HomePage()
	{
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Ja-Virtual app");
		setSize(new Dimension(450,450));
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());

		JLabel image = new JLabel();
		ImageIcon  img= new ImageIcon(("logo-ja-virtual.png"));

		//		getClass().getClassLoader().getResource


		image.setIcon( new ImageIcon(img.getImage().getScaledInstance(75,75, Image.SCALE_SMOOTH)));

		JLabel phrase_acceuil = new JLabel("Bienvenue sur Ja-Virtual");
		phrase_acceuil.setFont(new Font("Serif", Font.BOLD, 25));
		JComboBox myCompany=new JComboBox();

		myCompany.addItem(" Saisir le nom de votre entreprise....." );
		System.out.println(company_names.toString());
		for(Map n:company_names)
		{
			myCompany.addItem(n.get("company_name"));
		}
		myCompany.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				JComboBox cn = (JComboBox)e.getSource();
				String company_name= (String)cn.getSelectedItem();
				Boolean contains=false;
				for(Map n:company_names)
				{
					if(n.containsValue(company_name))
					{
						contains=true;
						my_company=new General_Services((Integer)n.get("id_generalservices"),company_name);

					}
				}
				if(!contains)
				{
					my_company=new General_Services(1," Saisir le nom de votre entreprise.....");	
				}
			}
		});	
		JButton valider= new JButton("Valider");
		valider.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if(my_company.getCompany_name()!=" Saisir le nom de votre entreprise.....")
				{

					try
					{
						connection.client.close();
					}catch(Exception ex)
					{
						ex.printStackTrace();
					}
					WelcomePage next_view=new WelcomePage(my_company);
					dispose();
				}
				else
					JOptionPane.showMessageDialog(new JFrame(),
							"Veuillez préciser le nom de votre entreprise!","Nom de l'entreprise non précisé",
							JOptionPane.PLAIN_MESSAGE);
			}	

		});
		JButton municipalite = new JButton("Mairie");

		municipalite.addActionListener((ActionListener) this);

		this.setVisible(true);
		GridBagConstraints c = new GridBagConstraints();
		c.insets=new Insets(15,1,15,1);

		c.ipadx=1;
		c.ipady=5;
		c.gridx = 0;//set the x location of the grid for the next component
		c.gridy = 0;//set the y location of the grid for the next component
		this.getContentPane().add(image,c);


		c.ipadx=10;
		c.ipady=10;
		c.gridx = 1;//set the x location of the grid for the next component

		this.getContentPane().add(phrase_acceuil,c);
		c.anchor=GridBagConstraints.CENTER;


		c.gridy = 5;//change the y location
		c.ipadx=5;
		c.ipady=5;

		this.getContentPane().add(myCompany,c);

		c.gridy = 6;//change the y location

		c.ipadx=45;
		c.ipady=5;
		//	this.getContentPane().add(annuler,c);

		c.gridy = 7;//change the y location

		this.getContentPane().add(valider,c);

		c.gridy = 8;//change the y location
		c.ipadx=15;
		c.ipady=5;

		this.getContentPane().add(municipalite,c);


		myCompany.getEditor().getEditorComponent().setBackground(Color.white);
		myCompany.setFont(new Font("Serif", Font.ITALIC, 16));
		myCompany.setBackground(Color.white);
		//      this.getContentPane().add(panel);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		Color color=new Color(190,245,116);
		getContentPane().setBackground(color);
		setResizable(false);
		setVisible(true);


		//ObjectInputStream O = new ObjectInputStream();
	}

	public void actionPerformed(ActionEvent e){

		//	fen = new Mairie();
		this.dispose();


	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HomePage();
	}
}

