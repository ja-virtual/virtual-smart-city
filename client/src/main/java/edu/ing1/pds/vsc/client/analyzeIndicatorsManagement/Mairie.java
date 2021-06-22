package edu.ing1.pds.vsc.client.analyzeIndicatorsManagement;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;


import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.General_Services;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mairie extends JFrame {



	// private AnalyserDao analyserDao = new AnalyserDaoImpl();

	private static final String LOGO_ICON_PATH = "C:\\Users\\compt\\eclipse-workspace\\projet\\src\\\\projet\\\\logo.png";
	private static final String ANALYSER_LES_INDICATEURS = "Analyser les indicateurs";
	private JPanel right = new JPanel();
	private JPanel left = new JPanel(new GridLayout(5, 1));

	Color color = new Color(190, 245, 116);
	private JPanel center = new JPanel();
	private Double nbCapteur;
	private Double dgrTemp;
	private Double occupWs;
	private Double elec;
	private Double nbEq;

	JTable table;

	

	// header of Jtable
	String title[] = { "Indicateurs", "Taux" };

	// values of Jtable

	DefaultTableModel tabModel;

	private void Interface() {
		setLayout(new BorderLayout());

		// Left menu creation

		left.setMinimumSize(new Dimension(250, 480));
		left.setPreferredSize(new Dimension(250, 480));
		left.setMaximumSize(new Dimension(250, 480));

		// setLocationRelativeTo(this.getParent());
//test
		center.setBackground(Color.white);
		center.setLayout(new BorderLayout());

		this.getContentPane().add(center, BorderLayout.CENTER);
		//

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
		ImageIcon img = new ImageIcon("C:\\Users\\compt\\eclipse-workspace\\projet\\src\\projet\\home.png");
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

		// modifier le modÃ¨le du composant
		TableModel tableModel = new DefaultTableModel(null, title) {
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
		JLabel espace = new JLabel("                           ");
		Title.setFont(new Font("Serif", Font.BOLD, 45));
		Title.setHorizontalAlignment(JLabel.CENTER);
		
		JComboBox myCompany = new JComboBox();

		myCompany.addItem(" Saisir le nom de votre entreprise.....");
		for (Map n : company_names) {
			myCompany.addItem(n.get("company_name"));
		}
		myCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cn = (JComboBox) e.getSource();
				String company_name = (String) cn.getSelectedItem();
				Boolean contains = false;
				for (Map n : company_names) {
					if (n.get("company_name").equals(company_name)) {
						my_company = new General_Services((Integer) n.get("id_generalservices"), company_name);
						contains =  true;
						break;
					}
				}
				if(!contains) {
					my_company = new General_Services(0, "");
					TableModel tableModel = new DefaultTableModel(null, title) {
						@Override
						public boolean isCellEditable(int row, int column) {

							return false;
						}
					};
					table.setModel(tableModel);
				}else
				calculer();
			}
		});
		myCompany.getEditor().getEditorComponent().setBackground(Color.white);
		myCompany.setFont(new Font("Serif", Font.ITALIC, 16));
		myCompany.setBackground(Color.white);
		
		
		JPanel p3 = new JPanel(new BorderLayout());
		JPanel p4 = new JPanel(new BorderLayout());
		p3.add(Title, BorderLayout.NORTH);
		p4.add(myCompany, BorderLayout.NORTH);
		p4.add(espace, BorderLayout.SOUTH);
		p3.add(p4, BorderLayout.SOUTH);
		TableCellRenderer tableRenderer;

		p3.setBackground(Color.white);
		right.add(p3, BorderLayout.NORTH);

		setVisible(true);
		// exit
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// list

	ClientToServer connection = new ClientToServer();
	ArrayList<Map> company_names = General_Services.All_GeneralServices(connection);
	General_Services my_company = new General_Services(1, " Saisir le nom de votre entreprise.....");
//
//	{
//		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//		setTitle("Ja-Virtual app");
//		setSize(new Dimension(450, 450));
//		setLocationRelativeTo(null);
//		setLayout(new GridBagLayout());
//
//		
//
//		this.setVisible(true);
//		GridBagConstraints c = new GridBagConstraints();
//		c.insets = new Insets(30, 5, 30, 5);
//
//		c.ipadx = 1;
//		c.ipady = 5;
//		c.gridx = 0;// set the x location of the grid for the next component
//		c.gridy = 0;// set the y location of the grid for the next component
//
//		c.ipadx = 10;
//		c.ipady = 10;
//		c.gridx = 1;// set the x location of the grid for the next component
//
//		c.anchor = GridBagConstraints.CENTER;
//
//		c.gridy = 30;// change the y location
//		c.ipadx = 30;
//		c.ipady = 30;
//
//		c.gridy = 6;// change the y location
//
//		c.ipadx = 45;
//		c.ipady = 5;
//
//		c.gridy = 40;// change the y location
//
//		c.gridy = 8;// change the y location
//		c.ipadx = 15;
//		c.ipady = 5;
//
//		
//
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//		setResizable(false);
//		setVisible(true);
//
//	}
	// end

	public static void main(String[] args) {

		new Mairie();

	}

	private void calculer() {
		
		AnalyserDao analyserDao = new AnalyserDaoImpl();
		dgrTemp = analyserDao.degre(connection, my_company.getId_generalservices());
		nbCapteur = analyserDao.nbConsur(connection, my_company.getId_generalservices());
		elec = analyserDao.level(connection, my_company.getId_generalservices());
		nbEq = analyserDao.nbreEquipment(connection, my_company.getId_generalservices());
		occupWs = analyserDao.nbreWorkspaceAvailable(connection, my_company.getId_generalservices());

		Object[][] valeurs = { { "Degre de temperature", dgrTemp }, { "Nombre de capteurs", nbCapteur },
				{ "consommation electricite", elec }, { "nombre d'equipements", nbEq },
				{ "occupation de workspace", occupWs } };

		TableModel tableModel = new DefaultTableModel(valeurs, title) {
			@Override
			public boolean isCellEditable(int row, int column) {

				return false;
			}
		};
		table.setModel(tableModel);
	}
	/*
	 * ArrayList<Map> cc = AnalyserDaoImpl.All_NombreCapteurs(connection); for (Map
	 * n:cc) { my_company.addItem(n.get("id_sensor"));
	 * 
	 * }
	 */



}
