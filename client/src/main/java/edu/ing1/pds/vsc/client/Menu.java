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
	        // créer un nouveau frame 
	        frame = new JFrame("frame"); 
	     //   ImageIcon icone = new ImageIcon("logo-ja-virtual.png");
	        BufferedImage img = ImageIO.read(new File("logo-ja-virtual.png"));
	        JLabel pic = new JLabel(new ImageIcon(img));
	        frame.add(pic);
	        // créer un objet
	        Menu obj = new Menu(); 
	  
	        // définir la disposition du frame 
	        frame.setLayout(new FlowLayout()); 
	  
	        // tableau de chaînes contenant des langages
	        String s1[] = {"- saisir votre entreprise - : ", "EDF", "Apple", "Microsoft", "Windows", "Samsung" }; 
	      
	        // créer une case à cocher
	        combobox = new JComboBox(s1); 

		     combobox.setSelectedIndex(0); // aucune sélection par défaut
	        // ajouter ItemListener
	        combobox.addItemListener(obj); 
	  
	      
	        
	        
	        // créer des étiquettes
	        l1 = new JLabel("Bienvenue sur Ja-Virtual\n"); 
	    
	  
	        
	        JButton btn = new JButton("Annuler");
	        btn.setBounds(80,190,100,40);
	        JButton btn2 = new JButton("Valider");
	        btn2.setBounds(220,190,100,40);
	        JButton btn3 = new JButton("Mairie");
	        btn3.setBounds(150,250,100,40);
	        btn3.setBackground(Color.green); 
	        // créer un nouveau panneau
	        JPanel p = new JPanel(); 

	        // ajouter combobox et labels au panneau
	        p.add(l1);
	        p.add(combobox); 
	     

	        // ajouter le panneau au frame
	        frame.add(p); 

	        // définir la taille du frame 
	        frame.setSize(400, 200); 

	        frame.show(); 
	        
	        
	        frame.add(btn);
	        frame.add(btn2);
	        frame.add(btn3);
	      // frame.setSize(900,700);
	        frame.setPreferredSize(new Dimension(650, 850));
	        
	        frame.setResizable(false);
	        frame.setLocationRelativeTo(null);
	        frame.setLayout(null);
	        frame.setVisible(true);
	    } 
	    public void itemStateChanged(ItemEvent e) 
	    { 
	        // si l'état du combobox est modifiée 
	        if (e.getSource() == combobox) { 
	  
	         //   l2.setText(" ["+combobox.getSelectedItem()+"]"); 
	        } 
	    } 
	 
}