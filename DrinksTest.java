import javax.swing.*;

public class DrinksTest {
    public static void main(String[] args) {
        Drinks drink1 = new Drinks("Marguerita","Tequilla,Salt,lemon juice",6.00);
        Drinks drink2 = new Drinks();
        Drinks drink3 = new Drinks("Blue Lagoon","Vodka,blue coracao,cointreau,sprite",6.0);

        Drinks[] allDrinks = {drink1,drink2,drink3};

        JOptionPane.showMessageDialog(null,allDrinks,"test",JOptionPane.INFORMATION_MESSAGE);
    }
}
