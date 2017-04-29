package com.dominick.freecell.cards;

/**
 * Created by Dominick Martelly on 4/28/2017 at 10:59 PM.
 *
 * @author Dominick Martelly
 */
enum Suit {
    HEART(true), SPADE(false), DIAMOND(true), CLUBS(false);

    boolean red;

    Suit(boolean isRed) {
        this.red = isRed;
    }

    boolean isRed() {
        return red;
    }
}
