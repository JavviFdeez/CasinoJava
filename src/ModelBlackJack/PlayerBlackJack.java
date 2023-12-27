package ModelBlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Clase que representa un jugador en el juego
public class PlayerBlackJack {
    public String name;  // Nombre del jugador
    private List<CardBlackJack> hand;  // Mano de cartas del jugador
    private int moneyWallet;  // Dinero en la cartera del jugador
    private int score;  // Puntuación de la mano del jugador

    // Constructor que inicializa un jugador con un nombre dado
    public PlayerBlackJack(String name) {
        this.name = name;
        this.hand = new ArrayList<>();  // Inicializa la mano como una nueva lista vacía
        this.moneyWallet = 0;  // Inicializa el dinero en la cartera como 0
        this.score = 0;  // Inicializa la puntuación como 0
    }

    // Métodos getter y setter para el nombre del jugador
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Métodos getter y setter para la mano de cartas del jugador
    public List<CardBlackJack> getHand() {
        return hand;
    }

    // Método para imprimir visualmente la mano del jugador
    public void printHand() {
        for (CardBlackJack cardBlackJack : hand) {
            CardBlackJack.printCard(cardBlackJack);  // Utiliza el método de la clase CardBlackJack para imprimir cada carta
        }
    }

    public void setHand(List<CardBlackJack> hand) {
        this.hand = hand;
    }

    // Métodos getter y setter para el dinero en la cartera del jugador
    public int getMoneyWallet() {
        return moneyWallet;
    }

    public void setMoneyWallet(int moneyWallet) {
        this.moneyWallet = moneyWallet;
    }

    // Método para agregar una carta a la mano del jugador y actualizar la puntuación
    public void addCard(CardBlackJack cardBlackJack) {
        hand.add(cardBlackJack);
        updateScore(cardBlackJack);  // Actualiza la puntuación al agregar una carta
    }

    // Método para restablecer la mano del jugador y la puntuación
    public void resetHand() {
        hand.clear();
        resetScore();  // Reinicia la puntuación al restablecer la mano
    }

    // Método privado para reiniciar la puntuación del jugador
    private void resetScore() {
        score = 0;
    }

    // Método privado para actualizar la puntuación del jugador al agregar una carta
    private void updateScore(CardBlackJack cardBlackJack) {
        score += cardBlackJack.getScore();
        // Lógica adicional según las reglas del Blackjack si es necesario
    }

    // Métodos getter y setter para la puntuación del jugador
    public void setScore(int score) {
        this.score = score;
    }

    // Método para obtener la puntuación actual de la mano del jugador
    public int getScore() {
        int numberOfAces = 0;

        // Contar los Ases en la mano del jugador
        for (CardBlackJack cardBlackJack : hand) {
            if ("Ace".equals(cardBlackJack.getValue())) {
                numberOfAces++;
            }
        }

        int calculatedScore = score;

        // Ajustar el valor de los Ases si es necesario para evitar pasarse de 21
        while (calculatedScore > 21 && numberOfAces > 0) {
            calculatedScore -= 10;
            numberOfAces--;
        }

        return calculatedScore;
    }

    // Método para manejar Ases que valen 11 y cambiarlos a 1 si es necesario para evitar pasarse
    public void handleAcesOver21() {
        for (CardBlackJack cardBlackJack : hand) {
            if ("Ace".equals(cardBlackJack.getValue()) && cardBlackJack.getScore() == 11) {
                setScore(getScore() - 10);
                System.out.println("Cambiando el valor del As a 1 para evitar pasarse.");
            }
        }
    }

    // Métodos equals y toString para comparar jugadores y obtener una representación en cadena
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerBlackJack playerBlackJack = (PlayerBlackJack) o;
        return moneyWallet == playerBlackJack.moneyWallet && Objects.equals(name, playerBlackJack.name) && Objects.equals(hand, playerBlackJack.hand);
    }

    @Override
    public String toString() {
        return "PlayerBlackJack{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                ", moneyWallet=" + moneyWallet +
                '}';
    }
}