
/**
 * Write a description of class pizza here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class Pizza {
   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("People: ");
      double numPeople = keyboard.nextInt();
      double totalCost;
      int numPizzas;
      numPizzas = (int) Math.ceil((numPeople * 2) / 12);
      totalCost = numPizzas * 14.95;
      System.out.println("Pizzas: " + numPizzas);
      System.out.println("Cost: " + String.format("%.2f", totalCost));
   }
}
