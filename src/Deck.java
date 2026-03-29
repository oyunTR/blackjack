import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Cards> cards;  // instance field - artik kaybolmaz
    private Random random;

    public Deck(){
        cards = new ArrayList<Cards>();
        random = new Random();

        // 8 deste olustur (logic yorumlarinda belirtildigi gibi)
        for (int deck = 0; deck < 8; deck++) {
            String[] symbols = {"Diamond", "Heart", "Spade", "Club"};
            for (String symbol : symbols) {
                int i = 50;
                for (int c = 0; c < 13; c++) {
                    Cards card = new Cards();
                    card.setSymbol(symbol);
                    card.setNumber(String.valueOf(i));
                    cards.add(card);
                    if (i < 57) {
                        i += 1;
                    } else if (i == 57) {
                        i += 8;
                    } else if (i == 65) {
                        i += 9;
                    } else if (i == 74) {
                        i += 1;
                    } else {
                        i += 6;
                    }
                }
            }
        }
    }

    // Desteden rastgele bir kart cek ve cikar
    public Cards drawCard() {
        if (cards.isEmpty()) {
            return null; // deste bitti
        }
        int randomIndex = random.nextInt(cards.size());
        return cards.remove(randomIndex); // karti cek ve desteden cikar
    }

    // Destede kac kart kaldi
    public int getSize() {
        return cards.size();
    }

}
