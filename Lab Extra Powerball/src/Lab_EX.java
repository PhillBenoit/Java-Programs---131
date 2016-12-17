/******************************************************************************
* Lab_EX.java                                                                 *
* Created by: Phillip Benoit 11-20-16                                         *
* CIS 131 - Programming and Problem Solving II                                * 
* Pima Community College - Fall 2016                                          *
******************************************************************************* 
* Extra Credit Lab                                                            *
* Powerball                                                                   *
*******************************************************************************
* This program simulates playing the                                          *
* powerball lottery game.                                                                            *
*******************************************************************************/

import java.math.BigInteger;

public class Lab_EX {
    
    final static int TICKET_MIN=0;
    final static int TICKET_MAX=2000000;
    final static String STARTING_MONEY="1000";
    final static String TICKET_QUESTION = String.format("How many $%d tickets would you like to purchase?", Drawing.TICKET_PRICE);
    final static String REPORT = "You wagered $%s and won a total of $%s for a ";
    

    public static void main(String[] args) {
        IR.displayProgramInformation("Lab_EX", "11-20-16", "Extra Credit Lab", "Powerball",
                "This program simulates playing the",
                "powerball lottery game.");
        playGame();
        IR.displayEndOfProgram();
    }
    
    static void playGame() {
        BigInteger score = new BigInteger(STARTING_MONEY);
        int tickets = 1;
        int maxTickets = calculateMax(score);
        while (maxTickets != 0 && tickets != TICKET_MIN) {
            Drawing.displayPrizes();
            System.out.println("You have: $" + score.toString());
            System.out.println("Maximum Tickets: " + maxTickets);
            tickets = IR.getIntegerBetweenLowAndHigh(TICKET_QUESTION, TICKET_MIN, maxTickets);
            if (tickets != TICKET_MIN) {
                score = score.subtract(BigInteger.valueOf(tickets * Drawing.TICKET_PRICE));
                BigInteger winnings = Drawing.runDrawing(tickets);
                reportWinnings(BigInteger.valueOf(tickets * Drawing.TICKET_PRICE), winnings);
                score = score.add(winnings);
            }
            maxTickets = calculateMax(score);
        }
        System.out.println("Final Score: $" + score.toString());
    }
    
    static int calculateMax(BigInteger score) {
        int max = 0;
        if (score.divide(BigInteger.valueOf(Drawing.TICKET_PRICE))
                .compareTo(BigInteger.valueOf(TICKET_MAX)) == -1) {
            max = score.divide(BigInteger.valueOf(Drawing.TICKET_PRICE)).intValue();
        } else {
            max = TICKET_MAX;
        }
        return max;
    }
    
    static void reportWinnings(BigInteger wager, BigInteger winnings) {
        String display = String.format(REPORT, wager.toString(), winnings.toString());
        String lossGain = "loss";
        BigInteger difference = new BigInteger("0");
        if (wager.compareTo(winnings) == -1) {
            lossGain = "gain";
            difference = winnings.subtract(wager);
        } else {
            difference = wager.subtract(winnings);
        }
        display += lossGain + " of $" + difference.toString() + "\n";
        System.out.println(display);
    }
    
}
