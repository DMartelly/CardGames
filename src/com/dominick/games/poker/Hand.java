package com.dominick.games.poker;

/**
 * Created by Dominick on 6/7/2017.
 *
 * @author Dominick
 */
enum Hand {
    ROYAL_FLUSH(1), STRAIGHT_FLUSH(2), FOUR_OF_A_KIND(3), FULL_HOUSE(4), FLUSH(5), STRAIGHT(6),
    THREE_OF_A_KIND(7), TWO_PAIR(8), ONE_PAIR(9), HIGH_CARD(10);

    final private int value;

    Hand(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
