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
import javax.swing.JPanel;
import javax.swing.MenuElement;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.HomePage;
import edu.ing1.pds.vsc.client.Request;


public class Map_Full extends JFrame  {

	 private final static Logger logger = LoggerFactory.getLogger(Map_Full.class.getName());
	private ClientToServer connection=new ClientToServer();
	private Connection con=null;
	JPanel p3=new JPanel(new BorderLayout());
	private JPanel right=new JPanel();
	JPanel left = new JPanel(new GridLayout(5,1));
	Color color=new Color(190,245,116);
	JLabel building_label=new JLabel("Batiment :   Batiment numéro 1");
	JLabel floor_label=new JLabel("Etage :   Etage number 1");
	private int building_number=1;
	private int floor_number=1;
	private  WorkSpace reunion1=null,reunion2=null,reunion3=null,reunion4=null,open_space1=null,open_space2=null,individual1=null,individual2=null,individual3=null,individual4=null;
	Canvas map;
	ArrayList<Map>workspaces=WorkSpace.listWorkSpace(connection,building_number, floor_number);
	ArrayList<Map>buildings=Building.allBuildings(connection);
	public void Map_creation()
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
			for(Map n : workspaces)
			{
				String workspace_type=(String) n.get("type_workspace");
				if(workspace_type.equals("salle de reunion"))
				{	
					if(reunion1==null)
					{

						reunion1=new WorkSpace((String)n.get("id_workspace"),workspace_type,(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs"));

					}
					else if(reunion2==null)
					{

						reunion2=new WorkSpace((String)n.get("id_workspace"),workspace_type,(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs"));

					}
					else if(reunion3==null)
					{

						reunion3=new WorkSpace((String)n.get("id_workspace"),workspace_type,(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs"));

					}
					else
					{
						
						reunion4=new WorkSpace((String)n.get("id_workspace"),workspace_type,(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs"));

					}
				}
				else if(workspace_type.equals("individuel"))
				{
					if(individual1==null)
					{
						individual1=new WorkSpace((String)n.get("id_workspace"),workspace_type,(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs"));

					}
					else if(individual2==null)
					{
						individual2=new WorkSpace((String)n.get("id_workspace"),workspace_type,(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs"));
					}
					else if(individual3==null)
					{
						individual3=new WorkSpace((String)n.get("id_workspace"),workspace_type,(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs"));
					}
					else 
					{
						individual4=new WorkSpace((String)n.get("id_workspace"),workspace_type,(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs"));
					}
				}
				else
				{
					if(open_space1==null)
					{
						open_space1=new WorkSpace((String)n.get("id_workspace"),workspace_type,(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs"));

					}
					else
					{
						open_space2=new WorkSpace((String)n.get("id_workspace"),workspace_type,(Integer)n.get("floor_number"),(Boolean)n.get("is_available"),(Integer)n.get("id_building"),(Integer)n.get("id_gs"));
					}
				}
			}
			map.repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Critere(JMenuBar critere)
	{
		try {
			JMenu building=new JMenu("numéro de batiment");
			JMenu floor=new JMenu(" numéro d'étage");
			JMenu work_space=new JMenu("espace de travail");
			critere.add(building);
			critere.add(floor);
			critere.add(work_space);
			for(Map n : workspaces)
			{

				JMenuItem workspace_number=new JMenuItem(n.get("type_workspace")+" "+n.get("id_workspace"));
				workspace_number.setPreferredSize(new Dimension(150,30));
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
							for(Map n : workspaces)
							{

								JMenuItem workspace_number=new JMenuItem(n.get("type_workspace")+" "+n.get("id_workspace"));
								workspace_number.setPreferredSize(new Dimension(150,30));
								work_space.add(workspace_number);

							}
					
						} catch (Exception e1) {
						}
						Map_creation();
					}} );

			}
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
							for(Map n:buildings){

								JMenuItem workspace_number=new JMenuItem(n.get("type_workspace")+" "+n.get("id_workspace"));
								workspace_number.setPreferredSize(new Dimension(150,30));
								work_space.add(workspace_number);

							}
							Map_creation();
						} catch (Exception e1) {
						}
}} );

			}
		} catch (Exception e) {
		}
	}

	private void Interface() throws Exception
	{
		setLayout(new BorderLayout());

		//Left menu creation

		left.setMinimumSize(new Dimension(250, 480));
		left.setPreferredSize(new Dimension(250, 480));
		left.setMaximumSize(new Dimension(250, 480));

		JPanel p=new JPanel();
		JLabel image = new JLabel();
		ImageIcon  img= new ImageIcon("C:\\Users\\elori\\Downloads\\logo_ja_virtual.png");
		image.setIcon( new ImageIcon(img.getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH)));


		JLabel phrase_acceuil = new JLabel("Bienvenue sur Ja-Virtual");
		phrase_acceuil.setFont(new Font("Serif", Font.BOLD, 13));
		p.add(image);
		p.add(phrase_acceuil);
		p.setBackground(color);
		left.add(p);
		p=new JPanel(new GridLayout());
		image = new JLabel();
		img= new ImageIcon("C:\\Users\\elori\\Downloads\\use_case_icon.png");
		image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));


		JLabel use_case = new JLabel("Fonctionnalite 1");
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
		use_case.setFont(new Font("Serif", Font.BOLD, 15));
		p.add(image,BorderLayout.WEST);
		p.add(use_case,BorderLayout.CENTER);
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
		img= new ImageIcon("C:\\Users\\elori\\Downloads\\use_case_icon.png");
		image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));

		use_case = new JLabel("Fonctionnalite 2");
		use_case.setFont(new Font("Serif", Font.BOLD, 15));
		p.add(image,BorderLayout.WEST);
		p.add(use_case,BorderLayout.CENTER);
		p.setBackground(color);
		left.add(p);
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				// you can open a new frame here as
				// i have assumed you have declared "frame" as instance variable
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
		img= new ImageIcon("C:\\Users\\elori\\Downloads\\use_case_icon.png");
		image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));

		use_case = new JLabel("Mappage C/E");
		use_case.setFont(new Font("Serif", Font.BOLD, 15));
		p.add(image,BorderLayout.WEST);
		p.add(use_case,BorderLayout.CENTER);
		p.setBackground(color);
		left.add(p);
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				// you can open a new frame here as
				// i have assumed you have declared "frame" as instance variable
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
		img= new ImageIcon("C:\\Users\\elori\\Downloads\\use_case_icon.png");
		image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));


		use_case = new JLabel("Fonctionnalite 4");
		use_case.setFont(new Font("Serif", Font.BOLD, 15));
		p.add(image,BorderLayout.WEST);
		p.add(use_case,BorderLayout.CENTER);
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
		right.setBackground(Color.white);
		right.setLayout(new BorderLayout());

		JMenuBar menuBar=new JMenuBar();

		menuBar.setBorderPainted(isDoubleBuffered());
		menuBar.setSize(750,45);
		JMenu list=new JMenu("Liste des emplacements ");
		list.setSize(750,45);
		JMenu plan=new JMenu("Plan");
		plan.addMenuListener((MenuListener) new MenuListener() {

			public void menuSelected(MenuEvent e) {

				try {
					Map_Full menuItem1=new Map_Full();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}


			@Override
			public void menuDeselected(MenuEvent e) {
				//nothing to code

			}

			@Override
			public void menuCanceled(MenuEvent e) {
				//nothing to code

			}
		});
		plan.setSize(150,45);
		list.addMenuListener((MenuListener) new MenuListener() {

			public void menuSelected(MenuEvent e) {

				List_Position menuItem1=new List_Position();
				dispose();
			}


			@Override
			public void menuDeselected(MenuEvent e) {
				//nothing to code

			}

			@Override
			public void menuCanceled(MenuEvent e) {
				//nothing to code

			}
		});

		menuBar.add(list);
		menuBar.add(plan);
		// menuBar.add(Box.createHorizontalGlue());
		// menuBar.add(criterion);
		right.add(menuBar, BorderLayout.NORTH);

		this.getContentPane().add(left,BorderLayout.WEST);
		this.getContentPane().add(right,BorderLayout.CENTER);
		left.setBackground(color);

		setSize(new Dimension(950,780));
		setLocationRelativeTo(null);
		setResizable(false);

	}
	public Map_Full()throws Exception
	{

		con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestHajar","postgres","admin");

		Interface();
		// frame = new JFrame("My Drawing");
		JMenuBar criterion=new JMenuBar();
		Critere(criterion);

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
		map=new Floor_Map();
		map.setSize(750, 750);
		p3.add(map,BorderLayout.CENTER);
		Map_creation();
		right.add(p3,BorderLayout.CENTER);
		setVisible(true);
	}
	public static void main(String[] args)throws Exception {
		new Map_Full();
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
				else if(reunion1.getId_generalServices()==1)
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
				else if(reunion2.getId_generalServices()==1)
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
				else if(open_space1.getId_generalServices()==1)
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
					g.drawString(individual1.getId_workspace(),520,170);
					
				}
				else if(individual1.getId_generalServices()==1)
				{
					g.setColor(Color.green);
					g.fillRect(510,120,35,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString("Idv\n",520,160);
					g.drawString(individual1.getId_workspace(),520,170);
				}
				else
				{

					g.setColor(Color.red);
					g.drawRect(510,120,35,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString("Idv\n",520,160);
					g.drawString(individual1.getId_workspace(),520,170);
			
					
				}
				
				if(individual2.getIs_available()==true)
				{
					g.drawRect(565,120,35,95);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString("Idv\n",575,160);
					g.drawString(individual2.getId_workspace(),575,170);

				}
				else if(individual2.getId_generalServices()==1)
				{
					g.setColor(Color.green);
					g.drawRect(565,120,35,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString("Idv\n",575,160);
					g.drawString(individual2.getId_workspace(),575,170);
				}
				else
				{
					g.setColor(Color.red);
					g.drawRect(565,120,35,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString("Idv\n",575,160);
					g.drawString(individual2.getId_workspace(),575,170);
				}

				if(reunion3.getIs_available()==true)
				{
					g.drawRect(70,225,95,95);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString(reunion3.toString(), 90,265);
				}
				else if(reunion3.getId_generalServices()==1)
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
				else if(reunion4.getId_generalServices()==1)
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
				else if(open_space2.getId_generalServices()==1)
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
					g.drawString(individual3.getId_workspace(),520,270);
					
				}
				else if(individual3.getId_generalServices()==1)
				{
					g.setColor(Color.green);
					g.fillRect(510,225,35,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString("Idv\n",520,260);
					g.drawString(individual3.getId_workspace(),520,270);
				}
				else
				{

					g.setColor(Color.red);
					g.drawRect(510,120,35,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString("Idv\n",520,160);
					g.drawString(individual3.getId_workspace(),520,170);
			
					
				}
				
				if(individual4.getIs_available()==true)
				{
					g.drawRect(565,225,35,95);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString("Idv\n",575,260);
					g.drawString(individual4.getId_workspace(),575,270);

				}
				else if(individual4.getId_generalServices()==1)
				{
					g.setColor(Color.green);
					g.drawRect(565,225,35,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString("Idv\n",575,260);
					g.drawString(individual4.getId_workspace(),575,270);
				}
				else
				{
					g.setColor(Color.red);
					g.drawRect(565,225,35,95);
					g.setColor(Color.black);
					g.setFont(new Font("Serif", Font.BOLD, 13));
					g.drawString("Idv\n",575,260);
					g.drawString(individual4.getId_workspace(),575,270);
				}
			}	
	

		}	
	}
}
