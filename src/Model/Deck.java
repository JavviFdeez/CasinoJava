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
        for (String suit : new String[]{"Hearts", "Spades", "Diamonds", "Clubs"}) {
            for (String value : new String[]{"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}) {
                Card card = new Card(suit, value);
                cards.add(card);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawLetter() {
        if (!cards.isEmpty()) {
            Card drawnLetter = cards.remove(0);
            return drawnLetter;
        }
        return null;
    }
}