package classes;

import java.time.LocalDate;
import java.util.*;

public class Purchase {
    private static List<Purchase> purchases = new ArrayList<>();
    private static Set<Payment> allPayments = new HashSet<>();
    private Client client;
    private Cosmetic cosmetic;
    private LocalDate date;
    private Set<Payment> payments = new HashSet<>();

    public Purchase(Client client, Cosmetic cosmetic) {
        if (client == null || cosmetic == null) throw new IllegalArgumentException("invalid arguments");
        this.client = client;
        this.cosmetic = cosmetic;
        this.date = LocalDate.now();
        purchases.add(this);
        client.addPurchase(this);
        cosmetic.addPurchase(this);
    }

    public void addPayment(Payment payment) {
        if (allPayments.contains(payment)) throw new IllegalArgumentException("payment already added");
        payments.add(payment);
        allPayments.add(payment);
    }

    public static List<Purchase> getPurchases() {
        return Collections.unmodifiableList(purchases);
    }

    public void removePurchase() {
        purchases.remove(this);
        client.removePurchase(this);
        cosmetic.removePurchase(this);
        allPayments.removeAll(payments);
    }

    public static Set<Payment> getAllPayments() {
        return Collections.unmodifiableSet(allPayments);
    }

    public Client getClient() {
        return client;
    }

    public Cosmetic getCosmetic() {
        return cosmetic;
    }

    public LocalDate getDate() {
        return date;
    }

    public Set<Payment> getPayments() {
        return Collections.unmodifiableSet(payments);
    }

    @Override
    public String toString() {
        return "classes.Purchase{" +
                "client=" + client +
                ", date=" + date +
                ", cosmetic=" + cosmetic +
                '}';
    }
}
