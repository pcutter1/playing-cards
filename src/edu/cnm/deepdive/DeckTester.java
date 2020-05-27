package edu.cnm.deepdive;

import java.util.Arrays;

public class DeckTester {

  public static void main(String[] args) {
    Suit[] suits = Suit.values();
    Rank[] ranks = Rank.values();
    Card[] deck = new Card[suits.length * ranks.length];
    int index = 0;
    for (Suit suit : suits) {
      for (Rank rank : ranks) {
        Card c = new Card(suit, rank);
        deck[index] = c;
        index++;
      }
    }
    System.out.println(Arrays.toString(deck));
  }

}
