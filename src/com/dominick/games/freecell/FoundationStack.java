package com.dominick.games.freecell;

import com.dominick.cards.Card;

import java.util.Stack;

/**
 * Created by Dominick Martelly on 5/21/2017 at 10:23 PM.
 *
 * @author Dominick Martelly
 */
class FoundationStack extends Stack<Card> {

    boolean pushCard(Card item) {
        if (canStack(item)) {
            super.push(item);
            return true;
        }
        return false;
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
