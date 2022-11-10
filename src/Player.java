import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int bet;
    private int money;


    List<Card> pHand = new ArrayList<>();

    public void draw(List<Card> deckOfCards) {
        pHand.add(deckOfCards.get(0));
        deckOfCards.remove(0);

    }

    public void resetCards(){
        pHand.clear();

    }

    public void firstdraw(List<Card> deckOfCards) {
        pHand.add(deckOfCards.get(0));
        deckOfCards.remove(0);

    }

    public Player(String name, int bet) {

        this.name = name;
        this.bet = bet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
