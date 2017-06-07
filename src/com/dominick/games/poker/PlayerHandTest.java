package com.dominick.games.poker;

import com.dominick.cards.Card;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Dominick on 6/7/2017.
 *
 * @author Dominick
 */
public class PlayerHandTest {

    @org.junit.Test
    public void canRedraw() throws Exception {
    }

    @org.junit.Test
    public void getHand_1() throws Exception {
        Set<Card> myCards = new HashSet<>();
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            myCards.add(new Card(r.nextInt(14), r.nextInt(4)));
        }
        PlayerHand myHand = new PlayerHand(myCards);
        System.out.println("myCards = " + myCards);
        System.out.println("myHand = " + myHand.getHand());
    }

    @org.junit.Test
    public void getHand_2() throws Exception {
        Set<Card> myCards = new HashSet<>();
        myCards.add(new Card(13, 0));
        myCards.add(new Card(12, 0));
        myCards.add(new Card(11, 0));
        myCards.add(new Card(10, 0));
        myCards.add(new Card(0, 0));
        PlayerHand myHand = new PlayerHand(myCards);

        System.out.println("myCards = " + myCards);
        System.out.println("myHand = " + myHand.getHand());
    }

}