package Model;

import java.util.Objects;

public class Card {
    private String suit;  // Palo
    private String value; // Valor

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // Obtener el valor numérico de la carta
    public int getScore() {
        if (value.equals("J") || value.equals("Q") || value.equals("K")) {
            return 10;
        } else if (value.equals("Ace")) {
            return 11;
        } else {
            return Integer.parseInt(value);
        }
    }
    // Método para imprimir una carta
    public static void printCard(Card card) {
        System.out.println("Tus 2 cartas asignadas: ");
        String[] cardDesign = {
                "┌─────────────────┐",
                "│                 │",
                "│        " + card.getSuit() + "        │",
                "│                 │",
                "│                 │",
                "│       " + card.getValue() + "        │",
                "│                 │",
                "└─────────────────┘"
        };

        for (String line : cardDesign) {
            System.out.println(line);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(suit, card.suit) && Objects.equals(value, card.value);
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}