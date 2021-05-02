package edu.ing1.pds.vsc.client.accessCardManagement.AccessCardServiceIHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class AccessCardStatus extends JFrame {

    private JPanel right = new JPanel();
    JPanel left = new JPanel(new GridLayout(5, 1));
    Color color = new Color(190, 245, 116);

    public AccessCardStatus() {

        setLayout(new BorderLayout());

        //Left menu creation

        left.setMinimumSize(new Dimension(250, 480));
        left.setPreferredSize(new Dimension(250, 480));
        left.setMaximumSize(new Dimension(250, 480));

        JPanel p = new JPanel();
        JLabel image = new JLabel();
        ImageIcon img = new ImageIcon("C:\\Users\\mtsad\\Downloads\\logo_ja_virtual.png");
        image.setIcon(new ImageIcon(img.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        JLabel phrase_acceuil = new JLabel("Bienvenue JUTT MILL");
        phrase_acceuil.setFont(new Font("Serif", Font.BOLD, 13));
        p.add(image);
        p.add(phrase_acceuil);
        p.setBackground(color);
        left.add(p);


        p = new JPanel();
        image = new JLabel();
        img = new ImageIcon("C:\\Users\\mtsad\\Downloads\\home.png");
        image.setIcon(new ImageIcon(img.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH)));


        JLabel use_case = new JLabel("Acceuil               ");
        use_case.setFont(new Font("Serif", Font.BOLD, 15));
        p.add(image);
        p.add(use_case);
        p.setBackground(color);
        left.add(p);


        image = new JLabel();
        img = new ImageIcon("C:\\Users\\mtsad\\Downloads\\service.png");
        image.setIcon(new ImageIcon(img.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH)));

        use_case = new JLabel("Services");
        use_case.setFont(new Font("Serif", Font.BOLD, 15));
        p.add(image);
        p.add(use_case);
        p.setBackground(color);
        left.add(p);

        p = new JPanel();
        image = new JLabel();
        img = new ImageIcon("C:\\Users\\mtsad\\Downloads\\card acess.png");
        image.setIcon(new ImageIcon(img.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH)));


        use_case = new JLabel("Gestion des acces");
        use_case.setFont(new Font("Serif", Font.BOLD, 15));
        p.add(image);
        p.add(use_case);
        p.setBackground(color);
        left.add(p);
        image = new JLabel();
        img = new ImageIcon("C:\\Users\\mtsad\\Downloads\\contact2.png");
        image.setIcon(new ImageIcon(img.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH)));

        use_case = new JLabel("Contacts");
        use_case.setFont(new Font("Serif", Font.BOLD, 15));
        p.add(image);
        p.add(use_case);
        p.setBackground(color);
        left.add(p);

        //creation of the right menu
        right.setBackground(Color.white);
        right.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();

        menuBar.setBorderPainted(isDoubleBuffered());
        menuBar.setSize(750, 45);
        JMenu list = new JMenu("Menu");
        list.setSize(750, 45);

        JMenuItem menuItem1 = new JMenuItem("Statut des badges");
        JMenuItem menuItem2 = new JMenuItem("Creer un badge");

        menuBar.add(list);
        list.add(menuItem1);
        list.add(menuItem2);
        right.add(menuBar, BorderLayout.NORTH);

        this.getContentPane().add(left, BorderLayout.WEST);
        this.getContentPane().add(right, BorderLayout.CENTER);
        left.setBackground(color);

        setSize(new Dimension(950, 780));
        setLocationRelativeTo(null);
        setResizable(false);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AccessCardStatus();

    }

}