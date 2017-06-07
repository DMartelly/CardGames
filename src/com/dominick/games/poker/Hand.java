package com.dominick.games.poker;

/**
 * Created by Dominick on 6/7/2017.
 *
 * @author Dominick
 */
enum Hand {
    ROYAL_FLUSH(1), STRAIGHT_FLUSH(2), FOUR_OF_A_KIND(3), FULL_HOUSE(4), STRIGHT(5),
    THREE_OF_A_KIND(6), TWO_PAIR(7), ONE_PAIR(8), HIGH_CARD(9);

    final private int value;

    Hand(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
