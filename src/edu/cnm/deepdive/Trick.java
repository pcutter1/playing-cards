package edu.cnm.deepdive;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Trick {

  private static final String PILE_REPORT_FORMAT =
      "%1$s pile contents: %2$s; %1$s card count: %3$d.%n";
  private final Random rng;

  private Deque<Card> redPile;
  private Deque<Card> blackPile;

  public Trick () {
   rng = new SecureRandom();
  }

  private void organize() {
    Deck deck = new Deck();
    List<Card> cards = new ArrayList<>();
    Collections.addAll(cards, deck.getCards());
    Collections.shuffle(cards, rng);
    redPile = new LinkedList<>();
    blackPile = new LinkedList<>();
    while (!cards.isEmpty()) {
      Card selector = cards.remove(0);
      if (selector.getSuit().getColor() == Color.RED) {
        redPile.add(cards.remove(0));
      } else {
        blackPile.add((cards.remove(0)));
      }
    }
  }

  private void swap() {
    Collections.shuffle((List<Card>) redPile, rng);
    Collections.shuffle((List<Card>) blackPile, rng);
    int limit = Math.min(redPile.size(), blackPile.size());
    int swapSize = rng.nextInt(limit + 1);
    for (int i = 0; i < swapSize; i++) {
      blackPile.offerLast(redPile.pollFirst());
      redPile.offerLast(blackPile.pollFirst());
    }
  }

  private void report() {
    Collections.sort((List<Card>) redPile,
        Comparator.comparing((Card card) -> card.getSuit().getColor())
        .thenComparing(Comparator.naturalOrder()));
    Collections.sort((List<Card>) blackPile,
        Comparator.comparing((Card card) -> card.getSuit().getColor())
            .reversed()
            .thenComparing(Comparator.naturalOrder()));
    int redCount = 0;
    int blackCount = 0;
    for (Card card : redPile) {
      if (card.getSuit().getColor() == Color.RED) {
        redCount++;
      }
    }
    for (Card card : blackPile) {
      if (card.getSuit().getColor() == Color.BLACK) {
        blackCount++;
      }
    }
    System.out.printf(PILE_REPORT_FORMAT, Color.RED, redPile, redCount);
    System.out.printf(PILE_REPORT_FORMAT, Color.BLACK, blackPile, blackCount);
  }

  public static void main(String[] args) {
    Trick trick = new Trick();
    trick.organize();
    trick.swap();
    trick.report();
  }

}
