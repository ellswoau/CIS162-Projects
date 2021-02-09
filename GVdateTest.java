
/**
 * Project CIS162 test class
 * Austin Ellsworth
 * 
 */
 
public class GVdateTest
{
    // instance variables - replace the example below with your own
    private int x;

      public static void main (String []  args) {
        System.out.println ("Testing begings");
 
        //********** phase 1 testing ************
 
        // testing the default constructor 
        GVdate today = new GVdate();
        assert today.getMonth() == 10 : "month should be 10";   
        assert today.getDay() == 12 : "day should be 12";  
        assert today.getYear() == 2020 : "year should be 2020";  
 
        // testing constructor 2
        GVdate theDay = new GVdate(1, 10, 1995);
        assert theDay.getMonth() == 1 : "month should be 1";
        assert theDay.getDay() == 10 : "day should be 10";
        assert theDay.getYear() == 1995 : "year should be 1995";

        
        // TO DO: complete the checks for month, day and year
 
        // testing setter methods 
        //testing setMonth
        //
        GVdate day = new GVdate();
        day.setMonth(8);
        assert day.getMonth() == 8 : "Month should be 8";
        day.setDay(9);
        assert day.getDay() == 9 : "Day should be 9";
        day.setYear(2021);
        assert day.getYear() == 2021 : "Year should be 2021";
        // TO DO: complete the code to check for month
        // TO DO: finish testing setDay and setYear
        // TO DO: test the toString method
        String stringTest = day.toString();
        assert stringTest.equals("8/9/2021") : "String should be 8/9/2021";
        
        //System.out.println(day.isDateValid(2,29,2021));
        System.out.println("Test 2021 for leap year");
        System.out.println(day.isLeapYear(2021));
         System.out.println("Test 2000 for leap year");
        System.out.println(day.isLeapYear(2000));
        //System.out.println(day.getLastDayOfMonth(2, 2021));
        System.out.println("");
        System.out.println("Testing four string formats:");
        System.out.println(day.toString(1));
        System.out.println(day.toString(2));
        day.nextDay();
        System.out.println(day.toString(3));
        day.skipAhead(6);
        System.out.println(day.toString(4));
        System.out.println("");
        
        System.out.println("Is Aug 16, 2021 my birthday?");
        System.out.println(day.isMyBirthday());
        


        
        
        
        
        System.out.println ("Testing ends");
    }  

}
