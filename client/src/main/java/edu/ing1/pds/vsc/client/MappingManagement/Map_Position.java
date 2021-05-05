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




public class Map_Position extends JFrame {



	private ClientToServer connection=null;
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
	JButton sensor_move=new JButton("Déplacer capteur");
	JButton equipment_move=new JButton("Déplacer equipement");
	JButton position_map=new JButton("Mapper ");

	JCheckBox sensor=new JCheckBox("Capteur");
	JCheckBox equipment=new JCheckBox("Equipement");
	Boolean available_positions=false;
	Positions my_position;
	Map is_sensor=null,is_equipment=null;
	JMenu leave=new JMenu("Quitter");
	InfoMapping tobe_closed=null;
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
				tobe_closed.dispose();
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
				tobe_closed.dispose();
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
				tobe_closed.dispose();
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
				tobe_closed.dispose();
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
				tobe_closed.dispose();
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
	             tobe_closed.dispose();
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
					tobe_closed.dispose();
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
	              tobe_closed.dispose();
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
		
		menuBar.add(leave);
		right.add(menuBar, BorderLayout.NORTH);

		this.getContentPane().add(left,BorderLayout.WEST);
		this.getContentPane().add(right,BorderLayout.CENTER);
		left.setBackground(color);

		setSize(new Dimension(950,780));
		setLocationRelativeTo(null);
		setResizable(false);

	}
	public Map_Position(WorkSpace workspace,Positions position,int id_old_position,String type_object,General_Services GS)
	{
		connection=new ClientToServer();
		company=GS;
		my_position=position;
		if(type_object.equals("sensor"))
		is_sensor=Sensor.getSensor(connection,id_old_position);
		else
	    is_equipment=Equipment.getEquipment(connection,id_old_position);
		
		myInterface();
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
		my_workspace=workspace;
		positions=Positions.listPositions(connection,my_workspace.getId_workspace());
		equipments=Equipment.listEquipments(connection,my_workspace.getId_workspace());
		sensors=Sensor.listSensors(connection,my_workspace.getId_workspace());
		map.setSize(750, 750);
		JPanel p3=new JPanel(new BorderLayout());
	//	JPanel p4=new JPanel(new GridLayout(3,3));
		JLabel workspace_map=new JLabel("");
		workspace_map.setText(my_workspace.getType_workspace()+" "+my_workspace.getId_workspace());
		workspace_map.setFont(new Font("Serif", Font.BOLD, 15));
		workspace_map.setHorizontalAlignment(JLabel.CENTER);
		JPanel 	p_inter=new JPanel(new BorderLayout());
		JButton b1=new JButton("Retour vers les champs");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
						InfoMoving previous_view;
						if(is_sensor!=null)
						{
							try {
								connection.client.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							Sensor my_sensor=new Sensor((Integer)is_sensor.get("id_sensor"),(String)is_sensor.get("type_sensor"),(Boolean)is_sensor.get("is_available"),(Boolean)is_sensor.get("is_working"),(Integer)is_sensor.get("id_gs"),(Integer)is_sensor.get("id_position"));
							System.out.println("Sensor : "+my_sensor.getId_position());
							previous_view=new InfoMoving(my_sensor,"sensor",company);
							dispose();

						}
						else if(is_equipment!=null)
						{		
							try {
								connection.client.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							Equipment my_equipment=new Equipment((Integer)is_equipment.get("id_equipment"),(String)is_equipment.get("type_equipment"),(Boolean)is_equipment.get("is_available"),(Boolean)is_equipment.get("is_working"),(Integer)is_equipment.get("id_gs"),(Integer)is_equipment.get("id_position"));
							System.out.println("Equipment : "+my_equipment.getId_position());
							previous_view=new InfoMoving(my_equipment,"equipment",company);
							dispose();
						}
						
					}

		});
		b1.setPreferredSize(new Dimension(150,40));
		b1.setBackground(color);
		workspace_map.setText(my_workspace.getType_workspace()+" "+my_workspace.getId_workspace()+" | Batiment "+my_workspace.getId_building()+" | Etage "+my_workspace.getFloor_number());
		p_inter.setBackground(Color.white);
		p_inter.setPreferredSize(new Dimension(250,70));
		p_inter.add(b1,BorderLayout.NORTH);
		p_inter.add(workspace_map,BorderLayout.CENTER);
		p3.add(p_inter,BorderLayout.NORTH);
		p3.add(map,BorderLayout.CENTER);
		right.add(p3,BorderLayout.CENTER);
		setVisible(true);
	}


	public Map_Position(InfoMapping instance,ClientToServer con,Map ws, Positions position, General_Services GS) {
		company=GS;
		tobe_closed=instance;
		my_position=position;
		connection=con;
		myInterface();
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
		my_workspace=new WorkSpace((Integer)ws.get("id_workspace"), (String)ws.get("type_workspace"),(Integer)ws.get("floor_number"),(Boolean)ws.get("is_available"),(Integer)ws.get("id_building"), (Integer)ws.get("id_gs"));
		positions=Positions.listPositions(connection,my_workspace.getId_workspace());
		equipments=Equipment.listEquipments(connection,my_workspace.getId_workspace());
		sensors=Sensor.listSensors(connection,my_workspace.getId_workspace());
		map.setSize(750, 750);
		JPanel p3=new JPanel(new BorderLayout());
		JLabel workspace_map=new JLabel("");
		workspace_map.setText(my_workspace.getType_workspace()+" "+my_workspace.getId_workspace());
		workspace_map.setFont(new Font("Serif", Font.BOLD, 15));
		workspace_map.setHorizontalAlignment(JLabel.CENTER);
		JPanel 	p_inter=new JPanel(new BorderLayout());
		workspace_map.setText(my_workspace.getType_workspace()+" "+my_workspace.getId_workspace()+" | Batiment "+my_workspace.getId_building()+" | Etage "+my_workspace.getFloor_number());
		p_inter.setBackground(Color.white);
		p_inter.setPreferredSize(new Dimension(250,70));
		p_inter.add(workspace_map,BorderLayout.CENTER);
		p3.add(p_inter,BorderLayout.NORTH);
		p3.add(map,BorderLayout.CENTER);
		right.add(p3,BorderLayout.CENTER);
		setLocationRelativeTo(map);
		setVisible(true);
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
				Positions pos=new Positions((Integer)position.get("id_position"),(Integer)position.get("longitude"),(Integer)position.get("latitude"),(Integer)position.get("id_workspace"),(String)position.get("type_position"),(Boolean)position.get("is_available"));
				if(pos.getId_position()==my_position.getId_position())
				{
					g.setColor(Color.blue);
					g.fillOval((Integer)position.get("latitude"),(Integer)position.get("longitude"),45,45);
					g.drawString("Emplacement concerné",((Integer)position.get("latitude")-11),((Integer)position.get("longitude")+60));
					g.setColor(Color.black);
				}
				else if((Boolean)position.get("is_available")==true)
					{
						g.drawOval((Integer)position.get("latitude"),(Integer)position.get("longitude"),45,45);
						g.drawString("emplacement "+(Integer)position.get("id_position"),((Integer)position.get("latitude")-11),((Integer)position.get("longitude")+60));
					}
					else 
					{
						g.fillOval((Integer)position.get("latitude"),(Integer)position.get("longitude"),45,45);
						g.drawString("emplacement occupé",((Integer)position.get("latitude")-11),((Integer)position.get("longitude")+60));

					
					}
					
				}
			}

		}

	

}