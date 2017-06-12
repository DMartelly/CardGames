package com.dominick.games.poker;

import com.dominick.cards.Card;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.assertEquals;

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
    public void getHand_1_Random() throws Exception {
        Set<Card> myCards = new HashSet<>();
        Random r = new Random();
        while (myCards.size() < 5) {
            myCards.add(new Card(r.nextInt(14), r.nextInt(4)));
        }
        PlayerHand myHand = new PlayerHand(myCards);
        System.out.println("myCards = " + myCards);
        System.out.println("myHand = " + myHand.getHand());
    }

    @org.junit.Test
    public void getHand_2_RoyalFlush() throws Exception {
        Set<Card> myCards = new HashSet<>();
        myCards.add(new Card(13, 0));
        myCards.add(new Card(12, 0));
        myCards.add(new Card(11, 0));
        myCards.add(new Card(10, 0));
        myCards.add(new Card(0, 0));
        PlayerHand myHand = new PlayerHand(myCards);

        assertEquals("getHand_2_RoyalFlush Failed", Hand.ROYAL_FLUSH, myHand.getHand());
    }

    @org.junit.Test
    public void getHand_3_StraightFlush() throws Exception {
        Set<Card> myCards = new HashSet<>();
        myCards.add(new Card(9, 1));
        myCards.add(new Card(8, 1));
        myCards.add(new Card(7, 1));
        myCards.add(new Card(6, 1));
        myCards.add(new Card(5, 1));
        PlayerHand myHand = new PlayerHand(myCards);

        assertEquals("getHand_3_StraightFlush Failed", Hand.STRAIGHT_FLUSH, myHand.getHand());
    }

    @org.junit.Test
    public void getHand_4_FourOfAKind() throws Exception {
        Set<Card> myCards = new HashSet<>();
        myCards.add(new Card(9, 2));
        myCards.add(new Card(4, 3));
        myCards.add(new Card(9, 3));
        myCards.add(new Card(9, 1));
        myCards.add(new Card(9, 0));
        PlayerHand myHand = new PlayerHand(myCards);

        assertEquals("getHand_4_FourOfAKind Failed", Hand.FOUR_OF_A_KIND, myHand.getHand());
    }

    @org.junit.Test
    public void getHand_5_FullHouse() throws Exception {
        Set<Card> myCards = new HashSet<>();
        myCards.add(new Card(12, 2));
        myCards.add(new Card(12, 3));
        myCards.add(new Card(1, 3));
        myCards.add(new Card(1, 1));
        myCards.add(new Card(1, 0));
        PlayerHand myHand = new PlayerHand(myCards);

        assertEquals("getHand_5_FullHouse Failed", Hand.FULL_HOUSE, myHand.getHand());
    }

    @org.junit.Test
    public void getHand_6_Straight() throws Exception {
        Set<Card> myCards = new HashSet<>();
        myCards.add(new Card(4, 2));
        myCards.add(new Card(2, 3));
        myCards.add(new Card(5, 3));
        myCards.add(new Card(1, 1));
        myCards.add(new Card(3, 0));
        PlayerHand myHand = new PlayerHand(myCards);

        assertEquals("getHand_6_Straight Failed", Hand.STRAIGHT, myHand.getHand());
    }


    @org.junit.Test
    public void getHand_7_Flush() throws Exception {
        Set<Card> myCards = new HashSet<>();
        myCards.add(new Card(13, 0));
        myCards.add(new Card(0, 0));
        myCards.add(new Card(1, 0));
        myCards.add(new Card(7, 0));
        myCards.add(new Card(10, 0));
        PlayerHand myHand = new PlayerHand(myCards);

        assertEquals("getHand_7_Flush Failed", Hand.FLUSH, myHand.getHand());
    }

    @org.junit.Test
    public void allPossibleOdds() throws Exception {

        Iterator<PlayerHand> allPossibleHands = allPossibleHands().iterator();
        int HighCard = 0;
        while (allPossibleHands.hasNext()) {
            switch (allPossibleHands.next().getHand().getValue()) {
                case 0:
                    HighCard++;
            }
        }

        assertEquals("Possible High Cards", 1302540, HighCard);
    }

    private Set<PlayerHand> allPossibleHands() {
        Set<PlayerHand> set = new HashSet<>();

        return set;
    }

}