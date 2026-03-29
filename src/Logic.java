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
        Balance account=new Balance();

        while(play) { // ana oyun dongusu oyuncu stand diyene veya patlayana kadar

            Balance bet = new Balance(); //bet olusturuldu
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your bet: ");
            bet.setBet(sc.nextInt());

            // kart dagitimi
            // sirasi ile oyuncu dealer oyuncu dealer

            DealerHand dealerHand = new DealerHand();
            PlayerHand playerHand = new PlayerHand();

            // Her yeni elde yeni bir 8x52'lik deste olustur
            Deck deck = new Deck();

            // Kart dagitimi: oyuncu, dealer, oyuncu, dealer sirasi ile
            playerHand.addCardPlayer(deck.drawCard());  // oyuncuya 1. kart (acik)
            dealerHand.addCardDealer(deck.drawCard());   // dealer'a 1. kart (kapali)
            playerHand.addCardPlayer(deck.drawCard());  // oyuncuya 2. kart (acik)
            dealerHand.addCardDealer(deck.drawCard());   // dealer'a 2. kart (acik)

            // BLACKJACK kontrolu
            // Oyuncunun ve dealer'in ilk 2 kartinin toplamini hesapla
            int playerTotal = playerHand.getPlayerHand().get(0).getValue() + playerHand.getPlayerHand().get(1).getValue();
            int dealerTotal = dealerHand.getHandDealer().get(0).getValue() + dealerHand.getHandDealer().get(1).getValue();

            boolean playerBlackjack = (playerTotal == 21);
            boolean dealerBlackjack = (dealerTotal == 21);

            if (playerBlackjack && dealerBlackjack) {
                result = "Draw! Both have Blackjack.";
                bet.setBet(0);
                play = false;
                break;
            } else if (playerBlackjack) {
                // sadece oyuncu blackjack -> oyuncu kazanir (1.5x bet)
                result = "BLACKJACK! Player wins!";
                double temp = bet.getBet();
                temp *= 1.5;
                bet.setBet(0);
                account.setAccount(account.getAccount() + temp); // betin 1.5x kati accounta eklenir
                play = false;
                break;
            } else if (dealerBlackjack) {
                // sadece dealer blackjack -> dealer kazanir
                result = "Dealer has BLACKJACK! Dealer wins.";
                account.setAccount(account.getAccount() - bet.getBet()); // bet account'tan dusurulur
                bet.setBet(0);
                play = false;
                break;
            }

            // ===== OYUNCU ACTION'LARI =====
            boolean playerTurn = true;
            boolean doubled = false;

            while (playerTurn) {
                playerTotal = playerHand.getTotal();

                // BOOM kontrolu
                if (playerTotal > 21) {
                    result = "BOOM! Player busts. Dealer wins.";
                    account.setAccount(account.getAccount() - bet.getBet());
                    bet.setBet(0);
                    break;
                }

                // Oyuncuya secenekleri goster
                System.out.println("\nYour hand: ");
                for (Cards c : playerHand.getPlayerHand()) {
                    System.out.print(c.getNumber() + " of " + c.getSymbol() + " | ");
                }
                System.out.println("\nYour total: " + playerTotal);
                System.out.println("Dealer's visible card: " + dealerHand.getHandDealer().get(1).getNumber()
                        + " of " + dealerHand.getHandDealer().get(1).getSymbol());

                System.out.println("\nChoose action:");
                System.out.println("1 - HIT");
                System.out.println("2 - STAY");
                if (playerHand.getPlayerHand().size() == 2) {
                    System.out.println("3 - DOUBLE DOWN");
                    // SPLIT sadece pair ise
                    if (playerHand.getPlayerHand().get(0).getNumber().equals(
                            playerHand.getPlayerHand().get(1).getNumber())) {
                        System.out.println("4 - SPLIT");
                    }
                }

                int choice = sc.nextInt();

                if (choice == 1) {
                    // HIT - yeni kart al
                    playerHand.addCardPlayer(deck.drawCard());
                } else if (choice == 2) {
                    // STAY - elini koru
                    playerTurn = false;
                } else if (choice == 3 && playerHand.getPlayerHand().size() == 2) {
                    // DOUBLE DOWN - bet 2x, tek kart al, tur biter
                    bet.setBet(bet.getBet() * 2);
                    playerHand.addCardPlayer(deck.drawCard());
                    doubled = true;
                    System.out.println("Double Down! You got: "
                            + playerHand.getPlayerHand().get(playerHand.getPlayerHand().size() - 1).getNumber()
                            + " of " + playerHand.getPlayerHand().get(playerHand.getPlayerHand().size() - 1).getSymbol());
                    playerTurn = false;
                }
                // TODO: SPLIT action'ini daha sonra implement edebilirsin
            }

            // Oyuncu bust olduysa dealer oynamaz
            playerTotal = playerHand.getTotal();
            if (playerTotal > 21) {
                continue; // sonraki ele gec
            }

            // ===== DEALER ACTION'LARI =====
            // Dealer kapali kartini acar
            System.out.println("\n--- Dealer's Turn ---");
            System.out.println("Dealer reveals: " + dealerHand.getHandDealer().get(0).getNumber()
                    + " of " + dealerHand.getHandDealer().get(0).getSymbol());

            dealerTotal = dealerHand.getTotal();

            // Dealer 17'den kucukse kart cekmek ZORUNDA
            while (dealerTotal < 17) {
                dealerHand.addCardDealer(deck.drawCard());
                dealerTotal = dealerHand.getTotal();
                System.out.println("Dealer hits: " + dealerHand.getHandDealer().get(dealerHand.getHandDealer().size() - 1).getNumber()
                        + " of " + dealerHand.getHandDealer().get(dealerHand.getHandDealer().size() - 1).getSymbol());
            }

            System.out.println("Dealer total: " + dealerTotal);

            // ===== SONUCLARI KARSILASTIR =====
            if (dealerTotal > 21) {
                // Dealer BOOM
                result = "Dealer busts! Player wins!";
                account.setAccount(account.getAccount() + bet.getBet());
            } else if (playerTotal > dealerTotal) {
                // Oyuncu kazanir
                result = "Player wins! " + playerTotal + " vs " + dealerTotal;
                account.setAccount(account.getAccount() + bet.getBet());
            } else if (dealerTotal > playerTotal) {
                // Dealer kazanir
                result = "Dealer wins! " + dealerTotal + " vs " + playerTotal;
                account.setAccount(account.getAccount() - bet.getBet());
            } else {
                // Draw - push
                result = "Push! Both have " + playerTotal;
            }

            bet.setBet(0);
            System.out.println("\n>>> " + result);
            System.out.println("Account balance: " + account.getAccount());

            // Tekrar oynamak istiyor mu?
            System.out.println("\nPlay again? (1 = Yes, 0 = No)");
            int again = sc.nextInt();
            if (again == 0) {
                play = false;
            }

        }
        return "You Won: ";
    }

}
