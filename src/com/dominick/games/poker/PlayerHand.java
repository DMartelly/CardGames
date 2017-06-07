package com.dominick.games.poker;

import com.dominick.cards.Card;
import com.dominick.cards.Rank;
import com.dominick.cards.Suit;

import java.util.*;

/**
 * Created by Dominick on 6/7/2017.
 *
 * @author Dominick
 */
public class PlayerHand {
    private Set<Card> cards;
    private boolean canRedraw;
    private Hand hand;


    PlayerHand(Set<Card> cards) {
        this.cards = cards;
        canRedraw = true;
        evaluateCurrentHand();
    }

    public PlayerHand(Card c1, Card c2, Card c3, Card c4, Card c5) {
        cards = new HashSet<>(5);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        canRedraw = true;
    }

    private void evaluateCurrentHand() {
        if (cards.size() != 5) {
            return;
        }
        boolean isFlush = hasSameSuit();
        boolean isStraight = hasHighStraight() || hasStraight();
        //Royal Flush
        if (isFlush && hasHighStraight()) {
            hand = Hand.ROYAL_FLUSH;
            return;
        }
        //Straight Flush
        if (isFlush && isStraight) {
            hand = Hand.STRAIGHT_FLUSH;
            return;
        }
        //Four of a kind
        Iterator<Card> itr = cards.iterator();
        Rank firstCardRank = itr.next().getRank();
        Rank secondCardRank = itr.next().getRank();
        for (int i = 0; i < Suit.values().length; i++) {
            if (!cards.contains(new Card(firstCardRank.getValue(), i))) {
                break;
            }
            if (i == Suit.values().length - 1) {
                hand = Hand.FOUR_OF_A_KIND;
                return;
            }
        }
        for (int i = 0; i < Suit.values().length; i++) {
            if (!cards.contains(new Card(secondCardRank.getValue(), i))) {
                break;
            }
            if (i == Suit.values().length - 1) {
                hand = Hand.FOUR_OF_A_KIND;
                return;
            }
        }
        hand = Hand.HIGH_CARD;
    }

    private boolean hasHighStraight() {
        return containsRank(0) && containsRank(13) && containsRank(12) &&
                containsRank(11) && containsRank(10);
    }

    private boolean containsRank(int rank) {
        for (int i = 0; i < 4; i++) {
            final Card temp = new Card(rank, i);
            if (cards.contains(temp)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasStraight() {
        List<Card> temp = new ArrayList<>(cards);
        Collections.sort(temp);
        int num = temp.get(0).getRank().getValue();
        for (int i = 1; i < temp.size(); i++) {
            if (++num != temp.get(i).getRank().getValue())
                return false;
        }
        return true;
    }

    private boolean hasSameSuit() {
        final Iterator<Card> itr = cards.iterator();
        Card c1 = itr.next();
        while (itr.hasNext()) {
            if (c1.getSuit() != itr.next().getSuit()) {
                return false;
            }
        }
        return true;
    }

    public boolean canRedraw() {
        return canRedraw;
    }

    Hand getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return hand.toString();
    }
}
