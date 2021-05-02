package edu.ing1.pds.vsc.client.accessCardManagement.AccessCardServiceIHM;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class AccessManagement extends JFrame implements ActionListener{

    public  JLabel image;
    public JPanel header;
    public Color color;
    public JLabel welcome_phrase;
    public JPanel criterias;
    public JComboBox criteria1;
    public JComboBox criteria2;
    public JComboBox criteria3;
    public JComboBox criteria4;
    public JComboBox criteria5;
    public JTextField criteria6;
    public JTextField criteria7;
    public JButton validate;
    public String dep_access;
    public String meetingroom_access;
    public String elec_locals_access;
    public String equipment_access;
    public String server_locals_access;
    public String person_name;
    public String choice;


    public AccessManagement()
    {
        setSize(new Dimension(850,850));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Color color = new Color(255,255,255);
        this.color = color;
        getContentPane().setBackground(color);
        setResizable(true);
        setVisible(true);


        JPanel header = new JPanel(new GridLayout(1,1));
        this.header = header;
        JLabel image = new JLabel();
        this.image = image;
        ImageIcon  img= new ImageIcon("C:\\Users\\mtsad\\Downloads\\logo_ja_virtual.png");
        image.setIcon( new ImageIcon(img.getImage().getScaledInstance(90,90, Image.SCALE_SMOOTH)));
        image.setBackground(color);
        header.add(image);


        JLabel welcome_phrase = new JLabel("Creation de badge --- Gestion des acces");

        this.welcome_phrase = welcome_phrase;
        welcome_phrase.setFont(new Font("Serif", Font.BOLD, 20));
        welcome_phrase.setPreferredSize(new Dimension(80,80));
        welcome_phrase.setBackground(color);
        header.add(welcome_phrase);
        header.setBackground(color);


        JPanel criterias = new JPanel(new GridLayout(4,2));
        this.criterias = criterias;

        JPanel p = new JPanel();
        JLabel label_1 = new JLabel("Acces au departement ou service");
        label_1.setPreferredSize(new Dimension(220,40));

        JComboBox criteria_1 = new JComboBox();
        this.criteria1 = criteria_1;
        criteria_1.addActionListener(this);
        criteria_1.addItem("None" );
        criteria_1.addItem("oui" );
        criteria_1.addItem("non" );
        criteria_1.setPreferredSize(new Dimension(80,40));
        p.setBackground(color);
        p.add(label_1);
        p.add(criteria_1);
        criterias.add(p);


        p = new JPanel();
        label_1 = new JLabel("Acces aux salles de reunions");
        label_1.setPreferredSize(new Dimension(220,40));

        JComboBox criteria_2 = new JComboBox();
        this.criteria2 = criteria_2;
        criteria_2.addActionListener(this);
        criteria_2.addItem("None" );
        criteria_2.addItem("oui" );
        criteria_2.addItem("non" );
        criteria_2.setPreferredSize(new Dimension(80,40));
        p.setBackground(color);
        p.add(label_1);
        p.add(criteria_2);
        criterias.add(p);

        p = new JPanel();
        label_1 = new JLabel("Acces aux locaux electriques ");
        label_1.setPreferredSize(new Dimension(220,40));

        JComboBox criteria_3 = new JComboBox();
        this.criteria3 = criteria_3;
        criteria_3.addActionListener(this);
        criteria_3.addItem("None" );
        criteria_3.addItem("oui" );
        criteria_3.addItem("non" );
        criteria_3.setPreferredSize(new Dimension(80,40));
        p.setBackground(color);
        p.add(label_1);
        p.add(criteria_3);
        criterias.add(p);;

        p = new JPanel();
        label_1 = new JLabel("Acces aux equipement");
        label_1.setPreferredSize(new Dimension(220,40));

        JComboBox criteria_4 = new JComboBox();
        this.criteria4 = criteria_4;
        criteria_4.addActionListener(this);
        criteria_4.addItem("None" );
        criteria_4.addItem("oui" );
        criteria_4.addItem("non" );
        criteria_4.setPreferredSize(new Dimension(80,40));
        p.setBackground(color);
        p.add(label_1);
        p.add(criteria_4);
        criterias.add(p);

        p=new JPanel();
        label_1 = new JLabel("acces au local serveur");
        label_1.setPreferredSize(new Dimension(200,40));

        JComboBox criteria_5 = new JComboBox();
        this.criteria5 = criteria_5;
        criteria_5.addActionListener(this);
        criteria_5.addItem("None" );
        criteria_5.addItem("oui" );
        criteria_5.addItem("non" );
        criteria_5.setPreferredSize(new Dimension(80,40));
        p.setBackground(color);
        p.add(label_1);
        p.add(criteria_5);
        criterias.add(p);

        p=new JPanel();
        label_1 = new JLabel("la nom de la personne");
        label_1.setPreferredSize(new Dimension(165,40));

        JTextField criteria_6= new JTextField();
        this.criteria6 = criteria_6;
        criteria_6.addActionListener(this);
        criteria_6.setText("le nom de la personne");
        criteria_6.setColumns(20);
        criteria_6.setPreferredSize(new Dimension(100,40));
        p.setBackground(color);
        p.add(label_1);
        p.add(criteria_6);
        criterias.add(p);

        p=new JPanel();
        label_1 = new JLabel("choix du niveau dacces");
        label_1.setPreferredSize(new Dimension(200,40));

        JTextField criteria_7 = new JTextField();
        this.criteria7 = criteria_7;
        criteria_7.addActionListener(this);
        criteria_7.setText("Entrez le choix du niveau d'acces");
        criteria_7.setColumns(20);
        criteria_7.setPreferredSize(new Dimension(80,40));
        p.setBackground(color);
        p.add(label_1);
        p.add(criteria_7);
        criterias.add(p);


        p=new JPanel();
        JButton validate= new JButton("Terminer");
        this.validate = validate;
        validate.addActionListener(this);
        validate.setPreferredSize(new Dimension(120,40));
        p.setBackground(color);
        p.add(validate, BorderLayout.CENTER);


        this.add(header, BorderLayout.NORTH);
        this.add(criterias, BorderLayout.CENTER);
        this.add(p, BorderLayout.SOUTH);


        criteria_1.setEditable(true);
        criteria_1.getEditor().getEditorComponent().setBackground(Color.white);
        criteria_1.setFont(new Font("Serif", Font.ITALIC, 16));
        criteria_1.setBackground(Color.white);


        criteria_2.setEditable(true);
        criteria_2.getEditor().getEditorComponent().setBackground(Color.white);
        criteria_2.setFont(new Font("Serif", Font.ITALIC, 16));
        criteria_2.setBackground(Color.white);


        criteria_3.setEditable(true);
        criteria_3.getEditor().getEditorComponent().setBackground(Color.white);
        criteria_3.setFont(new Font("Serif", Font.ITALIC, 16));
        criteria_3.setBackground(Color.white);


        criteria_4.setEditable(true);
        criteria_4.getEditor().getEditorComponent().setBackground(Color.white);
        criteria_4.setFont(new Font("Serif", Font.ITALIC, 16));
        criteria_4.setBackground(Color.white);


        criteria_5.setEditable(true);
        criteria_5.getEditor().getEditorComponent().setBackground(Color.white);
        criteria_5.setFont(new Font("Serif", Font.ITALIC, 16));
        criteria_5.setBackground(Color.white);


        criteria_6.setEditable(true);
        criteria_6.setFont(new Font("Serif", Font.ITALIC, 16));
        criteria_6.setBackground(Color.white);


        criteria_7.setEditable(true);
        criteria_7.setFont(new Font("Serif", Font.ITALIC, 16));
        criteria_7.setBackground(Color.white);


        this.add(criterias);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == validate) {
            dep_access = criteria1.getSelectedItem().toString();
            meetingroom_access = criteria2.getSelectedItem().toString();
            elec_locals_access = criteria3.getSelectedItem().toString();
            equipment_access = criteria4.getSelectedItem().toString();
            server_locals_access = criteria5.getSelectedItem().toString();
            person_name = criteria6.getText();
            choice = criteria7.getText();
            System.out.println(dep_access);
            System.out.println(meetingroom_access);
            System.out.println(elec_locals_access);
            System.out.println(equipment_access);
            System.out.println(server_locals_access);
            System.out.println(person_name);
            System.out.println(choice);
        }

    }

    public static void main(String[] args) {
        //TODO Auto-generated method stub
        AccessManagement accessManagement = new AccessManagement();
        //System.out.print(location1.direction);
    }
}