package Model;

import java.util.Objects;

// Clase que representa una carta de juego
public class Card {
    private String suit;  // Palo de la carta
    private String value; // Valor de la carta

    // Constructor que inicializa una carta con un palo y un valor dados
    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    // Métodos getter y setter para el palo de la carta
    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    // Métodos getter y setter para el valor de la carta
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // Método para obtener el valor numérico de la carta
    public int getScore() {
        if ("J".equals(value) || "Q".equals(value) || "K".equals(value)) {
            return 10;
        } else if ("Ace".equals(value)) {
            return 11;
        } else {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
    }

    // Método para imprimir una representación visual de la carta
    public static void printCard(Card card) {
        String[] cardDesign = {
                "┌──────────────────┐",
                "│ "+ card.getValue()+"           "+ card.getValue() + "    │",
                "│ "+ card.getSuit() +"           "+ card.getSuit() +  "    │",
                "│                  │",
                "│        " + card.getSuit() + "         │",
                "│                  │",
                "│ "+ card.getValue()+"            "+ card.getValue() +"   │",
                "│ "+ card.getSuit() +"            "+ card.getSuit() + "   │",
                "└──────────────────┘"
        };

        for (String line : cardDesign) {
            System.out.println(line);
        }
    }

    // Método equals para comparar si dos cartas son iguales
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(suit, card.suit) && Objects.equals(value, card.value);
    }

    // Método toString para obtener una representación en cadena de la carta
    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}