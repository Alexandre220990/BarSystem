import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarSystem extends JFrame implements ActionListener{
    JFrame frame;
    JMenu drinkMenu;
    JLabel label1;
    JButton button1;
    JButton button2;
    JMenuItem item1;
    JMenuItem item2;

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

        this.button1=new JButton("HI");
        this.button1.setFont(new Font("serif",Font.BOLD,18));
        this.button2=new JButton("BYE");
        button2.setSize(30,60);
        this.button2.setFont(new Font("serif",Font.BOLD,18));
        this.button1.addActionListener(this);
        this.button2.addActionListener(this);

        this.add(label1);
        this.add(button1);
        this.add(button2);

        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.button1){
            JOptionPane.showMessageDialog(null,"HI","HI",JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource() == this.button2){
            JOptionPane.showMessageDialog(null,"BYE","BYE",JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource() == this.item1 || e.getSource() == this.item2){
            JOptionPane.showMessageDialog(null,"menu item test","test",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
