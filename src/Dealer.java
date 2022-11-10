import java.util.ArrayList;
import java.util.List;

public class Dealer {

    List<Card> dHand = new ArrayList<>();

    public void firstdraw(List<Card> deckOfCards) {
        dHand.add(deckOfCards.get(0));
        deckOfCards.remove(0);
        dHand.add(deckOfCards.get(0));
        deckOfCards.remove(0);
    }

    public void draw(List<Card> deckOfCards) {
        dHand.add(deckOfCards.get(0));
        deckOfCards.remove(0);
        //System.out.println(dHand);

    }

    public void resetCards() {
        dHand.clear();

    }
}
