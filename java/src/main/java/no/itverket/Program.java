package no.itverket;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Program {
    final static Person player = new Person("player");
    final static Person dealer = new Person("dealer");

    final static Deck deck = new Deck();
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
      System.out.println("The dealer starts the game.");
      // Dealeren starter spillet
      dealerPlaysOne();

      // Spilleren spiller til turen er over
      playerPlaysTurn();
      // Dealer spiller til turen er over
      dealerPlaysTurn();

      checkWinner();
    }

    /**
     * Oppgave 5 - Dealer spiller første kortet
     * I denne funksjonen spiller dealeren et kort
     */
     static void dealerPlaysOne() {
        Card card = deck.cards.remove();
        dealer.addCardToHand(card);

        int rank = card.rank;
        if (card.rank == 14) {
            rank = dealer.chooseAceRank(card);
        }

        System.out.printf("Dealer drew: %s of %s %nDealers current hand: %s%n", rank, card.suit, dealer.displayHand());
    }

    static void checkWinner() {
      if ((dealer.total == player.total) || (player.total > 21 && dealer.total > 21)) {
        System.out.println("Draw");
      }

      if ((dealer.total > player.total ||
        player.total > 21) &&
        dealer.total <= 21) {
        System.out.println("Dealer wins");
      }
      if ((player.total > dealer.total || dealer.total > 21) && player.total <= 21) {
        System.out.println("Player wins");
      }
    }

  /**
   * Spilleren spiller til runden er ferdig
   */
  static void playerPlaysTurn() {
    while (true) {
      System.out.println("Stand, Hit");
      String read = Program.scanner.nextLine().toLowerCase();

      if (read.equals("hit")) {
        Card card = Program.deck.cards.remove();
        player.addCardToHand(card);
        System.out.printf("Hit with %s of %s. Total is %s%n", card.displayRank(), card.suit, player.total);

        if (player.endOfRound()) {
          break;
        }
      } else if (read.equals("stand")) {
        System.out.println("Game ended for " + player.name);
        break;
      }
    }
  }

  /**
   * Oppgave 5 - Dealer spiller automatisk frem til 17 eller mer totalt
   */
  static void dealerPlaysTurn() throws InterruptedException {
    while (dealer.total < 17) {
      sleep(3000);
      Card card= Program.deck.cards.remove();
      dealer.addCardToHand(card);
      System.out.printf("Dealer drew %s of %s. Total is %s%n", card.displayRank(), card.suit, dealer.total);
    }
  }
}