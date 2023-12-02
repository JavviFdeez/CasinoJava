package Model;

import java.util.List;
import java.util.Objects;

public class Game {
    private List<Player> players;

    public Game(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(players, game.players);
    }

    @Override
    public String toString() {
        return "Game{" +
                "players=" + players +
                '}';
    }
}