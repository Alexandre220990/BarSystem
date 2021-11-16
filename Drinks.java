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

}
