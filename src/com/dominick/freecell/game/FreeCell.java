package com.dominick.freecell.game;

import com.dominick.freecell.cards.Card;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Dominick Martelly on 4/28/2017 at 11:33 PM.
 *
 * @author Dominick Martelly
 */
public class FreeCell {
    private List<LinkedList<Card>> playingField = new ArrayList<>(8);
    private Card[] freeCells = new Card[4];
    private List<Stack<Card>> foundations = new ArrayList<>(4);


    public boolean isGameReady() {
        for (int i = 0; i < 4; i++) {
            if (playingField.get(i).size() != 8) {
                return false;
            }
        }
        for (int i = 4; i < 8; i++) {
            if (playingField.get(i).size() != 7) {
                return false;
            }
        }
        for (Card freeCell : freeCells) {
            if (freeCell != null) {
                return false;
            }
        }

        for (Stack foundation : foundations) {
            if (!foundation.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Moves a card to a FreeCell position
     *
     * @param c the card to move
     * @param i the FreeCell location
     * @return if the move succeeded
     */
    boolean moveToFreeCell(Card c, int i) {
        if (freeCells[i] != null) {
            return false;
        }
        freeCells[i] = c;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder board = new StringBuilder();
        //FreeCells
        for (Card freeCell : freeCells) {
            board.append(freeCell == null ? "__" : freeCell.toString());
            board.append(" ");
        }
        //Foundation
        for (int i = 0; i < 4; i++) {
            try {
                Stack foundation = foundations.get(i);
                board.append(foundation.isEmpty() ? "__" : foundation.peek().toString());
            } catch (IndexOutOfBoundsException ignored) {
                board.append("__");
            }
            board.append(" ");
        }
        board.append("\n\n");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                try {
                    board.append(playingField.get(j).get(i));
                } catch (IndexOutOfBoundsException ignored) {
                    board.append("__");
                }
                board.append(" ");
            }
            board.append('\n');
        }
        return board.toString();
    }
}
