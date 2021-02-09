
/**
 * Write a description of class RockPaperGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Random;
import java.util.Scanner;


public class RockPaperGame
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class RockPaperGame
     */
    public RockPaperGame(){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter your choice: (R)ock, (P)aper, (S)cissors, (L)izard, or sp(Ock. Enter 'Q' to quit.");
        char userChoice = scnr.next().charAt(0);
        
        while (userChoice != 'Q') {
            System.out.println(playGame(userChoice, computersChoice()));
            System.out.println("");
            System.out.println("Please enter your choice for the next round. Enter 'Q' to quit.");
            System.out.println("");
            userChoice = scnr.next().charAt(0);
        }
        
        System.out.println("Game ended.");
    }
    public char computersChoice() {
        Random rand = new Random();
        int intRandom = rand.nextInt(5);
        if (intRandom == 0) return 'R';
        if (intRandom == 1) return 'P';
        if (intRandom == 2) return 'S';
        if (intRandom == 3) return 'L';
        if (intRandom == 4) return 'O';
        
        else return 'X';        
    }

    public String playGame(char userInput, char computerInput){
        if (userInput == 'R') {
            if (computerInput == 'R') return "Computer also played Rock. It's a tie.";
            if (computerInput == 'P') return "Computer chose paper. Paper covers rock. You lose.";
            if (computerInput == 'S') return "Computer chose scissors. Rock crushes scissors. You win.";
            if (computerInput == 'L') return "Computer chose lizard. Rock crushes lizard. You win.";
            if (computerInput == 'O') return "Computer chose spock. Spock vaporizes rock. You lose.";
        }
        if (userInput == 'P') {
            if (computerInput == 'R') return "Computer chose rock. Paper covers rock. You win.";
            if (computerInput == 'P') return "Computer also chose paper. It's a tie.";
            if (computerInput == 'S') return "Computer chose scissors. Scissors cut paper. You lose.";
            if (computerInput == 'L') return "Computer chose lizard. Lizard eats paper. You lose.";
            if (computerInput == 'O') return "Computer chose spock. Paper disproves spock. You win.";
        }
        if (userInput == 'S') {
            if (computerInput == 'R') return "Computer played Rock. Rock crushes scissors. You lose.";
            if (computerInput == 'P') return "Computer chose paper. Scissors cut paper. You win.";
            if (computerInput == 'S') return "Computer also chose scissors. It's a tie.";
            if (computerInput == 'L') return "Computer chose lizard. Scissors decapitate Lizard. You win.";
            if (computerInput == 'O') return "Computer chose spock. Spock smashes scissors. You lose.";
        }
        if (userInput == 'L') {
            if (computerInput == 'R') return "Computer played Rock. Rock crushes lizard. You lose.";
            if (computerInput == 'P') return "Computer chose paper. Lizard eats paper. You win.";
            if (computerInput == 'S') return "Computer chose scissors. Scissors decapitate lizard. You lose.";
            if (computerInput == 'L') return "Computer also chose lizard. It's a tie.";
            if (computerInput == 'O') return "Computer chose spock. Lizard poisons spock. You win.";
        }
        if (userInput == 'O') {
            if (computerInput == 'R') return "Computer played Rock. Spock vaporizes rock. You win.";
            if (computerInput == 'P') return "Computer chose paper. Paper disproves spock. You lose.";
            if (computerInput == 'S') return "Computer chose scissors. Spock smashes scissors. You win.";
            if (computerInput == 'L') return "Computer chose lizard. Lizard poisons spock. You lose.";
            if (computerInput == 'O') return "Computer also chose spock. It's a tie.";
        }
        else return "Incorrect input"; 
        return "";
    }
    
    
    
    public static void main(String[] args) {
        RockPaperGame game = new RockPaperGame();

    }

}
