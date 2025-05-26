package classes;

import java.util.ArrayList;
import java.util.List;

public class Cosmetic {
    private static List<Cosmetic> cosmetics = new ArrayList<>();
    private String name;
    private double price;
    private Category category;
    private List<Purchase> purchases = new ArrayList<>();

    public Cosmetic(String name, double price, Category category) {
        setName(name);
        setPrice(price);
        setCategory(category);
        cosmetics.add(this);
    }

    public void setCategory(Category category) {
        if (category == null) throw new IllegalArgumentException("classes.Category cannot be null");
        if (this.category == null) {
            this.category = category;
            category.addCosmetic(this);
        }
    }

    public void addPurchase(Purchase purchase) {
        if (!purchases.contains(purchase)) {
            purchases.add(purchase);
        }
    }
    public void removePurchase(Purchase purchase) {
        purchases.remove(purchase);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("name cannot be null or empty");
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 1) throw new IllegalArgumentException("Price cannot be negative or 0");
        this.price = price;
    }


    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "classes.Cosmetic{" +
                "category=" + category +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}

