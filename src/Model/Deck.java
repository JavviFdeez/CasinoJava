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

    // Método para verificar si el mazo está vacío
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    // Método para extraer una carta del mazo
    public Card drawCard() {
        if (!isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }
}