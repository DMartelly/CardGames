package com.dominick.cards;

/**
 * Created by Dominick Martelly on 4/28/2017 at 10:54 PM.
 *
 * @author Dominick Martelly
 */
public class Card implements Comparable<Card> {
    private Suit suit;
    private Rank rank;

    public Card(int rank, int suit) {
        switch (rank) {
            case 0:
                this.rank = Rank.ACE;
                break;
            case 1:
                this.rank = Rank.ONE;
                break;
            case 2:
                this.rank = Rank.TWO;
                break;
            case 3:
                this.rank = Rank.THREE;
                break;
            case 4:
                this.rank = Rank.FOUR;
                break;
            case 5:
                this.rank = Rank.FIVE;
                break;
            case 6:
                this.rank = Rank.SIX;
                break;
            case 7:
                this.rank = Rank.SEVEN;
                break;
            case 8:
                this.rank = Rank.EIGHT;
                break;
            case 9:
                this.rank = Rank.NINE;
                break;
            case 10:
                this.rank = Rank.TEN;
                break;
            case 11:
                this.rank = Rank.JACK;
                break;
            case 12:
                this.rank = Rank.QUEEN;
                break;
            case 13:
                this.rank = Rank.KING;
        }

        switch (suit) {
            case 0:
                this.suit = Suit.CLUBS;
                break;
            case 1:
                this.suit = Suit.DIAMOND;
                break;
            case 2:
                this.suit = Suit.HEART;
                break;
            case 3:
                this.suit = Suit.SPADE;
        }
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }


    @Override
    public int hashCode() {
        return this.getRank().getValue() + this.getSuit().ordinal() * 15;
    }

    @Override
    public String toString() {
        return this.getRank().toString() + "" + this.getSuit().toString();
    }

    @Override
    public int compareTo(Card card) {
        if (this.getRank() == card.getRank()) {
            return this.getSuit().compareTo(card.getSuit());
        } else return this.getRank().compareTo(card.getRank());
    }
}
