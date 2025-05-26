package classes;

public class Payment {
    private double totalPrice;
    private Type type;
    private Purchase purchase;

    private Payment(double totalPrice, Type type, Purchase purchase) {
        this.totalPrice = totalPrice;
        this.type = type;
        this.purchase = purchase;
    }

    public static void createPayment(double totalPrice, Type type, Purchase purchase) {
        if (purchase == null) throw new IllegalArgumentException("Purchase is null");
        Payment payment = new Payment(totalPrice, type, purchase);
        purchase.addPayment(payment);
    }

    @Override
    public String toString() {
        return "classes.Payment{" +
                "totalPrice=" + totalPrice +
                ", type=" + type +
                ", purchase=" + purchase +
                '}';
    }
}

