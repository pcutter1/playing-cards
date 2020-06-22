package edu.cnm.deepdive;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class ShoeTester {

  public static void main(String[] args) {
    Random rng = new SecureRandom();
    Shoe shoe = new Shoe(1);
    System.out.println(Arrays.toString(shoe.getCards()));
    shoe.shuffle(rng);
    System.out.println(Arrays.toString(shoe.getCards()));
    shoe.sort();
    System.out.println(Arrays.toString(shoe.getCards()));
    shoe.sort(new Comparator<Card>() {
      @Override
      public int compare(Card c1, Card c2) {
        int comparison = c1.getSuit().compareTo(c2.getSuit());
        if (comparison == 0) {
          comparison = c1.getRank().compareTo(c2.getRank());
          if (comparison != 0) {
            if (c1.getRank().equals(Rank.ACE)) {
              comparison = 1;
            } else if (c2.getRank().equals(Rank.ACE)) {
              comparison = -1;
            }
          }
        }
        return comparison;
      }
    });
    System.out.println(Arrays.toString(shoe.getCards()));
  }

}
