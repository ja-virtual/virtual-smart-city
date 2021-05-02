package edu.ing1.pds.vsc.client.analyzeIndicatorsManagement;



import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import edu.ing1.pds.vsc.client.analyzeIndicatorsManagement.AnalyserDao;
import edu.ing1.pds.vsc.client.analyzeIndicatorsManagement.AnalyserDaoImpl;

public class Mairie extends JFrame {

    private AnalyserDao analyserDao = new AnalyserDaoImpl();


    private static final String LOGO_ICON_PATH = "C:\\\\Users\\\\compt\\\\eclipse-workspace\\\\projet\\\\src\\\\projet\\\\logo.png";
    private static final String ANALYSER_LES_INDICATEURS = "Analyser les indicateurs";
    private JPanel right = new JPanel();
    private JPanel left = new JPanel(new GridLayout(5, 1));
    Color color = new Color(190, 245, 116);
    JTable table;

    // L'en-tête de Jtable
    String titre[] = { "Indicateurs", "Taux", "Tables" };

    // Les valeurs de Jtable

    Object[][] valeurs = { { "Degré de température", "", "Lumière" }, { "Nombre de capteurs", analyserDao.getNombreCapteurs(), "capteurs" },
            { "consommation électricité", "", "Lumière" }, { "nombre d'équipements", analyserDao.getNombreServices(), "équipements" },
            { "occupation de workspace", "", "workspace" } };

    DefaultTableModel tabModel;

    private void Interface() {
        setLayout(new BorderLayout());

        // Left menu creation

        left.setMinimumSize(new Dimension(250, 480));
        left.setPreferredSize(new Dimension(250, 480));
        left.setMaximumSize(new Dimension(250, 480));

        JPanel p = new JPanel();
        JLabel image = new JLabel();

        JLabel phrase_acceuil = new JLabel("Bienvenue Mairie");
        phrase_acceuil.setFont(new Font("Serif", Font.BOLD, 13));
        p.add(image);
        p.add(phrase_acceuil);
        p.setBackground(color);
        left.add(p);
        p = new JPanel(new GridLayout());
        image = new JLabel();
        ImageIcon 	img = new ImageIcon("C:\\Users\\compt\\eclipse-workspace\\projet\\src\\projet\\home.png");
        image.setIcon(new ImageIcon(img.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH)));

        JLabel use_case = new JLabel("Accueil");
        p.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // t.setVisible(true);
                dispose();
            }
        });
        p.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                e.getComponent().setBackground(Color.white);
            }

            public void mouseExited(MouseEvent e) {
                e.getComponent().setBackground(color);
            }
        });
        use_case.setFont(new Font("Serif", Font.BOLD, 15));
        p.add(image, BorderLayout.WEST);
        p.add(use_case, BorderLayout.CENTER);
        p.setBackground(color);
        left.add(p);
        p.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // t.setVisible(true);
                dispose();
            }
        });
        p.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                e.getComponent().setBackground(Color.white);
            }

            public void mouseExited(MouseEvent e) {
                e.getComponent().setBackground(color);
            }
        });

        p = new JPanel(new BorderLayout());

        image = new JLabel();


        use_case = new JLabel(ANALYSER_LES_INDICATEURS);
        use_case.setFont(new Font("Serif", Font.BOLD, 15));
        p.add(image, BorderLayout.WEST);
        p.add(use_case, BorderLayout.CENTER);
        p.setBackground(color);
        left.add(p);
        p.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                dispose();
            }
        });
        p.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                e.getComponent().setBackground(Color.white);
            }

            public void mouseExited(MouseEvent e) {
                e.getComponent().setBackground(color);
            }
        });

        p = new JPanel(new BorderLayout());
        image = new JLabel();
        img = new ImageIcon(LOGO_ICON_PATH);
        image.setIcon(new ImageIcon(img.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH)));

        use_case = new JLabel("");
        use_case.setFont(new Font("Serif", Font.BOLD, 15));
        p.add(image, BorderLayout.WEST);
        p.add(use_case, BorderLayout.CENTER);
        p.setBackground(color);
        left.add(p);
        p.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                dispose();
            }
        });
        p.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                e.getComponent().setBackground(Color.white);
            }

            public void mouseExited(MouseEvent e) {
                e.getComponent().setBackground(color);
            }
        });

        p = new JPanel(new BorderLayout());
        image = new JLabel();


        use_case = new JLabel("Quitter");
        use_case.setFont(new Font("Serif", Font.BOLD, 15));
        image = new JLabel();
        img = new ImageIcon("C:\\\\Users\\\\compt\\\\eclipse-workspace\\\\projet\\\\src\\\\projet\\\\f.png");
        image.setIcon(new ImageIcon(img.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH)));

        p.add(image, BorderLayout.WEST);
        p.add(use_case, BorderLayout.CENTER);
        p.setBackground(color);
        left.setBackground(color);
        left.add(p);

        p.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                dispose();
            }

        });
        p.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                e.getComponent().setBackground(Color.white);
            }

            public void mouseExited(MouseEvent e) {
                e.getComponent().setBackground(color);
            }
        });

        // creation of the right menu
        right.setBackground(Color.white);
        right.setLayout(new BorderLayout());

        table = new JTable();

        // modifier le modèle du composant
        TableModel tableModel = new DefaultTableModel(valeurs, titre) {
            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }
        };
        table.setModel(tableModel);
        // Ajouter le composant dans un JScrollPane
        JScrollPane jsp = new JScrollPane(table);
        // Ajouter le JScrollPane dans le JFrame
        right.add(jsp, BorderLayout.CENTER);

        JLabel phrase_acceuill = new JLabel("Bienvenue Mairie");

        this.getContentPane().add(left, BorderLayout.WEST);
        this.getContentPane().add(right, BorderLayout.CENTER);

        setSize(new Dimension(950, 780));
        setLocationRelativeTo(null);
        setResizable(false);

    }

    public Mairie() {
        Interface();
        JLabel Title = new JLabel(ANALYSER_LES_INDICATEURS);
        Title.setFont(new Font("Serif", Font.BOLD, 45));
        Title.setHorizontalAlignment(JLabel.CENTER);
        JPanel p3 = new JPanel(new BorderLayout());
        p3.add(Title, BorderLayout.NORTH);
        TableCellRenderer tableRenderer;

        p3.setBackground(Color.white);
        right.add(p3, BorderLayout.NORTH);

        setVisible(true);
        // exit
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        new Mairie();

    }

}