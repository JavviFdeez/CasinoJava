package ModelBlackJack;

import java.util.Objects;

// Clase que representa una carta de juego
public class CardBlackJack {
    private String suit;  // Palo de la carta
    private String value; // Valor de la carta

    // Constructor que inicializa una carta con un palo y un valor dados
    public CardBlackJack(String suit, String value) {
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
    public static void printCard(CardBlackJack cardBlackJack) {
        String[] cardDesign = {
                "┌──────────────────┐",
                "│ "+ cardBlackJack.getValue()+"           "+ cardBlackJack.getValue() + "    │",
                "│ "+ cardBlackJack.getSuit() +"           "+ cardBlackJack.getSuit() +  "    │",
                "│                  │",
                "│        " + cardBlackJack.getSuit() + "         │",
                "│                  │",
                "│ "+ cardBlackJack.getValue()+"            "+ cardBlackJack.getValue() +"   │",
                "│ "+ cardBlackJack.getSuit() +"            "+ cardBlackJack.getSuit() + "   │",
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
        CardBlackJack cardBlackJack = (CardBlackJack) o;
        return Objects.equals(suit, cardBlackJack.suit) && Objects.equals(value, cardBlackJack.value);
    }

    // Método toString para obtener una representación en cadena de la carta
    @Override
    public String toString() {
        return "CardBlackJack{" +
                "suit='" + suit + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}