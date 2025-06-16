package ort.pr.dos.patrones.composite.mcchombo;

public class IndividualProduct implements Product {

    private String name;
    private double price;

    public IndividualProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IndividualProduct {");
        sb.append("name: '").append(name).append('\'');
        sb.append(", price: ").append(price);
        sb.append('}');
        return sb.toString();
    }
}
