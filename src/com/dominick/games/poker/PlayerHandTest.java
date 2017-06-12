package com.dominick.games.poker;

import com.dominick.cards.Card;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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

        assertEquals(Hand.ROYAL_FLUSH, myHand.getHand());
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

        assertEquals(Hand.STRAIGHT_FLUSH, myHand.getHand());
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

        assertEquals(Hand.FOUR_OF_A_KIND, myHand.getHand());
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

        assertEquals(Hand.FULL_HOUSE, myHand.getHand());
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

        assertEquals(Hand.STRAIGHT, myHand.getHand());
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

        assertEquals(Hand.FLUSH, myHand.getHand());
    }

    @org.junit.Test
    public void equals_1() throws Exception {
        Set<Card> myCards = new HashSet<>();
        myCards.add(new Card(10, 3));
        myCards.add(new Card(0, 1));
        myCards.add(new Card(13, 0));
        myCards.add(new Card(1, 0));
        myCards.add(new Card(7, 0));
        PlayerHand myHand = new PlayerHand(myCards);

        Set<Card> myCards2 = new HashSet<>();
        myCards2.add(new Card(1, 0));
        myCards2.add(new Card(13, 0));
        myCards2.add(new Card(7, 0));
        myCards2.add(new Card(0, 1));
        myCards2.add(new Card(10, 3));
        PlayerHand myHand2 = new PlayerHand(myCards2);

        assertEquals(myHand2, myHand);
    }

    @org.junit.Test
    public void equals_2() throws Exception {
        Set<Card> myCards = new HashSet<>();
        myCards.add(new Card(13, 0));
        myCards.add(new Card(0, 1));
        myCards.add(new Card(1, 0));
        myCards.add(new Card(7, 0));
        myCards.add(new Card(10, 0));
        PlayerHand myHand = new PlayerHand(myCards);

        Set<Card> myCards2 = new HashSet<>();
        myCards2.add(new Card(1, 0));
        myCards2.add(new Card(13, 0));
        myCards2.add(new Card(7, 0));
        myCards2.add(new Card(0, 0));
        myCards2.add(new Card(10, 0));
        PlayerHand myHand2 = new PlayerHand(myCards2);

        assertNotEquals(myHand2, myHand);
    }

    @org.junit.Test
    public void allPossibleOdds() throws Exception {

        Iterator<PlayerHand> allPossibleHands = allPossibleHands().iterator();
        int highCard = 0, pair = 0, royalFlush = 0;
        while (allPossibleHands.hasNext()) {
            switch (allPossibleHands.next().getHand().getValue()) {
                case 10:
                    highCard++;
                    break;
                case 9:
                    pair++;
                    break;
                case 1:
                    royalFlush++;
                default:
                    break;
            }
        }

        assertEquals(4, royalFlush);
        assertEquals(1098240, pair);
        assertEquals("Num of High Cards is incorrect", 1302540, highCard);
    }

    private Set<PlayerHand> allPossibleHands() {
        Set<PlayerHand> set = new HashSet<>();
        List<Card> allCards = new ArrayList<>();
        for (int rank = 0; rank < 13; rank++) {
            for (int suit = 0; suit < 4; suit++) {
                allCards.add(new Card(rank, suit));
            }
        }
        for (int i = 0; i < allCards.size() - 4; i++) {
            for (int j = i + 1; j < allCards.size() - 3; j++) {
                for (int k = j + 1; k < allCards.size() - 2; k++) {
                    for (int l = k + 1; l < allCards.size() - 1; l++) {
                        for (int m = l + 1; m < allCards.size(); m++) {
                            set.add(new PlayerHand(allCards.get(i), allCards.get(j),
                                    allCards.get(k), allCards.get(l), allCards.get(m)));
                        }
                    }
                }
            }
        }
        return set;
    }

}