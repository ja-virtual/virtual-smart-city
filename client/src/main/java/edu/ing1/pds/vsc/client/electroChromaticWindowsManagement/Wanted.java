package edu.ing1.pds.vsc.client.electroChromaticWindowsManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

	public class Wanted extends JFrame implements ActionListener{
		
		Welcome welcome;
		Windows window;
		Connection connect = null;
		
		static JTable table = new JTable();
		static JComboBox building = new JComboBox();
		static JComboBox positions = new JComboBox();
		static JComboBox workspace = new JComboBox();
		
		private static final long serialVersionUID = 1L;

			public Wanted(String title) { 
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
				mainPanel.setLayout(new GridLayout(6,1));
				this.getContentPane().add(mainPanel, BorderLayout.CENTER);
				
				JPanel pan1 = new JPanel();
				pan1.setLayout(new FlowLayout(FlowLayout.CENTER));
				
				JButton start = new JButton("Demarrer");
				start.setFont(new Font("Calibri", Font.BOLD, 20));
				start.addActionListener(this);
				pan1.add(start);
				mainPanel.add(pan1);
				
				JPanel pan2 = new JPanel();
				pan2.setLayout(new FlowLayout(FlowLayout.CENTER));
				JLabel lab3 = new JLabel("Batiment : ");
				pan2.add(lab3);
				pan2.add(building);
				mainPanel.add(pan2);
				
				JPanel pan3 = new JPanel();
				pan3.setLayout(new FlowLayout(FlowLayout.CENTER));
				JLabel lab4 = new JLabel("Position : ");
				pan3.add(lab4);
				pan3.add(positions);
				mainPanel.add(pan3);
				
				JPanel pan4 = new JPanel();
				pan4.setLayout(new FlowLayout(FlowLayout.CENTER));
				JLabel lab5 = new JLabel("Salle : ");
				pan4.add(lab5);
				pan4.add(workspace);
				mainPanel.add(pan4);
				
				JPanel pan5 = new JPanel();
				pan4.setLayout(new FlowLayout(FlowLayout.CENTER));
				JButton find = new JButton("Trouver");
				find.setFont(new Font("Calibri", Font.BOLD, 20));
				find.addActionListener(this);
				pan5.add(find);
				
				mainPanel.add(pan5);
				
				JPanel pan6 = new JPanel();
				pan6.setLayout(new FlowLayout(FlowLayout.CENTER));			
				JScrollPane pane = new JScrollPane(table);
				pan6.add(pane);
				
				mainPanel.add(pan6);
				
								
				this.setVisible(true);
			}
						
			
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand() == "Retour") {
				welcome = new Welcome("Virtual Smart City");
				this.dispose();
			}
			else if (e.getActionCommand() == "Demarrer") {

				try {
					
					Statement stmt1 = connect.createStatement ();
					String sql1 = " select * from Building ";
					ResultSet rs1 = stmt1.executeQuery(sql1);
					
					while(rs1.next()) {
						int id = rs1.getInt(1);
						//String build = "Building avec id N"+id; 
						
						building.addItem(id);	
					
					} 
					
					Statement stmt2 = connect.createStatement ();
					String sql2 = " select * from Positions ";
					ResultSet rs2 = stmt1.executeQuery(sql2);
					
					while(rs2.next()) {
						int id = rs2.getInt(1);
						String position = "Position avec id N�"+id; 
						
						positions.addItem(position);	
					
					} 
					
					Statement stmt3 = connect.createStatement ();
					String sql3 = " select * from Workspace ";
					ResultSet rs3 = stmt1.executeQuery(sql3);
					
					while(rs3.next()) {
						int id = rs3.getInt(1);
						String space = "Salle avec l'id N�"+id; 
						
						workspace.addItem(space);	
					
					} 
					
										
					rs1.close();
					stmt1.close();
					rs2.close();
					stmt2.close();
					rs3.close();
					stmt3.close();
				}
				
				catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
			else if (e.getActionCommand() == "Trouver") {
				
				//welcome = new Welcome("Virtual Smart City");
				//this.dispose();
			}
			else if (e.getActionCommand() == "Fenetres electro-chromatiques") {
				
				welcome = new Welcome("Virtual Smart City");
				this.dispose();
			}
		}
			
		
	}
	