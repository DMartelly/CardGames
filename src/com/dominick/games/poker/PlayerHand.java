package com.dominick.games.poker;

import com.dominick.cards.Card;

import java.util.ArrayList;

/**
 * Created by Dominick on 6/7/2017.
 *
 * @author Dominick
 */
public class PlayerHand {
    ArrayList<Card> cards;
    boolean redraw;
    Hand hand;


    public PlayerHand(ArrayList<Card> cards) {
        this.cards = cards;
        redraw = false;
        evaluateCurrentHand();
    }

    public PlayerHand(Card c1, Card c2, Card c3, Card c4, Card c5) {
        cards = new ArrayList<>(5);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        redraw = false;
    }

    private void evaluateCurrentHand() {
        if (cards.size() != 5) {
            return;
        }
    }
}
