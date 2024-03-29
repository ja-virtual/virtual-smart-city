package edu.ing1.pds.vsc.client;
import javax.imageio.ImageIO;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException; 


class Menu extends JFrame implements ItemListener {

	
	

	    // frame 
	    static JFrame frame; 
	    // combobox 
	    static JComboBox combobox; 
	    // label 
	    static JLabel l1; 

	    public static void main(String[] args) throws IOException 
	    {
	        // cr�er un nouveau frame 
	        frame = new JFrame("frame"); 
	     //   ImageIcon icone = new ImageIcon("logo-ja-virtual.png");
	        BufferedImage img = ImageIO.read(new File("logo-ja-virtual.png"));
	        JLabel pic = new JLabel(new ImageIcon(img));
	        frame.add(pic);
	        // cr�er un objet
	        Menu obj = new Menu(); 
	  
	        // d�finir la disposition du frame 
	        GridLayout grid=new GridLayout(5,1);
	        
	        frame.setLayout(grid); 
	   
	        // tableau de cha�nes contenant des langages
	        String s1[] = {"- saisir votre entreprise -  ", "EDF", "Apple", "Microsoft", "Windows", "Samsung" }; 
	      
	        // cr�er une case � cocher
	        combobox = new JComboBox(s1); 

		     combobox.setSelectedIndex(0); // aucune s�lection par d�faut
	        // ajouter ItemListener
	        combobox.addItemListener(obj); 
	  
	      
	        
	        
	        // cr�er des �tiquettes
	        l1 = new JLabel("Bienvenue sur Ja-Virtual\n"); 
	    
	  
	        
	        JButton btn = new JButton("Annuler");
	        btn.setBounds(80,190,100,40);
	        JButton btn2 = new JButton("Valider");
	        btn2.setBounds(220,190,100,40);
	        JButton btn3 = new JButton("Mairie");
	        btn3.setBounds(150,250,100,40);
	        btn3.setBackground(Color.green); 
	        // cr�er un nouveau panneau
	        JPanel p = new JPanel(); 

	        // ajouter le panneau et les boutons au frame
	    //    frame.add(p);    
	        p.add(btn);
	        p.add(btn2);
	        
	       // d�finir la taille du frame 
	        frame.setPreferredSize(new Dimension(650, 850));
	        // frame.setSize(900,700);
	        
	        //defining the properties of the frame
	 	    frame.add(l1);
	        frame.add(combobox); 
	        frame.add(p);
	        frame.add(btn3);
	         frame.setResizable(false);
	        frame.setLocationRelativeTo(null);
	        frame.setLayout(null);
	        frame.setVisible(true);
	    } 
	    public void itemStateChanged(ItemEvent e) 
	    { 
	        // si l'�tat du combobox est modifi�e 
	        if (e.getSource() == combobox) { 
	  
	         //   l2.setText(" ["+combobox.getSelectedItem()+"]"); 
	        } 
	    } 
	 
}