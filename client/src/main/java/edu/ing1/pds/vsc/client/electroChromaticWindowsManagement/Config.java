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
import java.util.ArrayList;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.General_Services;

	public class Config extends JFrame implements ActionListener {
		Welcome welcome;
		Windows window;
		General_Services company=null;
		ClientToServer connection=new ClientToServer();
		//int id_gs = company.getId_generalservices();
		JTable table1 = new JTable();
			
		JTable table2 = new JTable();
		
		int selection;
		
	
		/**
		 * 
		 */
		
		private static final long serialVersionUID = 1L;

			public Config(General_Services gs) { 
				super();
				company = gs;
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
				
				table1.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"id_windows", "status", "temperature", "light", "blind", "opacity", "id_equipment"
						}
					));
				pan1.add(bouton1);
				pan1.add(table1.getTableHeader());
				pan1.add(table1);
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
								
				table2.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"id_windows", "status", "temperature", "light", "blind", "opacity", "id_equipment"
						}
					));
				
				pan3.add(bouton4);
				pan3.add(table2.getTableHeader());
				pan3.add(table2);
				
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
				
				ArrayList<Map> rs1 = WindowsTable.windowsDefaultStatus(connection, selection);
				try
				{
					connection.client.close();
					
				}
				catch(Exception e1)
				{
					
				}
				
				for(Map n:rs1)
					
				{
					
					String id_windows = String.valueOf((int) n.get("id_windows"));
					String status = (String) n.get("status");
					String temperature = String.valueOf((int) n.get("temperature"));
					String light = String.valueOf((int) n.get("light"));
					String blind = (String) n.get("blind");
					String opacity = (String) n.get("opacity");
					String id_equipment = String.valueOf((int) n.get("id_equipment"));
					
					String [] data = {id_windows, status, temperature, light, blind, opacity, id_equipment};
					DefaultTableModel tblModel = (DefaultTableModel) table1.getModel();
					
					tblModel.addRow(data);
				}
				
			}
			
			else if (e.getActionCommand() == "Configurer eclairage") {
				
				ArrayList<Map> rs2 = LightingTable.levelFromLighting(connection, selection);
				try
				{
					connection.client.close();
					
				}
				catch(Exception e1)
				{
					
				}
				
				
				for(Map n:rs2)
					
				{
					String id_light = (String) n.get("id_light");
					String level = (String) n.get("level");
					String id_windows = (String) n.get("id_windows");
					
				
					
					switch (level) {
					
					  case "Aucun":
						  int update1 = WindowsTable.windowsUpdateForLightLevelAucun(connection, selection);
						  break;
					  case "Faible":
						  int update2 = WindowsTable.windowsUpdateForLightLevelFaible(connection, selection);
						  break;
					  case "Moyen":
						  int update3 = WindowsTable.windowsUpdateForLightLevelMoyen(connection, selection);
						  break;
					  case "Fort":
						  int update4 = WindowsTable.windowsUpdateForLightLevelFort(connection, selection);
						  break;
						
					  default:
						  int update5 = WindowsTable.windowsUpdateForLightLevelAutre(connection, selection);
						  	  
					} 
					}
				
			}		
			
			else if (e.getActionCommand() == "Configurer temperature") {
				ArrayList<Map> rs3 = TemperatureTable.degreeFromTemperature(connection, selection);
				
				try
				{
					connection.client.close();
					
				}
				catch(Exception e1)
				{
					
				}
				
				
				for(Map n:rs3)
					
				{
					
					String id_temperature = (String) n.get("id_temperature");
					int degree = (int) n.get("degree");
					String id_windows = (String) n.get("id_windows");	
					
					if ( degree < 18 ) {
						int update6 = WindowsTable.windowsUpdateForTemperatureDegreeLessThan18(connection, selection);
					}
					else if (degree>=18 || degree<22 ) {
						int update7 = WindowsTable.windowsUpdateForTemperatureDegree18_22(connection, selection);
					}
					else if (degree>=22) {
						int update8 = WindowsTable.windowsUpdateForTemperatureDegree22(connection, selection);
					}
				
				}
		}
			
			else if (e.getActionCommand() == "Actualiser statut") {
				
				ArrayList<Map> rs4 = WindowsTable.windowsUpdatedStatus(connection, selection);
				try
				{
					connection.client.close();
					
				}
				catch(Exception e1)
				{
					
				}
				
				for(Map n:rs4)
					
				{
					
					String id_windows = String.valueOf((int) n.get("id_windows"));
					String status = (String) n.get("status");
					String temperature = String.valueOf((int) n.get("temperature"));
					String light = String.valueOf((int) n.get("light"));
					String blind = (String) n.get("blind");
					String opacity = (String) n.get("opacity");
					String id_equipment = String.valueOf((int) n.get("id_equipment"));
					
					String [] data = {id_windows, status, temperature, light, blind, opacity, id_equipment};
					DefaultTableModel tblModel = (DefaultTableModel) table2.getModel();
					
					tblModel.addRow(data);
				}
					
			}
			else if (e.getActionCommand() == "Fenetres electro-chromatiques") {
				
				welcome = new Welcome(company);
				this.dispose();
			}
		}
	}