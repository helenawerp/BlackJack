package no.itverket;

import java.util.ArrayList;
import java.util.List;

public class Person {

  String name;
  int total;
  final List<Card> hand = new ArrayList<>();

  public Person(String name) {
    this.name = name;
  }

  /**
   * Legger til kort på hånden og til totalsummen
   * @param card Kort å legge til
   * @return total
   */
  int addCardToHand(Card card) {
    int rank = card.rank;
    hand.add(card);

    if (card.rank == 14) rank = chooseAceRank(card);
    return total += rank;
  }

  /**
   * Oppgave 3 - Velger om ess skal telle som 14 eller 1 for spilleren
   * @param card Kort
   * @return int 1 eller 2
   */
  int chooseAceRank(Card card) {
    if (total + card.rank > 21) {
      return 1;
    } else return 14;
  }

  // Oppgave 1
  boolean endOfRound() {
    if (total == 21) {
      System.out.printf(name + " total is %s", total);
      return true;
    } else if (total > 21) {
      System.out.printf(name + " round over %n");
      return true;
    } else {
      return false;
    }
  }

  String displayHand() {
    StringBuilder currentHand = new StringBuilder();
    for (Card card : hand) {
    currentHand.append(card.rank).append(" ");
    }

    return currentHand.toString();
  }

  // For tester
  public Person setTotal(int total) {
    this.total = total;
    return this;
  }
}