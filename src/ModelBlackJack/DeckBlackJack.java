package ModelBlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Clase que representa un mazo de cartas
public class DeckBlackJack {

    private List<CardBlackJack> cardBlackJacks;  // Lista de cartas en el mazo

    // Constructor que inicializa el mazo y lo baraja
    public DeckBlackJack() {
        this.cardBlackJacks = new ArrayList<>();
        initializeDeck();  // Inicializa el mazo con todas las cartas
        shuffle();  // Baraja el mazo al crearlo
    }

    // Método privado para inicializar el mazo con todas las cartas
    private void initializeDeck() {
        for (String suit : new String[]{"♥", "♠", "♦", "♣"}) {
            for (String value : new String[]{"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}) {
                CardBlackJack cardBlackJack = new CardBlackJack(suit, value);  // Crea una nueva carta con palo y valor dados
                cardBlackJacks.add(cardBlackJack);  // Agrega la carta al mazo
            }
        }
    }

    // Método para barajar el mazo
    public void shuffle() {
        Collections.shuffle(cardBlackJacks);  // Utiliza el método de la clase Collections para barajar la lista de cartas
    }

    // Método para verificar si el mazo está vacío
    public boolean isEmpty() {
        return cardBlackJacks.isEmpty();
    }

    // Método para extraer una carta del mazo
    public CardBlackJack drawCard() {
        if (!isEmpty()) {
            return cardBlackJacks.remove(0);  // Extrae la primera carta del mazo
        }
        return null;  // Retorna null si el mazo está vacío
    }
}