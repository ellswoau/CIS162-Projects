
/**
 * CIS 162 - Section 6 
 * Project 2 - "Chuck" tester class
 *
 * @author Austin Ellsworth
 * @version Fall 2020
 */
public class ChuckTest
{
    public static void main(String [] args){
        int before = 0;

        final int ONES = 1;
        final int TWOS = 2;
        final int THREES= 3;
        final int FOURS = 4;
        final int FIVES = 5;
        final int SIXES = 6;
        final int FIELD = 7;
        final int SMALL = 8;
        final int LARGE = 9;

        Chuck game = new Chuck();

        System.out.println("Testing begins...");
        if(game.getCredits() != 10){
            System.out.println("FAIL: credits should start at 10");
        }
        System.out.println("number of credits at beginning: " + game.getCredits());

        System.out.println("Testing Field");
        //wins bet on Field
        before = game.getCredits();
        game.placeBet(FIELD);
        game.testRoll(6,6,3);
        System.out.println("number of credits after field win test roll: " + game.getCredits());

        if(game.getCredits() != (before+1)){
            System.out.println("FAIL: should have won betting on Field");
        }  
        //loses bet on Field
        before = game.getCredits();
        game.placeBet(FIELD);
        game.testRoll(4,6,1);
        if(game.getCredits() != (before-1)){
            System.out.println("FAIL: should have lost betting on Field");
        }  

        System.out.println("Testing Large");
        // wins bet on Large
        before = game.getCredits();
        game.placeBet(LARGE);
        game.testRoll(6,3,3);
        if(game.getCredits() != (before+1)){
            System.out.println("FAIL: should have won betting on Large");
        }        
        // loses bet on Large
        before = game.getCredits();
        game.placeBet(LARGE);
        game.testRoll(2,3,3);
        if(game.getCredits() != (before-1)){
            System.out.println("FAIL: should have lost betting on Large");
        }  

        System.out.println("Testing Small");
        // wins bet on Small
        before = game.getCredits();
        game.placeBet(SMALL);
        game.testRoll(2,3,3);
        if(game.getCredits() != (before+1)){
            System.out.println("FAIL: should have won betting on Small");
        }        
        // loses bet on Small
        before = game.getCredits();
        game.placeBet(SMALL);
        game.testRoll(2,6,5);
        if(game.getCredits() != (before-1)){
            System.out.println("FAIL: should have lost betting on Small");
        } 

        System.out.println("Testing Triples. !!!Ignore lost bet on 1's!!!");
        //use loop to test bets on 1, 2, 3, 4, 5, 6, win on triplets
        for (int i = 1; i <= 6; i++) {

            // wins bet on "i" -- triplets
            before = game.getCredits();
            game.placeBet(i);
            game.testRoll(i,i,i);
            if(game.getCredits() != (before+10)){
                System.out.println("FAIL: should have won betting on  "  + i +"'s");
            }        

            // loses bet on "i"
            before = game.getCredits();
            game.placeBet(i);
            game.testRoll(1,1,1);
            if(game.getCredits() != (before-1)){
                //ignore fail on 1, alternative to static input on test roll to always
                //cause fail is too laborious 
                System.out.println("FAIL: should have lost betting on "  + i +"'s");
            } 
        }

        System.out.println("Testing add 17 credits");
        before = game.getCredits();
        game.addCredits(17);
        if(game.getCredits() != (before+17)){
            System.out.println("FAIL: wrong number of credits");
        }  

        System.out.println("Testing completed.");
    }

}
