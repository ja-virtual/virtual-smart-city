package edu.ing1.pds.vsc.client.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Welcome extends JFrame implements ActionListener{
	Init init ;

	/**
	 *
	 */

	//GridLayout gl = new GridLayout(1,3);
	FlowLayout fl = new FlowLayout();

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
		//logoLabel.setSize( new Dimension(30, 30));
		leftPanel.add(logoLabel);

		this.getContentPane().add(leftPanel, BorderLayout.WEST);

		JPanel south = new JPanel();
		south.setBackground(Color.GREEN);
		JButton uc1 = new JButton ("Fonctionnalité 1");
		uc1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JButton uc2 = new JButton ("Fonctionnalité 2");
		uc2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JButton uc3 = new JButton ("Fenetres electro-chromatiques");
		uc3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JButton uc4 = new JButton ("Fonctionnalité 4");
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

		JLabel lab1 = new JLabel("Bienvenue dans l'interface des");
		JLabel lab2 = new JLabel("fenetres electro-chromatiques");
		//tf1.setText("\r\n Bienvenue dans l'interface des \r\n fenetres electro-chromatiques \r\n\r\n \r\n\r\n \r\n");
		lab1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 40));
		lab2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 40));
		northPanel.add(lab1);
		northPanel.add(lab2);
		mainPanel.add(northPanel);

		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(new FlowLayout());

		JLabel lab3 = new JLabel("Vous pouvez visualiser le mapping");
		JLabel lab4 = new JLabel("des capteurs de votre espace en ");
		JLabel lab5 = new JLabel("cliquant sur le bouton \"Visualiser\"");
		lab3.setFont(new Font("Calibri", Font.ITALIC, 40));
		lab4.setFont(new Font("Calibri", Font.ITALIC, 40));
		lab5.setFont(new Font("Calibri", Font.ITALIC, 40));
		middlePanel.add(lab3);
		middlePanel.add(lab4);
		middlePanel.add(lab5);
		mainPanel.add(middlePanel);

		JPanel southPanel = new JPanel();
		northPanel.setLayout(new FlowLayout());
		JButton bouton1 = new JButton("Quitter");
		bouton1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		//bouton1.setFont(new Font(title, 20, defaultCloseOperation));
		bouton1.addActionListener(this);

		JButton bouton2 = new JButton("Visualiser");
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
		if (e.getActionCommand() == "Quitter") {
			System.exit(0);
		}
		else if (e.getActionCommand() == "Visualiser") {

			init = new Init("Virtual Smart City");
			this.dispose();
		}

	}

}