package no.itverket;

import java.util.*;

class Deck {
    Queue<Card> cards = new ArrayDeque<>();

    // Creates a new Deck & for each suit placing in a card with each value 1-13
    Deck() {
        for (Suit suit : Suit.values()) {
            for (int i = 1; i < 14; i++) {
                cards.offer(new Card(suit, i));
            }
        }
        shuffleDeck(cards);
    }

    /**
     * Stokker bunken på begynnelsen av hvert spill
     * @param deck Deck
     * @return Stokket bunke
     */
     void shuffleDeck(Queue<Card> deck) {
        List<Card> shuffledDeck = new ArrayList<>(deck);
        Collections.shuffle(shuffledDeck);
        cards = new ArrayDeque<>(shuffledDeck);
    }
}
