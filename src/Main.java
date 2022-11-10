import java.util.Collections;
import java.util.List;
import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {

            Deck deckTemplate = new Deck();
            Player player = new Player("", 0); // DRY
            Dealer dealer = new Dealer();

            List<Card> deckOfCards = deckTemplate.generateDeck(); // Sorted by default
            Menu menu = new Menu(player, dealer, deckOfCards);

            /* player.draw(deckOfCards);             // Draw card
               System.out.println(deckOfCards);     // ALL CARDS IN DECK
               System.out.println(player.pHand);    // Show drawn card
               System.out.println(deckOfCards);     // AFTER DRAW ALL CARDS IN DECK
            */

            menu.mainMenu(); // Starts BlackJack

        }
    }
