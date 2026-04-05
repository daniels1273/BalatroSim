import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        Card card1 = new Card("Jack", "diamonds");
        Card card2 = new Card("10", "diamonds");
        Card card3 = new Card("Queen", "diamonds");
        Card card4 = new Card("9", "clubs");
        Card card5 = new Card("5", "diamonds");
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        Score test = new Score(cards);
    }
}
