package edu.ing1.pds.vsc.client.MappingManagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.General_Services;
import edu.ing1.pds.vsc.client.HomePage;




public class InfoMapping extends JFrame {

	General_Services company;
	private JPanel right=new JPanel(new BorderLayout());
	JPanel left = new JPanel(new GridLayout(5,1));
	Color color=new Color(190,245,116);
	private ClientToServer connection=new ClientToServer();
	private Connection con=null;
	ArrayList<Map>buildings=Building.allBuildings(connection);
	ArrayList<Map>workspaces=WorkSpace.listWorkSpace(connection,1,1);
	ArrayList<Map>equipments=Equipment.listEquipments(connection,0);
	ArrayList<Map>sensors=Sensor.listSensors(connection,0);
	ArrayList<Map> company_names=General_Services.All_GeneralServices(connection);
	Positions position=new Positions();
	Map my_workspace=null;
	InfoMapping instance=this;
	//Fields
	JTextField building=new JTextField("Batiment concerne"),floor=new JTextField("Etage  concerne"),work_space=new JTextField("espace loue concerne"),longitude=new JTextField("longitude"),latitude=new JTextField("latitude");
	JComboBox type_mapped_object=new JComboBox(),mapped_object=new JComboBox();;
	public void infoPositions(Positions position)
	{
		longitude.setText(position.getLongitude()+"");
		latitude.setText(position.getLatitude()+"");
		my_workspace=WorkSpace.theWorkSpace(connection,position.getId_workspace());
		building.setText("Batiment "+(Integer)my_workspace.get("id_building"));
		floor.setText("Etage "+(Integer)my_workspace.get("floor_number"));
		work_space.setText((String)my_workspace.get("type_workspace")+" "+(Integer)my_workspace.get("id_workspace"));

		mapped_object.addItem("Capteur");
		mapped_object.addItem("Equipement");
		mapped_object.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				JComboBox cn = (JComboBox)e.getSource();
				String name_object= (String)cn.getSelectedItem();
				type_mapped_object.removeAllItems();
				ArrayList<String> my_list=null;
				if(name_object.equals("Capteur"))
				{
					my_list=Positions.possibleMapping(position.getType_position(),"sensor");

				}	
				else
				{my_list=Positions.possibleMapping(position.getType_position(),"equipment");}


				for(String m: my_list)
				{
					type_mapped_object.addItem(m);
				}

			}});
	}



	private void myInterface()
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
				try
				{
					connection.client.close();
					
				}
				catch(Exception e1)
				{
					
				}
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
				try
				{
					connection.client.close();
					
				}
				catch(Exception e1)
				{
					
				}
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
				use_case1.setForeground(color);
			}
			public void mouseExited(MouseEvent e)
			{
				e.getComponent().setBackground(color);
				use_case1.setForeground(Color.black);
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
				try
				{
					connection.client.close();
					
				}
				catch(Exception e1)
				{
					
				}
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
				try
				{
					connection.client.close();
					
				}
				catch(Exception e1)
				{
					
				}
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


		JLabel use_case4 = new JLabel("Gestion Accés");
		use_case4.setHorizontalAlignment(JLabel.CENTER);
		use_case4.setFont(new Font("Serif", Font.BOLD,17));
		p.add(use_case4,BorderLayout.CENTER);
		p.setBackground(color);
		left.add(p);
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				try
				{
					connection.client.close();
					
				}
				catch(Exception e1)
				{
					
				}
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
		JMenu list=new JMenu("Liste des emplacements ");
		list.setSize(750,45);
		list.addMenuListener(new MenuListener() {
	          
			 
	           @Override
	           public void menuSelected(MenuEvent e) {
try
{
	connection.client.close();
	
}
catch(Exception ex)
{
  ex.printStackTrace();	
}
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
	        	   try
	        	   {
	        		   connection.client.close();
	        	   }catch(Exception ex)
	        	   {
	        		   ex.printStackTrace();
	        	   }
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
	        	   try
	        	   {
	        		   connection.client.close();
	        	   }catch(Exception ex)
	        	   {
	        		   ex.printStackTrace();
	        	   }
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
	        	   try
	        	   {
	        		   connection.client.close();
	        	   }catch(Exception ex)
	        	   {
	        		   ex.printStackTrace();
	        	   }
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
	public InfoMapping(Positions pos,General_Services GS)
	{
		company=GS;
		position=pos;
		myInterface();
		JLabel info_position=new JLabel("Information Mappage");
		info_position.setFont(new Font("Serif", Font.BOLD, 45));
		GridLayout layout=new GridLayout(4,1,1,1);

		JPanel p3=new JPanel(layout);
		info_position.setHorizontalAlignment(JLabel.CENTER);
		JPanel 	p_inter=new JPanel();
		JButton b1=new JButton("Voir sur Plan");
		b1.setPreferredSize(new Dimension(250,50));
		p_inter.setBackground(Color.white);
		p_inter.setPreferredSize(new Dimension(250,10));
		p_inter.add(info_position,BorderLayout.CENTER);
		b1.setBackground(color);
		
		b1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
			  Map_Position mp=new Map_Position(instance,connection,my_workspace,position,company);
			}

		});    
		p_inter.add(b1);
		p3.add(p_inter);

		//the fields
		p_inter=new JPanel(new GridLayout(7,1,5,3));

		//Local Business Field
		JLabel label=new JLabel("Batiment concerné");
		Border border = label.getBorder();
		Border margin = new EmptyBorder(30,30,30,30);
		label.setBorder(new CompoundBorder(border, margin));
		building=new JTextField();
		building.setPreferredSize(new Dimension(70,100));
		building.setEditable(false);
		p_inter.setBackground(Color.white);
		p_inter.add(label);
		p_inter.add(building);



		//the floor field
		label=new JLabel("Etage concerne");
		border = label.getBorder();
		margin = new EmptyBorder(30,30,30,30);
		label.setBorder(new CompoundBorder(border, margin));
		floor=new JTextField();
		floor.setPreferredSize(new Dimension(70,40));
		floor.setEditable(false);
		p_inter.setBackground(Color.white);
		p_inter.add(label);
		p_inter.add(floor);


		//workspace field
		label=new JLabel("Espace de travail concerne");
		border = label.getBorder();
		margin = new EmptyBorder(30,30,30,30);
		label.setBorder(new CompoundBorder(border, margin));
		work_space=new JTextField();
		work_space.setPreferredSize(new Dimension(70,40));
		work_space.setEditable(false);
		p_inter.setBackground(Color.white);
		p_inter.add(label);
		p_inter.add(work_space);
		p3.add(p_inter);
		right.add(p3,BorderLayout.CENTER);


		//longitude field
		label=new JLabel("Longitude");
		border = label.getBorder();
		margin = new EmptyBorder(30,30,30,30);
		label.setBorder(new CompoundBorder(border, margin));
		longitude=new JTextField();
		longitude.setPreferredSize(new Dimension(70,40));
		longitude.setEditable(false);
		p_inter.setBackground(Color.white);
		p_inter.add(label);
		p_inter.add(longitude);

		//latitude field
		label=new JLabel("latitude");
		border = label.getBorder();
		margin = new EmptyBorder(30,30,30,30);
		label.setBorder(new CompoundBorder(border, margin));
		latitude=new JTextField();
		latitude.setPreferredSize(new Dimension(70,40));
		latitude.setEditable(false);
		p_inter.setBackground(Color.white);
		p_inter.add(label);
		p_inter.add(latitude);

		//Field type of mapped object
		label=new JLabel("type objet mappé");
		border = label.getBorder();
		margin = new EmptyBorder(30,30,30,30);
		label.setBorder(new CompoundBorder(border, margin));	
		mapped_object.setPreferredSize(new Dimension(70,100));
		p_inter.setBackground(Color.white);
		p_inter.add(label);
		p_inter.add(mapped_object);

		//Field type of object mapped choosed
		label=new JLabel("sous-type objet mappé");
		border = label.getBorder();
		margin = new EmptyBorder(30,30,30,30);
		label.setBorder(new CompoundBorder(border, margin));
		ArrayList<String> my_list=Positions.possibleMapping(position.getType_position(),"sensor");
		for(String m: my_list)
		{
			type_mapped_object.addItem(m);
		}
		type_mapped_object.setPreferredSize(new Dimension(70,100));
		p_inter.setBackground(Color.white);
		p_inter.add(label);
		p_inter.add(type_mapped_object);

		//mapping button
		p_inter=new JPanel();
		p3.add(p_inter);
		JPanel space=new JPanel();
		space.setPreferredSize(new Dimension(450,40));
		JButton b2=new JButton("Mapper");
		b2.setBackground(color);
		b2.setPreferredSize(new Dimension(250,50));
		space.setBackground(Color.white);
		b2.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean update=false;
				if(mapped_object.getSelectedIndex()==1)
				{
					update=Equipment.mapEquipment(connection,company.getId_generalservices(), position.getId_position(),type_mapped_object.getSelectedItem().toString());
				}
				else
				{
					update=Sensor.mapSensor(connection,company.getId_generalservices(), position.getId_position(),type_mapped_object.getSelectedItem().toString());
				}
				if(update==true)
					JOptionPane.showMessageDialog(new JFrame(),
							"cet emplacement est occupé maintenant par un/une "+type_mapped_object.getSelectedItem().toString(),
							"Succés",
							JOptionPane.PLAIN_MESSAGE);

				else
					JOptionPane.showMessageDialog(new JFrame(),
							"Mappage non supporté! essayer une autre fois",
							"Echec",
							JOptionPane.PLAIN_MESSAGE);	

			}

		});    
		infoPositions(position);
		p_inter.setBackground(Color.white);
		p_inter.add(space);
		p_inter.add(b2);
		//  p3.add(p_inter);
		right.add(p3,BorderLayout.CENTER);
		p3.setBackground(Color.white);
		setVisible(true);
	}
	public static void main(String[] args) {
		new InfoMapping(new Positions(1,480,470,1,"type2",true),new General_Services(1,"Snapshat"));
	}

}
