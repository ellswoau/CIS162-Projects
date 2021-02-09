//Class used to calculate the volme of a sphere
//Created by Austin Ellsworth
import java.util.Scanner;
import java.lang.Math.*;

public class SphereVolume {
public static void main(String[] args) 
{ 
       double userRadius;
       Scanner scnr = new Scanner(System.in);
       System.out.print("Please enter sphere radius: ");
       userRadius = scnr.nextInt();
       double sphereVolume;
       sphereVolume = (4/3)*userRadius*userRadius*userRadius*Math.PI;
       System.out.print("The volume is ");
       System.out.printf("%.2f", sphereVolume);
       System.out.println(".");

       
}
}