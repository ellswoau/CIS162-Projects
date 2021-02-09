
/**
 * Write a description of class Lab832 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner; 
public class Lab832
{
    // instance variables - replace the example below with your own
    public static void main(String[] args) {
        /* Type your code here. */
        Scanner scnr = new Scanner(System.in);
        int numInput = scnr.nextInt();      
        int[] numString = new int[numInput];        
        
        //get numbers
        for ( int i = 0; i < numInput; i++) {
            numString[i] = scnr.nextInt();
        }
        int lowerBound = scnr.nextInt();
        int upperBound = scnr.nextInt();
        
        for ( int i = 0; i < numInput; i++) {
            if (numString[i] <= upperBound && numString[i] >= lowerBound) {
                System.out.print(numString[i] + " ");
            }
        }


    }
}
