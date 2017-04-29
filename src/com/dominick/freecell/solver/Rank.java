package com.dominick.freecell.solver;

/**
 * Created by Dominick Martelly on 4/28/2017 at 10:56 PM.
 *
 * @author Dominick Martelly
 */
enum Rank {
    ACE(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7),
    EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);

    private int value;

    Rank(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }

}
