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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

	public class Config extends JFrame implements ActionListener {
		Welcome welcome;
		Windows window;
		
		Connection connect = null;
		JTable table1 = new JTable();
		//JTable sptab1 = new JTable();
		//JTable sptab2 = new JTable();
	
		JTable table2 = new JTable();
		
		int selection;
		
	
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
				
				JPanel pan1 = new JPanel();
				pan1.setLayout(new FlowLayout());
				
				JButton bouton1 = new JButton("Statut par defaut");
				bouton1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				bouton1.addActionListener(this);
				
				JScrollPane pane1 = new JScrollPane(table1);
				pane1.setPreferredSize(new Dimension(500,100));
			
				pan1.add(bouton1);
				pan1.add(pane1);
				mainPanel.add(pan1);
				
				JPanel pan2 = new JPanel();
				pan2.setLayout(new FlowLayout());
				
				JButton bouton2 = new JButton("Configurer temperature");
				bouton2.setFont(new Font("Tahoma", Font.PLAIN, 20));
				bouton2.addActionListener(this);
				JButton bouton3 = new JButton("Configurer eclairage");
				bouton3.setFont(new Font("Tahoma", Font.PLAIN, 20));
				bouton3.addActionListener(this);
				pan2.add(bouton2);
				pan2.add(bouton3);
				
				mainPanel.add(pan2);
				
				
				JPanel pan3 = new JPanel();
				pan3.setLayout(new FlowLayout());

				JButton bouton4 = new JButton("Actualiser statut");
				bouton4.setFont(new Font("Tahoma", Font.PLAIN, 20));
				bouton4.addActionListener(this);
								
				JScrollPane pane3 = new JScrollPane(table2);
				pane3.setPreferredSize(new Dimension(500,100));
				pan3.add(bouton4);
				pan3.add(pane3);
				
				mainPanel.add(pan3);
				
						
					this.setVisible(true);
			}
			
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand() == "Quitter") {
				System.exit(0);
			}
			else if (e.getActionCommand() == "Statut par defaut") {

				try {
					
					selection =  (int) Windows.box.getSelectedItem();
					Statement stmt1 = connect.createStatement ();
					
					String sql1 = " select * from Windows where id_equipment = "+selection+" ";
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
			
			else if (e.getActionCommand() == "Configurer eclairage") {
				
				try {
					
					Statement statement1 = connect.createStatement ();
					String req1 = " select level from Lighting where id_windows = "+selection+" ";
					ResultSet result1 = statement1.executeQuery(req1);
					
					while(result1.next()) { 
						
						String level = result1.getString(1);
					
					switch (level) {
					
					  case "Aucun":
						  String update1 = "update Windows set blind = 'Niveau 0', opacity = 'Aucun' where id_windows = "+selection+" "; 
						  int n1=statement1.executeUpdate(update1);
					   break;
					  case "Faible":
						  String update2 = "update Windows set blind = 'Niveau 1', opacity = 'Faible' where id_windows = "+selection+" "; 
						  int n2=statement1.executeUpdate(update2);
					   break;
					  case "Moyen":
						  String update3 = "update Windows set blind = 'Niveau 2', opacity = 'Moyen' where id_windows = "+selection+" "; 
						  int n3=statement1.executeUpdate(update3);
						   break;
					  case "Fort":
						  String update4 = "update Windows set blind = 'Niveau 3', opacity = 'Fort' where id_windows = "+selection+" "; 
						  int n4=statement1.executeUpdate(update4);
						   break;
						
					  default:
						  String update5 = "update Windows set blind = 'Niveau 4' and opacity = 'Fort' where id_windows = "+selection+" "; 
						  int n5=statement1.executeUpdate(update5);
						  	  
					} 
					}
					
					result1.close();
					statement1.close();
					
					
				}
					
					catch (Exception e2) {
						e2.printStackTrace();
					}
			
			}		
			
			else if (e.getActionCommand() == "Configurer temperature") {
				
				try {
					
					Statement statement2 = connect.createStatement ();
					String req2 = " select degree from Temperature where id_windows = "+selection+" ";
					ResultSet result2 = statement2.executeQuery(req2);
					
					while(result2.next()) {
						int degree = result2.getInt(1);
					switch (degree) {
					
					  case 20:
						  String update6 = "update Windows set blind = 'Niveau 0', opacity = 'Aucun' where id_windows = "+selection+" "; 
						  int n6=statement2.executeUpdate(update6);
					   break;
					  case 21:
						  String update7 = "update Windows set blind = 'Niveau 1', opacity = 'Faible' where id_windows = "+selection+" "; 
						  int n7=statement2.executeUpdate(update7);
					   break;
					  case 22:
						  String update8 = "update Windows set blind = 'Niveau 2', opacity = 'Moyen' where id_windows = "+selection+" "; 
						  int n8=statement2.executeUpdate(update8);
						   break;
					  case 23:
						  String update9 = "update Windows set blind = 'Niveau 3', opacity = 'Fort' where id_windows = "+selection+" "; 
						  int n9=statement2.executeUpdate(update9);
						   break;
						
					  default:
						  String update10 = "update Windows set blind = 'Niveau 4', opacity = 'Fort' where id_windows = "+selection+" "; 
						  int n10=statement2.executeUpdate(update10);
					}
					}  
						  result2.close();
							statement2.close();
							
									}
								
								catch (Exception e3) {
									e3.printStackTrace();
								}
						}
			
			else if (e.getActionCommand() == "Actualiser statut") {
				
				try {
					
					Statement stmt2 = connect.createStatement ();
					String sql2 = " select * from Windows where id_equipment = "+selection+" ";
					ResultSet rs2 = stmt2.executeQuery(sql2);
					table2.setShowGrid(true);
				    table2.setShowVerticalLines(true);
				    table2.setModel(DbUtils.resultSetToTableModel(rs2));
				
				
				rs2.close();
				stmt2.close();
				
				}
					
					catch (Exception e4) {
						e4.printStackTrace();
					}
			}
			else if (e.getActionCommand() == "Fenetres electro-chromatiques") {
				
				welcome = new Welcome("Virtual Smart City");
				this.dispose();
			}
		}
	}