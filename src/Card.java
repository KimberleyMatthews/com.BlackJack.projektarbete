
public class Card {

    private String cardSymbol;
    private String cardValue;


    public String getCardSymbol() {
        return cardSymbol;
    }

    public void setCardSymbol(String cardSymbol) {
        this.cardSymbol = cardSymbol;
    }

    public int getCardValue() {

        int score = switch (cardValue) {
            case "Ace" -> 11;   // TODO - Fix 1 or 11
            case "Jack", "King", "Queen" -> 10;

            default -> Integer.parseInt(cardValue);
        };


        return score;
    }

    public void setCardValue(String cardValue) {
        this.cardValue = cardValue;
    }

        @Override
        public String toString() {
            return  " cardSymbol = '" + cardValue + '\'' +
                    ", cardValue = '" + cardSymbol;
        }
    }

