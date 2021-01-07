package exercise.poker2;

public class Card {

    public String suit;//花色
    public int rank;//点数

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("[%s %d]", suit, rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof exercise.poker.Card)) return false;
        exercise.poker.Card card = (exercise.poker.Card) o;
        return this.rank == card.rank && this.suit.equals(card.suit);
    }

    //只比较点数是否相同
    public boolean equalsRank(Card card) {
        return this.rank == card.rank;
    }
}
