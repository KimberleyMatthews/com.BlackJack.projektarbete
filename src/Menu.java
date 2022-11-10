
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    Player player;          // <-- NULL
    Dealer dealer;          // <-- NULL
    List<Card> deckOfCards; // <-- NULL

    int pSum = 0;
    int dSum = 0;

    private int playersMoney = 500;

    // Constructor

    public Menu(Player player, Dealer dealer, List<Card> deckOfCards) {
        this.player = player;           // <-- Player is no longer NULL
        this.dealer = dealer;           // <-- Dealer is no longer NULL
        this.deckOfCards = deckOfCards; // <-- deckOfCards is no longer NULL

    }

    public void mainMenu() {

        boolean isPlaying = true;

            System.out.println("Hello and welcome to BlackJack, please enter your name");
            player.setName(scanner.next());

            System.out.println("You've got " + playersMoney + " $ to spend");
            System.out.println("Please place your bet bellow (between 2-500$)");
            player.setBet(scanner.nextInt());
            playersMoney -= player.getBet();
            System.out.println(playersMoney);
            System.out.println("bet" + player.getBet());

            System.out.println(player.getName() + ", please choose one of the following options");


        do {
            if (playersMoney < 1) {
                isPlaying = false;
                System.out.println("You are out of money " +
                                    "/n Game over");
            }

            System.out.println(""" 
                    1 - Start game\s
                    2 - Exit game \s
                    """);

            switch (scanner.next()) {
                case "1" -> menuStartGame();
                case "2" -> isPlaying = false;

                default -> System.out.println("Error");

            }
        } while (isPlaying);


    }

    public void menuStartGame() {

        boolean isPlaying = true;

        player.resetCards();
        dealer.resetCards();
        pSum = 0;
        dSum = 0;

        Collections.shuffle(deckOfCards); // Shuffle

        player.firstdraw(deckOfCards);    // Draw card
        player.firstdraw(deckOfCards);
        System.out.println(player.getName() + " you got - " + player.pHand);
        for (int i = 0; i < player.pHand.size(); i++) {
            pSum += player.pHand.get(i).getCardValue();

        }
        System.out.println(pSum);

        dealer.firstdraw(deckOfCards);    // Draw card
        System.out.println("The dealer got - " + dealer.dHand);
        for (int i = 0; i < dealer.dHand.size(); i++) {
            dSum += dealer.dHand.get(i).getCardValue();
        }
        System.out.println(dSum);

        pCheckBlackjack();
        dCheckBlackjack();

        System.out.println((""" 
                1 - Draw card \s
                2 - Stay \s
                """));

        do {

        switch (scanner.next()) {
            case "1" -> {

                player.draw(deckOfCards); // Players draw
                System.out.println(player.getName() + " you got - " + player.pHand);
                pSum += player.pHand.get(player.pHand.size() - 1).getCardValue();
                System.out.println(pSum);

                if (pSum > 21) {

                    System.out.println("Sorry the Dealer got 21, YOU LOST " + player.getBet());
                    System.out.println((""" 
                    1 - Yes \s
                    2 - No \s
                    """));

                    isPlaying = false;
                    menuStartGame();

                }

                pCheckBlackjack();


            }
            case "2" -> {
                System.out.println("Stay");
                dealer.draw(deckOfCards);
                System.out.println("The dealer got - " + dealer.dHand);
                dSum += dealer.dHand.get(dealer.dHand.size() - 1).getCardValue();
                System.out.println(dSum);
                isPlaying = false;

                dCheckBlackjack();
            }

        }

        } while(isPlaying);
        System.out.println("The game is over");
    }

    public void pCheckBlackjack() {

        if (pSum == 21) {

            System.out.println("Congratz you got Blackjack! " + 2* player.getBet());
            playersMoney += (2* player.getBet());

            menuStartGame();

        } else if (pSum > 21) {

            System.out.println("Sorry the Dealer got 21, YOU LOST " + player.getBet());

            System.out.println((""" 
                    1 - Yes \s
                    2 - No \s
                    """));

            menuStartGame();
        }

    }

    public void dCheckBlackjack() {

            if (dSum == 21) {

                System.out.println("Sorry the Dealer got 21, YOU LOST " + player.getBet());

                System.out.println("Want to try again?");
                System.out.println((""" 
                    1 - Yes \s
                    2 - No \s
                    """));

                menuStartGame();

            } else if (dSum > 21) {

                System.out.println("The Dealer got over 21, YOU WON! " + player.getBet() );

                System.out.println("Want to go again?");
                System.out.println((""" 
                    1 - Yes \s
                    2 - No \s
                    """));

                menuStartGame();
            }
        }
    }
