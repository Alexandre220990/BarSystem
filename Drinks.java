import java.io.Serializable;

public class Drinks implements Serializable {
private String name;
private String composition;
private String price;

    public Drinks() {
        this("no name","empty", String.valueOf(0.0));
    }

    public Drinks(String name, String composition, String price) {
        this.name = name;
        this.composition = composition;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "\nCocktail\n" +
                "name:" + getName() +"\n"+
                "composition:" + getComposition() + "\n"+
                "price:" + getPrice();
    }
}
