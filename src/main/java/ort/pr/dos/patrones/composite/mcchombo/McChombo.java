package ort.pr.dos.patrones.composite.mcchombo;

import java.util.ArrayList;
import java.util.List;

public class McChombo implements Product {

    private String name;
    private List<Product> products;

    public McChombo(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    @Override
    public double getPrice() {
        double priceWithoutDiscount = products.stream()
                .mapToDouble(product -> product.getPrice())
                .sum();
        return priceWithoutDiscount * 0.9;
    }

    public void add(Product product) {
        products.add(product);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("McChombo {");
        sb.append("name: '").append(name).append('\'');
        sb.append("price: '").append(getPrice()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
