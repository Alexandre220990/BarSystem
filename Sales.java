import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sales implements Serializable {
    private Bartenders bartender;
    private double cost;
    private Date date;

    public Sales() {
        this(6.0);
    }

    public Sales(double cost) {
        this.cost = cost;
        this.date = new Date();
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return "Sales\n " + date.format(this.date) + "\nCost: " + String.format("%.2f", this.cost) + "\n";
    }
}
