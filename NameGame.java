
/**
 * Name game assignment
 * created by Austin Ellsworth
 */
import java.util.Scanner;
import java.util.Random;
public class NameGame

{
    public static void main(String[] args) 
    { 
        Scanner scnr = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String inputName = scnr.next();
        // print name
        System.out.println("Hello, " + inputName + ". Nice to meet you.");
        // remove first and last letters
        System.out.println(inputName.substring(1,(inputName.length() - 1)));
        //move first two letters to the end of the string
        System.out.println(inputName.substring(2, inputName.length()) + inputName.substring(0,2));
        //print middle character or character to the right of center
        //interger division is trunicated so no need for if statement
        int middleChar = (inputName.length() / 2);
        System.out.println(inputName.charAt(middleChar));
        //print out middle three characters
        System.out.println(inputName.substring(middleChar - 1, middleChar + 2));
        //print random character from name
        Random randGen = new Random();
        int randomCharNum = randGen.nextInt(inputName.length());
        //add 1 to randomCharNum to improve human readability (counting from 1 instead of 0)
        System.out.println("Character " + (randomCharNum +1)  + " from your name is: " + inputName.charAt(randomCharNum));

        
        
       

    }
}
