package edu.ing1.pds.vsc.client;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class MappingUC extends JFrame {

    private JPanel right=new JPanel();
    JPanel left = new JPanel(new GridLayout(5,1));
    Color color=new Color(190,245,116);
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
        p.setBackground(color);
        left.add(p);
        p=new JPanel(new GridLayout());
        image = new JLabel();
        img= new ImageIcon("C:\\Users\\elori\\Downloads\\use_case_icon.png");
        image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));


        JLabel use_case = new JLabel("Fonctionnalite 1");
        p.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
               Accueil t = new Accueil();
                t.setVisible(true);
                dispose();
            }
        });
        p.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent e)
            {
                e.getComponent().setBackground(Color.white);
            }
            public void mouseExited(MouseEvent e)
            {
                e.getComponent().setBackground(color);
            }
        });
        use_case.setFont(new Font("Serif", Font.BOLD, 15));
        p.add(image,BorderLayout.WEST);
        p.add(use_case,BorderLayout.CENTER);
        p.setBackground(color);
        left.add(p);
        p.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                Accueil t = new Accueil();
                t.setVisible(true);
                dispose();
            }
        });
        p.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent e)
            {
                e.getComponent().setBackground(Color.white);
            }
            public void mouseExited(MouseEvent e)
            {
                e.getComponent().setBackground(color);
            }
        });


        p=new JPanel(new GridLayout());

        image = new JLabel();
        img= new ImageIcon("C:\\Users\\elori\\Downloads\\use_case_icon.png");
        image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));

        use_case = new JLabel("Fonctionnalite 2");
        use_case.setFont(new Font("Serif", Font.BOLD, 15));
        p.add(image,BorderLayout.WEST);
        p.add(use_case,BorderLayout.CENTER);
        p.setBackground(color);
        left.add(p);
        p.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                // you can open a new frame here as
                // i have assumed you have declared "frame" as instance variable
                Accueil t = new Accueil();
                t.setVisible(true);
                dispose();
            }
        });
        p.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent e)
            {
                e.getComponent().setBackground(Color.white);
            }
            public void mouseExited(MouseEvent e)
            {
                e.getComponent().setBackground(color);
            }
        });

        p=new JPanel(new GridLayout());
        image = new JLabel();
        img= new ImageIcon("C:\\Users\\elori\\Downloads\\use_case_icon.png");
        image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));

        use_case = new JLabel("Mappage C/E");
        use_case.setFont(new Font("Serif", Font.BOLD, 15));
        p.add(image,BorderLayout.WEST);
        p.add(use_case,BorderLayout.CENTER);
        p.setBackground(color);
        left.add(p);
        p.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                // you can open a new frame here as
                // i have assumed you have declared "frame" as instance variable
                Accueil t = new Accueil();
                t.setVisible(true);
                dispose();
            }
        });
        p.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent e)
            {
                e.getComponent().setBackground(Color.white);
            }
            public void mouseExited(MouseEvent e)
            {
                e.getComponent().setBackground(color);
            }
        });

        p=new JPanel(new GridLayout());
        image = new JLabel();
        img= new ImageIcon("C:\\Users\\elori\\Downloads\\use_case_icon.png");
        image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));


        use_case = new JLabel("Fonctionnalite 4");
        use_case.setFont(new Font("Serif", Font.BOLD, 15));
        p.add(image,BorderLayout.WEST);
        p.add(use_case,BorderLayout.CENTER);
        p.setBackground(color);
        left.add(p);
        p.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                // you can open a new frame here as
                // i have assumed you have declared "frame" as instance variable
                Accueil t = new Accueil();
                t.setVisible(true);
                dispose();
            }
        });
        p.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent e)
            {
                e.getComponent().setBackground(Color.white);
            }
            public void mouseExited(MouseEvent e)
            {
                e.getComponent().setBackground(color);
            }
        });

        //creation of the right menu
        right.setBackground(Color.white);
        right.setLayout(new BorderLayout());

        JMenuBar menuBar=new JMenuBar();

        menuBar.setBorderPainted(isDoubleBuffered());
        menuBar.setSize(750,45);
        JMenu list=new JMenu("Liste des emplacements ");
        list.setSize(750,45);
        JMenu plan=new JMenu("Plan");
        plan.addMenuListener((MenuListener) new MenuListener() {

            public void menuSelected(MenuEvent e) {

                Map_Full menuItem1=new Map_Full();
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
       list.addMenuListener((MenuListener) new MenuListener() {

            public void menuSelected(MenuEvent e) {

            	 List_Position menuItem1=new List_Position();
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
     
        menuBar.add(list);
        menuBar.add(plan);
        right.add(menuBar, BorderLayout.NORTH);

        this.getContentPane().add(left,BorderLayout.WEST);
        this.getContentPane().add(right,BorderLayout.CENTER);
        left.setBackground(color);

        setSize(new Dimension(950,780));
        setLocationRelativeTo(null);
        setResizable(false);

    }
    public MappingUC()
    {
        Interface();
        setVisible(true);
    }
    public static void main(String[] args) {
        new MappingUC();

    }

}
