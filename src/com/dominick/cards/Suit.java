package com.dominick.cards;

/**
 * Created by Dominick Martelly on 4/28/2017 at 10:59 PM.
 *
 * @author Dominick Martelly
 */
public enum Suit implements Comparable<Suit> {
    CLUBS(false, 'C'), DIAMOND(true, 'D'), HEART(true, 'H'), SPADE(false, 'S');

    private final boolean isRED;
    private final char displayCharacter;

    Suit(boolean isRed, char c) {
        this.isRED = isRed;
        this.displayCharacter = c;
    }

    public boolean isRed() {
        return isRED;
    }

    @Override
    public String toString() {
        return String.valueOf(displayCharacter);
    }
}
