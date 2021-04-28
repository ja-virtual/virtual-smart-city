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

import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

	public class Windows extends JFrame implements ActionListener{
		Welcome welcome;
		Config config;
		Init init;
		
		Connection connect = null;
		static JTable table = new JTable();
		static JComboBox box = new JComboBox();
		
		private static int windowsId;
//		
//
		public static int getWindowsId() {
			return windowsId;
		}


		/**
		 * 
		 */
		
		private static final long serialVersionUID = 1L;

			public Windows(String title) { 
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
				
				JButton load = new JButton("Charger mes fenetres");
				load.setFont(new Font("Tahoma", Font.PLAIN, 20));
				load.addActionListener(this);
			
				northPanel.add(load);
				JScrollPane pane = new JScrollPane(table);
				
				northPanel.add(pane);
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
				
				try {
				
				Statement stmt1 = connect.createStatement ();
				String sql1 = " select * from Sensor where type = 'Fenetre' ";
				ResultSet rs1 = stmt1.executeQuery(sql1);
				table.setShowGrid(true);
			    table.setShowVerticalLines(true);
			    table.setModel(DbUtils.resultSetToTableModel(rs1));
			    //stmt1. close ();
			    
			    
			    Statement stmt2 = connect.createStatement ();
			    String sql2 = " select * from Sensor where type = 'Fenetre' " ;
			    ResultSet rs2 = stmt2.executeQuery(sql2);
				while(rs2.next()) {
					int id = rs2.getInt(1);
					
					//String fenetre = "Fenetre avec id N°"+id; 
					
					box.addItem(id);
					//windowsId = new ArrayList< Integer>();
					//windowsId.add(id);
					
					//box = new JComboBox(windowsId);
					//box.addActionListener()new Ac;
					
					//windowsId = new ArrayList< Integer>();
					//windowsId.add(id);
					
					box.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent event) {
			                // Get the source of the component, which is our combo
			                // box.
			               if (event.getSource()== box) {
			            	   windowsId = (int) box.getSelectedItem();
			            	   //System.out.println(i);
			               }
			            }
			        });
					
				
				} 
			rs1.close();
			stmt1.close();
			rs2.close();
			stmt2.close();
			}
				
				catch (Exception e1) {
					e1.printStackTrace();
				}
						
			}
			else if (e.getActionCommand() == "Selectionner") {

				config = new Config("Virtual Smart City");
				this.dispose();
				int selection = (int) Windows.getWindowsId();
				//System.out.println(getWindowsId());
			}
			else if (e.getActionCommand() == "Fenetres electro-chromatiques") {
				
				welcome = new Welcome("Virtual Smart City");
				this.dispose();
			
			}
		}
		
	}