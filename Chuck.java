/*****************************************************************
CIS162 - Section 6

Project 2 "Chuck" game

@author Austin Ellsworth
@version Fall 2020
 ******************************************************************/

public class Chuck
{
    // private instance variables
    private int x;
    private GVdie[] dieArray = new GVdie[3];
    private int creditBal;
    private String currentMessage;
    boolean[] betsArray = new boolean[9];

    /*****************************************************************
    Main constructor for a Chuck object
     *****************************************************************/
    public Chuck()
    {
        // set initial credit balance to 10
        creditBal = 10;

        // initialize die objects array in loop and set faces to blank
        for (int i = 0; i < 3; i++) {
            dieArray[i] = new GVdie();
            dieArray[i].setBlank();
        }

        //set all bets in array to false
        for (int i = 0; i < 9; i++) {
            betsArray[i] = false;
        }
    }

    /*****************************************************************
    getMessage accessor method. used by GUI to display message to 
    user
     *****************************************************************/
    public String getMessage() {
        return currentMessage;
    }

    /*****************************************************************
    getCredits accessor reports the current number of credits that
    the user has 
     *****************************************************************/
    public int getCredits() {
        return creditBal;
    }

    /*****************************************************************
    Not quite sure why this is needed but I'm guessing the GUI class
    uses this to show the current value for each dice
     *****************************************************************/
    public GVdie[] getDice() {
        return dieArray;
    }

    /*****************************************************************
    Method used to add up the total value of all three dice
    and return the sum as an integer
     *****************************************************************/
    private int getSumDiceValues() {
        int sum = 0;
        
        //loop through dieArray adding to sum w/ getValue()
        for (int i = 0; i < 3; i++) {
            sum = sum + dieArray[i].getValue();
        }
        return sum;
    }

    /*****************************************************************
    Method used to check for doubles (value appearing twice) within
    dice array. Checks whatever num is inputted as parameter. Returns
    boolean.
     *****************************************************************/
    private boolean isDoubles (int num) {
        int timesMatched = 0;
        
        //add to timesMatched variable if dieArray value matches input
        for (int i = 0; i < 3; i++) {
            if (num == dieArray[i].getValue()) {
                timesMatched++;
            }
        }
        if (timesMatched == 2) return true;
        else return false;
    }

    /*****************************************************************
    Checks for triplets by comparing all three dice in array.
    Returns boolean.
     *****************************************************************/
    private boolean isTriplets () {
        
        //check that first two die are equal AND second two dice equal
        if (dieArray[0].getValue() == dieArray[1].getValue() && dieArray[1].getValue() == dieArray[2].getValue()) {
            return true;
        }
        else return false;
    }

    /*****************************************************************
    Check for no triplets AND total sum value greater than 10
     *****************************************************************/
    private void checkLarge() {
        if (getSumDiceValues() > 10 && isTriplets() == false) {
            creditBal += 2;
            currentMessage = "The sum of all die is greater than ten, and there are no triplets. The player has won";
        }
    }

    /*****************************************************************
    Check for no triplets AND total sum less than 11
     *****************************************************************/   
    private void checkSmall() {
        if (getSumDiceValues() < 11 && isTriplets() == false) {
            creditBal += 2;
            currentMessage = "The sum of all die is less than 11, and there are no triplets. The player has won";
        }
    }

    /*****************************************************************
    Check for total sum value between 8 and 12
     *****************************************************************/
    private void checkField() {
        if (getSumDiceValues() < 8 || getSumDiceValues() > 12) {
            creditBal += 2;
            currentMessage = "The sum of all dice were less than 8 or greater than 12. The player has won";
        }
    }

    /*****************************************************************
    Check how many dice equal the given input number
     *****************************************************************/
    private void checkNumber(int num) {
        int timesMatched = 0;
        
        //same loop as isDoubles but more outcomes follow
        for (int i = 0; i < 3; i++) {
            if (num == dieArray[i].getValue()) {
                timesMatched++;
            }
        }
        if (timesMatched == 3) creditBal += 11;
        if (timesMatched == 2) creditBal += 3;
        if (timesMatched == 1) creditBal += 2;
        currentMessage = "Player has matched " + num + " " + timesMatched + " times.";
    }

    /*****************************************************************
    Check all bets, subtract credits used from balance, and run helper methods for bets
     *****************************************************************/
    private void checkAllBets() {
        currentMessage = "Player has lost";
        
        //subtract 1 from creditBal each time a true value appears
        for (int i = 0; i < 9; i++) {
            if (betsArray[i] == true) {
                creditBal=creditBal - 1;
            }
        }
        if (betsArray[0] == true) { checkNumber(1); }
        if (betsArray[1] == true) { checkNumber(2); }
        if (betsArray[2] == true) { checkNumber(3); }
        if (betsArray[3] == true) { checkNumber(4); }
        if (betsArray[4] == true) { checkNumber(5); }
        if (betsArray[5] == true) { checkNumber(6); }
        if (betsArray[6] == true) { checkField(); }
        if (betsArray[7] == true) { checkSmall(); }
        if (betsArray[8] == true) { checkLarge(); }
    }

    /*****************************************************************
    Add credits to balance
     *****************************************************************/
    public void addCredits (int amount) {
        if (amount > 0) {
            creditBal += amount;
        }
    }

    /*****************************************************************
    Place bets and set value to true in betsArray
     *****************************************************************/
    public void placeBet (int bet) {
        if (bet >= 1 && bet <= 9) {
            betsArray[(bet-1)] = true;
        }
    }

    /*****************************************************************
    Cancel a bet by setting the value in betsArray to false
     *****************************************************************/
    public void cancelBet (int bet) {
        if (bet >= 1 && bet <= 9) {
            betsArray[(bet-1)] = false;
        }
    }

    /*****************************************************************
    Loop through all elements in betsArray using cancelBet method
     *****************************************************************/
    public void clearAllBets() {
        for (int i = 0; i < 9; i++) {
            betsArray[i] = false;
        }
    }

    /*****************************************************************
    Roll all die in array, check bets, then clear bets
     *****************************************************************/
    public void roll() {
        if (enoughCredits()) {
            for (int i = 0; i < 3; i++) {
                dieArray[i].roll();
            }
            checkAllBets();
            clearAllBets();
        }
        else {
            currentMessage = "Player doesn't have enough credits to place bets";
        }
    }

    /*****************************************************************
    Reset for a fresh game
     *****************************************************************/
    public void reset() {
        for (int i = 0; i < 3; i++) {
            dieArray[i].setBlank();
            currentMessage = "Player has lost.";
            clearAllBets();
        }
    }

    /*****************************************************************
    Loop through betsArray to calculate needed credits and return true 
    if the user has enough credits to cover the bets
     *****************************************************************/
    public boolean enoughCredits() {
        int neededCredits = 0;
        for (int i = 0; i < 9; i++) {
            if (betsArray[i] == true) {
                neededCredits++;
            }
        }
        if (creditBal - neededCredits >= 0) {
            return true;
        }
        else{
            return false;
        }
    }

    /*****************************************************************
    Test roll method for debug, 3 integer inputs. Rolls dice until 
    the dice hits the specific value asked for
     *****************************************************************/
    public void testRoll(int v1, int v2, int v3) {
        if (enoughCredits()) {
            while (dieArray[0].getValue() != v1) {
                dieArray[0].roll();
            }
            while (dieArray[1].getValue() != v2) {
                dieArray[1].roll();
            }
            while (dieArray[2].getValue() != v3) {
                dieArray[2].roll();
            }
        }
        checkAllBets();
        clearAllBets();

    }

    /*****************************************************************
    Test roll method for debug, array input. Rolls dice until 
    the dice hits the specific value asked for
     *****************************************************************/
    public void testRoll(int [] array) {
        if (enoughCredits()) {
            while (dieArray[0].getValue() != array[0]) {
                dieArray[0].roll();
            }
            while (dieArray[1].getValue() != array[1]) {
                dieArray[1].roll();
            }
            while (dieArray[2].getValue() != array[2]) {
                dieArray[2].roll();
            }

        }
        checkAllBets();
        clearAllBets();
    }

}
