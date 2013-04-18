package conan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Deck {

    private Stack<Card> deck = new Stack<>();
    private Comparator<Card> cardComparator = new CardComparator();

    /**
     * Create a new Deck; note that decks of cards come out of the wrapper sorted by suit and then by rank.
     */
    public Deck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(0, new Card(suit, rank));
            }
        }
    }

    public Stack<Card> getDeck() {
        return deck;
    }

    public void setDeck(Stack<Card> deck) {
        this.deck = deck;
    }

    /**
     * Shuffles the deck.
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Draw a number of cards from the deck.  The end result is that the cards returned are removed from the deck.
     * Cards are returned in the same order they were within the deck (i.e. they are all drawn at once, rather than one
     * after another).
     *
     * @param howMany the number of cards to draw
     * @return a list of cards
     */
    public List<Card> draw(int howMany) {
        List<Card> cards = new ArrayList<>(howMany);
        while (cards.size() < howMany) {
            cards.add(deck.pop());
        }
        return cards;
    }

    /**
     * Draw a number of cards from the deck in sorted order.  The end result is that the cards returned are removed from
     * the deck.
     *
     * @param howMany the number of cards to draw
     * @return a list of cards
     */
    public List<Card> drawSorted(int howMany) {
        List<Card> cards = draw(howMany);
        Collections.sort(cards, cardComparator);
        return cards;
    }
}
