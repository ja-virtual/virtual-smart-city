
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

                List_Sensor menuItem1=new List_Sensor("Test");
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

                List_Sensor menuItem1=new List_Sensor("Sensor");
                dispose();
            }
        });

        list_equipment.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent ev) {

                List_Sensor menuItem2=new List_Sensor("Equipment");
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
    public MappingUC()
    {
        Interface();
        setVisible(true);
    }
    public static void main(String[] args) {
        new MappingUC();

    }

}
