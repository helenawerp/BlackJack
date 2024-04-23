package no.itverket;

import org.junit.Test;
import org.junit.Assert;

public class PersonTest {

  Person player = new Person("player");

  @Test
  public void chooseAceRankTest() {
    Card card = new Card(Suit.Clubs, 14);
    player.setTotal(1);
    Assert.assertEquals(player.chooseAceRank(card), 14);
    player.setTotal(20);
    Assert.assertEquals(player.chooseAceRank(card), 1);
  }
}
