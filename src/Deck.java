import java.util.ArrayList;

public class Deck {

    public Deck(){

        ArrayList<Cards> cards = new ArrayList<Cards>();
        int i = 50;

        while (cards.size() < 13){

            Cards card = new Cards();
            card.setSymbol("Diamod");
            card.setNumber(String.valueOf(i));
            cards.add(card);
            if(i <57) {
                i += 1;
            }
            else if(i == 57){
                i+=8;
            }
            else if(i == 65){
                i+=9;
            }
            else if(i == 74){
                i+=1;
            }
            else{
                i+=6;
            }

        }
        i=50;
        while (cards.size() < 26){

            Cards card = new Cards();
            card.setSymbol("Heart");
            card.setNumber(String.valueOf(i));
            cards.add(card);
            if(i <57) {
                i += 1;
            }
            else if(i == 57){
                i+=8;
            }
            else if(i == 65){
                i+=9;
            }
            else if(i == 74){
                i+=1;
            }
            else{
                i+=6;
            }

        }
        i=50;
        while (cards.size() < 39){

            Cards card = new Cards();
            card.setSymbol("Spade");
            card.setNumber(String.valueOf(i));
            cards.add(card);
            if(i <57) {
                i += 1;
            }
            else if(i == 57){
                i+=8;
            }
            else if(i == 65){
                i+=9;
            }
            else if(i == 74){
                i+=1;
            }
            else{
                i+=6;
            }

        }
        i=50;
        while (cards.size() < 52){

            Cards card = new Cards();
            card.setSymbol("Club");
            card.setNumber(String.valueOf(i));
            cards.add(card);
            if(i <57) {
                i += 1;
            }
            else if(i == 57){
                i+=8;
            }
            else if(i == 65){
                i+=9;
            }
            else if(i == 74){
                i+=1;
            }
            else{
                i+=6;
            }

        }

    }

}
