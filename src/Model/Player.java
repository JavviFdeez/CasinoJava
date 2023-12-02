package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
    private String name;
    private List<Card> hand;
    private int moneyWallet;
    private int score;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.moneyWallet = 0;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public int getMoneyWallet() {
        return moneyWallet;
    }

    public void setMoneyWallet(int moneyWallet) {
        this.moneyWallet = moneyWallet;
    }

    // Agregar una carta a la mano del jugador
    public void addCard(Card card) {
        hand.add(card);
        updateScore(card);  // Actualizar la puntuación al agregar una carta
    }

    // Restablecer la mano del jugador y la puntuación
    public void resetHand() {
        hand.clear();
        resetScore();  // Reiniciar la puntuación al restablecer la mano
    }

    // Reiniciar la puntuación del jugador
    private void resetScore() {
        score = 0;
    }

    // Actualizar la puntuación del jugador al agregar una carta
    private void updateScore(Card card) {
        score += card.getScore();
        // Lógica adicional según las reglas del Blackjack si es necesario
    }

    public void setScore(int score) {
        this.score = score;
    }

    // Obtener el puntaje actual de la mano del jugador
    public int getScore() {
        int numberOfAces = 0;

        for (Card card : hand) {
            // Contar los Ases
            if (card.getValue().equals("Ace")) {
                numberOfAces++;
            }
        }

        int calculatedScore = score;

        // Ajustar el valor de los Ases si es necesario
        while (calculatedScore > 21 && numberOfAces > 0) {
            calculatedScore -= 10;
            numberOfAces--;
        }

        return calculatedScore;
    }

    public void handleAceOver21() {
        for (Card card : hand) {
            if ("Ace".equals(card.getValue()) && card.getScore() == 11) {
                setScore(1);
                System.out.println("Cambiando el valor del As a 1 para evitar pasarse.");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return moneyWallet == player.moneyWallet && Objects.equals(name, player.name) && Objects.equals(hand, player.hand);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                ", moneyWallet=" + moneyWallet +
                '}';
    }
}