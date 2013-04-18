package conan;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DeckTest {

    private Deck deck;

    @Before
    public void setUp() {
        deck = new Deck();
    }

    @Test
    public void testShuffle() {
        // Duplicate sorted deck (decks start sorted)
        Stack<Card> testDeck = new Stack<>();
        testDeck.addAll(deck.getDeck());

        // Shuffle
        deck.shuffle();

        // The deck will randomly be shuffled into the same order 1 in 52! times.  Oh well
        assertNotEquals("Shuffled deck shouldn't match unshuffled", testDeck, deck.getDeck());
    }

    @Test
    public void testDrawSingle() {
        // Draw all cards one by one; cards will come out in sorted order, low to high
        int deckSize = 52;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                assertEquals("Unexpected card drawn", new Card(suit, rank), deck.draw(1).get(0));
                assertEquals("Incorrect deck size", --deckSize, deck.getDeck().size());
            }
        }
        assertEquals("Deck was not empty", 0, deck.getDeck().size());
    }

    @Test
    public void testDrawMultiple() {
        // Draw all cards in one go; cards will come out in sorted order, low to high
        List<Card> cards = deck.draw(52);
        int i = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                assertEquals("Unexpected card drawn", new Card(suit, rank), cards.get(i++));
            }
        }
        assertEquals("Deck was not empty", 0, deck.getDeck().size());
    }

    @Test
    public void testDrawSorted() {
        // Shuffle deck
        deck.shuffle();

        // Draw all cards
        List<Card> cards = deck.drawSorted(52);

        // Cards should come out in sorted order, low to high
        int i = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                assertEquals("Unexpected card drawn", new Card(suit, rank), cards.get(i++));
            }
        }
        assertEquals("Deck was not empty", 0, deck.getDeck().size());
    }
}
