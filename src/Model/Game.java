package Model;

import java.util.List;
import java.util.Objects;

// Clase que representa una partida de juego
public class Game {
    private List<Player> players;  // Lista de jugadores en la partida
    private Deck deck;  // Mazo asociado a la partida

    // Constructor que inicializa una partida con una lista de jugadores
    public Game(List<Player> players) {
        this.deck = new Deck();  // Inicializa el mazo asociado a la partida
        this.players = players;  // Asigna la lista de jugadores
    }

    // Métodos getter y setter para la lista de jugadores
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    // Métodos getter y setter para el mazo asociado a la partida
    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    // Método equals para comparar si dos partidas son iguales
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(players, game.players) && Objects.equals(deck, game.deck);
    }

    // Método toString para obtener una representación en cadena de la partida
    @Override
    public String toString() {
        return "Game{" +
                "players=" + players +
                ", deck=" + deck +
                '}';
    }
}