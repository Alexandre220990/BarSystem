import javax.swing.*;

public class DrinksTest {
    public static void main(String[] args) {
        Drinks drink1 = new Drinks("Marguerita","Tequilla,Salt,lemon juice",6.00);
        Drinks drink2 = new Drinks();

        Drinks[] allDrinks = {drink1,drink2};

        JOptionPane.showMessageDialog(null,allDrinks,"test",JOptionPane.INFORMATION_MESSAGE);
    }
}
