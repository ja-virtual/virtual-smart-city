package edu.ing1.pds.vsc.client;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import ch.qos.logback.classic.Logger;
import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.General_Services;
import edu.ing1.pds.vsc.client.HomePage;
import edu.ing1.pds.vsc.client.Request;
import edu.ing1.pds.vsc.client.MappingManagement.List_Position;
import edu.ing1.pds.vsc.client.MappingManagement.Map_Full;
import edu.ing1.pds.vsc.client.MappingManagement.MappingUC;
import edu.ing1.pds.vsc.client.MappingManagement.WorkSpace;
import edu.ing1.pds.vsc.client.electroChromaticWindowsManagement.Welcome;
import edu.ing1.pds.vsc.client.workspaceLocation.lolo.lolo.Loocation;

public class WelcomePage extends JFrame {

	private ClientToServer connection=new ClientToServer();
	General_Services company=null;
	private JPanel right=new JPanel(new BorderLayout());
	JPanel left = new JPanel(new GridLayout(5,1));
	Color color=new Color(190,245,116);

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
					try
					{
						connection.client.close();

					}
					catch(Exception e1)
					{
						

					}
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

		menuBar.add(Box.createHorizontalGlue());
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

		this.getContentPane().add(left,BorderLayout.CENTER);

		left.setBackground(color);

		setSize(new Dimension(950,780));
		setLocationRelativeTo(null);
		setResizable(false);

	}
	public WelcomePage(General_Services GS)
	{

		company=GS;
		myInterface();
		setVisible(true);
	}


}
