package com.dominick.freecell.cards;

/**
 * Created by Dominick Martelly on 4/28/2017 at 10:54 PM.
 *
 * @author Dominick Martelly
 */
public class Card {
    private Suit suit;
    private Rank rank;

    Card(char rank, char suit) {
        switch (rank) {
            case '0':
                this.rank = Rank.ACE;
            case '1':
                this.rank = Rank.ONE;
            case '2':
                this.rank = Rank.TWO;
            case '3':
                this.rank = Rank.THREE;
            case '4':
                this.rank = Rank.FOUR;
            case '5':
                this.rank = Rank.FIVE;
            case '6':
                this.rank = Rank.SIX;
            case '7':
                this.rank = Rank.SEVEN;
            case '8':
                this.rank = Rank.EIGHT;
            case '9':
                this.rank = Rank.NINE;
            case 't':
            case 'T':
                this.rank = Rank.TEN;
            case 'j':
            case 'J':
                this.rank = Rank.JACK;
            case 'q':
            case 'Q':
                this.rank = Rank.QUEEN;
            case 'k':
            case 'K':
                this.rank = Rank.KING;
            case 'a':
            case 'A':
                this.rank = Rank.ACE;
        }

        switch (suit) {
            case 'h':
                this.suit = Suit.HEART;
            case 'd':
                this.suit = Suit.DIAMOND;
            case 's':
                this.suit = Suit.SPADE;
            case 'c':
                this.suit = Suit.CLUBS;
        }
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return this.getRank().toString() + "" + this.getSuit().toString();
    }
}
