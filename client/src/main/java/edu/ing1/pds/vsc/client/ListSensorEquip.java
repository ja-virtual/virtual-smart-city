

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

public class ListSensorEquip extends JFrame {

    private JPanel right=new JPanel();
    private JPanel left = new JPanel(new GridLayout(5,1));
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


        JLabel use_case = new JLabel("Fonctionnalité 1");
        p.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                test t = new test();
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
                test t = new test();
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


        p=new JPanel(new BorderLayout());

        image = new JLabel();
        img= new ImageIcon("C:\\Users\\elori\\Downloads\\use_case_icon.png");
        image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));

        use_case = new JLabel("Fonctionnalité 2");
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
                test t = new test();
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

        p=new JPanel(new BorderLayout());
        image = new JLabel();
        img= new ImageIcon("C:\\Users\\elori\\Downloads\\use_case_icon.png");
        image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));

        use_case = new JLabel("Mappage Cap/Equ");
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
                test t = new test();
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

        p=new JPanel(new BorderLayout());
        image = new JLabel();
        img= new ImageIcon("C:\\Users\\elori\\Downloads\\use_case_icon.png");
        image.setIcon( new ImageIcon(img.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH)));


        use_case = new JLabel("Fonctionnalité 4");
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
                test t = new test();
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
        JMenu list=new JMenu("Liste des éléments à mapper");
        list.setSize(750,45);
        JMenu plan=new JMenu("Plan");
        plan.addMenuListener((MenuListener) new MenuListener() {

            public void menuSelected(MenuEvent e) {

                ListSensorEquip menuItem1=new ListSensorEquip("Mapper");
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
        JMenuItem list_sensor=new JMenuItem("Liste des capteurs à mapper");
        JMenuItem list_equipment=new JMenuItem("Liste des équipements à mapper");
        list_sensor.addActionListener((ActionListener) new ActionListener() {
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
        list.add(list_sensor);
        list.add(list_equipment);
        right.add(menuBar, BorderLayout.NORTH);

        this.getContentPane().add(left,BorderLayout.WEST);
        this.getContentPane().add(right,BorderLayout.CENTER);
        left.setBackground(color);

        setSize(new Dimension(950,780));
        setLocationRelativeTo(null);
        setResizable(false);

    }
    public ListSensorEquip(String type_element)
    {
        Interface();
        JLabel Title=new JLabel(type_element);
        Title.setFont(new Font("Serif", Font.BOLD, 45));
        Title.setHorizontalAlignment(JLabel.CENTER);
        JPanel p3=new JPanel(new BorderLayout());
        p3.add(Title,BorderLayout.NORTH);
        TableCellRenderer tableRenderer;
        JTable table = new JTable(new JTableButtonModel(type_element));
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
        p3.add(scrollPane,BorderLayout.CENTER);
        p3.setBackground(Color.white);
        right.add(p3);


        setVisible(true);
    }
    public static void main(String[] args) {
        new ListSensorEquip("Sensor");

    }

    class JTableButtonRenderer implements TableCellRenderer {
        private TableCellRenderer defaultRenderer;
        public JTableButtonRenderer(TableCellRenderer renderer) {
            defaultRenderer = renderer;
        }
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if(value instanceof Component)
                return (Component)value;
            return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
    class JTableButtonModel extends AbstractTableModel {

        private Vector<Vector<Object>> data = new  Vector<Vector<Object>>();

        private String[] columns=new String[3];
        public JTableButtonModel(String type)
        {
            if(type=="Sensor")
            {
                try {
                    Class.forName("org.postgresql.Driver");

                    Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestHajar","postgres","admin");
                    ResultSet rs = con.createStatement().executeQuery("SELECT * FROM personne");
                    Vector<Object> row = new Vector<Object>();
                    columns[0]=" ID Capteur";
                    columns[1]=" Date de fournissement";
                    columns[2]=" ";
                    while(rs.next()) {


                        row.add(rs.getString("nom"));
                        row.add(rs.getInt("age"));
                        row.add(new JButton("Mapper"));

                        data.add(row);
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            else
            {
                columns[0]=" ID Equipement";
                columns[1]=" Date de fournissement";
                columns[2]=" ";
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

