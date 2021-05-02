package edu.ing1.pds.vsc.client.accessCardManagement.AccessCardServiceIHM;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class AccessCardForm extends JFrame implements ActionListener{

    public  JLabel image;
    public JPanel header;
    public Color color;
    public JLabel welcome_phrase;
    public JPanel criterias;
    public JTextField criteria1;
    public JTextField criteria2;
    public JTextField criteria3;
    public JComboBox criteria4;
    public JTextField criteria5;
    public JTextField criteria6;
    public JTextField criteria7;
    public JButton validate;
    public String registation_nbr;
    public String department;
    public String manager;
    public String it_locals;
    public String server_locals;
    public String equipment_locals;
    public String electrical_locals;



    public AccessCardForm()
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


        JLabel welcome_phrase = new JLabel("Creation de badge --- Informations Utilisateur");

        this.welcome_phrase = welcome_phrase;
        welcome_phrase.setFont(new Font("Serif", Font.BOLD, 20));
        welcome_phrase.setPreferredSize(new Dimension(80,80));
        welcome_phrase.setBackground(color);
        header.add(welcome_phrase);
        header.setBackground(color);


        JPanel criterias = new JPanel(new GridLayout(4,2));
        this.criterias = criterias;

        JPanel p = new JPanel();
        JLabel label_1 = new JLabel("Matricule");
        label_1.setPreferredSize(new Dimension(60,40));
        criterias.setBackground(color);

        JTextField criteria_1 = new JTextField();
        this.criteria1 =criteria_1;
        criteria_1.addActionListener(this);
        criteria_1.setText("entrez le matricule du salarie");
        criteria_1.setColumns(20);
        criteria_1.setPreferredSize(new Dimension(60,40));
        p.setBackground(color);
        p.add(label_1);
        p.add(criteria_1);
        criterias.add(p);


        p=new JPanel();
        label_1 = new JLabel("Departement de travail");
        label_1.setPreferredSize(new Dimension(150,40));

        JTextField criteria_2 = new JTextField();
        this.criteria2 =criteria_2;
        criteria_2.addActionListener(this);
        criteria_2.setText("Departement de travail");
        criteria_2.setColumns(20);
        criteria_2.setPreferredSize(new Dimension(60,40));
        p.setBackground(color);
        p.add(label_1);
        p.add(criteria_2);
        criterias.add(p);

        p=new JPanel();
        label_1 = new JLabel("Manager");
        label_1.setPreferredSize(new Dimension(80,40));

        JTextField criteria_3 = new JTextField();
        this.criteria3 = criteria_3;
        criteria_3.addActionListener(this);
        criteria_3.setText("entrez le nom du manager");
        criteria_3.setColumns(20);
        criteria_3.setPreferredSize(new Dimension(60,40));
        p.setBackground(color);
        p.add(label_1);
        p.add(criteria_3);
        criterias.add(p);

        p = new JPanel();
        label_1 = new JLabel("Utilisation des locaux informatiques");
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
        label_1 = new JLabel("Habilitation pour le local serveur");
        label_1.setPreferredSize(new Dimension(200,40));

        JTextField criteria_5 = new JTextField();
        //System.out.println(criteria_5 == null);
        this.criteria5 = criteria_5;
        criteria_5.addActionListener(this);
        criteria_5.setText("Entrez le numero de certificat");
        criteria_5.setColumns(20);
        criteria_5.setPreferredSize(new Dimension(80,40));
        p.setBackground(color);
        p.add(label_1);
        p.add(criteria_5);
        criterias.add(p);

        p=new JPanel();
        label_1 = new JLabel("Utilisation des equipements");
        label_1.setPreferredSize(new Dimension(165,40));

        JTextField criteria_6= new JTextField();
        this.criteria6 = criteria_6;
        criteria_6.addActionListener(this);
        criteria_6.setText("Si oui, qui sont");
        criteria_6.setColumns(20);
        criteria_6.setPreferredSize(new Dimension(100,40));
        p.setBackground(color);
        p.add(label_1);
        p.add(criteria_6);
        criterias.add(p);

        p=new JPanel();
        label_1 = new JLabel("Utilisation des locaux electrique");
        label_1.setPreferredSize(new Dimension(200,40));

        JTextField criteria_7 = new JTextField();
        this.criteria7 = criteria_7;
        criteria_7.addActionListener(this);
        criteria_7.setText("Entrez le numero de certificatn");
        criteria_7.setColumns(20);
        criteria_7.setPreferredSize(new Dimension(80,40));
        p.setBackground(color);
        p.add(label_1);
        p.add(criteria_7);
        criterias.add(p);


        p=new JPanel();
        JButton validate= new JButton("Valider & Continuer");
        this.validate = validate;
        validate.addActionListener(this);
        validate.setPreferredSize(new Dimension(150,40));
        p.setBackground(color);
        p.add(validate, BorderLayout.CENTER);


        this.add(header, BorderLayout.NORTH);
        this.add(criterias, BorderLayout.CENTER);
        this.add(p, BorderLayout.SOUTH);


        criteria_1.setEditable(true);
        criteria_1.setFont(new Font("Serif", Font.ITALIC, 16));
        criteria_1.setBackground(Color.white);


        criteria_2.setEditable(true);
        criteria_2.setFont(new Font("Serif", Font.ITALIC, 16));
        criteria_2.setBackground(Color.white);


        criteria_3.setEditable(true);
        criteria_3.setFont(new Font("Serif", Font.ITALIC, 16));
        criteria_3.setBackground(Color.white);


        criteria_4.setEditable(true);
        criteria_4.getEditor().getEditorComponent().setBackground(Color.white);
        criteria_4.setFont(new Font("Serif", Font.ITALIC, 16));
        criteria_4.setBackground(Color.white);


        criteria_5.setEditable(true);
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
            registation_nbr = criteria1.getText();
            department = criteria2.getText();
            manager = criteria3.getText();
            it_locals = criteria4.getSelectedItem().toString();
            server_locals = criteria5.getText();
            equipment_locals = criteria6.getText();
            electrical_locals = criteria7.getText();
            System.out.println(registation_nbr);
            System.out.println(department);
            System.out.println(manager);
            System.out.println(it_locals);
            System.out.println(server_locals);
            System.out.println(equipment_locals);
            System.out.println(electrical_locals);
        }
    }


    public static void main(String[] args) {
        //TODO Auto-generated method stub
        AccessCardForm form = new AccessCardForm();
        //System.out.print(location1.direction);
    }
}