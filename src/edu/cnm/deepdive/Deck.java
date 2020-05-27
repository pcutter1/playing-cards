package edu.cnm.deepdive;

import java.util.Arrays;

public class Deck {

  private final Card[] cards;

  public Deck() {
    Suit[] suits = Suit.values();
    Rank[] ranks = Rank.values();
    cards = new Card[suits.length * ranks.length];
    int index = 0;
    for (Suit suit : suits) {
      for (Rank rank : ranks) {
        Card c = new Card(suit, rank);
        cards[index] = c;
        index++;
      }
    }
  }

  public Card[] getCards() {
    return Arrays.copyOf(cards, cards.length);
  }

}
