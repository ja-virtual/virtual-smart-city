package edu.ing1.pds.vsc.client.electroChromaticWindowsManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

	public class Config extends JFrame implements ActionListener{
		Welcome welcome;
		Windows window;
		
		Connection connect = null;
		static JTable table1 = new JTable();
		//static JComboBox box1 = new JComboBox();
		static JTable table2 = new JTable();
		//static JComboBox box2 = new JComboBox();
		//Window[] selection = Windows.getWindows();
		
	
		/**
		 * 
		 */
		
		private static final long serialVersionUID = 1L;

			public Config(String title) { 
				super();
				connect=DbConnection.dbConnector();
				this.setSize(900,600);
				this.setLocationRelativeTo(null);
				this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				JPanel leftPanel = new JPanel();
				GridLayout grille = new GridLayout(3,1);
				leftPanel.setLayout(grille);
				leftPanel.setBackground(Color.GREEN);
				leftPanel.setPreferredSize(new Dimension(300, 600));
				
				JPanel north = new JPanel();
				north.setLayout(new FlowLayout(FlowLayout.LEFT));
				ImageIcon icon = new ImageIcon("images/logo.png");
		
				JLabel logoLabel = new JLabel(icon);
				logoLabel.setIcon( new ImageIcon(icon.getImage().getScaledInstance(130,130, Image.SCALE_SMOOTH)));
				leftPanel.add(logoLabel);
				
				this.getContentPane().add(leftPanel, BorderLayout.WEST);
				
				JPanel south = new JPanel();
				south.setBackground(Color.GREEN);
				JButton uc1 = new JButton ("Fonctionnalite 1");
				uc1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				JButton uc2 = new JButton ("Fonctionnalite 2");
				uc2.setFont(new Font("Tahoma", Font.PLAIN, 20));
				JButton uc3 = new JButton ("Fenetres electro-chromatiques");
				uc3.addActionListener(this);
				uc3.setFont(new Font("Tahoma", Font.PLAIN, 20));
				JButton uc4 = new JButton ("Fonctionnalite 4");
				uc4.setFont(new Font("Tahoma", Font.PLAIN, 20));
				
				south.add(uc1);
				south.add(uc2);
				south.add(uc3);
				south.add(uc4);
				
				leftPanel.add(south);
				
				this.getContentPane().add(leftPanel, BorderLayout.WEST);
				
				JPanel mainPanel = new JPanel();
				mainPanel.setLayout(new GridLayout(3,1));
				this.getContentPane().add(mainPanel, BorderLayout.CENTER);
				
				JPanel northPanel = new JPanel();
				northPanel.setLayout(new FlowLayout());
				
				JButton bouton1 = new JButton("Voir statut");
				bouton1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				bouton1.addActionListener(this);
				
				JScrollPane pane1 = new JScrollPane(table1);
				northPanel.add(bouton1);
				northPanel.add(pane1);
				
				
				mainPanel.add(northPanel);
				
				
				JPanel middlePanel = new JPanel();
				middlePanel.setLayout(new FlowLayout());

				JButton bouton2 = new JButton("Actualiser");
				bouton2.setFont(new Font("Tahoma", Font.PLAIN, 20));
				bouton2.addActionListener(this);
								
				JScrollPane pane2 = new JScrollPane(table2);
				middlePanel.add(bouton2);
				middlePanel.add(pane2);
				
				mainPanel.add(middlePanel);
				
				JPanel southPanel = new JPanel();
				southPanel.setLayout(new FlowLayout());
				JButton bouton3 = new JButton("Quitter");
				bouton3.setFont(new Font("Tahoma", Font.PLAIN, 20));
				bouton3.addActionListener(this);
				
				southPanel.add(bouton3);
				mainPanel.add(southPanel);
						
					this.setVisible(true);
			}
			
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand() == "Quitter") {
				System.exit(0);
			}
			else if (e.getActionCommand() == "Voir statut") {

				try {
					//Windows win = new Windows("Virtual Smart city");
					int selection = (int) Windows.getWindowsId();
					Statement stmt1 = connect.createStatement ();
					//id = new ArrayList< Integer>();
					//windowId = Windows.getWindows();
					String sql1 = " select * from Windows where id = selection ";
					ResultSet rs1 = stmt1.executeQuery(sql1);
					table1.setShowGrid(true);
				    table1.setShowVerticalLines(true);
				    table1.setModel(DbUtils.resultSetToTableModel(rs1));
				    
				    
				    
			rs1.close();
			stmt1.close();
			
			}
				
				catch (Exception e1) {
					e1.printStackTrace();
				}

			}
			else if (e.getActionCommand() == "Actualiser") {
				
				try {
					
					Statement stmt2 = connect.createStatement ();
					String sql2 = " select * from Windows where type = 'Fenetre' ";
					ResultSet rs2 = stmt2.executeQuery(sql2);
					table1.setShowGrid(true);
				    table1.setShowVerticalLines(true);
				    table1.setModel(DbUtils.resultSetToTableModel(rs2));
				
				
				rs2.close();
				stmt2.close();
				
				}
					
					catch (Exception e2) {
						e2.printStackTrace();
					}
			}
			else if (e.getActionCommand() == "Fenetres electro-chromatiques") {
				
				welcome = new Welcome("Virtual Smart City");
				this.dispose();
			}
		}
	}