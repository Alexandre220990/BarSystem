import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class BarSystem extends JFrame implements ActionListener{
    JFrame frame;
    JMenu drinkMenu;
    JMenu bartendersMenu;
    JLabel label1;
    JButton addBartender;
    JButton showBartender;
    JButton addCocktail;
    JButton showCocktails;
    JMenuItem addCocktailMenu;
    JMenuItem showCocktailsMenu;
    JMenuItem addBartenderMenu;
    JMenuItem showBartendersMenu;
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
            drinkMenu.add(addCocktailMenu);
            drinkMenu.add(showCocktailsMenu);
        addCocktailMenu.addActionListener(this);
        showCocktailsMenu.addActionListener(this);

        this.bartendersMenu = new JMenu("Bartenders");
        mainMenu.add(bartendersMenu);
        addBartenderMenu = new JMenuItem("Add Bartender");
        showBartendersMenu = new JMenuItem("Show Bartenders");
            bartendersMenu.add(addBartenderMenu);
            bartendersMenu.add(showBartendersMenu);
        addBartenderMenu.addActionListener(this);
        showBartendersMenu.addActionListener(this);

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
        boolean validName = false;

        while (!validName){
            if(!name.equals("")){
                if(name.length() >= 2 && name.length() <= 50){
                    for (i = 0; i < name.length(); i++){
                        if (Character.isDigit(name.charAt(i))) {
                            break;
                        }
                    }
                    if(i == name.length()){
                        validName=true;
                        break;
                    }else
                        name = JOptionPane.showInputDialog("The name cant contain digits:");
                }else
                    name = JOptionPane.showInputDialog("Name with wrong length:");
            }else
                name = JOptionPane.showInputDialog("You need to enter a name:");
        }

        String address = JOptionPane.showInputDialog("Enter Staff's address");
        boolean validAddress=false;

        while (!validAddress){
            if(!address.equals("")){
                if(address.length() >= 4 && address.length() <= 80){
                    validAddress=true;
                    break;
                }else
                    address = JOptionPane.showInputDialog("Address with wrong length:");
            }else
                address= JOptionPane.showInputDialog("You need to enter an address:");
        }

        String pps = JOptionPane.showInputDialog("Enter Staff's pps number");
        boolean validPps=false;

        while (!validPps){
            if(!pps.equals("")){
                if(pps.length() == 9){
                    validPps=true;
                    break;
                }else
                    pps = JOptionPane.showInputDialog("Name with wrong length:");
            }else
                pps = JOptionPane.showInputDialog("You need to enter a name:");
        }

        String phone = JOptionPane.showInputDialog("Enter Staff's phone number");
        boolean validPhone = false;

        while (!validPhone){
            if(!phone.equals("")){
                if(phone.length() >= 2 && phone.length() <= 50){
                    for (i = 0; i < phone.length(); i++){
                        if (Character.isLetter(phone.charAt(i))) {
                            break;
                        }
                    }
                    if(i == phone.length()){
                        validPhone=true;
                        break;
                    }else
                        phone = JOptionPane.showInputDialog("The phone number cant contain letters:");
                }else
                    phone = JOptionPane.showInputDialog("Phone number with wrong length:");
            }else
                phone = JOptionPane.showInputDialog("You need to enter a Phone number:");
        }

        String email = JOptionPane.showInputDialog("Enter Staff's email address");
        boolean validEmail=false;

        while (!validEmail){
            if(!email.equals("")){
                validEmail=true;
                break;
            }else
                email = JOptionPane.showInputDialog("You need to enter an email:");
        }
        this.bartender = new Bartenders(name, address,pps,phone,email);
        JOptionPane.showMessageDialog(null,"Bartender added","Done",JOptionPane.INFORMATION_MESSAGE);
        this.barStaff.add(this.bartender);
    }

    public void addNewCocktail(){
        String cName = JOptionPane.showInputDialog("Enter cocktail Name");
        boolean validCname=false;

        while(!validCname){
            if(!cName.equals("")){
                validCname=true;
            }else
                cName = JOptionPane.showInputDialog("You need to enter a cocktail Name");
        }
        String compo = JOptionPane.showInputDialog("Enter cocktail composition");
        boolean validCompo=false;
        while(!validCompo){
            if(!compo.equals("")){
                validCompo=true;
            }else
                compo = JOptionPane.showInputDialog("You need to enter a cocktail composition");
        }
            String price = JOptionPane.showInputDialog("Enter cocktail price");
            boolean validPrice=false;
            while(!validPrice){
                if(!price.equals("")){
                    validPrice=true;
                }else
                    price = JOptionPane.showInputDialog("You need to enter a cocktail price");
            }
        this.drinks = new Drinks(cName,compo,price);
        JOptionPane.showMessageDialog(null,"Cocktail added","Done",JOptionPane.INFORMATION_MESSAGE);
        this.cocktails.add(this.drinks);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.addBartender || e.getSource()==addBartenderMenu){
            this.addNewBartender();
        }
        if(e.getSource() == this.showBartender || e.getSource()==showBartendersMenu){
            output = new JTextArea();
            //String name = JOptionPane.showInputDialog("Enter Staff's Name");
            output.setText("Bartender Details:\n\n");
            output.append(this.barStaff.toString());
            JOptionPane.showMessageDialog((Component)null, output, "Bartender Details",JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource() == this.addCocktail || e.getSource()==addCocktailMenu){
            this.addNewCocktail();
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
            */