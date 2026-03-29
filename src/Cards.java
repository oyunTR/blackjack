import java.util.ArrayList;

public class Cards {

    private String symbol;
    private String number;

    public String getSymbol(){
        return symbol;
    }
    public String getNumber(){
        return number;
    }

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }
    public void setNumber(String number){
        this.number = number;
    }

    // Kartin blackjack degerini dondurur
    public int getValue(){
        switch (number) {
            case "A": return 11;  // Ace - baslangicta 11, gerekirse 1 olur
            case "J": return 10;  // Jack
            case "Q": return 10;  // Queen
            case "K": return 10;  // King
            default:
                return Integer.parseInt(number); // "2"=2, "3"=3, ..., "10"=10
        }
    }

    // Ace mi kontrol et
    public boolean isAce(){
        return number.equals("A");
    }
}
