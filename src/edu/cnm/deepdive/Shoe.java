package edu.cnm.deepdive;

import java.util.Arrays;
import java.util.Random;

public class Shoe {

  private final Card[] cards;

  public Shoe(int decks) {
    int deckSize = Suit.values().length * Rank.values().length;
    cards = new Card[decks * deckSize];
    for (int i = 0; i < decks; i++) {
      Deck d = new Deck();
      System.arraycopy(d.getCards(), 0, cards, i * deckSize, deckSize);
      }
  }


  public Card[] getCards() {
    return Arrays.copyOf(cards, cards.length);
  }

  public void shuffle(Random rng) {
    for (int targetIndex = cards.length - 1; targetIndex > 0; targetIndex--) {
      int sourceIndex = rng.nextInt(targetIndex + 1);
      Card temp = cards[targetIndex];
      cards[targetIndex] = cards[sourceIndex];
      cards[sourceIndex] = temp;
    }
  }

}


