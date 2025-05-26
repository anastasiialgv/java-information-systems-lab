package classes;

import java.util.*;

public class Client {
    private static List<Client> clients = new ArrayList<>();
    private String name;
    private String surname;
    private int age;
    private String email;
    private List<Purchase> purchases = new ArrayList<>();
    private Map<String, LoyaltyCard> cards = new HashMap<>();

    public Client(String name, String surname, int age, String email) {
        setName(name);
        setSurname(surname);
        setEmail(email);
        setAge(age);
        clients.add(this);
    }
    public void addPurchase(Purchase purchase) {
        if (!purchases.contains(purchase))
            purchases.add(purchase);
    }

    public void removePurchase(Purchase purchase) {
        purchases.remove(purchase);
    }

    public List<Purchase> getPurchases() {
        return Collections.unmodifiableList(purchases);
    }

    public void addCard(LoyaltyCard card) {
        if (!cards.containsKey(card.getCardNumber())) {
            cards.put(card.getCardNumber(), card);
            card.addClient(this);
        }
    }

    public LoyaltyCard findCard(String cardNumber) throws Exception {
        if(!cards.containsKey(cardNumber)) {
            throw new Exception("Unable to find a card: " + cardNumber);
        }
        return cards.get(cardNumber);
    }


    public Map<String, LoyaltyCard> getCards() {
        return Collections.unmodifiableMap(cards);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("name cannot be null or empty");
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.isEmpty()) throw new IllegalArgumentException("surname cannot be null or empty");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 1) throw new IllegalArgumentException("age cannot be negative or 0");
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) throw new IllegalArgumentException("surname cannot be null or empty");
        this.email = email;
    }

    @Override
    public String toString() {
        return "classes.Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}