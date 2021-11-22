import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BarSystem extends JFrame implements ActionListener{
    JFrame frame;
    JMenu drinkMenu;
    JLabel label1;
    JButton addBartender;
    JButton showBartender;
    JMenuItem item1;
    JMenuItem item2;
    JTextArea output;
    ArrayList<Bartenders> barStaff = new ArrayList();
    ArrayList<Drinks> cocktails = new ArrayList();
    ArrayList<Sales> sales = new ArrayList();
    private Bartenders bartender;
    private Drinks drinks;
    private Sales sale;

    public BarSystem(){
        this.setTitle("Bar System");
        this.setSize(60, 180);

        FlowLayout layout = new FlowLayout();
        this.setLayout(layout);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar mainMenu = new JMenuBar();
        this.setJMenuBar(mainMenu);

        this.drinkMenu = new JMenu("Menu");
        mainMenu.add(drinkMenu);
            item1 = new JMenuItem("item 1");
            item2 = new JMenuItem("item 2");
            this.drinkMenu.add(item1);
            this.drinkMenu.add(item2);
            item1.addActionListener(this);
            item2.addActionListener(this);

        this.label1 = new JLabel("welcome");
        this.label1.setFont(new Font("serif",Font.BOLD,22));

        this.addBartender=new JButton("HI");
        this.addBartender.setFont(new Font("serif",Font.BOLD,18));
        this.showBartender=new JButton("BYE");
        showBartender.setSize(30,60);
        this.showBartender.setFont(new Font("serif",Font.BOLD,18));
        this.addBartender.addActionListener(this);
        this.showBartender.addActionListener(this);

        this.add(label1);
        this.add(addBartender);
        this.add(showBartender);

        this.setVisible(true);

    }
    public void save() throws IOException {
        ObjectOutputStream newS = new ObjectOutputStream(new FileOutputStream("newbartender.dat"));
        newS.writeObject(this.barStaff);
        newS.close();
    }

    public void open() throws IOException, ClassNotFoundException {
        ObjectInputStream showS = new ObjectInputStream(new FileInputStream("newbartender.dat"));
        this.barStaff = (ArrayList)showS.readObject();
        showS.close();

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.addBartender){
            String name = JOptionPane.showInputDialog("Enter Staff's Name");
            String address = JOptionPane.showInputDialog("Enter Staff's address");
            String pps = JOptionPane.showInputDialog("Enter Staff's pps number");
            String phone = JOptionPane.showInputDialog("Enter Staff's phone number");
            String email = JOptionPane.showInputDialog("Enter Staff's email address");
            this.bartender = new Bartenders(name, address,pps,phone,email);
            this.barStaff.add(this.bartender);
            try {
                this.save();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            JOptionPane.showMessageDialog(null,"Bartender added","Done",JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource() == this.showBartender){
            output = new JTextArea();
            //String name = JOptionPane.showInputDialog("Enter Staff's Name");
            output.setText("Bartender Details:\n\n");
            output.append(this.barStaff.toString());
            JOptionPane.showMessageDialog((Component)null, output, "Staff Details",JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource() == this.item1 || e.getSource() == this.item2){
            JOptionPane.showMessageDialog(null,"menu item test","test",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
