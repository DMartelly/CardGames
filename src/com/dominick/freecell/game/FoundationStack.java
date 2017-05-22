package com.dominick.freecell.game;

import com.dominick.freecell.cards.Card;

import java.util.Stack;

/**
 * Created by Dominick Martelly on 5/21/2017 at 10:23 PM.
 *
 * @author Dominick Martelly
 */
class FoundationStack extends Stack<Card> {

    @Override
    public Card push(Card item) {
        if (canStack(item))
            return super.push(item);
        return item;
    }

    private boolean canStack(Card cardToAdd) {
        //Check value
        if (this.isEmpty()) {
            if (cardToAdd.getRank().getValue() == 0) {
                return true;
            }
        } else {
            Card topCard = this.peek();
            if (cardToAdd.getSuit().equals(topCard.getSuit()) &&
                    cardToAdd.getRank().getValue() - 1 == topCard.getRank().getValue()) {
                return true;
            }
        }
        return false;
    }
}
