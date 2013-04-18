#Specification

Please write a representation of a deck of cards.

The Deck class should contain three public methods:

    // shuffles the deck  
    public void shuffle();
    
    // draw a number of cards from the deck.  The end result is that the cards returned are removed from the deck.  
    public List<Card> draw(int howMany);
    
    // draw a number of cards from the deck in sorted order.  The end result is that the cards returned are removed 
    // from the deck.  
    public List<Card> drawSorted(int howMany);

* Cards should be first sorted by suit and then by face value (where aces are always high).
* Please include unit tests. Using Maven for dependency management would yield some Brownie points!
* Please package all relevant source, libraries and configuration and send this back to us.


# Notes

* There is no support for jokers
* A better data structure for a deck would be a Deque, but the functionality it adds was not required by the spec
