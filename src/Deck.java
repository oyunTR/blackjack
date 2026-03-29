import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Cards> decks;  // instance field - artik kaybolmaz
    private Random random;

    public Deck(){
        decks = new ArrayList<Cards>();
        random = new Random();

        // 8 deste olustur (logic yorumlarinda belirtildigi gibi)
        String[] symbols = {"Diamond", "Heart", "Spade", "Club"};
        String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (int deck = 0; deck < 8; deck++) {
            for (String symbol : symbols) {
                for (String number : numbers) {
                    Cards card = new Cards();
                    card.setSymbol(symbol);
                    card.setNumber(number);
                    decks.add(card);
                }
            }
        }
    }

    // Desteden rastgele bir kart cek ve cikar
    public Cards drawCard() {
        if (decks.isEmpty()) {
            return null; // deste bitti
        }
        int randomIndex = random.nextInt(decks.size());
        return decks.remove(randomIndex); // karti cek ve desteden cikar
    }

    // Destede kac kart kaldi
    public int getSize() {
        return decks.size();
    }

}
