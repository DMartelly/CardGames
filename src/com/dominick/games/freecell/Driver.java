package com.dominick.games.freecell;

/**
 * Created by Dominick Martelly on 4/29/2017 at 12:20 AM.
 *
 * @author Dominick Martelly
 */
class Driver {
    public static void main(String[] args) {
        FreeCell myFreeCell = new FreeCell();
        myFreeCell.newGame(11982);
        System.out.println(myFreeCell);

        myFreeCell.newGame(982);
        System.out.println(myFreeCell);

        System.out.println(myFreeCell.isGameReady());

        System.out.println(myFreeCell.moveToFreeCell(0, 0) ? "Move Succeeded" : "Move Failed");
        System.out.println(myFreeCell);

        System.out.println(myFreeCell.isGameReady());

        System.out.println(myFreeCell.moveToFreeCell(1, 0) ? "Move Succeeded" : "Move Failed");
        System.out.println(myFreeCell);

        System.out.println(myFreeCell.moveToFreeCell(3, 1) ? "Move Succeeded" : "Move Failed");
        System.out.println(myFreeCell);

        System.out.println(myFreeCell.moveToFoundation(3, 1) ? "Move Succeeded" : "Move Failed");
        System.out.println(myFreeCell.moveToFoundation(0, 2) ? "Move Succeeded" : "Move Failed");
        System.out.println(myFreeCell.moveToFoundation(1, 3) ? "Move Succeeded" : "Move Failed");
        System.out.println(myFreeCell);
    }
}
