package ModelBlackJack;

import java.util.List;
import java.util.Objects;

// Clase que representa una partida de juego
public class GameBlackJack {
    private List<PlayerBlackJack> playerBlackJacks;  // Lista de jugadores en la partida
    private DeckBlackJack deckBlackJack;  // Mazo asociado a la partida

    // Constructor que inicializa una partida con una lista de jugadores
    public GameBlackJack(List<PlayerBlackJack> playerBlackJacks) {
        this.deckBlackJack = new DeckBlackJack();  // Inicializa el mazo asociado a la partida
        this.playerBlackJacks = playerBlackJacks;  // Asigna la lista de jugadores
    }

    // Métodos getter y setter para la lista de jugadores
    public List<PlayerBlackJack> getPlayers() {
        return playerBlackJacks;
    }

    public void setPlayers(List<PlayerBlackJack> playerBlackJacks) {
        this.playerBlackJacks = playerBlackJacks;
    }

    // Métodos getter y setter para el mazo asociado a la partida
    public DeckBlackJack getDeck() {
        return deckBlackJack;
    }

    public void setDeck(DeckBlackJack deckBlackJack) {
        this.deckBlackJack = deckBlackJack;
    }

    // Método equals para comparar si dos partidas son iguales
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameBlackJack gameBlackJack = (GameBlackJack) o;
        return Objects.equals(playerBlackJacks, gameBlackJack.playerBlackJacks) && Objects.equals(deckBlackJack, gameBlackJack.deckBlackJack);
    }

    // Método toString para obtener una representación en cadena de la partida
    @Override
    public String toString() {
        return "GameBlackJack{" +
                "playerBlackJacks=" + playerBlackJacks +
                ", deckBlackJack=" + deckBlackJack +
                '}';
    }
}