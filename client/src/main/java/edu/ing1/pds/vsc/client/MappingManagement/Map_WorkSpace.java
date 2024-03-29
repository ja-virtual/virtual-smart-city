package edu.ing1.pds.vsc.client.MappingManagement;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.General_Services;
import edu.ing1.pds.vsc.client.HomePage;
import edu.ing1.pds.vsc.client.WelcomePage;
import edu.ing1.pds.vsc.client.workspaceLocation.lolo.lolo.Loocation;




public class Map_WorkSpace extends JFrame {



	private ClientToServer connection=new ClientToServer();
	private Connection con=null;
	General_Services company=null;
	private JPanel right=new JPanel();
	JPanel left = new JPanel(new GridLayout(5,1));
	Color color=new Color(190,245,116);
	Canvas map = new Workspace_Map();
	WorkSpace my_workspace;
	ArrayList<Map> equipments, sensors,positions;
	JComboBox sensors_box=new JComboBox();
	JComboBox equipments_box=new JComboBox();
	JButton sensor_move=new JButton("D�placer capteur");
	JButton equipment_move=new JButton("D�placer equipement");
	JButton position_map=new JButton("Mapper ");
	
	JCheckBox sensor=new JCheckBox("Capteur");
	JCheckBox equipment=new JCheckBox("Equipement");
	Boolean available_positions=false;

	public void sensorOrEquipment(String choice)
	{
		switch(choice)
		{
		case "sensor_equipment":
			if(!sensors.isEmpty())
			{
				String msg="\"Cet espace de travail ne contient aucun ";
				sensor.setSelected(true);
				sensors_box.removeAllItems();
				sensors_box.show();
				for(Map n:sensors)
				{
					sensors_box.addItem(n.get("type_sensor")+" "+n.get("id_sensor"));
				}
			}
			else
				sensors_box.hide();

			if(!equipments.isEmpty())
			{
				equipments_box.removeAllItems();
				equipment.setSelected(true);
				equipments_box.show();
				for(Map n:equipments)
				{
					equipments_box.addItem(n.get("type_equipment")+" "+n.get("id_equipment"));
				}
			}
			else
				equipments_box.hide();

			break;
		case "sensor":
			sensor_move.setEnabled(true);
			if(!sensors.isEmpty())
			{
				String msg="\"Cet espace de travail ne contient aucun ";
				sensor.setSelected(true);
				sensors_box.removeAllItems();
				sensors_box.show();
				for(Map n:sensors)
				{
					sensors_box.addItem(n.get("type_sensor")+" "+n.get("id_sensor"));
				}
			}
			else
			{
				sensors_box.hide();
				sensor.setSelected(false);
				JOptionPane.showMessageDialog(new JFrame(),
						"Cet espace de travail ne contient aucun capteur pour le moment",
						"Pas de capteur",
						JOptionPane.PLAIN_MESSAGE);
			}

			break;
		case "equipment":
			equipment_move.setEnabled(true);
			if(!equipments.isEmpty())
			{
				equipment.setSelected(true);
				equipments_box.removeAllItems();
				equipment.setSelected(true);
				equipments_box.show();
				for(Map n:equipments)
				{
					equipments_box.addItem(n.get("type_equipment")+" "+n.get("id_equipment"));
				}
			}
			else
			{

				equipments_box.hide();
				equipment.setSelected(false);
				JOptionPane.showMessageDialog(new JFrame(),
						"Cet espace de travail ne contient aucun equipement pour le moment",
						"Pas d'equipement",
						JOptionPane.PLAIN_MESSAGE);
			}
			break;
		case "no_sensor":
			sensor_move.setEnabled(false);
			sensors_box.hide();
			break;
		case "no_equipment":
			equipment_move.setEnabled(false);
			equipments_box.hide();
			break;
		}
		map.repaint();
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
			public void mouseClicked(MouseEvent e)
			{
				ArrayList<Map>ws=WorkSpace.allRentedWorkSpace(connection, company.getId_generalservices());
				if(ws==null )
				{
					JOptionPane.showMessageDialog(new JFrame(),
							"Pas d'espace lou� pour pouvoir utiliser cette fonctionnalit�","Mappage impossible pour le moment",
							JOptionPane.ERROR_MESSAGE);
				}
				else if(ws.isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(),
							"Pas d'espace lou� pour pouvoir utiliser cette fonctionnalit�","Mappage impossible pour le moment",
							JOptionPane.ERROR_MESSAGE);
				}
				else
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


			}});
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
		JMenu legend=new JMenu("L�gende");
		legend.addMenuListener(new MenuListener() {


			@Override
			public void menuSelected(MenuEvent e) {
				JOptionPane.showMessageDialog(new JFrame(),
						"La l�gende est la suivante :\n "
								+ "Ovale vide + Titre 'Emplacement libre' ==>  un emplacement pret � etre occup� par un objet \n"
								+ "Ovale noire + Titre 'Emplacement occup�' ==>  un emplacement d�j� occup� par un objet \n"
								+ "Ovale vert + Titre 'type capteur/�quipement id capteur/�quipement' ==>  un emplacement occup� par un capteur ou �quipment fonctionnel \n"
								+ "Ovale rouge + Titre 'type capteur/�quipement id capteur/�quipement' ==>  un emplacement occup� par un capteur ou �quipment non fonctionnel \n",
								"� propos",
								JOptionPane.PLAIN_MESSAGE);

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
		menuBar.add(legend);
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
	        	   try
	        	   {
	        		   connection.client.close();
	        	   }catch(Exception ex)
	        	   {
	        		   ex.printStackTrace();
	        	   }
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
	public Map_WorkSpace(WorkSpace workspace,General_Services GS)
	{
		company=GS;
		myInterface();
		my_workspace=workspace;
		positions=Positions.listPositions(connection,my_workspace.getId_workspace());
		equipments=Equipment.listEquipments(connection,my_workspace.getId_workspace());
		sensors=Sensor.listSensors(connection,my_workspace.getId_workspace());
		map.setSize(750, 750);
		JPanel p3=new JPanel(new BorderLayout());
		JPanel p4=new JPanel(new GridLayout(3,3));
		sensor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(sensor.isSelected())
					sensorOrEquipment("sensor");
				else
					sensorOrEquipment("no_sensor");


			}});
		equipment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(equipment.isSelected())
					{sensorOrEquipment("equipment");
					}
				else
				{
					sensorOrEquipment("no_equipment");
				}


			}});
		JPanel space=new JPanel();
		sensor_move.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 if(my_workspace.getId_generalServices()==0)
					{
						JOptionPane.showMessageDialog(new JFrame(),
								"Cet espace de travail n'est pas encore lou�",
								"D�placement Interdit",
								JOptionPane.PLAIN_MESSAGE);
					}
				 else if(my_workspace.getId_generalServices()==company.getId_generalservices())
				{
					  if(sensors_box.isVisible() && sensors_box.getSelectedIndex()!=-1)
					  {
						  try
							{
								connection.client.close();
							} 
							catch (IOException e1) {
								e1.printStackTrace();
							}
						Map sensor=sensors.get(sensors_box.getSelectedIndex());
						InfoMoving last_view=new InfoMoving(new Sensor((Integer)sensor.get("id_sensor"),(String)sensor.get("type_sensor"),(Boolean)sensor.get("is_available"),(Boolean)sensor.get("is_working"),(Integer)sensor.get("id_gs"),(Integer)sensor.get("id_position")),"sensor",company);
					  dispose();
					  }
					  else
					  {
							JOptionPane.showMessageDialog(new JFrame(),
									"Veuillez selectionner le capteur � d�placer",
									"Deplacement Interdit",
									JOptionPane.PLAIN_MESSAGE);
					  }
				}
				else if(company.getId_generalservices()!=my_workspace.getId_generalServices())
					JOptionPane.showMessageDialog(new JFrame(),
							"Cet espace de travail appartient � autre service g�n�ral",
							"Deplacement Interdit",
							JOptionPane.PLAIN_MESSAGE);
				


			}});
		sensor_move.setBackground(color);
		equipment_move.setBackground(color);
		equipment_move.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 if(my_workspace.getId_generalServices()==0)
					{
						JOptionPane.showMessageDialog(new JFrame(),
								"Cet espace de travail n'est pas encore lou�",
								"D�placement Interdit",
								JOptionPane.PLAIN_MESSAGE);
					}
				 else if(my_workspace.getId_generalServices()==company.getId_generalservices())
				{
						if(equipments_box.isVisible() && equipments_box.getSelectedIndex()!=-1)
						  {
							try
							{
								connection.client.close();
							} 
							catch (IOException e1) {
								e1.printStackTrace();
							}
							Map equip=equipments.get(equipments_box.getSelectedIndex());
							InfoMoving last_view=new InfoMoving(new Equipment((Integer)equip.get("id_equipment"),(String)equip.get("type_equipment"),(Boolean)equip.get("is_available"),(Boolean)equip.get("is_working"),(Integer)equip.get("id_gs"),(Integer)equip.get("id_position")),"equipment",company);
						  dispose();
						  }
						  else
						  {
								JOptionPane.showMessageDialog(new JFrame(),
										"Veuillez selectionner l'equipment � d�placer",
										"Deplacement Interdit",
										JOptionPane.PLAIN_MESSAGE);
						  }	
				}
				else if(company.getId_generalservices()!=my_workspace.getId_generalServices())
					JOptionPane.showMessageDialog(new JFrame(),
							"Cet espace de travail appartient � autre service g�n�ral",
							"Deplacement Interdit",
							JOptionPane.PLAIN_MESSAGE);
				


			}});
		position_map.setBackground(color);
		JComboBox positions_box=new JComboBox();
		for(Map n:positions)
		{
			if((Boolean)n.get("is_available")==true)
			{available_positions=true;
			positions_box.addItem("Emplacement "+n.get("id_position"));
			}
		}
		position_map.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(my_workspace.getId_generalServices()==0)
				{
					JOptionPane.showMessageDialog(new JFrame(),
							"Cet espace de travail n'est pas encore lou�",
							"Mappage Interdit",
							JOptionPane.PLAIN_MESSAGE);
				}
				else if(company.getId_generalservices()!=my_workspace.getId_generalServices())
				{
					JOptionPane.showMessageDialog(new JFrame(),
							"Cet espace de travail appartient � autre service g�n�ral",
							"Mappage Interdit",
							JOptionPane.PLAIN_MESSAGE);
			}
			else if(!available_positions)
			{
					JOptionPane.showMessageDialog(new JFrame(),
							"Cet espace de travail ne contient aucun emplacement libre pour le moment",
							"Pas d'emplacement libre",
							JOptionPane.PLAIN_MESSAGE);
			}
				else
				{
					Map row=null;
					for(Map n:positions)
					{
						if(n.get("id_position").toString().equals(positions_box.getSelectedItem().toString().substring(12)))
						{
							row=n;
						}
					}
					try
					{
						connection.client.close();
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
					
					InfoMapping im=new InfoMapping(new Positions((Integer)row.get("id_position"),(Integer)row.get("longitude"),(Integer)row.get("latitude"),(Integer)row.get("id_workspace"),(String)row.get("position_type"),(Boolean)row.get("is_available")),company);
			     	  dispose();
				}


			}});
		p4.add(sensor);
		p4.add(space);
		p4.add(equipment);
		p4.add(sensor_move);
		p4.add(equipment_move);
		p4.add(position_map);
		p4.add(sensors_box);
		p4.add(equipments_box);
		p4.add(positions_box);
		if(available_positions==false)
		{
			positions_box.hide();
		}
		p3.add(p4,BorderLayout.NORTH);
		p3.add(map,BorderLayout.CENTER);
		right.add(p3,BorderLayout.CENTER);
		setVisible(true);
		sensorOrEquipment("sensor_equipment");
	}
	public static void main(String[] args) {
		new Map_WorkSpace(new WorkSpace(2,"individuel",1,true, 1,1),new General_Services(1,"SnapShat"));
	}


	class Workspace_Map extends Canvas
	{
		public void paint(Graphics g) {

			if(my_workspace.getType_workspace().equals("salle de reunion"))
			{ 

				g.drawRect(120,140,450,450);

			}
			else if(my_workspace.getType_workspace().equals("open Space"))
			{ 
				g.drawRect(70,140,550,350);
			}
			else
			{
				g.drawRect(130,80,350,500);
			}

			for(Map position: positions)
			{
				if(!sensor.isSelected() && !equipment.isSelected())
				{
					if((Boolean)position.get("is_available")==true)
					{
						g.drawOval((Integer)position.get("latitude"),(Integer)position.get("longitude"),45,45);
						g.drawString("emplacement "+(Integer)position.get("id_position"),((Integer)position.get("latitude")-11),((Integer)position.get("longitude")+60));
					}
					else
					{
						g.fillOval((Integer)position.get("latitude"),(Integer)position.get("longitude"),45,45);
						g.drawString("emplacement occup�",((Integer)position.get("latitude")-11),((Integer)position.get("longitude")+60));

					}
				}
				else
				{
					if(sensor.isSelected() && !equipment.isSelected())
					{
						if((Boolean)position.get("is_available")==true)
						{

							g.drawOval((Integer)position.get("latitude"),(Integer)position.get("longitude"),45,45);
							g.drawString("emplacement "+(Integer)position.get("id_position"),((Integer)position.get("latitude")-11),((Integer)position.get("longitude")+60));
						}
						else
						{ 

							Map s=Sensor.getSensor(connection,(Integer)position.get("id_position"));
							if(s!=null)
							{
								Sensor my_sensor=new Sensor((Integer)s.get("id_sensor"),(String)s.get("type_sensor"),(Boolean)s.get("is_available"),(Boolean)s.get("is_working"),(Integer)s.get("id_gs"),(Integer)s.get("id_position"));
								if(my_sensor.getIs_working()==true)
								{
								  g.setColor(Color.green);
								}
								else
								{
									 g.setColor(Color.red);	
								}
								g.fillOval((Integer)position.get("latitude"),(Integer)position.get("longitude"),45,45);
								 g.setColor(Color.black);
								g.drawString(my_sensor.getType_sensor()+" "+my_sensor.getId_sensor(),((Integer)position.get("latitude")-16),((Integer)position.get("longitude")+60));
							}
							else
							{
								g.fillOval((Integer)position.get("latitude"),(Integer)position.get("longitude"),45,45);
								g.drawString("emplacement occup�",((Integer)position.get("latitude")-11),((Integer)position.get("longitude")+60));
							}
						}
					}
					else if(equipment.isSelected() && !sensor.isSelected())
					{
						if((Boolean)position.get("is_available")==true)
						{

							g.drawOval((Integer)position.get("latitude"),(Integer)position.get("longitude"),45,45);
							g.drawString("emplacement "+(Integer)position.get("id_position"),((Integer)position.get("latitude")-6),((Integer)position.get("longitude")+60));
						}
						else
						{ 

							Map p=Equipment.getEquipment(connection,(Integer)position.get("id_position"));
							if(p!=null)
							{

								Equipment my_equipment=new Equipment((Integer)p.get("id_equipment"),(String)p.get("type_equipment"),(Boolean)p.get("is_available"),(Boolean)p.get("is_working"),(Integer)p.get("id_gs"),(Integer)p.get("id_position"));
								if(my_equipment.getIs_working()==true)
								{
								  g.setColor(Color.green);
								}
								else
								{
									 g.setColor(Color.red);	
								}
								g.fillOval((Integer)position.get("latitude"),(Integer)position.get("longitude"),45,45);
								 g.setColor(Color.black);
								g.drawString(my_equipment.getType_equipment()+" "+my_equipment.getId_equipment(),((Integer)position.get("latitude")-16),((Integer)position.get("longitude")+60));
							}
							else
							{
								g.fillOval((Integer)position.get("latitude"),(Integer)position.get("longitude"),45,45);
								g.drawString("emplacement occup�",((Integer)position.get("latitude")-11),((Integer)position.get("longitude")+60));
							}
						}
					}
				   else if(equipment.isSelected() && sensor.isSelected())
				   {
					   if((Boolean)position.get("is_available")==true)
						{

							g.drawOval((Integer)position.get("latitude"),(Integer)position.get("longitude"),45,45);
							g.drawString("emplacement "+(Integer)position.get("id_position"),((Integer)position.get("latitude")-6),((Integer)position.get("longitude")+60));
						}
						else
						{ Map s=Sensor.getSensor(connection,(Integer)position.get("id_position"));
						Map p=Equipment.getEquipment(connection,(Integer)position.get("id_position"));
						if(s!=null)
						{
							Sensor my_sensor=new Sensor((Integer)s.get("id_sensor"),(String)s.get("type_sensor"),(Boolean)s.get("is_available"),(Boolean)s.get("is_working"),(Integer)s.get("id_gs"),(Integer)s.get("id_position"));
							if(my_sensor.getIs_working()==true)
							{
							  g.setColor(Color.green);
							}
							else
							{
								 g.setColor(Color.red);	
							}
							g.fillOval((Integer)position.get("latitude"),(Integer)position.get("longitude"),45,45);
							 g.setColor(Color.black);
							g.drawString(my_sensor.getType_sensor()+" "+my_sensor.getId_sensor(),((Integer)position.get("latitude")-16),((Integer)position.get("longitude")+60));
						}
						else if(p!=null)
						{
							Equipment my_equipment=new Equipment((Integer)p.get("id_equipment"),(String)p.get("type_equipment"),(Boolean)p.get("is_available"),(Boolean)p.get("is_working"),(Integer)p.get("id_gs"),(Integer)p.get("id_position"));
							if(my_equipment.getIs_working()==true)
							{
							  g.setColor(Color.green);
							}
							else
							{
								 g.setColor(Color.red);	
							}
							g.fillOval((Integer)position.get("latitude"),(Integer)position.get("longitude"),45,45);
							g.setColor(Color.black);
							g.drawString(my_equipment.getType_equipment()+" "+my_equipment.getId_equipment(),((Integer)position.get("latitude")-16),((Integer)position.get("longitude")+60));
						
						}
						}
				   }
						
				}
			}

		}

	}


}