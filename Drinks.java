public class Drinks {
private String name;
private String composition;
private Double price;

    public Drinks() {
        this("no name","empty",0.0);
    }

    public Drinks(String name, String composition, Double price) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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
