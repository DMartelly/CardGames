package com.dominick.freecell.game;

import com.dominick.freecell.cards.Card;

import java.util.Stack;

/**
 * Created by Dominick Martelly on 4/29/2017 at 12:31 AM.
 *
 * @author Dominick Martelly
 */
class CardStack extends Stack<Card> {

    @Override
    public Card push(Card c) {
        if (!this.isEmpty() || canStack(c))
            super.push(c);
        return c;
    }

    private boolean canStack(Card cardToAdd) {
        Card topCard = this.peek();
        //Check value
        if (cardToAdd.getRank().getValue() + 1 != topCard.getRank().getValue()) {
            return false;
        }
        if (cardToAdd.getSuit().isRed() == topCard.getSuit().isRed()) {
            return false;
        }
        this.peek();
        return true;
    }
}
