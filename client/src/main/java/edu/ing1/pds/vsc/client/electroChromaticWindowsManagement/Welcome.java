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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

	public class Welcome extends JFrame implements ActionListener{
		Init init ;
		Welcome welcome;
		Wanted wanted;
		
		/**
		 * 
		 */
		
		private static final long serialVersionUID = 1L;

			public Welcome(String title) { 
				super();
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
				
				JPanel mainPanel = new JPanel();
				mainPanel.setLayout(new GridLayout(3,1));
				this.getContentPane().add(mainPanel, BorderLayout.CENTER);
				
				JPanel northPanel = new JPanel();
				northPanel.setLayout(new FlowLayout());
				
				JLabel lab1 = new JLabel("Interface des fenetres");
				JLabel lab2 = new JLabel("electro-chromatiques");
			
				lab1.setFont(new Font("Calibri", Font.BOLD, 30));
				lab2.setFont(new Font("Calibri", Font.BOLD, 30));
				
				northPanel.add(lab1);
				northPanel.add(lab2);
				mainPanel.add(northPanel);
				
				JPanel middlePanel = new JPanel();
				middlePanel.setLayout(new FlowLayout());
			
				JButton bouton1 = new JButton("Localiser un equipement");
				bouton1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				bouton1.addActionListener(this);
				JButton bouton2 = new JButton("Voir mes equipements");
				bouton2.setFont(new Font("Tahoma", Font.PLAIN, 20));
				bouton2.addActionListener(this);
				
				
				middlePanel.add(bouton1);
				middlePanel.add(bouton2);
				
				mainPanel.add(middlePanel);
				
								
				JPanel southPanel = new JPanel();
				northPanel.setLayout(new FlowLayout());
				JButton bouton3 = new JButton("Quitter");
				bouton1.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
			else if (e.getActionCommand() == "Voir mes equipements") {

				init = new Init("Virtual Smart City");
				this.dispose();
				
			}
			else if (e.getActionCommand() == "Rechercher une fenetre") {
				
				wanted = new Wanted("Virtual Smart City");
				this.dispose();
			}
		
		}
		
		
	}