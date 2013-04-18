package conan;

import java.util.Comparator;

/**
 * Compares {@link Card}s first by {@link Suit} and then by {@link Rank}.
 */
public class CardComparator implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
        if (card1 == null || card2 == null) {
            throw new NullPointerException();
        }

        if (card1.getSuit() != card2.getSuit()) {
            return card1.getSuit().compareTo(card2.getSuit());
        } else {
            return card1.getRank().compareTo(card2.getRank());
        }
    }
}
