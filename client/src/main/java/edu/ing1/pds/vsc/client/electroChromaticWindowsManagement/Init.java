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
//import java.beans.Statement;
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

	public class Init extends JFrame implements ActionListener{
		
		Welcome welcome;
		Windows window;

		static JTable table = new JTable();
		
		Connection connect = null;
		
		private static final long serialVersionUID = 1L;

			public Init(String title) { 
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
				mainPanel.setLayout(new GridLayout(2,1));
				this.getContentPane().add(mainPanel, BorderLayout.CENTER);
				
				JPanel northPanel = new JPanel();
				northPanel.setLayout(new FlowLayout());
			
				JButton load = new JButton("Charger mes équipements");
				load.setFont(new Font("Tahoma", Font.PLAIN, 20));
				load.addActionListener(this);
				northPanel.add(load);
								
				JScrollPane pane = new JScrollPane(table);
				northPanel.add(pane);
				
				mainPanel.add(northPanel);
				
				JPanel southPanel = new JPanel();
				northPanel.setLayout(new FlowLayout());
				JButton bouton1 = new JButton("Retour");
				bouton1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				bouton1.addActionListener(this);
				
				JButton bouton2 = new JButton("Voir mes fenetres");
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
				welcome = new Welcome("Virtual Smart City");
				this.dispose();
			}
			else if (e.getActionCommand() == "Voir mes fenetres") {

				window = new Windows("Virtual Smart City");
				this.dispose();
				
				
			}
			else if (e.getActionCommand() == "Fenetres electro-chromatiques") {
				
				welcome = new Welcome("Virtual Smart City");
				this.dispose();
				
			}
			else if(e.getActionCommand() == "Charger mes équipements") {
			
			try {
				
				Statement stmt = connect.createStatement ();
				String sql = " select * from equipment ";
				ResultSet rs = stmt.executeQuery(sql);
				
			      table.setShowGrid(true);
			      table.setShowVerticalLines(true);
			      table.setModel(DbUtils.resultSetToTableModel(rs));
			      rs. close ();
			      stmt. close ();
			}
			
			catch(Exception e1) {
				e1.printStackTrace();
			}
				
		}
			
		}
				
	}
	