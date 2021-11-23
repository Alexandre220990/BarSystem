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
    JButton addCocktail;
    JButton showCocktails;
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
        Font font = new Font("serif",Font.BOLD,18);
        this.setTitle("Bar System");
        this.setSize(220, 260);

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

        this.addBartender=new JButton("Add Bartender");
        this.addBartender.setFont(font);
        this.showBartender=new JButton("Show Bartenders list");
        this.showBartender.setFont(font);
        this.addCocktail=new JButton("Add a Cocktails");
        this.addCocktail.setFont(font);
        this.showCocktails=new JButton("Show Cocktails list");
        this.showCocktails.setFont(font);
        this.addBartender.addActionListener(this);
        this.showBartender.addActionListener(this);
        this.addCocktail.addActionListener(this);
        this.showCocktails.addActionListener(this);

        this.add(label1);
        this.add(addBartender);
        this.add(showBartender);
        this.add(addCocktail);
        this.add(showCocktails);

        this.setVisible(true);

    }
    public void save() throws IOException {
        ObjectOutputStream newS = new ObjectOutputStream(new FileOutputStream("newbartender.dat"));
        newS.writeObject(this.barStaff);
        newS.close();
        ObjectOutputStream newD = new ObjectOutputStream(new FileOutputStream("newcocktail.dat"));
        newD.writeObject(this.cocktails);
        newD.close();
    }

    public void open() throws IOException, ClassNotFoundException {
        ObjectInputStream showS = new ObjectInputStream(new FileInputStream("newbartender.dat"));
        this.barStaff = (ArrayList)showS.readObject();
        showS.close();
        ObjectInputStream showD = new ObjectInputStream(new FileInputStream("newcocktail.dat"));
        this.cocktails = (ArrayList)showD.readObject();
        showD.close();

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
            JOptionPane.showMessageDialog((Component)null, output, "Bartender Details",JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource() == this.addCocktail){
            String cName = JOptionPane.showInputDialog("Enter cocktail Name");
            String compo = JOptionPane.showInputDialog("Enter cocktail composition");
            String price = JOptionPane.showInputDialog("Enter cocktail price");
            this.drinks = new Drinks(cName,compo,price);
            this.cocktails.add(this.drinks);
            try {
                this.save();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            JOptionPane.showMessageDialog(null,"Cocktail added","Done",JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource() == this.showCocktails){
            output = new JTextArea();
            //String name = JOptionPane.showInputDialog("Enter Staff's Name");
            output.setText("Cocktail List:\n\n");
            output.append(this.cocktails.toString());
            JOptionPane.showMessageDialog((Component)null, output, "Cocktail List",JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource() == this.item1 || e.getSource() == this.item2){
            JOptionPane.showMessageDialog(null,"menu item test","test",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
