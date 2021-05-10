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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ch.qos.logback.classic.Logger;
import edu.ing1.pds.vsc.client.ClientToServer;

	public class Windows extends JFrame implements ActionListener{
		Welcome welcome;
		Config config;
		Init init;
		
		//Connection connect = null;
		JTable table = new JTable();
		static JComboBox box = new JComboBox();
		static int selection;
		ClientToServer connection=new ClientToServer();
		/**
		 * 
		 */
		
		private static final long serialVersionUID = 1L;

			public Windows(String title) { 
				super();
				//connect=DbConnection.dbConnector();
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
				
				JButton load = new JButton("Charger mes fenetres");
				load.setFont(new Font("Tahoma", Font.PLAIN, 20));
				load.addActionListener(this);
			
				northPanel.add(load);
				
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
								"id_equipment", "type_equipment", "is_available", "is_working", "id_gs", "id_position"
						}
					));
				
				//JScrollPane pane = new JScrollPane(table);
				northPanel.add(table.getTableHeader());
				northPanel.add(table);
				mainPanel.add(northPanel);
				
				JPanel middlePanel = new JPanel();
				middlePanel.setLayout(new FlowLayout());
				
				JLabel lab2 = new JLabel("Selectionner une fenetre : ");
				lab2.setFont(new Font("Calibri", Font.BOLD, 20));
				
			
			    box.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
				middlePanel.add(lab2);
				middlePanel.add(box);
				
				
				
				mainPanel.add(middlePanel);
				
				JPanel southPanel = new JPanel();
				northPanel.setLayout(new FlowLayout());
				JButton bouton1 = new JButton("Retour");
				bouton1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				bouton1.addActionListener(this);
				
				JButton bouton2 = new JButton("Selectionner");
				bouton2.setFont(new Font("Tahoma", Font.PLAIN, 20));
				bouton2.addActionListener(this);
				
				southPanel.add(bouton1);
				southPanel.add(bouton2);
				mainPanel.add(southPanel);
				
				this.setVisible(true);
			}
			
			
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (e.getActionCommand() == "Retour") {
				init = new Init("Virtual Smart City");
				this.dispose();
			}
			else if (e.getActionCommand() == "Charger mes fenetres") {
				
				try
				{
					connection.client.close();
					
				}
				catch(Exception e1)
				{
					
				}
				
				ArrayList<Map> rs = WindowsTable.ownWindows(connection);
				for(Map n:rs)
				{
					String id_equipment =(String) n.get("id_equipment");
					String type_equipment = (String) n.get("type_equipment");
					String is_available = (String) n.get("is_available");
					String is_working = (String) n.get("is_working");
					String id_gs = (String) n.get("id_gs");
					String id_position = (String) n.get("id_position");
					
					String [] data = {id_equipment, type_equipment, is_available, is_working, id_gs, id_position};
					DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
					
					
				    tblModel.addRow(data);
				    
				}
			    
				for(Map n:rs)
				{
					int id = (int) n.get("id_equipment");
															
					box.addItem(id);
					
										
					box.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent event) {
			               
			               if (event.getSource()== box) {
			            	  selection = (int) box.getSelectedItem();
			            	  
			            	 
			               }
			            }
			        });
				} 
			
			}
			
			else if (e.getActionCommand() == "Selectionner") {
				try
				{
					connection.client.close();
					
				}
				catch(Exception e1)
				{
					
				}

				ArrayList<Map> insert = WindowsTable.windowsDefaultInsertion(connection, selection);
				ArrayList<Map> insert1 = TemperatureTable.temperatureDefaultInsertion(connection, selection);
				ArrayList<Map> insert2 = LightingTable.lightingDefaultInsertion(connection, selection);
			
				config = new Config("Virtual Smart City");
				this.dispose();
								
			}
			
			else if (e.getActionCommand() == "Fenetres electro-chromatiques") {
				
				welcome = new Welcome("Virtual Smart City");
				this.dispose();
			
			}
		}
		
	}