import java.util.ArrayList;
import java.util.List;

public class CardDeck<T extends Card> {

    private ArrayList<T> cards;
    private int dealtIndex = 0;

    public void setDeckOfCards(ArrayList<T> deckOfCards) {
        this.cards = deckOfCards;
    }

    public void shuffle() {

        for (int i = 0; i < cards.size(); i++) {
            int j = AssortedMethods.randonInRange(i, cards.size() - 1 - i);
            T card1 = cards.get(i);
            T card2 = cards.get(j);
            cards.set(i, card2);
            cards.set(j, card1);
        }
    }

    public int remainingCard() {
        return cards.size() - dealtIndex;
    }

    public T dealCard() {
        if (remainingCard() == 0) {
            return null;
        }
        T card = cards.get(dealtIndex);
        dealtIndex++;
        return card;
    }


}
