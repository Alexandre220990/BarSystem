//Alexandre Francisco
//T00219415
/*This program allows you to add bartenders, cocktails and sales into a bar system,display them and delete
them.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;


public class BarSystem extends JFrame implements ActionListener{
    JFrame frame;
    JMenu drinkMenu;
    JMenu bartendersMenu;
    JMenu salesMenu;
    JLabel label1;
    JLabel imgLabel;
    JButton addBartender;
    JButton addCocktail;
    JMenuItem addCocktailMenu;
    JMenuItem showCocktailsMenu;
    JMenuItem addBartenderMenu;
    JMenuItem showBartendersMenu;
    JMenuItem deleteBartender;
    JMenuItem deleteCocktail;
    JMenuItem addSalesMenu;
    JMenuItem showSalesMenu;
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
        this.setSize(220, 405);
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
        deleteCocktail = new JMenuItem("Delete Cocktail");
            drinkMenu.add(addCocktailMenu);
            drinkMenu.add(showCocktailsMenu);
            drinkMenu.add(deleteCocktail);
        addCocktailMenu.addActionListener(this);
        showCocktailsMenu.addActionListener(this);
        deleteCocktail.addActionListener(this);

        this.bartendersMenu = new JMenu("Bartenders");
        mainMenu.add(bartendersMenu);
        addBartenderMenu = new JMenuItem("Add Bartender");
        showBartendersMenu = new JMenuItem("Show Bartenders");
        deleteBartender = new JMenuItem("Delete Bartenders");
            bartendersMenu.add(addBartenderMenu);
            bartendersMenu.add(showBartendersMenu);
            bartendersMenu.add(deleteBartender);
        addBartenderMenu.addActionListener(this);
        showBartendersMenu.addActionListener(this);
        deleteBartender.addActionListener(this);

        this.salesMenu = new JMenu("Sales");
        mainMenu.add(salesMenu);
        addSalesMenu = new JMenuItem("Add Sales");
        showSalesMenu = new JMenuItem("Show Sales");
            salesMenu.add(addSalesMenu);
            salesMenu.add(showSalesMenu);
        addSalesMenu.addActionListener(this);
        showSalesMenu.addActionListener(this);

        this.imgLabel = new JLabel();
        this.imgLabel.setIcon(new ImageIcon(this.getClass().getResource("cocktail.png")));

        this.label1 = new JLabel("welcome");
        this.label1.setFont(new Font("serif",Font.BOLD,22));

        this.addBartender=new JButton("Add Bartender");
        this.addBartender.setFont(font);
        this.addCocktail=new JButton("Add a Cocktails");
        this.addCocktail.setFont(font);
        this.addBartender.addActionListener(this);
        this.addCocktail.addActionListener(this);

        this.add(label1);
        this.add(imgLabel);
        this.add(addBartender);
        this.add(addCocktail);

        this.setVisible(true);

    }
    public void create() throws IOException {
        ObjectOutputStream newB = new ObjectOutputStream(new FileOutputStream("newbartender.dat"));
        newB.writeObject(this.barStaff);
        newB.close();
        ObjectOutputStream newD = new ObjectOutputStream(new FileOutputStream("newcocktail.dat"));
        newD.writeObject(this.cocktails);
        newD.close();
        ObjectOutputStream newS = new ObjectOutputStream(new FileOutputStream("newsale.dat"));
        newS.writeObject(this.sales);
        newS.close();
    }

    public void open() throws IOException, ClassNotFoundException {
        ObjectInputStream showB = new ObjectInputStream(new FileInputStream("newbartender.dat"));
        this.barStaff = (ArrayList)showB.readObject();
        showB.close();
        ObjectInputStream showD = new ObjectInputStream(new FileInputStream("newcocktail.dat"));
        this.cocktails = (ArrayList)showD.readObject();
        showD.close();
        ObjectInputStream showS = new ObjectInputStream(new FileInputStream("newsale.dat"));
        this.sales = (ArrayList)showS.readObject();
        showS.close();
    }

    public void addNewBartender() {
        String name = JOptionPane.showInputDialog("Enter Staff's Name");
        int i;
        boolean validName = false;
        if (name!=null){
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
                        pps = JOptionPane.showInputDialog("Pps number with wrong length:");
                }else
                    pps = JOptionPane.showInputDialog("You need to enter a pps number:");
            }

            String phone = JOptionPane.showInputDialog("Enter Staff's phone number");
            boolean validPhone = false;

            while (!validPhone){
                if(!phone.equals("")){
                    if(phone.length() >= 9 && phone.length() <= 10){
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
            JOptionPane.showMessageDialog(null,"Bartender added","Done", INFORMATION_MESSAGE);
            this.barStaff.add(this.bartender);
        }else
            JOptionPane.showMessageDialog(null,"No added bartenders","Exit", INFORMATION_MESSAGE);


    }

    public void deleteBartender(){
        JComboBox bartendersList = new JComboBox();
        Iterator<Bartenders> iterator = barStaff.iterator();

        if(!iterator.hasNext()) {
            JOptionPane.showMessageDialog((Component)null,"No bartenders to remove", "Remove Staff",INFORMATION_MESSAGE);
        }
        else {
            Bartenders nameToDelete = (Bartenders) iterator.next();
            bartendersList.addItem(nameToDelete.getName());
            JOptionPane.showMessageDialog((Component)null,bartendersList, "Bartender to remove",INFORMATION_MESSAGE);
            int delete = bartendersList.getSelectedIndex();
            this.barStaff.remove(delete);
            JOptionPane.showMessageDialog((Component)null, "Bartender Removed", "Removed",INFORMATION_MESSAGE);
        }
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
            Double price = Double.valueOf(JOptionPane.showInputDialog("Enter cocktail price"));
            boolean validPrice=false;
            while(!validPrice){
                if(!price.equals("")){
                    validPrice=true;
                }else
                    price = Double.valueOf(JOptionPane.showInputDialog("You need to enter a cocktail price"));
            }
        this.drinks = new Drinks(cName,compo,price);
        JOptionPane.showMessageDialog(null,"Cocktail added","Done", INFORMATION_MESSAGE);
        this.cocktails.add(this.drinks);
    }

    public void deleteCocktail(){
        JComboBox cocktailList = new JComboBox();
        Iterator<Drinks> iterator = cocktails.iterator();

        if(!iterator.hasNext()) {
            JOptionPane.showMessageDialog((Component)null,"No cocktails to remove", "Remove Staff",INFORMATION_MESSAGE);
        }
        else {
            Drinks cocktailToDelete = (Drinks) iterator.next();
            cocktailList.addItem(cocktailToDelete.getName());
            JOptionPane.showMessageDialog((Component)null,cocktailList, "Cocktail to remove",INFORMATION_MESSAGE);
            int delete = cocktailList.getSelectedIndex();
            this.cocktails.remove(delete);
            JOptionPane.showMessageDialog((Component)null, "Cocktail Removed", "Removed",INFORMATION_MESSAGE);
        }
    }

    public void addSales(){
        Double cost = Double.valueOf(JOptionPane.showInputDialog("Enter sales of the day for today\n"));

        String name=JOptionPane.showInputDialog("Enter seller name:");

        boolean valid=false;

        while(!valid){
            for(int i=0;i<barStaff.size();i++)
                if (name.equals(barStaff.get(i).getName())) {
                    this.sale = new Sales(cost);
                    valid = true;
                }
                else
                    name=JOptionPane.showInputDialog("This bartender does not exist\n"
                                                    +"To add sales, the seller need to exist");
        }

        JOptionPane.showMessageDialog((Component)null, "Today sales added, and the value is: EUR " + cost, "Sales added", INFORMATION_MESSAGE);
        this.sales.add(this.sale);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.addBartender || e.getSource()==this.addBartenderMenu){
            this.addNewBartender();
        }
        if(/*e.getSource() == this.showBartender ||*/ e.getSource()==this.showBartendersMenu){
            output = new JTextArea();
            output.setText("Bartender Details:\n\n");
            output.append(this.barStaff.toString());
            JOptionPane.showMessageDialog((Component)null, output, "Bartender Details", INFORMATION_MESSAGE);
        }
        if(e.getSource() == this.deleteBartender){
            this.deleteBartender();
        }
        if(e.getSource() == this.addCocktail || e.getSource()==this.addCocktailMenu){
            this.addNewCocktail();
        }
        if(/*e.getSource() == this.showCocktails ||*/ e.getSource()==showCocktailsMenu){
            output = new JTextArea();
            output.setText("Cocktail List:\n\n");
            output.append(this.cocktails.toString());
            JOptionPane.showMessageDialog((Component)null, output, "Cocktail List", INFORMATION_MESSAGE);
        }
        if(e.getSource()==this.deleteCocktail){
            deleteCocktail();
        }
        if(e.getSource()==this.addSalesMenu){
            this.addSales();
        }
        if(e.getSource()==this.showSalesMenu){
            output = new JTextArea();
            output.setText("Sales:\n\n");
            output.append(this.sales.toString());
            JOptionPane.showMessageDialog((Component)null, output, "Sales", INFORMATION_MESSAGE);
        }
    }
}
