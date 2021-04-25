package edu.ing1.pds.vsc.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class InfoMapping extends JFrame {

    private JPanel left_menu=new JPanel();
    JPanel left = new JPanel(new GridLayout(5,1));
    private void Interface()
    {
        setLayout(new BorderLayout());

        //Left menu creation

        left.setMinimumSize(new Dimension(250, 480));
        left.setPreferredSize(new Dimension(250, 480));
        left.setMaximumSize(new Dimension(250, 480));

        JPanel p=new JPanel();
        JLabel image = new JLabel();
        ImageIcon  img= new ImageIcon("C:\\Users\\elori\\Downloads\\logo_ja_virtual.png");
        image.setIcon( new ImageIcon(img.getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH)));


        JLabel phrase_acceuil = new JLabel("Bienvenue sur Ja-Virtual");
        phrase_acceuil.setFont(new Font("Serif", Font.BOLD, 13));
        p.add(image);
        p.add(phrase_acceuil);
        Color color=new Color(190,245,116);
        p.setBackground(color);
        left.add(p);
        p=new JPanel();
        image = new JLabel();
        img= new ImageIcon("C:\\Users\\elori\\Downloads\\use_case_icon.png");
        image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));


        JLabel use_case = new JLabel("Fonctionnalité 1");
        use_case.setFont(new Font("Serif", Font.BOLD, 15));
        p.add(image);
        p.add(use_case);
        p.setBackground(color);
        left.add(p);


        image = new JLabel();
        img= new ImageIcon("C:\\Users\\elori\\Downloads\\use_case_icon.png");
        image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));

        use_case = new JLabel("Fonctionnalité 2");
        use_case.setFont(new Font("Serif", Font.BOLD, 15));
        p.add(image);
        p.add(use_case);
        p.setBackground(color);
        left.add(p);

        p=new JPanel();
        image = new JLabel();
        img= new ImageIcon("C:\\Users\\elori\\Downloads\\use_case_icon.png");
        image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));


        use_case = new JLabel("Mappage Cap/Equ");
        use_case.setFont(new Font("Serif", Font.BOLD, 15));
        p.add(image);
        p.add(use_case);
        p.setBackground(color);
        left.add(p);
        image = new JLabel();
        img= new ImageIcon("C:\\Users\\elori\\Downloads\\use_case_icon.png");
        image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));

        use_case = new JLabel("Fonctionnalité 4");
        use_case.setFont(new Font("Serif", Font.BOLD, 15));
        p.add(image);
        p.add(use_case);
        p.setBackground(color);
        left.add(p);

        //creation of the right menu
        left_menu.setBackground(Color.white);
        left_menu.setLayout(new BorderLayout());

        JMenuBar menuBar=new JMenuBar();

        menuBar.setBorderPainted(isDoubleBuffered());
        menuBar.setSize(750,45);
        JMenu list=new JMenu("Liste des elements a�mapper");
        list.setSize(750,45);
        JMenu plan=new JMenu("Plan");
        plan.addMenuListener((MenuListener) new MenuListener() {

            public void menuSelected(MenuEvent e) {

                ListSensorEquip menuItem1=new ListSensorEquip("test");
                dispose();
            }


            @Override
            public void menuDeselected(MenuEvent e) {
                //nothing to code

            }

            @Override
            public void menuCanceled(MenuEvent e) {
                //nothing to code

            }
        });
        plan.setSize(150,45);
        JMenuItem ListSensorEquip=new JMenuItem("Liste des capteurs a mapper");
        JMenuItem list_equipment=new JMenuItem("Liste des Equipements a  mapper");
        ListSensorEquip.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent ev) {

                ListSensorEquip menuItem1=new ListSensorEquip("Sensor");
                dispose();
            }
        });

        list_equipment.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent ev) {

                ListSensorEquip menuItem2=new ListSensorEquip("Equipment");
                dispose();
            }
        });
        menuBar.add(list);
        menuBar.add(plan);
        list.add(ListSensorEquip);
        list.add(list_equipment);
        left_menu.add(menuBar, BorderLayout.NORTH);

        this.getContentPane().add(left,BorderLayout.WEST);
        this.getContentPane().add(left_menu,BorderLayout.CENTER);
        left.setBackground(color);

        setSize(new Dimension(950,780));
        setLocationRelativeTo(null);
        setResizable(false);

    }
    public InfoMapping()
    {

        Interface();
        JLabel info_position=new JLabel("Information Mappage");
        info_position.setFont(new Font("Serif", Font.BOLD, 45));
        GridLayout layout=new GridLayout(4,1,1,1);

        JPanel p3=new JPanel(layout);
        info_position.setHorizontalAlignment(JLabel.CENTER);
        JPanel 	p_inter=new JPanel();
        JButton b1=new JButton("Positionner sur le Plan");
        b1.setPreferredSize(new Dimension(250,50));
        p_inter.setBackground(Color.white);
        p_inter.setPreferredSize(new Dimension(250,10));
        p_inter.add(info_position,BorderLayout.CENTER);
        p_inter.add(b1);
        p3.add(p_inter);

        //the fields
        p_inter=new JPanel(new GridLayout(5,1,25,10));

        //Local Business Field
        JLabel label=new JLabel("Espace loue concerne");
        Border border = label.getBorder();
        Border margin = new EmptyBorder(30,30,30,30);
        label.setBorder(new CompoundBorder(border, margin));
        JTextField textField=new JTextField();
        textField.setPreferredSize(new Dimension(50,30));
        textField.setEditable(false);
        p_inter.setBackground(Color.white);
        p_inter.add(label);
        p_inter.add(textField);



        //the floor field
        label=new JLabel("Etage concerne");
        border = label.getBorder();
        margin = new EmptyBorder(30,30,30,30);
        label.setBorder(new CompoundBorder(border, margin));
        textField=new JTextField();
        textField.setPreferredSize(new Dimension(50,30));
        textField.setEditable(false);
        p_inter.setBackground(Color.white);
        p_inter.add(label);
        p_inter.add(textField);


        //workspace field
        label=new JLabel("Espace de travail concerne");
        border = label.getBorder();
        margin = new EmptyBorder(30,30,30,30);
        label.setBorder(new CompoundBorder(border, margin));
        textField=new JTextField();
        textField.setPreferredSize(new Dimension(50,30));
        textField.setEditable(false);
        p_inter.setBackground(Color.white);
        p_inter.add(label);
        p_inter.add(textField);
        p3.add(p_inter);
        left_menu.add(p3,BorderLayout.CENTER);


        //longitude field
        label=new JLabel("Longitude");
        border = label.getBorder();
        margin = new EmptyBorder(30,30,30,30);
        label.setBorder(new CompoundBorder(border, margin));
        textField=new JTextField();
        textField.setPreferredSize(new Dimension(50,30));
        textField.setEditable(false);
        p_inter.setBackground(Color.white);
        p_inter.add(label);
        p_inter.add(textField);

        //latitude field
        label=new JLabel("latitude");
        border = label.getBorder();
        margin = new EmptyBorder(30,30,30,30);
        label.setBorder(new CompoundBorder(border, margin));
        textField=new JTextField();
        textField.setPreferredSize(new Dimension(50,30));
        textField.setEditable(false);
        p_inter.setBackground(Color.white);
        p_inter.add(label);
        p_inter.add(textField);


        //mapping button
        p_inter=new JPanel();
        b1=new JButton("Mapper");
        b1.setPreferredSize(new Dimension(250,50));
        p_inter.setBackground(Color.white);
        p_inter.add(b1);
        p3.add(p_inter);
        left_menu.add(p3,BorderLayout.CENTER);
        p3.setBackground(Color.white);
        setVisible(true);
    }
    public static void main(String[] args) {
        new InfoMapping();
    }

}
