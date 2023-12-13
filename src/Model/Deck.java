package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Clase que representa un mazo de cartas
public class Deck {

    private List<Card> cards;  // Lista de cartas en el mazo

    // Constructor que inicializa el mazo y lo baraja
    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();  // Inicializa el mazo con todas las cartas
        shuffle();  // Baraja el mazo al crearlo
    }

    // Método privado para inicializar el mazo con todas las cartas
    private void initializeDeck() {
        for (String suit : new String[]{"♥", "♠", "♦", "♣"}) {
            for (String value : new String[]{"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}) {
                Card card = new Card(suit, value);  // Crea una nueva carta con palo y valor dados
                cards.add(card);  // Agrega la carta al mazo
            }
        }
    }

    // Método para barajar el mazo
    public void shuffle() {
        Collections.shuffle(cards);  // Utiliza el método de la clase Collections para barajar la lista de cartas
    }

    // Método para verificar si el mazo está vacío
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    // Método para extraer una carta del mazo
    public Card drawCard() {
        if (!isEmpty()) {
            return cards.remove(0);  // Extrae la primera carta del mazo
        }
        return null;  // Retorna null si el mazo está vacío
    }
}