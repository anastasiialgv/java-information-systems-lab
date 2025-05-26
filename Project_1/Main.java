import classes.*;

import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Category skincare = new Category("Skincare", 101, "Skincare");
        Category makeup = new Category("Makeup", 102, "Makeup");

        Cosmetic cream = new Cosmetic("Moisturizer", 50.0, skincare);
        Cosmetic lipstick = new Cosmetic("Lipstick", 35.0, makeup);

        Client anna = new Client("Anna", "Ivanova", 28, "anna@example.com");
        Client john = new Client("John", "Smith", 34, "john@example.com");

        Purchase p1 = new Purchase(anna, cream);
        Purchase p2 = new Purchase(john, lipstick);

        Payment.createPayment(50.0, Type.CARD, p1);
        Payment.createPayment(20.0, Type.CASH, p1);
        Payment.createPayment(80.0, Type.TRANSFER, p2);

        System.out.println(Purchase.getAllPayments());
        p1.removePurchase();
        System.out.println(Purchase.getAllPayments());

        LoyaltyCard card1 = new LoyaltyCard(LocalDateTime.of(2024, 3, 15, 10, 0), "CARD001", 150);
        LoyaltyCard card2 = new LoyaltyCard(LocalDateTime.of(2024, 4, 1, 12, 30), "CARD002", 300);

        anna.addCard(card1);
        anna.addCard(card2);
        john.addCard(card2);

        try {
            LoyaltyCard foundCard = anna.findCard("CARD002");
            System.out.println("Found card for client1: " + foundCard.getCardNumber() + " with points: " + foundCard.getPoints());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            LoyaltyCard notFound = anna.findCard("CARD999");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}