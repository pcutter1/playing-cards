package edu.cnm.deepdive;

public class Card {

  private final Suit suit;
  private final Rank rank;

  /**
   * Creates an instance of {@code Card} with the specified {@link Suit} and {@link Rank}.
   *
   * @param suit selected suit.
   * @param rank selected rank.
   */
  public Card(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
  }

  public Suit getSuit() {
    return suit;
  }

  public Rank getRank() {
    return rank;
  }

  @Override
  public String toString() {
    return rank.symbol() + suit.symbol();
  }

}

