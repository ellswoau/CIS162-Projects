import java.util.Scanner;
import java.lang.Math; 
import java.text.DecimalFormat;



public class LabProgram {
    
   //public LabProgram() {
    //}
   private static DecimalFormat df2 = new DecimalFormat("#.00");

   public double nextFrequency(double start, double n) {
       double r = Math.pow(2, 1.0/12.0); 
       return start*((double)(Math.pow(r, n)));
    }
   public static void main(String[] args) {
      LabProgram lab1 = new LabProgram();
      Scanner scnr = new Scanner(System.in);
      double input = scnr.nextDouble();
      System.out.println("" + df2.format(input) +" " + df2.format(lab1.nextFrequency(input, 1)) +
      " " + df2.format(lab1.nextFrequency(input, 2)) + " " + df2.format(lab1.nextFrequency(input, 3)) +
      " " + df2.format(lab1.nextFrequency(input, 4)) );
      /* Type your code here. */

   }
}
