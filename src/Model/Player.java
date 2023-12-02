package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
        private String name;
        private List<Card> hand;
        private int score;

        public Player(String name) {
            this.name = name;
            this.hand = new ArrayList<>();
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return score == player.score && Objects.equals(name, player.name) && Objects.equals(hand, player.hand);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                ", score=" + score +
                '}';
    }
}


