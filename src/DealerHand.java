import java.util.ArrayList;

public class DealerHand {

    private final ArrayList<Cards> dealerHand; // hand olusturuldu

    public DealerHand() { // constructor ile dealerin kartlarini alicagi hand olusturuluyor
        this.dealerHand = new ArrayList<>();
    }

    public void addCardDealer(Cards newCard) { // yeni kart ekler hande
        this.dealerHand.add(newCard);
    }
    public ArrayList<Cards> getHandDealer() {
        return this.dealerHand;
    }
    public void clearDealerHand() {
        this.dealerHand.clear();
    }

    // Elin toplam degerini hesapla (Ace = 11 veya 1)
    public int getTotal() {
        int total = 0;
        int aceCount = 0;
        for (Cards card : dealerHand) {
            total += card.getValue();
            if (card.isAce()) {
                aceCount++;
            }
        }
        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }
        return total;
    }
}

