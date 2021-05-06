package edu.ing1.pds.vsc.client.MappingManagement;



import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.General_Services;
import edu.ing1.pds.vsc.client.HomePage;
import edu.ing1.pds.vsc.client.WelcomePage;
import edu.ing1.pds.vsc.client.workspaceLocation.lolo.lolo.Loocation;

public class List_Position extends JFrame {


	private ClientToServer connection=new ClientToServer();
	private Connection con=null;
	General_Services company=null;
	private JPanel right=new JPanel(new BorderLayout());
	JPanel left = new JPanel(new GridLayout(5,1));
	Color color=new Color(190,245,116);
	ArrayList<Map>available_positions;
	
	private void myInterface()
	{
		setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//Left menu creation

		left.setMinimumSize(new Dimension(250, 480));
		left.setPreferredSize(new Dimension(250, 480));
		left.setMaximumSize(new Dimension(250, 480));

		JPanel p=new JPanel(new BorderLayout());
		JLabel image = new JLabel();
		ImageIcon  img= new ImageIcon("C:\\Users\\elori\\Downloads\\logo_ja_virtual.png");
		image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));
		image.setHorizontalAlignment(JLabel.CENTER);
		JLabel welcome_sentence = new JLabel("Bienvenue "+company.getCompany_name());
		welcome_sentence.setHorizontalAlignment(JLabel.CENTER);
		welcome_sentence.setFont(new Font("Serif", Font.ITALIC, 20));
		p.add(image,BorderLayout.NORTH);
		p.add(welcome_sentence,BorderLayout.CENTER);
		p.setBackground(color);
		left.add(p);
		p=new JPanel(new GridLayout());
		JLabel use_case1 = new JLabel("Gestion de Location");
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				try
				{
					connection.client.close();

				}
				catch(Exception e1)
				{

				}
				Loocation t = new Loocation(company);
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
		use_case1.setHorizontalAlignment(JLabel.CENTER);
		use_case1.setFont(new Font("Serif", Font.BOLD,17));
		p.add(use_case1,BorderLayout.CENTER);
		p.setBackground(color);
		left.add(p);
		p=new JPanel(new GridLayout());
		JLabel use_case2 = new JLabel("Mappage Capteur/Equipement");
		use_case2.setHorizontalAlignment(JLabel.CENTER);
		use_case2.setFont(new Font("Serif", Font.BOLD,17));;
		p.add(use_case2,BorderLayout.CENTER);
		p.setBackground(color);
		left.add(p);
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				ArrayList<Map>ws=WorkSpace.allRentedWorkSpace(connection, company.getId_generalservices());
				if(ws==null )
				{
					JOptionPane.showMessageDialog(new JFrame(),
							"Pas d'espace loué pour pouvoir utiliser cette fonctionnalité","Mappage impossible pour le moment",
							JOptionPane.ERROR_MESSAGE);
				}
				else if(ws.isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(),
							"Pas d'espace loué pour pouvoir utiliser cette fonctionnalité","Mappage impossible pour le moment",
							JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					try
					{
						connection.client.close();

					}
					catch(Exception e1)
					{

					}
					MappingUC t = new MappingUC(company);
					t.setVisible(true);
					dispose();
				}


			}});
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				e.getComponent().setBackground(Color.white);
				use_case2.setForeground(color);
			}
			public void mouseExited(MouseEvent e)
			{
				e.getComponent().setBackground(color);
				use_case2.setForeground(Color.black);
			}
		});

		p=new JPanel(new GridLayout());

		JLabel use_case3 = new JLabel("Configuration Fenetre EC");
		use_case3.setHorizontalAlignment(JLabel.CENTER);
		use_case3.setFont(new Font("Serif", Font.BOLD,17));
		p.add(use_case3,BorderLayout.CENTER);
		p.setBackground(color);
		left.add(p);
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				try
				{
					connection.client.close();

				}
				catch(Exception e1)
				{

				}
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
				use_case3.setForeground(color);
			}
			public void mouseExited(MouseEvent e)
			{
				e.getComponent().setBackground(color);
				use_case3.setForeground(Color.black);
			}
		});

		p=new JPanel(new GridLayout());
		image = new JLabel();
		img= new ImageIcon("C:\\Users\\elori\\Downloads\\use_case_icon.png");
		image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));


		JLabel use_case4 = new JLabel("Gestion Accés");
		use_case4.setHorizontalAlignment(JLabel.CENTER);
		use_case4.setFont(new Font("Serif", Font.BOLD,17));
		p.add(use_case4,BorderLayout.CENTER);
		p.setBackground(color);
		left.add(p);
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				try
				{
					connection.client.close();

				}
				catch(Exception e1)
				{

				}
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
				use_case4.setForeground(color);
			}
			public void mouseExited(MouseEvent e)
			{
				e.getComponent().setBackground(color);
				use_case4.setForeground(Color.black);
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
		list.addMenuListener(new MenuListener() {


			@Override
			public void menuSelected(MenuEvent e) {
				try
				{
					connection.client.close();

				}
				catch(Exception ex)
				{
					ex.printStackTrace();	
				}
				List_Position lp=new List_Position(company);

				dispose();
			}

			@Override
			public void menuDeselected(MenuEvent e) {
			}

			@Override
			public void menuCanceled(MenuEvent e) {

			}
		});
		JMenu map=new JMenu("Plan");
		map.addMenuListener(new MenuListener() {


			@Override
			public void menuSelected(MenuEvent e) {
				try
				{
					connection.client.close();
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
				Map_Full hp=new Map_Full(company);
				dispose();

			}

			@Override
			public void menuDeselected(MenuEvent e) {
			}

			@Override
			public void menuCanceled(MenuEvent e) {

			}
		});
		map.setSize(150,45);
		JMenu about=new JMenu("À propos");
		about.addMenuListener(new MenuListener() {


			@Override
			public void menuSelected(MenuEvent e) {
				JOptionPane.showMessageDialog(new JFrame(),
						"il existe trois types d'emplacements dans lesquelles un capteur ou un équipement peut être mappé.\nCependant chaque type conditionne le mappage mentionné et n'accepte que certains types d'objets\n"
								+ "Type 1  accepte : "+Positions.possibleMapping("type1","sensor")+" "+Positions.possibleMapping("type1","equipment")+"\n"
								+ "Type 2  accepte : "+Positions.possibleMapping("type2","sensor")+" "+Positions.possibleMapping("type2","equipment")+"\n"
								+ "Type 3  accepte : "+Positions.possibleMapping("type3","sensor")+" "+Positions.possibleMapping("type3","equipment")+"\n",
								"À propos",
								JOptionPane.PLAIN_MESSAGE);

			}

			@Override
			public void menuDeselected(MenuEvent e) {
			}

			@Override
			public void menuCanceled(MenuEvent e) {

			}
		});
		map.setSize(150,45);
		menuBar.add(list);
		menuBar.add(map);
		menuBar.add(about);
		menuBar.add(Box.createHorizontalGlue());
		JMenu homePage=new JMenu("Acceuil");
		homePage.addMenuListener(new MenuListener() {


			@Override
			public void menuSelected(MenuEvent e) {
				try
				{
					connection.client.close();
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
				WelcomePage hp=new WelcomePage(company);
				dispose();
			}

			@Override
			public void menuDeselected(MenuEvent e) {
			}

			@Override
			public void menuCanceled(MenuEvent e) {

			}
		});
		menuBar.add(homePage);
		JMenu leave=new JMenu("Quitter");
		leave.addMenuListener(new MenuListener() {


			@Override
			public void menuSelected(MenuEvent e) {
				try
				{
					connection.client.close();
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
				HomePage t = new HomePage();
				dispose();
			}

			@Override
			public void menuDeselected(MenuEvent e) {
			}

			@Override
			public void menuCanceled(MenuEvent e) {

			}
		});
		menuBar.add(leave);
		right.add(menuBar, BorderLayout.NORTH);

		this.getContentPane().add(left,BorderLayout.WEST);
		this.getContentPane().add(right,BorderLayout.CENTER);
		left.setBackground(color);

		setSize(new Dimension(950,780));
		setLocationRelativeTo(null);
		setResizable(false);

	}
	public List_Position(General_Services GS)
	{
		company=GS;
		available_positions=Positions.availablePositions(connection,0,company.getId_generalservices());
		if(available_positions==null)
		{
			JOptionPane.showMessageDialog(new JFrame(),
					" Tous vos emplacements sont mappé!",
							"Pas d'emplacement vide pour le moment",
							JOptionPane.PLAIN_MESSAGE);
		}
		else if(available_positions.isEmpty())
		{
			JOptionPane.showMessageDialog(new JFrame(),
					" Tous vos emplacements sont mappé!",
					"Pas d'emplacement vide pour le moment",
							JOptionPane.PLAIN_MESSAGE);
		}
		myInterface();
		JLabel Title=new JLabel("Liste d'emplacement");
		Title.setFont(new Font("Serif", Font.BOLD, 45));
		Title.setHorizontalAlignment(JLabel.CENTER);
		JPanel p3=new JPanel(new BorderLayout());
		p3.add(Title,BorderLayout.NORTH);
		TableCellRenderer tableRenderer;
		JTable table = new JTable(new JTableButtonModel());
		tableRenderer = table.getDefaultRenderer(JButton.class);
		table.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));


		table.setRowSelectionAllowed(false);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setRowHeight(table.getRowHeight() + 20);
		table.getTableHeader().setPreferredSize(
				new Dimension(scrollPane.WIDTH,40)
				);
		table.getTableHeader().setBackground(color);
		scrollPane.setBackground(Color.white);
		DefaultTableCellRenderer custom = new DefaultTableCellRenderer();
		custom.setHorizontalAlignment(JLabel.CENTER);
		for (int i=0 ; i<table.getColumnCount()-1 ; i++)
		{
			table.getColumnModel().getColumn(i).setCellRenderer(custom);
		}
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent event) {
				try {
					connection.client.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Map row=available_positions.get(table.getSelectedRow());
				InfoMapping im=new InfoMapping(new Positions((Integer)row.get("id_position"),(Integer)row.get("longitude"),(Integer)row.get("latitude"),(Integer)row.get("id_workspace"),(String)row.get("position_type"),(Boolean)row.get("is_available")),company);

				dispose();
			}
		});
		p3.add(scrollPane,BorderLayout.CENTER);
		p3.setBackground(Color.white);
		right.add(p3);


		setVisible(true);
	}
	public static void main(String[] args) {
		new List_Position(new General_Services(1,"Snapshat"));

	}

	class JTableButtonRenderer implements TableCellRenderer,ActionListener {
		private TableCellRenderer defaultRenderer;
		public JTableButtonRenderer(TableCellRenderer renderer) {
			defaultRenderer = renderer;
		}
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			if(value instanceof Component)
				return (Component)value;
			return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();

		}
	}
	class JTableButtonModel extends AbstractTableModel {

		private Vector<Vector<Object>> data = new  Vector<Vector<Object>>();

		private String[] columns=new String[3];
		public JTableButtonModel()
		{

			try {

				columns[0]="ID Emplacement";
				columns[1]="type d'emplacement";
				columns[2]="";
			JButton map;
				for(Map n:available_positions) {
					Vector<Object> row = new Vector<Object>();
						row.add(n.get("id_position"));
						row.add(n.get("position_type"));
						map=new JButton("Mapper");
						row.add(map);
						map.setBackground(color);
						row.add(map);
						data.add(row);	
						
					
		
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public String getColumnName(int column) {
			return columns[column];
		}
		public int getRowCount() {
			return data.size();
		}
		public int getColumnCount() {
			return columns.length;
		}
		public Object getValueAt(int row, int column) {
			return data.get(row).get(column);
		}
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		public Class getColumnClass(int column) {
			return getValueAt(0, column).getClass();
		}
	}
}

