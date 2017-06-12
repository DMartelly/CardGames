package com.dominick.games.poker;

import com.dominick.cards.Card;

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
        hand = evaluateCurrentHand();
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

    private Hand evaluateCurrentHand() {
        final int sizeOfHand = cards.size();
        if (sizeOfHand != 5) {
            return null;
        }
        boolean isFlush = hasSameSuit();
        boolean isStraight = hasHighStraight() || hasStraight();
        //Royal Flush
        if (isFlush && hasHighStraight()) {
            return Hand.ROYAL_FLUSH;
        }
        //Straight Flush
        if (isFlush && isStraight) {
            return Hand.STRAIGHT_FLUSH;
        }
        //Four of a kind
        if (ofAKind(cards, 4)) {
            return Hand.FOUR_OF_A_KIND;
        }
        //Flush
        if (isFlush)
            return Hand.FLUSH;

        //Straight
        if (isStraight)
            return Hand.STRAIGHT;

        //Three of a kind
        final boolean hasThreeOfAKind = ofAKind(cards, 3);

        //Two Pair and Full House
        ArrayList<Card> temp = new ArrayList<>(cards);
        boolean onePair = false;
        for (int i = 0; i < sizeOfHand - 1; i++) {
            Card c2 = temp.get(i);
            for (int j = i + 1; j < sizeOfHand; j++) {
                if (c2.getRank() == temp.get(j).getRank()) {
                    if (onePair) {
                        return hasThreeOfAKind ? Hand.FULL_HOUSE : Hand.TWO_PAIR;
                    } else {
                        onePair = true;
                        break;
                    }
                }
            }
        }
        return onePair ? Hand.ONE_PAIR : Hand.HIGH_CARD;
    }

    private boolean ofAKind(Set<Card> cards, int size) {
        if (cards.size() < size) {
            return false;
        }
        if (size > 4 || size < 2)
            return false;
        List<Card> temp = new ArrayList<>(cards);
        Collections.sort(temp);
        for (int i = 0; i < 6 - size; i++) {
            Card first = temp.get(i);
            boolean found = true;
            for (int j = i; j < size + i; j++) {
                if (!temp.get(j).getRank().equals(first.getRank())) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return true;
            }
        }
        return false;
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
