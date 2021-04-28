package edu.ing1.pds.vsc.client.MappingManagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import edu.ing1.pds.vsc.client.HomePage;




public class InfoMapping extends JFrame {

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
                HomePage t = new HomePage();
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
                HomePage t = new HomePage();
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
                HomePage t = new HomePage();
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
                HomePage t = new HomePage();
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
                HomePage t = new HomePage();
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

                try {
                    Map_Full map=new Map_Full();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
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
        right.add(p3,BorderLayout.CENTER);


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
        b1.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                Connect_Server b=new Connect_Server();
                Object b1=b.allBuilding();
                if(b1!=null)
                {Building btest=(Building)b1;
                    System.out.println("well done"+btest.getId_building());
                }
                else
                    System.out.println("null result");

            }

        });        p_inter.setBackground(Color.white);
        p_inter.add(b1);
        p3.add(p_inter);
        right.add(p3,BorderLayout.CENTER);
        p3.setBackground(Color.white);
        setVisible(true);
    }
    public static void main(String[] args) {
        new InfoMapping();
    }

}
