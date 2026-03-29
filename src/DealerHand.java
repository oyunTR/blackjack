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

}
