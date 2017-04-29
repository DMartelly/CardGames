package com.dominick.freecell.cards;

/**
 * Created by Dominick Martelly on 4/28/2017 at 10:56 PM.
 *
 * @author Dominick Martelly
 */
public enum Rank {
    ACE(0, 'A'), ONE(1, '1'), TWO(2, '2'), THREE(3, '3'), FOUR(4, '4'), FIVE(5, '5'), SIX(6, '6'), SEVEN(7, '7'),
    EIGHT(8, '8'), NINE(9, '9'), TEN(10, 'T'), JACK(11, 'J'), QUEEN(12, 'Q'), KING(13, 'K');

    private int value;
    private char displayCharacter;

    Rank(int value, char character) {
        this.value = value;
        this.displayCharacter = character;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(displayCharacter);
    }
}
