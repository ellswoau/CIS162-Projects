
/**
 * Lab 10, a simplified version of the game "21"
 *
 * @author Austin Ellsworth
 * @version 1
 */
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Lab10
{
    // instance variables
    private int x;
    Random rand = new Random();
    private int score;
    private int[] playerHand = new int[2];
    private boolean gameOver = false;

    /**
     * Constructor for objects of class Lab10
     */
    public Lab10()
    {
        playerHand[0] = drawCard();
        playerHand[1] = drawCard();
        Scanner scnr = new Scanner(System.in);

        while ( ! gameOver) {
            System.out.println("Current score: " + calcScore());
            char userChoice = 'y';
            if (calcScore() == 21) {
                System.out.println("You win.");
                gameOver = true;
            }
            if (calcScore() > 21) {
                System.out.println("You lose.");
                gameOver = true;
                break;
            }
            System.out.println("");
            while (userChoice == 'y') {
                System.out.println("Enter 'd' to draw your next card, or 'q' to quit game");
                userChoice = scnr.next().charAt(0);
                if (userChoice == 'q') {
                    gameOver = true;
                }
                if (userChoice == 'd') {
                    playerHand = Arrays.copyOf(playerHand, playerHand.length + 1);
                    playerHand[playerHand.length - 1] = drawCard();
                }
            }

        }

    }

    //Simple, new random integer, returns value between 1 and 13
    private int drawCard() {
        int intRandom = rand.nextInt(12);
        return (intRandom + 1);

    }

    /*****************************************************************
    loops through the length of the playerHand array and adds up the 
    values of each card in the array with the getCardValue method.
     *****************************************************************/
    private int calcScore() {
        score = 0;
        for (int i = 0; i < playerHand.length; i++) {
            score += getCardValue(playerHand[i]);
        }
        return score;
    }

    /*****************************************************************
    Input identifying value of the card and a human readable string.
     *****************************************************************/
    private String getCardFace(int card) {
        if (card == 1) return "Ace";
        if (card == 2) return "Two";
        if (card == 3) return "Three";
        if (card == 4) return "Four";
        if (card == 5) return "Five";
        if (card == 6) return "Six";
        if (card == 7) return "Seven";
        if (card == 8) return "Eight";
        if (card == 9) return "Nine";
        if (card == 10) return "Ten";
        if (card == 11) return "Jack";
        if (card == 12) return "Queen";
        if (card == 13) return "King";
        else return "error";

    }

    /*****************************************************************
    Input identifying value of the card and output the score value 
    of the card.
     *****************************************************************/
    private int getCardValue(int card) {
        if (card == 1) {
            return 11;
        }
        if (card > 1 && card < 11) {
            for (int i = 2; i < 11; i++) {
                return card;
            }
        }
        if (card > 10 && card <= 13) {
            return 10;
        }
        else {
            return 0;
        }
    }

    /*****************************************************************
    main method.
     *****************************************************************/
    public static void main(String[] args) {
        Lab10 game = new Lab10();
    }
}
