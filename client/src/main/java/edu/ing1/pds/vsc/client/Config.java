package edu.ing1.pds.vsc.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

	public class Config extends JFrame implements ActionListener{

		/**
		 * 
		 */
		
		//GridLayout gl = new GridLayout(1,3);
		FlowLayout fl = new FlowLayout();
		
		private static final long serialVersionUID = 1L;

			public Config(String title) { 
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
				
				// image.setIcon( new ImageIcon(icon.getImage().getScaledInstance(75,75, Image.SCALE_SMOOTH)));
				 
				 //Image scaleImage = icon.getImage().getScaledInstance(28, 28,Image.SCALE_DEFAULT);
				JLabel logoLabel = new JLabel(icon);
				
				//logoLabel.setSize(50, 50);
				leftPanel.add(logoLabel);
				
				this.getContentPane().add(leftPanel, BorderLayout.WEST);
				
				JPanel south = new JPanel();
				south.setBackground(Color.GREEN);
				JButton uc1 = new JButton ("Fonctionnalit� 1");
				uc1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				JButton uc2 = new JButton ("Fonctionnalit� 2");
				uc2.setFont(new Font("Tahoma", Font.PLAIN, 20));
				JButton uc3 = new JButton ("Fenetres electro-chromatiques");
				uc3.setFont(new Font("Tahoma", Font.PLAIN, 20));
				JButton uc4 = new JButton ("Fonctionnalit� 4");
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
				
				JLabel lab1 = new JLabel("Choisir parmi les");
				JLabel lab2 = new JLabel("options propos�es");
				//tf1.setText("\r\n Bienvenue dans l'interface des \r\n fenetres electro-chromatiques \r\n\r\n \r\n\r\n \r\n");
				lab1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 40));
				lab2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 40));
				northPanel.add(lab1);
				northPanel.add(lab2);
				mainPanel.add(northPanel);
				
				JPanel middlePanel = new JPanel();
				middlePanel.setLayout(new GridLayout(6,2));
				JLabel statut = new JLabel("Statut : ");
				JLabel store = new JLabel("Store : ");
				JLabel chaufClim = new JLabel("Chauffage/Clim Reversible : ");
				JLabel temperature = new JLabel("Temperature : ");
				JLabel eclairage = new JLabel("Eclairage : ");
				JLabel opacite = new JLabel("Opacite Vitre : ");
				
				JComboBox<String> status = new JComboBox<String>();
				status.addItem("Ouvrir");
				status.addItem("Fermer");
				
				JComboBox<String> blind = new JComboBox<String>();
				blind.addItem("Niveau 0 (totalement ouvert)");
				blind.addItem("Niveau 1 (ouvert au quart)");
				blind.addItem("Niveau 2 (A moitier ouvert)");
				blind.addItem("Niveau 3 (ferm� au quart)");
				blind.addItem("Niveau 4 (totalement ferm�)");
				
				JComboBox<String> heatingAndCoolness = new JComboBox<String>();
				heatingAndCoolness.addItem("On");
				heatingAndCoolness.addItem("Off");
								
				JComboBox<String> degree = new JComboBox<String>();
				degree.addItem("20");
				degree.addItem("21");
				degree.addItem("22");
				degree.addItem("23");
				degree.addItem("24");
				degree.addItem("25");
				
				JComboBox<String> lighting = new JComboBox<String>();
				lighting.addItem("Faible");
				lighting.addItem("Moyen");
				lighting.addItem("Fort");
				
				JComboBox<String> opacity = new JComboBox<String>();
				opacity.addItem("Faible");
				opacity.addItem("Moyenne");
				opacity.addItem("Forte");
				
				middlePanel.add(statut);
				middlePanel.add(status);
				middlePanel.add(store);
				middlePanel.add(blind);
				middlePanel.add(chaufClim);
				middlePanel.add(heatingAndCoolness);
				middlePanel.add(temperature);
				middlePanel.add(degree);
				middlePanel.add(eclairage);
				middlePanel.add(lighting);
				middlePanel.add(opacite);
				middlePanel.add(opacity);
				
				mainPanel.add(middlePanel);
				
				JPanel southPanel = new JPanel();
				northPanel.setLayout(new FlowLayout());
				JButton bouton1 = new JButton("Retour");
				bouton1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				bouton1.addActionListener(this);
				
				JButton bouton2 = new JButton("Valider");
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
			
		}
	}