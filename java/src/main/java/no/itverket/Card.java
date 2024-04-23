package no.itverket;

class Card {
    Suit suit;
    int rank;
    String highRank;

    Card(Suit suit, int rank) {
        this.suit = suit;
        this.rank = rank;
        this.highRank = checkHighRank(rank);
    }

    /**
     * Oppgave 2 - Legger inn J, Q, K, A som en annen måte å displaye bildekort i konsollen.
     * @param rank Rank
     * @return String Forkortelse for bildekortet
     */
    String checkHighRank(int rank) {
        return switch (rank) {
            case 11 -> "J";
            case 12 -> "Q";
            case 13 -> "K";
            case 14 -> "A";
            default -> "";
        };
    }

    /**
     * Brukes til display av rank. I forbindelse med oppgave 2
     */
    String displayRank() {
        if (highRank.isBlank()) return String.valueOf(rank);
        else return highRank;
    }
}
