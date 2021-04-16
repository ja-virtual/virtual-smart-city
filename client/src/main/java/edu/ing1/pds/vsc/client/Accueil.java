import java.awt.*;

import javax.swing.*;


public class test extends JFrame {

	public test()
	{
		setSize(new Dimension(450,450));
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());

		//  JPanel panel = new JPanel(new GridBagLayout());

		JLabel image = new JLabel();
		ImageIcon  img= new ImageIcon("C:\\Users\\elori\\Downloads\\logo_ja_virtual.png");
		image.setIcon( new ImageIcon(img.getImage().getScaledInstance(75,75, Image.SCALE_SMOOTH)));


		JLabel phrase_acceuil = new JLabel("Bienvenue sur Ja-Virtual");
		phrase_acceuil.setFont(new Font("Serif", Font.BOLD, 25));
		JComboBox nom_entreprise=new JComboBox();

		nom_entreprise.addItem(" Saisir le nom de votre entreprise....." );
		nom_entreprise.addItem("Entreprise 1" );
		nom_entreprise.addItem("Entreprise 2" );
		nom_entreprise.addItem("Entreprise 3" );
		nom_entreprise.addItem("Entreprise 4" );
		JButton annuler = new JButton("Annuler");
		JButton valider= new JButton("Valider");
		JButton municipalite = new JButton("Municiplalité");


		GridBagConstraints c = new GridBagConstraints();
		c.insets=new Insets(15,1,15,1);

		c.ipadx=1;
		c.ipady=5;
		c.gridx = 0;//set the x location of the grid for the next component
		c.gridy = 0;//set the y location of the grid for the next component
		this.getContentPane().add(image,c);


		c.ipadx=10;
		c.ipady=10;
		c.gridx = 1;//set the x location of the grid for the next component

		this.getContentPane().add(phrase_acceuil,c);
		c.anchor=GridBagConstraints.CENTER;


		c.gridy = 5;//change the y location
		c.ipadx=5;
		c.ipady=5;

		this.getContentPane().add(nom_entreprise,c);

		c.gridy = 6;//change the y location

		c.ipadx=45;
		c.ipady=5;
		this.getContentPane().add(annuler,c);

		c.gridy = 7;//change the y location

		this.getContentPane().add(valider,c);

		c.gridy = 8;//change the y location
		c.ipadx=15;
		c.ipady=5;

		this.getContentPane().add(municipalite,c);

		nom_entreprise.setEditable(true);
		nom_entreprise.getEditor().getEditorComponent().setBackground(Color.white);
		nom_entreprise.setFont(new Font("Serif", Font.ITALIC, 16));
		nom_entreprise.setBackground(Color.white);
		//      this.getContentPane().add(panel);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		Color color=new Color(190,245,116);
		getContentPane().setBackground(color);
		setResizable(false);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test();
	}
}

