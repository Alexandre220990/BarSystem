import java.util.Date;

public class Sales {
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
        return "Sales" +
                "cost:" + cost + getCost() +
                "date:" + date + this.date;
    }
}
