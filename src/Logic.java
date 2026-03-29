import java.util.Scanner;

public class Logic {
    // kartlari olusturup bunlari bir arraye ata ardindan alinan actiona gore
    // desteden rastgele kart ver dongu icersinde
    // normal bir oyunda 8 tane deste kullaniliyor 8.
    // 8 deste surekli kariliyor yani ard arda ayni kart gelme olasiligi var.

    // ilk once oyuncuya kac parasi oldugu soruluyor. oyuncu var olan parasini yaziyor ve asil oyun ekrani
    // geliyor sonrasinda oyuncu bet'ini koyuyor ve dealer bet konulduktan sonra kartlari dagitmaya basliyor

    // ilk kartlar dagitilis sekli ilk once oyuncuya(acik) bir kart ardindan dealer'a(kapali) bir kart
    // ikinci kartlar dagitilis sekli ilk once oyuncuya(acik) bir kart ardindan dealer'a(acik) bir kart
    // oyuncu stay diyene kadar dealer kartini acmaz ve kendine kart cekemez
    // her zaman ilk once BLACKJACK var mi yok mu kontrol et

    // Verilen her bir kart 8x52'lik desteden cikarilir boylece ayni kartlarin ayni oyun icerisinde gelme
    // olasiligi duser ve bu cikarma islemi her  bir kart verildikten sonra yapilir.
    // Yeni bet konuldugunda sifirdan bir 8x52'lik deste kullanilir


    // oyuncunun 6 tane yasanabilecek action var
    // BLACKJACK sadece ace ve 10(10, J, Q, K) gelirse olusur ve dealerda aynisini yapmadigi surece kesin WIN
    // eger dealerda aynisini yaparsa draw parasini geri alir oyuncu
    // HIT, SPILIT, DOUBLEDOWN, STAY, BOOM
    // HIT yeni kart al. 21>= olana kadar yapilabilir bir action
    // SPILIT sadece ama sadece pair iki kart var ise oyuncuda gerceklestirilebilir
    // DOUBLEDOWN oyuncu beti iki katina cikarir kapali sekilde tek bir kart verilir baskada alamaz,
    // dealer kartlarini acar gerekli hamleyi yapar, ardindan oyuncuya kapali olarak verilen kart acilir
    // Stay oyuncu elinde olan kartlara razi olur
    // BOOM oyuncunun kartlari 21> olur ise gerceklesir

    // dealerda 4 tane gerceklesebilecek action var
    // BLACKJACK sadece ace ve 10(10, J, Q, K) gelirse olusur ve oyuncuda aynisini yapmadigi surece kesin WIN
    // eger oyuncuda aynisini yaparsa draw oyuncu parasi ellenmez
    // HIT <17 oldugu surece kartlar yapilicak olan action
    // STAY 17>= ve 21= oldugu surece yapilicak olan action
    // BOOM kartlar 21> oldugunda gerceklesen action

    public String Game(){
        boolean play=true;
        String result="";


        while(play) { // ana oyun dongusu oyuncu stand diyene veya patlayana kadar

            Bet bet=new Bet(); //bet olusturuldu
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter your bet: ");
            bet.setBet(sc.nextInt());

            // kart dagitimi
            // sirasi ile oyuncu dealer oyuncu dealer

            DealerHand dealerHand=new DealerHand();
            PlayerHand playerHand=new PlayerHand();

            // Her yeni elde yeni bir 8x52'lik deste olustur
            Deck deck = new Deck();

            // Kart dagitimi: oyuncu, dealer, oyuncu, dealer sirasi ile
            playerHand.addCardPlayer(deck.drawCard());  // oyuncuya 1. kart (acik)
            dealerHand.addCardDealer(deck.drawCard());   // dealer'a 1. kart (kapali)
            playerHand.addCardPlayer(deck.drawCard());  // oyuncuya 2. kart (acik)
            dealerHand.addCardDealer(deck.drawCard());   // dealer'a 2. kart (acik)

            // TODO: Burada BLACKJACK kontrolu yap
            // TODO: Oyuncu action'larini isle (HIT, STAY, SPLIT, DOUBLEDOWN)
            // TODO: Dealer action'larini isle


        }

        return "You Won: ";
    }

    public String Dealer() {

        String  result="";

        return result;
    }

    public String Player() {

        String  result="";

        return result;
    }

}
