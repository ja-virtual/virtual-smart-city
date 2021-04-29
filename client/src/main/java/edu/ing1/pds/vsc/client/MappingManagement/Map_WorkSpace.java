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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import edu.ing1.pds.vsc.client.HomePage;




public class Map_WorkSpace extends JFrame {

	private JPanel right=new JPanel();
	JPanel left = new JPanel(new GridLayout(5,1));
	Color color=new Color(190,245,116);
	Canvas map = new Map();
	WorkSpace my_workspace;
	private void Interface()
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
		right.add(menuBar, BorderLayout.NORTH);

		this.getContentPane().add(left,BorderLayout.WEST);
		this.getContentPane().add(right,BorderLayout.CENTER);
		left.setBackground(color);

		setSize(new Dimension(950,780));
		setLocationRelativeTo(null);
		setResizable(false);

	}
	public Map_WorkSpace(WorkSpace workspace)
	{
		Interface();
		my_workspace=workspace;

		map.setSize(750, 750);
		JPanel p3=new JPanel(new BorderLayout());
		JPanel p4=new JPanel(new GridLayout(3,3));



		JCheckBox sensor=new JCheckBox("Capteur");
		sensor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(sensor.isSelected())
					map.repaint();
				else
					System.out.println("equipement");


			}});
		JCheckBox equipment=new JCheckBox("Equipement");


		JPanel space=new JPanel();
		JButton sensor_move=new JButton("Déplacer capteur");
		sensor_move.setBackground(color);
		JButton equipment_move=new JButton("Déplacer equipement");
		equipment_move.setBackground(color);
		JButton position_map=new JButton("Mapper Emplacement");
		position_map.setBackground(color);
		JComboBox positions=new JComboBox();
		JComboBox sensors=new JComboBox();
		JComboBox equipments=new JComboBox();
		sensor.setSelected(true);
		equipment.setSelected(true);
		p4.add(sensor);
		p4.add(space);
		p4.add(equipment);
		p4.add(sensor_move);
		p4.add(equipment_move);
		p4.add(position_map);
		p4.add(positions);
		p4.add(sensors);
		p4.add(equipments);
		p3.add(p4,BorderLayout.NORTH);
		p3.add(map,BorderLayout.CENTER);
		right.add(p3,BorderLayout.CENTER);


		setVisible(true);
	}
	public static void main(String[] args) {
		new Map_WorkSpace(new WorkSpace("Hajar","open Space",1,true, 1,1));
	}


	class Map extends Canvas
	{
		public void paint(Graphics g) {


			if(my_workspace.getType_workspace().equals("open Space"))
			{
				final ImageIcon icon = new ImageIcon("C:\\Users\\elori\\OneDrive\\Desktop\\emplacement.png");
				Image img = icon.getImage();
			
				g.drawImage(img,120,140, this);

				g.drawRect(120,140,450,450);
				g.drawImage(getIconImage(),150,130,null);
			}
			else
				g.drawRect(50,200,575,220);

			/*g.fillRect(70,220,80,80);
			g.fillRect(170,220,90,80);
			g.fillRect(280,220,160,80);
			g.fillRect(460,220,35,80);
			g.fillRect(515,220,35,80);
			g.setColor(Color.red);
			g.fillRect(570,220,35,80);



			g.fillRect(70,320,80,80);
			g.fillRect(170,320,90,80);
			g.fillRect(280,320,160,80);
			g.fillRect(460,320,35,80);
			g.fillRect(515,320,35,80);
			g.setColor(color);
			g.fillRect(570,320,35,80);
			;*/
			// g.drawString("hajar", 150, 200);

		}	
	}
}