package com.dominick.freecell.game;

import com.dominick.freecell.cards.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * Created by Dominick Martelly on 4/28/2017 at 11:33 PM.
 *
 * @author Dominick Martelly
 */
class FreeCell {
    private List<CardStack> playingField = new ArrayList<>(8);
    private Card[] freeCells = new Card[4];
    private List<FoundationStack> foundations = new ArrayList<>(4);

    FreeCell() {
        for (int i = 0; i < 8; i++) {
            playingField.add(new CardStack());
        }
    }

    void setThePlayingField(long gameNumber) {
        for (CardStack cardStack : playingField) {
            cardStack.clear();
        }
        List<Card> deckOfCards = generateDeckOfCards();
        Random r = new Random(gameNumber);
        for (int i = 0; i < 52; i++) {
            int j = r.nextInt(deckOfCards.size());
            j %= deckOfCards.size();
            playingField.get(i % 8).add(deckOfCards.remove(j));
        }
    }

    private List<Card> generateDeckOfCards() {
        List<Card> deckOfCards = new ArrayList<>();
        for (int rank = 0; rank < 13; rank++) {
            for (int suit = 0; suit < 4; suit++) {
                deckOfCards.add(new Card(rank, suit));
            }
        }
        return deckOfCards;
    }

    boolean isGameReady() {
        for (int i = 0; i < 4; i++) {
            if (playingField.get(i).size() != 7) {
                return false;
            }
        }
        for (int i = 4; i < 8; i++) {
            if (playingField.get(i).size() != 6) {
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

    boolean moveToFreeCell(int column, int freeCell) {
        if (column < 0 || column > 7) {
            System.out.println("Invalid column");
            return false;
        }
        if (freeCell < 0 || freeCell > 3) {
            System.out.println("Invalid FreeCell location");
            return false;
        }
        if (playingField.get(column).isEmpty()) {
            System.out.println("No Card Found");
        }
        if (freeCells[freeCell] != null) {
            System.out.println("Invalid FreeCell location");
            return false;
        }
        freeCells[freeCell] = playingField.get(column).pop();
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
        boolean cont = true;
        for (int i = 0; cont; i++) {
            cont = false;
            for (int j = 0; j < 8; j++) {
                try {
                    board.append(playingField.get(j).get(i));
                    cont = true;
                } catch (IndexOutOfBoundsException ignored) {
                    board.append("  ");
                }
                board.append(" ");
            }
            board.append('\n');
        }
        return board.toString();
    }
}
