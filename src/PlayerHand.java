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

}
