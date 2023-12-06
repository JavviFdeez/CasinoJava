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

    // Método para imprimir una carta
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