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




public class InfoMoving extends JFrame {

	//for the interface
	private JPanel right=new JPanel(new BorderLayout());
	JPanel left = new JPanel(new GridLayout(5,1));
	Color color=new Color(190,245,116);

	//for the connection with the server
	private General_Services company;
	private ClientToServer connection=new ClientToServer();
	private Connection con=null;

	//the received data
	ArrayList<Map>equipments=Equipment.listEquipments(connection,0);
	ArrayList<Map>sensors=Sensor.listSensors(connection,0);
	ArrayList<Map> company_names=General_Services.All_GeneralServices(connection);

	//the created instances 
	WorkSpace my_old_workspace=null,my_new_workspace=null;
	Positions my_old_position=null,my_new_position=null;

	//the fields
	JTextField id_field=new JTextField(""),new_longitude=new JTextField(""),old_longitude=new JTextField(""),type_field=new JTextField(""),functional=new JTextField(""),old_workspace=new JTextField("e"),old_latitude=new JTextField("latitude"),new_workspace=new JTextField("e"),new_latitude=new JTextField("latitude");
	JComboBox type_mapped_object=new JComboBox(),mapped_object=new JComboBox();

	//the method that create the basic interface of the app
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
	public InfoMoving(Object moved_object,String type_object,General_Services GS)
	{
		company=GS;
		myInterface();
		JLabel info_position=new JLabel("Information déplacement");
		info_position.setFont(new Font("Serif", Font.BOLD, 45));
		GridLayout layout=new GridLayout(5,1,5,5);

		JPanel p3=new JPanel(layout);
		info_position.setHorizontalAlignment(JLabel.CENTER);
		JPanel 	p_inter=new JPanel();
		JButton b1=new JButton("Retour vers le Plan");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					connection.client.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Map_WorkSpace map_workspace=new Map_WorkSpace(my_old_workspace,company);
				dispose();
			}

		});
		b1.setPreferredSize(new Dimension(250,50));
		b1.setBackground(color);
		p_inter.setBackground(Color.white);
		p_inter.setPreferredSize(new Dimension(250,10));
		p_inter.add(info_position,BorderLayout.CENTER);
		p_inter.add(b1);
		p3.add(p_inter);

		if(type_object.equals("sensor"))
		{
			Sensor my_sensor=(Sensor)moved_object;
			//the fields
			p_inter=new JPanel();
			p_inter.setBackground(Color.white);
			p_inter.setPreferredSize(new Dimension(250,390));
			p_inter.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Info Capteur"));

			//The id and type of the sensor
			JPanel field_panel=new JPanel();
			JLabel label=new JLabel("ID Capteur");
			Border border = label.getBorder();
			Border margin = new EmptyBorder(30,30,30,30);
			label.setBorder(new CompoundBorder(border, margin));
			id_field=new JTextField();
			id_field.setText(my_sensor.getId_sensor()+"");
			id_field.setPreferredSize(new Dimension(150,30));
			id_field.setEditable(false);
			field_panel.setBackground(Color.white);
			field_panel.add(label);
			field_panel.add(id_field);
			p_inter.add(field_panel);
			p3.add(p_inter);

			//the functionality  field
			field_panel=new JPanel(new FlowLayout());
			label=new JLabel("Est fonctionnel");
			border = label.getBorder();
			margin = new EmptyBorder(30,30,30,30);
			label.setBorder(new CompoundBorder(border, margin));
			if(my_sensor.getIs_working()==true)
			{
				functional=new JTextField("oui");
				functional.setText("oui");
			}
			else
			{
				functional=new JTextField("non");
				functional.setText("non");
			}

			type_field.setPreferredSize(new Dimension(100,30));
			type_field.setEditable(false);
			field_panel.setBackground(Color.white);
			field_panel.add(label);
			field_panel.add(type_field);
			p_inter.add(field_panel);
			p3.add(p_inter);
			right.add(p3,BorderLayout.CENTER);

			//old positions info
			Map w=WorkSpace.workspace_Position(connection,my_sensor.getId_position(),company.getId_generalservices());
			my_old_position=new Positions((Integer)w.get("id_position"),(Integer)w.get("longitude"),(Integer)w.get("latitude"),(Integer)w.get("id_ws"),(String)w.get("type_position"),(Boolean)w.get("is_available_pos"));
			my_old_workspace=new WorkSpace((Integer)w.get("id_workspace"),(String)w.get("type_workspace"),(Integer)w.get("floor_number"),(Boolean)w.get("is_available_ws"),(Integer)w.get("id_building"),(Integer)w.get("id_gs"));
			p_inter=new JPanel();
			p_inter.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Ancien Emplacement"));
			right.add(p3,BorderLayout.CENTER);
			label=new JLabel("workspace");
			border = label.getBorder();
			margin = new EmptyBorder(30,30,30,30);
			label.setBorder(new CompoundBorder(border, margin));
			old_workspace=new JTextField();
			old_workspace.setText(my_old_workspace.toString());
			old_workspace.setPreferredSize(new Dimension(70,40));
			old_workspace.setEditable(false);
			p_inter.setBackground(Color.white);
			p_inter.add(label);
			p_inter.add(old_workspace);
			p3.add(p_inter);

			//old latitude field
			label=new JLabel("latitude");
			border = label.getBorder();
			margin = new EmptyBorder(30,30,30,30);
			label.setBorder(new CompoundBorder(border, margin));
			old_latitude=new JTextField();
			old_latitude.setText((Integer)w.get("latitude")+"");
			old_latitude.setPreferredSize(new Dimension(70,40));
			old_latitude.setEditable(false);
			p_inter.setBackground(Color.white);
			p_inter.add(label);
			p_inter.add(old_latitude);

			//old longitude field
			label=new JLabel("longitude");
			border = label.getBorder();
			margin = new EmptyBorder(30,30,30,30);
			label.setBorder(new CompoundBorder(border, margin));
			old_longitude=new JTextField();
			old_longitude.setText((Integer)w.get("longitude")+"");
			old_longitude.setPreferredSize(new Dimension(70,40));
			old_longitude.setEditable(false);
			p_inter.setBackground(Color.white);
			p_inter.add(label);
			p_inter.add(old_longitude);

			//Field type of mapped object
			JButton see_old=new JButton("Voir sur Plan");
			p_inter.add(see_old);
			see_old.setPreferredSize(new Dimension(200,30));
			see_old.setBackground(color);
			see_old.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try {
						connection.client.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Map_Position map_position=new Map_Position(my_old_workspace,my_old_position,my_old_position.getId_position(),"sensor",company);
					dispose();
				}

			});
			//new positions info
			p_inter=new JPanel();
			p_inter.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Nouveau Emplacement"));
			right.add(p3,BorderLayout.CENTER);
			JComboBox available_positions=new JComboBox();
			available_positions.addItem("Emplacement ...");
			for(Map n: Positions.availablePositions(connection,0,company.getId_generalservices()))
			{
				available_positions.addItem("Emplacement "+n.get("id_position"));
			}
			available_positions.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					JComboBox source = (JComboBox) (e.getSource());
					if(source.getSelectedIndex()!=-1 && source.getSelectedIndex()!=0)
					{
					Map w=WorkSpace.workspace_Position(connection,Integer.valueOf(source.getSelectedItem().toString().substring(12)),company.getId_generalservices());
					my_new_position=new Positions((Integer)w.get("id_position"),(Integer)w.get("longitude"),(Integer)w.get("latitude"),(Integer)w.get("id_ws"),(String)w.get("type_position"),(Boolean)w.get("is_available_pos"));
					my_new_workspace=new WorkSpace((Integer)w.get("id_workspace"),(String)w.get("type_workspace"),(Integer)w.get("floor_number"),(Boolean)w.get("is_available_ws"),(Integer)w.get("id_building"),(Integer)w.get("id_gs"));
					new_workspace.setText(my_new_workspace.toString());
					new_latitude.setText(my_new_position.getLatitude()+"");
					new_longitude.setText(my_new_position.getLongitude()+"");
					}
					else
					{
						new_workspace.setText("");
						new_latitude.setText("");
						new_longitude.setText("");
						my_new_workspace=null;
						my_new_position=null;
					}
				}

			});
			label=new JLabel("Espace de travail");
			border = label.getBorder();
			margin = new EmptyBorder(30,10,30,10);
			label.setBorder(new CompoundBorder(border, margin));
			new_workspace=new JTextField();
			new_workspace.setPreferredSize(new Dimension(70,40));
			new_workspace.setEditable(false);
			p_inter.setBackground(Color.white);
			p_inter.add(available_positions);
			p_inter.add(label);
			p_inter.add(new_workspace);
			p3.add(p_inter);

			//old latitude field
			label=new JLabel("latitude");
			border = label.getBorder();
			margin = new EmptyBorder(30,10,30,10);
			label.setBorder(new CompoundBorder(border, margin));
			new_latitude=new JTextField();
			new_latitude.setPreferredSize(new Dimension(70,40));
			new_latitude.setEditable(false);
			p_inter.setBackground(Color.white);
			p_inter.add(label);
			p_inter.add(new_latitude);

			//old longitude field
			label=new JLabel("longitude");
			border = label.getBorder();
			margin = new EmptyBorder(30,10,30,10);
			label.setBorder(new CompoundBorder(border, margin));
			new_longitude=new JTextField();
			new_longitude.setPreferredSize(new Dimension(70,40));
			new_longitude.setEditable(false);
			p_inter.setBackground(Color.white);
			p_inter.add(label);
			p_inter.add(new_longitude);

			//Field type of mapped object
			JButton see_new=new JButton("Voir sur Plan");
			p_inter.add(see_new);
			see_new.setPreferredSize(new Dimension(200,30));
			see_new.setBackground(color);
			see_new.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(my_new_workspace!=null)
					{
						try {
							connection.client.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						Map_Position map_workspace=new Map_Position(my_new_workspace,my_new_position,my_old_position.getId_position(),"sensor",company);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(new JFrame(),
								"veuillez précisez un emplacement d'abbord",
								"Nouveau emplacement non précisé",
								JOptionPane.PLAIN_MESSAGE);
					}


				}

			});

		}
		else if(type_object.equals("equipment"))
		{

			Equipment my_equipment=(Equipment)moved_object;
			if(my_equipment==null)
				System.out.println("this is null!!");
			//the fields
			p_inter=new JPanel();
			p_inter.setBackground(Color.white);
			p_inter.setPreferredSize(new Dimension(250,390));
			p_inter.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Info Equipment"));

			//The id and type of the sensor
			JPanel field_panel=new JPanel();
			JLabel label=new JLabel("ID Equipement");
			Border border = label.getBorder();
			Border margin = new EmptyBorder(30,30,30,30);
			label.setBorder(new CompoundBorder(border, margin));
			id_field=new JTextField();
			id_field.setText(my_equipment.getId_equipment()+"");
			id_field.setPreferredSize(new Dimension(150,30));
			id_field.setEditable(false);
			field_panel.setBackground(Color.white);
			field_panel.add(label);
			field_panel.add(id_field);
			p_inter.add(field_panel);
			p3.add(p_inter);

			//the functionality  field
			field_panel=new JPanel(new FlowLayout());
			label=new JLabel("Est fonctionnel");
			border = label.getBorder();
			margin = new EmptyBorder(30,30,30,30);
			label.setBorder(new CompoundBorder(border, margin));
			functional=new JTextField();
			if(my_equipment.getIs_working()==true)
			{
				functional.setText("oui");
			}
			else
			{
				functional.setText("non");
			}	
			type_field.setPreferredSize(new Dimension(100,30));
			type_field.setEditable(false);
			field_panel.setBackground(Color.white);
			field_panel.add(label);
			field_panel.add(type_field);
			p_inter.add(field_panel);
			p3.add(p_inter);
			right.add(p3,BorderLayout.CENTER);

			//old positions info
			System.out.println(my_equipment.getId_position());
			Map w=WorkSpace.workspace_Position(connection,my_equipment.getId_position(),company.getId_generalservices());
			my_old_position=new Positions((Integer)w.get("id_position"),(Integer)w.get("longitude"),(Integer)w.get("latitude"),(Integer)w.get("id_ws"),(String)w.get("type_position"),(Boolean)w.get("is_available_pos"));
			my_old_workspace=new WorkSpace((Integer)w.get("id_workspace"),(String)w.get("type_workspace"),(Integer)w.get("floor_number"),(Boolean)w.get("is_available_ws"),(Integer)w.get("id_building"),(Integer)w.get("id_gs"));
			p_inter=new JPanel();
			p_inter.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Ancien Emplacement"));
			right.add(p3,BorderLayout.CENTER);
			label=new JLabel("Espace de travail");
			border = label.getBorder();
			margin = new EmptyBorder(30,30,30,30);
			label.setBorder(new CompoundBorder(border, margin));
			old_workspace=new JTextField();
			old_workspace.setText(my_old_workspace.toString());
			old_workspace.setPreferredSize(new Dimension(70,40));
			old_workspace.setEditable(false);
			p_inter.setBackground(Color.white);
			p_inter.add(label);
			p_inter.add(old_workspace);
			p3.add(p_inter);

			//old latitude field
			label=new JLabel("latitude");
			border = label.getBorder();
			margin = new EmptyBorder(30,30,30,30);
			label.setBorder(new CompoundBorder(border, margin));
			old_latitude=new JTextField();
			old_latitude.setText((Integer)w.get("latitude")+"");
			old_latitude.setPreferredSize(new Dimension(70,40));
			old_latitude.setEditable(false);
			p_inter.setBackground(Color.white);
			p_inter.add(label);
			p_inter.add(old_latitude);

			//old longitude field
			label=new JLabel("longitude");
			border = label.getBorder();
			margin = new EmptyBorder(30,30,30,30);
			label.setBorder(new CompoundBorder(border, margin));
			old_longitude=new JTextField();
			old_longitude.setText((Integer)w.get("longitude")+"");
			old_longitude.setPreferredSize(new Dimension(70,40));
			old_longitude.setEditable(false);
			p_inter.setBackground(Color.white);
			p_inter.add(label);
			p_inter.add(old_longitude);

			//to see the old position within the map
			JButton see_old=new JButton("Voir sur Plan");
			p_inter.add(see_old);
			see_old.setPreferredSize(new Dimension(200,30));
			see_old.setBackground(color);
			see_old.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try {
						connection.client.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Map_Position map_position=new Map_Position(my_old_workspace,my_old_position,my_old_position.getId_position(),"equipment",company);
					dispose();
				}

			});
			//new positions info
			p_inter=new JPanel();
			p_inter.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Nouveau Emplacement"));
			right.add(p3,BorderLayout.CENTER);
			JComboBox available_positions=new JComboBox();
			available_positions.addItem("Emplacement ...");
			for(Map n: Positions.availablePositions(connection,0,company.getId_generalservices()))
			{
				available_positions.addItem("Emplacement "+n.get("id_position"));
			}
			available_positions.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					JComboBox source = (JComboBox) (e.getSource());
					if(source.getSelectedIndex()!=-1 && source.getSelectedIndex()!=0)
					{
					Map w=WorkSpace.workspace_Position(connection,Integer.valueOf(source.getSelectedItem().toString().substring(12)),company.getId_generalservices());
					my_new_position=new Positions((Integer)w.get("id_position"),(Integer)w.get("longitude"),(Integer)w.get("latitude"),(Integer)w.get("id_ws"),(String)w.get("type_position"),(Boolean)w.get("is_available_pos"));
					my_new_workspace=new WorkSpace((Integer)w.get("id_workspace"),(String)w.get("type_workspace"),(Integer)w.get("floor_number"),(Boolean)w.get("is_available_ws"),(Integer)w.get("id_building"),(Integer)w.get("id_gs"));
					new_workspace.setText(my_new_workspace.toString());
					new_latitude.setText(my_new_position.getLatitude()+"");
					new_longitude.setText(my_new_position.getLongitude()+"");
				}
					else
					{
						new_workspace.setText("");
						new_latitude.setText("");
						new_longitude.setText("");
						my_new_workspace=null;
						my_new_position=null;
					}
					}

			});
			label=new JLabel("Espace de travail");
			border = label.getBorder();
			margin = new EmptyBorder(30,10,30,10);
			label.setBorder(new CompoundBorder(border, margin));
			new_workspace=new JTextField();
			new_workspace.setPreferredSize(new Dimension(70,40));
			new_workspace.setEditable(false);
			p_inter.setBackground(Color.white);
			p_inter.add(available_positions);
			p_inter.add(label);
			p_inter.add(new_workspace);
			p3.add(p_inter);

			//old latitude field
			label=new JLabel("latitude");
			border = label.getBorder();
			margin = new EmptyBorder(30,10,30,10);
			label.setBorder(new CompoundBorder(border, margin));
			new_latitude=new JTextField();
			new_latitude.setPreferredSize(new Dimension(70,40));
			new_latitude.setEditable(false);
			p_inter.setBackground(Color.white);
			p_inter.add(label);
			p_inter.add(new_latitude);

			//old longitude field
			label=new JLabel("longitude");
			border = label.getBorder();
			margin = new EmptyBorder(30,10,30,10);
			label.setBorder(new CompoundBorder(border, margin));
			new_longitude=new JTextField();
			new_longitude.setPreferredSize(new Dimension(70,40));
			new_longitude.setEditable(false);
			p_inter.setBackground(Color.white);
			p_inter.add(label);
			p_inter.add(new_longitude);

			//to see the new position within the map
			JButton see_new=new JButton("Voir sur Plan");
			p_inter.add(see_new);
			see_new.setPreferredSize(new Dimension(200,30));
			see_new.setBackground(color);
			see_new.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(my_new_workspace!=null)
					{
						try {
							connection.client.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						Map_Position map_workspace=new Map_Position(my_new_workspace,my_new_position,my_old_position.getId_position(),"equipment",company);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(new JFrame(),
								"veuillez précisez un emplacement d'abbord",
								"Nouveau emplacement non précisé",
								JOptionPane.PLAIN_MESSAGE);
					}


				}

			});
		}
		p_inter=new JPanel();
		p3.add(p_inter);
		JPanel space=new JPanel();
		space.setPreferredSize(new Dimension(450,40));
		b1=new JButton("Déplacer");
		b1.setBackground(color);
		b1.setPreferredSize(new Dimension(250,50));
		space.setBackground(Color.white);
		b1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				if(type_object.equals("sensor"))
				{
					if(my_new_position!=null)
					{
					
					ArrayList<String> possible_mapping=Positions.possibleMapping(my_new_position.getType_position(), type_object);
					Sensor s=(Sensor)moved_object;
					String error="Déplacement est impossible pour la/les raison(s) suivantes:\n";
					if(!possible_mapping.contains(s.getType_sensor()))
					{
						error+="le type du capteur n'est pas supporté par cet emplacement\n";
					}
					if(!s.getIs_working())
					{
						error+="Le capteur "+s.getType_sensor()+" est non fonctionnel\n";
					}
					if(error!="Déplacement est impossible pour la/les raison(s) suivantes:\n")
					{
						JOptionPane.showMessageDialog(new JFrame(),error,"Déplacement Impossible",JOptionPane.PLAIN_MESSAGE);
					}
					else
					{
						Boolean move_success=Sensor.moveSensor(connection, s.getId_sensor(),my_old_position.getId_position(),my_new_position.getId_position());
						
						if(move_success==true)JOptionPane.showMessageDialog(new JFrame(),"Votre déplacement a été effectué avec succés","Succés",JOptionPane.PLAIN_MESSAGE);
						else
							JOptionPane.showMessageDialog(new JFrame(),"Le déplacement n'est pas possible essayer avec d'autre emplacement","Déplacement Impossible",JOptionPane.PLAIN_MESSAGE);
						
					}
				}
					else
					{
						JOptionPane.showMessageDialog(new JFrame(),my_new_position,"Déplacement Impossible",JOptionPane.PLAIN_MESSAGE);
					}
				}
				else
				{
					if(my_new_position!=null)
					{
					ArrayList<String> possible_mapping=Positions.possibleMapping(my_new_position.getType_position(), type_object);
					Equipment eq=(Equipment)moved_object;
					String error="Déplacement est impossible pour la/les raison(s) suivantes:\n";
					if(!possible_mapping.contains(eq.getType_equipment()))
					{
						error+="le type de l'équipement n'est pas supporté par cet emplacement\n";
					}
					if(!eq.getIs_working())
					{
						error+="L'équipement "+eq.getType_equipment()+" est non fonctionnel\n";
					}
					if(error!="Déplacement est impossible pour la/les raison(s) suivantes:\n")
					{
						JOptionPane.showMessageDialog(new JFrame(),error,"Déplacement Impossible",JOptionPane.PLAIN_MESSAGE);
					}
					else
					{
						Boolean move_success=Equipment.moveEquipment(connection, eq.getId_equipment(),my_old_position.getId_position(),my_new_position.getId_position());
						
						if(move_success==true)JOptionPane.showMessageDialog(new JFrame(),"Votre déplacement a été effectué avec succés","Succés",JOptionPane.PLAIN_MESSAGE);
						else
							JOptionPane.showMessageDialog(new JFrame(),"Le déplacement n'est pas possible essayer avec d'autre emplacement","Déplacement Impossible",JOptionPane.PLAIN_MESSAGE);
						
					}
				}
					else
					{
						JOptionPane.showMessageDialog(new JFrame(),my_new_position,"Déplacement Impossible",JOptionPane.PLAIN_MESSAGE);
					}	
				}
				
			}
		});    
		p_inter.setBackground(Color.white);
		p_inter.add(space);
		p_inter.add(b1);
		//  p3.add(p_inter);
		right.add(p3,BorderLayout.CENTER);
		p3.setBackground(Color.white);
		setVisible(true);

	}

	public static void main(String[] args) {
		new InfoMoving(new Equipment(1,"fenetre",true,true,0,0),"equipment",new General_Services(1,"Hajar Entertainent"));
	}

}
