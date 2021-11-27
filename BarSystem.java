import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class BarSystem extends JFrame implements ActionListener{
    JFrame frame;
    JMenu drinkMenu;
    JLabel label1;
    JButton addBartender;
    JButton showBartender;
    JButton addCocktail;
    JButton showCocktails;
    JMenuItem addCocktailMenu;
    JMenuItem showCocktailsMenu;
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
        this.setLocationRelativeTo((Component)null);

        FlowLayout layout = new FlowLayout();
        this.setLayout(layout);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar mainMenu = new JMenuBar();
        this.setJMenuBar(mainMenu);

        this.drinkMenu = new JMenu("Drinks");
        mainMenu.add(drinkMenu);
        addCocktailMenu = new JMenuItem("Add Cocktail");
        showCocktailsMenu = new JMenuItem("Show Cocktails");
            this.drinkMenu.add(addCocktailMenu);
            this.drinkMenu.add(showCocktailsMenu);
        addCocktailMenu.addActionListener(this);
        showCocktailsMenu.addActionListener(this);

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
    public void create() throws IOException {
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

    public void addNewBartender() {
        String name = JOptionPane.showInputDialog("Enter Staff's Name");
        int i;
        boolean valid = false;
        while (!valid){
            if (!name.equals("")) {
                if (name.length() >= 3 && name.length() <= 50) {
                    for (i = 0; i < name.length(); i++){
                        if (Character.isDigit(name.charAt(i))) {
                            break;
                        }
                    }
                    if (i == name.length()) {
                        String address = JOptionPane.showInputDialog("Enter Staff's address");
                        if (!address.equals("")) {
                            String pps = JOptionPane.showInputDialog("Enter bartender system PIN code");
                            for (i = 0; i < pps.length(); i++){
                                if (Character.isLetter(pps.charAt(i))) {
                                    break;
                                }
                            }
                            if (i == pps.length()) {
                                String phone = JOptionPane.showInputDialog("Enter Staff's phone number");
                                for (i = 0; i < phone.length(); i++){
                                    if (Character.isLetter(phone.charAt(i))) {
                                        break;
                                    }
                                }
                                if(i==phone.length()) {
                                    String email = JOptionPane.showInputDialog("Enter Staff's email address");
                                    this.bartender = new Bartenders(name, address, pps, phone, email);
                                    JOptionPane.showMessageDialog(null, "Bartender added", "Done", JOptionPane.INFORMATION_MESSAGE);
                                    valid = true;
                                }else {
                                    phone = JOptionPane.showInputDialog("phone number cant contain letters");
                                }
                            } else {
                                pps = JOptionPane.showInputDialog("Bartender system PIN code cant contain letters");
                            }
                        } else {
                            address = JOptionPane.showInputDialog("Need to enter address");
                        }
                    } else {
                        name = JOptionPane.showInputDialog("Name cant contain digits");
                    }
                } else {
                    name = JOptionPane.showInputDialog("Name with wrong length");
                }
            } else{
                name = JOptionPane.showInputDialog("Need to enter a name");
            }
        }
        this.barStaff.add(this.bartender);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.addBartender){
            this.addNewBartender();
        }
        if(e.getSource() == this.showBartender){
            output = new JTextArea();
            //String name = JOptionPane.showInputDialog("Enter Staff's Name");
            output.setText("Bartender Details:\n\n");
            output.append(this.barStaff.toString());
            JOptionPane.showMessageDialog((Component)null, output, "Bartender Details",JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource() == this.addCocktail || e.getSource()==addCocktailMenu){
            String cName = JOptionPane.showInputDialog("Enter cocktail Name");
            String compo = JOptionPane.showInputDialog("Enter cocktail composition");
            String price = JOptionPane.showInputDialog("Enter cocktail price");
            this.drinks = new Drinks(cName,compo,price);
            this.cocktails.add(this.drinks);
            try {
                this.create();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null,"Cocktail added","Done",JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource() == this.showCocktails || e.getSource()==showCocktailsMenu){
            output = new JTextArea();
            //String name = JOptionPane.showInputDialog("Enter Staff's Name");
            output.setText("Cocktail List:\n\n");
            output.append(this.cocktails.toString());
            JOptionPane.showMessageDialog((Component)null, output, "Cocktail List",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
/*
            */