import java.util.ArrayList;

public class PlayerHand {

    private final ArrayList<Cards> playerHand;

    public PlayerHand() {
        this.playerHand = new ArrayList<>();
    }

    public void addCardPlayer(Cards newCard) {
        playerHand.add(newCard);
    }
    public ArrayList<Cards> getPlayerHand() {
        return playerHand;
    }
    public void clearPlayerHand() {
        playerHand.clear();
    }

    // Elin toplam degerini hesapla (Ace = 11 veya 1)
    public int getTotal() {
        int total = 0;
        int aceCount = 0;
        for (Cards card : playerHand) {
            total += card.getValue();
            if (card.isAce()) {
                aceCount++;
            }
        }
        // 21'i gecerse Ace'leri 11 yerine 1 say
        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }
        return total;
    }
}

