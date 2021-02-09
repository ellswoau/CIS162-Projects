
/**
 * Write a description of class Lab830 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner; 
public class Lab830
{

    public static void main(String[] args) {
        /* Type your code here. */
        Scanner scnr = new Scanner(System.in);
        int numInput = scnr.nextInt();
        String[] wordString = new String[numInput];
        int[] numString = new int[numInput];

        for ( int i = 0; i < numInput; i++) {
            wordString[i] = scnr.next();
        }

        int compareWordIndex = 0;
        for (int i = 0; i < numInput; i++) {
            //set temp string to current index looped in array
            String temp = wordString[i];
            
            //count number of times "temp" string appears in list and set to a corresponding index of a number array
            for (int j = 0; j < numInput; j++){
                if (temp.equals(wordString[j])) {
                    numString[i]++;
                }
            }

        }
        
        //print results
        for (int i = 0; i < numInput; i++) {
            System.out.println(wordString[i] + " " + numString[i]);
        }


    }
}

