package edu.ing1.pds.vsc.client.MappingManagement;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.MenuElement;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.General_Services;
import edu.ing1.pds.vsc.client.HomePage;
import edu.ing1.pds.vsc.client.Request;
import edu.ing1.pds.vsc.client.WelcomePage;
import edu.ing1.pds.vsc.client.workspaceLocation.lolo.lolo.Loocation;


public class MappingUC extends JFrame  {

	private final static Logger logger = LoggerFactory.getLogger(Map_Full.class.getName());
	General_Services company=null;


	private ClientToServer connection=new ClientToServer();

	JPanel p3=new JPanel(new BorderLayout());
	private JPanel right=new JPanel();
	JPanel left = new JPanel(new GridLayout(5,1));
	Color color=new Color(190,245,116);
	JLabel building_label=new JLabel("Batiment :   Batiment numéro 1");
	JLabel floor_label=new JLabel("Etage :   Etage number 1");
	private int building_number=1;
	private int floor_number=1;
	private  WorkSpace reunion1=null,reunion2=null,reunion3=null,reunion4=null,open_space1=null,open_space2=null,individual1=null,individual2=null,individual3=null,individual4=null;
	Canvas myFloor_map;
	ArrayList<Map>workspaces=WorkSpace.listWorkSpace(connection,building_number, floor_number);
	ArrayList<Map>buildings=Building.allBuildings(connection);
	public void mapCreation()
	{
		try {
			reunion1=null;
			reunion2=null;
			individual1=null;
			individual2=null;
			reunion3=null;
			reunion4=null;
			individual3=null;
			individual4=null;
			open_space1=null;
			open_space2=null;
			workspaces=WorkSpace.listWorkSpace(connection,building_number, floor_number);
			buildings=Building.allBuildings(connection);
			for(Map n : workspaces)
			{
				String workspace_type=(String) n.get("type_workspace");
				if(workspace_type.equals("salle de reunion"))
				{	
					if(reunion1==null)
					{

						reunion1=new WorkSpace((Integer)n.get("id_workspace"),workspace_type,(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs"));

					}
					else if(reunion2==null)
					{

						reunion2=new WorkSpace((Integer)n.get("id_workspace"),workspace_type,(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs"));

					}
					else if(reunion3==null)
					{

						reunion3=new WorkSpace((Integer)n.get("id_workspace"),workspace_type,(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs"));

					}
					else
					{

						reunion4=new WorkSpace((Integer)n.get("id_workspace"),workspace_type,(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs"));

					}
				}
				else if(workspace_type.equals("individuel"))
				{
					if(individual1==null)
					{
						individual1=new WorkSpace((Integer)n.get("id_workspace"),workspace_type,(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs"));

					}
					else if(individual2==null)
					{
						individual2=new WorkSpace((Integer)n.get("id_workspace"),workspace_type,(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs"));
					}
					else if(individual3==null)
					{
						individual3=new WorkSpace((Integer)n.get("id_workspace"),workspace_type,(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs"));
					}
					else 
					{
						individual4=new WorkSpace((Integer)n.get("id_workspace"),workspace_type,(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs"));
					}
				}
				else
				{
					if(open_space1==null)
					{
						open_space1=new WorkSpace((Integer)n.get("id_workspace"),workspace_type,(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs"));

					}
					else
					{
						open_space2=new WorkSpace((Integer)n.get("id_workspace"),workspace_type,(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs"));
					}
				}
			}
			myFloor_map.repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void myCriterion(JMenuBar myCriterion)
	{
		try {
			JMenu building=new JMenu("numéro de batiment");
			JMenu floor=new JMenu(" numéro d'étage");
			JMenu work_space=new JMenu("espace de travail");
			myCriterion.add(building);
			myCriterion.add(floor);
			myCriterion.add(work_space);
			workspaces=WorkSpace.listWorkSpace(connection,building_number, floor_number);
			buildings=Building.allBuildings(connection);
			for(Map n : workspaces)
			{
				JMenuItem workspace_number=new JMenuItem(n.get("type_workspace")+" "+n.get("id_workspace"));
				workspace_number.setPreferredSize(new Dimension(150,30));
				workspace_number.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JMenuItem source = (JMenuItem) (e.getSource());
						workspaces=WorkSpace.listWorkSpace(connection,building_number, floor_number);
						buildings=Building.allBuildings(connection);
						for(Map n : workspaces)
						{
							if(((String)n.get("type_workspace")+" "+(Integer)n.get("id_workspace")).equals(source.getText()))
							{	
								try {
									connection.client.close();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								Map_WorkSpace my_workspace=new Map_WorkSpace(new WorkSpace((Integer)n.get("id_workspace"),(String)n.get("type_workspace"),
										(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs")),company);
								dispose();

							}}}

				});
				work_space.add(workspace_number);

			}
			for(int i=1;i<=4;i++)
			{
				JMenuItem flr_number=new JMenuItem("étage numéro "+i);
				flr_number.setPreferredSize(new Dimension(150,30));
				floor.add(flr_number);
				flr_number.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						try { 

							JMenuItem source = (JMenuItem) (e.getSource());
							floor_label.setText("Etage :  "+source.getText());
							floor_number=Integer.valueOf(source.getText().substring(13));
							work_space.removeAll();
							workspaces=WorkSpace.listWorkSpace(connection,building_number, floor_number);
							buildings=Building.allBuildings(connection);
							for(Map n : workspaces)
							{

								JMenuItem workspace_number=new JMenuItem(n.get("type_workspace")+" "+n.get("id_workspace"));
								workspace_number.setPreferredSize(new Dimension(150,30));
								workspace_number.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										JMenuItem source = (JMenuItem) (e.getSource());
										for(Map n : workspaces)
										{
											if(((String)n.get("type_workspace")+" "+(Integer)n.get("id_workspace")).equals(source.getText()))
											{	try {
												connection.client.close();
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											Map_WorkSpace my_workspace=new Map_WorkSpace(new WorkSpace((Integer)n.get("id_workspace"),(String)n.get("type_workspace"),
													(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs")),company);

											dispose();
											break;
											}}}

								});
								work_space.add(workspace_number);

							}

						} catch (Exception e1) {
						}
						mapCreation();
					}} );

			}
			workspaces=WorkSpace.listWorkSpace(connection,building_number, floor_number);
			buildings=Building.allBuildings(connection);
			for(Map n:buildings) {

				JMenuItem build_number=new JMenuItem("Batiment numéro "+n.get("id_building"));
				build_number.setPreferredSize(new Dimension(150,30));
				building.add(build_number);
				build_number.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try { 
							JMenuItem source = (JMenuItem) (e.getSource());
							building_label.setText("Batiment :  "+source.getText());
							building_number=Integer.valueOf(source.getText().substring(16));
							work_space.removeAll();
							workspaces=WorkSpace.listWorkSpace(connection,building_number, floor_number);
							buildings=Building.allBuildings(connection);
							for(Map n:workspaces){

								JMenuItem workspace_number=new JMenuItem(n.get("type_workspace")+" "+n.get("id_workspace"));
								workspace_number.setPreferredSize(new Dimension(150,30));
								workspace_number.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										JMenuItem source = (JMenuItem) (e.getSource());
										workspaces=WorkSpace.listWorkSpace(connection,building_number, floor_number);
										buildings=Building.allBuildings(connection);
										for(Map n : workspaces)
										{
											if(((String)n.get("type_workspace")+" "+(Integer)n.get("id_workspace")).equals(source.getText()))
											{	
												try {
													connection.client.close();
												} catch (IOException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
													Map_WorkSpace my_workspace=new Map_WorkSpace(new WorkSpace((Integer)n.get("id_workspace"),(String)n.get("type_workspace"),(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs")),company);
												dispose();
											}}}

								});
								work_space.add(workspace_number);
							}

							mapCreation();
						} catch (Exception e1) {
						}
					}} );

			}
		} catch (Exception e) {
		}
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
							"Pas d'espace loué pour pouvoir utiliser cette fonctionnalité","Mappage impossible pour le moment",
							JOptionPane.ERROR_MESSAGE);
				}
				else if(ws.isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(),
							"Pas d'espace loué pour pouvoir utiliser cette fonctionnalité","Mappage impossible pour le moment",
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
	public MappingUC(General_Services GS)
	{
		company=GS;

		myInterface();
		// frame = new JFrame("My Drawing");
		JMenuBar criterion=new JMenuBar();
		myCriterion(criterion);

		JPanel p4=new JPanel(new BorderLayout());
		JPanel p_inter=new JPanel(new GridLayout(3,1));
		JLabel Title=new JLabel("- Bienvenue aux Plans -");
		Title.setHorizontalAlignment(JLabel.CENTER);
		Title.setFont(new Font("Serif", Font.BOLD, 45));
		p_inter.add(Title);
		p_inter.add(building_label);
		p_inter.add(floor_label);
		p4.add(criterion,BorderLayout.NORTH);
		p4.add(p_inter,BorderLayout.CENTER);
		building_label.setHorizontalAlignment(JLabel.CENTER);
		building_label.setFont(new Font("Serif", Font.ITALIC, 25));
		floor_label.setHorizontalAlignment(JLabel.CENTER);
		floor_label.setFont(new Font("Serif", Font.ITALIC, 25));
		p3.add(p4,BorderLayout.NORTH);
		myFloor_map=new Floor_Map();
		myFloor_map.setSize(750, 750);
		p3.add(myFloor_map,BorderLayout.CENTER);
		mapCreation();
		right.add(p3,BorderLayout.CENTER);


		setVisible(true);
	}
	public static void main(String[] args)throws Exception {
		new Map_Full(new General_Services(1,"hajar"));
	}


	class Floor_Map extends Canvas
	{

		public void paint(Graphics g) {
			super.paint(g);

			g.drawRect(50,100,575,235);
			if(reunion1!=null && reunion2!=null &&reunion3!=null && reunion4!=null && individual1!=null && individual2!=null &&individual3!=null && individual4!=null&& open_space1!=null && open_space2!=null )
			{

				if(reunion1.getIs_available()==true)
				{
					g.drawRect(70,120,95,95);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString(reunion1.toString(), 90,165);
				}
				else if(reunion1.getId_generalServices()==company.getId_generalservices())
				{
					g.setColor(Color.green);
					g.fillRect(70,120,95,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString(reunion1.toString(), 90,165);

				}
				else
				{
					g.setColor(Color.red);
					g.fillRect(70,120,95,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString(reunion1.toString(), 90,165);
				}

				if(reunion2.getIs_available()==true)
				{
					g.drawRect(180,120,95,95);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString(reunion2.toString(), 220,165);
				}
				else if(reunion2.getId_generalServices()==company.getId_generalservices())
				{

					g.setColor(Color.green);
					g.fillRect(180,120,95,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString(reunion2.toString(), 220,165);
				}
				else
				{
					g.setColor(Color.red);
					g.fillRect(180,120,95,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString(reunion2.toString(), 220,165);
				}

				if(open_space1.getIs_available()==true)
				{
					g.drawRect(290,120,200,95);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString(open_space1.toString(),380,165);
				}
				else if(open_space1.getId_generalServices()==company.getId_generalservices())
				{
					g.setColor(Color.green);
					g.fillRect(290,120,200,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString(open_space1.toString(), 380,165);
				}
				else
				{

					g.setColor(Color.red);
					g.fillRect(290,120,200,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString(open_space1.toString(), 380,165);
				}

				if(individual1.getIs_available()==true)
				{

					g.drawRect(510,120,35,95);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString("Idv\n",520,160);
					g.drawString(individual1.getId_workspace()+"",520,170);

				}
				else if(individual1.getId_generalServices()==company.getId_generalservices())
				{
					g.setColor(Color.green);
					g.fillRect(510,120,35,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString("Idv\n",520,160);
					g.drawString(individual1.getId_workspace()+"",520,170);
				}
				else
				{

					g.setColor(Color.red);
					g.fillRect(510,120,35,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString("Idv\n",520,160);
					g.drawString(individual1.getId_workspace()+"",520,170);


				}

				if(individual2.getIs_available()==true)
				{
					g.drawRect(565,120,35,95);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString("Idv\n",575,160);
					g.drawString(individual2.getId_workspace()+"",575,170);

				}
				else if(individual2.getId_generalServices()==company.getId_generalservices())
				{
					g.setColor(Color.green);
					g.fillRect(565,120,35,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString("Idv\n",575,160);
					g.drawString(individual2.getId_workspace()+"",575,170);
				}
				else
				{
					g.setColor(Color.red);
					g.fillRect(565,120,35,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString("Idv\n",575,160);
					g.drawString(individual2.getId_workspace()+"",575,170);
				}

				if(reunion3.getIs_available()==true)
				{
					g.drawRect(70,225,95,95);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString(reunion3.toString(), 90,265);
				}
				else if(reunion3.getId_generalServices()==company.getId_generalservices())
				{
					g.setColor(Color.green);
					g.fillRect(70,225,95,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString(reunion3.toString(), 90,265);

				}
				else
				{
					g.setColor(Color.red);
					g.fillRect(70,225,95,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString(reunion3.toString(), 90,265);
				}

				if(reunion4.getIs_available()==true)
				{
					g.drawRect(180,225,95,95);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString(reunion4.toString(), 210,265);
				}
				else if(reunion4.getId_generalServices()==company.getId_generalservices())
				{

					g.setColor(Color.green);
					g.fillRect(180,225,95,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString(reunion4.toString(), 210,265);
				}
				else
				{
					g.setColor(Color.red);
					g.fillRect(180,225,95,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString(reunion4.toString(), 210,265);
				}

				if(open_space2.getIs_available()==true)
				{
					g.drawRect(290,225,200,95);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString(open_space2.toString(),380,265);
				}
				else if(open_space2.getId_generalServices()==company.getId_generalservices())
				{
					g.setColor(Color.green);
					g.fillRect(290,225,200,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString(open_space2.toString(), 380,265);
				}
				else
				{

					g.setColor(Color.red);
					g.fillRect(290,225,200,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString(open_space2.toString(), 380,265);
				}

				if(individual3.getIs_available()==true)
				{

					g.drawRect(510,225,35,95);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString("Idv\n",520,260);
					g.drawString(individual3.getId_workspace()+"",520,270);

				}
				else if(individual3.getId_generalServices()==company.getId_generalservices())
				{
					g.setColor(Color.green);
					g.fillRect(510,225,35,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString("Idv\n",520,260);
					g.drawString(individual3.getId_workspace()+"",520,270);
				}
				else
				{

					g.setColor(Color.red);
					g.fillRect(510,225,35,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString("Idv\n",520,260);
					g.drawString(individual3.getId_workspace()+"",520,270);


				}

				if(individual4.getIs_available()==true)
				{
					g.drawRect(565,225,35,95);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString("Idv\n",575,260);
					g.drawString(individual4.getId_workspace()+"",575,270);

				}
				else if(individual4.getId_generalServices()==company.getId_generalservices())
				{
					g.setColor(Color.green);
					g.fillRect(565,225,35,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString("Idv\n",575,260);
					g.drawString(individual4.getId_workspace()+"",575,270);
				}
				else
				{
					g.setColor(Color.red);
					g.fillRect(565,225,35,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString("Idv\n",575,260);
					g.drawString(individual4.getId_workspace()+"",575,270);
				}
			}	
			


		}	
	}
}
