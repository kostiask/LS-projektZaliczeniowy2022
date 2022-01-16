package pl.kul;

public class Product {
    static int i = 0;
    private int id;
    private String name;
    private double cena;

    public Product(String name, double cena) {
        this.id = Product.i;
        this.name = name;
        this.cena = cena;
        Product.i++;
    }

    @Override
    public String toString() {
        return "Product " + "id=" + id + ", name='" + name + '\'' + ", cena=" + cena + "zl";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCena() {
        return cena;
    }
}
