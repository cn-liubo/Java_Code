package exercise.poker2;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public List<Card> cardList = new ArrayList<exercise.poker2.Card>();
    public String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "cardList=" + cardList +
                ", name='" + name + '\'' +
                '}';
    }
}
