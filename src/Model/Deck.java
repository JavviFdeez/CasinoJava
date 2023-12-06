package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
        shuffle();
    }

    private void initializeDeck() {
        for (String suit : new String[]{"♥", "♠", "♦", "♣"}) {
            for (String value : new String[]{"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}) {
                Card card = new Card(suit, value);
                cards.add(card);
            }
        }
    }

    // Barajar el mazo
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Extraer una carta del mazo
    public Card drawCard() {
        if (!cards.isEmpty()) {
            Card drawnCard = cards.remove(0);
            return drawnCard;
        }
        return null;
    }
}