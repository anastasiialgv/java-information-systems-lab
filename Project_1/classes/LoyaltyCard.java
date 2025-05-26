package classes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoyaltyCard {
    private Set<LoyaltyCard> cards = new HashSet<>();
    private LocalDateTime issueDate;
    private String cardNumber;
    private int points;
    private List<Client> clients = new ArrayList<>();

    public LoyaltyCard(LocalDateTime issueDate, String cardNumber, int points) {
        setIssueDate(issueDate);
        setCardNumber(cardNumber);
        setPoints(points);
        cards.add(this);
    }

    public void addClient(Client client) {
        if (!clients.contains(client)) {
            clients.add(client);
            client.addCard(this);
        }
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        if (issueDate == null) throw new IllegalArgumentException("Issue date cannot be null");
        this.issueDate = issueDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.isEmpty()) throw new IllegalArgumentException("cardNumber cannot be null");
        this.cardNumber = cardNumber;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        if (points < 0) throw new IllegalArgumentException("points cannot be negative");
        this.points = points;
    }
}
