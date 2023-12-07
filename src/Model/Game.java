package Model;

import java.util.List;
import java.util.Objects;

public class Game {
    private List<Player> players;
    private Deck deck;

    public Game(List<Player> players) {
        this.deck = new Deck();
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    // Este método reinicia el mazo
    public void resetDeck() {
        this.deck = new Deck();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(players, game.players) && Objects.equals(deck, game.deck);
    }

    @Override
    public String toString() {
        return "Game{" +
                "players=" + players +
                ", deck=" + deck +
                '}';
    }
}