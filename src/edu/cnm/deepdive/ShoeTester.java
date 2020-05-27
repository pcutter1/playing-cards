package edu.cnm.deepdive;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class ShoeTester {

  public static void main(String[] args) {
    Random rng = new SecureRandom();
    Shoe shoe = new Shoe(1);
    System.out.println(Arrays.toString(shoe.getCards()));
    shoe.shuffle(rng);
    System.out.println(Arrays.toString(shoe.getCards()));
  }
}
