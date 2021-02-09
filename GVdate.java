
/**
 * CIS162 Project 1
 * By Austin Ellsworth
 */
public class GVdate
{
    // instance variables - replace the example below with your own
    private int month;
    private int day;
    private int year;
    private int birthdayMonth;
    private int birthdayDay;

    // default values for constructor
    public GVdate(){
        // initialise instance variables
        month = 10;
        day = 12;
        year = 2020;
    }

    //set string in calendar
    public GVdate(int m, int d, int y) {
        if ( isDateValid(m,d,y) ){
            month = m;
            day = d;
            year = y;
        }
        else {
            month = 10;
            day = 12;
            year = 2020;
        }
    }

    //Set date in calendar by parsing a string as input 
    public GVdate(String date) {
        int firstSlash = date.indexOf("/");
        int secondSlash = date.lastIndexOf("/");
        int lastChar = date.length();
        int monthNumber;
        int dayNumber;
        int yearNumber;
        monthNumber = Integer.parseInt( date.substring(0, firstSlash) );
        dayNumber = Integer.parseInt( date.substring(firstSlash + 1, secondSlash) );
        yearNumber = Integer.parseInt (date.substring(secondSlash + 1, lastChar) );
        if ( isDateValid(monthNumber,dayNumber,yearNumber) == true){
            month = monthNumber;
            day = dayNumber;
            year = yearNumber;
        }
        else {
            month = 10;
            day = 12;
            year = 2020;
        }

    }
    //these three are self explainatory
    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    //default toSting
    public String toString() {
        String newString = month + "/" + day + "/" + year;
        return newString;
    }

    //is it my birthday
    public boolean isMyBirthday() {
        int birthdayMonth = 2;
        int birthdayDay = 20;
        if (month == birthdayMonth && day == birthdayDay) {
            return true;
        }
        else {
            return false;
        }
    }

    //figure out if year is a leap year, to be used to calculate number of days in feb.
    public boolean isLeapYear(int y) {
        if (y % 4 == 0){

            if (y % 100 == 0){
                if (y % 400 == 0) {
                    return true;
                }
                else {
                    return false;
                }
                //return false;
            }
            return true;
        }

        else {
            return false;
        }
    }

    //change the month
    public void setMonth(int m){
        if ( isDateValid(m, day, year) ){
            month = m;
        }
        else {
            System.out.println("New month creates an invalid date");
        }
    }

    //change the day
    public void setDay(int d){
        if ( isDateValid(month, d, year) ){
            day = d;
        }
        else {
            System.out.println("New day creates an invalid date");
        }
    }

    //change the year
    public void setYear(int y){
        if ( isDateValid(month, day, y) ){
            year = y;
        }
        else {
            System.out.println("New year creates an invalid date");
        }
    }

    //set a new date from month day and year
    public void setDate(int m, int d, int y){
        if ( isDateValid(m, d, y) ){
            day = d;
            month = m;
            year = y;
        }
        else {
            System.out.println("New day creates an invalid date");
        }
    }
    
    //get number of days in each month
    //switch back to private after testing
    private int getLastDayOfMonth(int m, int y){
        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
            return 31;
        }
        if (m == 2){
            if (isLeapYear(y)){
                return 29;
            }
            else {
                return 28;
            }
        }
        if (m == 4 || m == 6 || m == 9 || m == 11){
            return 30;
        }
        return 0;

    }

    //check to make sure date is valid by making sure its contained with a valid range for that month/year
    private boolean isDateValid(int m, int d, int y){
        boolean monthValid = false;
        if (m >= 1 && m <= 12){
            monthValid = true;
        }
        boolean dayValid = false;
        if ( d >= 1 && d <= getLastDayOfMonth(m, y) ){
            dayValid = true;
        }
        boolean yearValid = false;
        if ( y >= 0 ){
            yearValid = true;
        }
        if (monthValid && dayValid && yearValid){
            return true;
        }
        else {
            return false;

        }

    }

    //switch used to get name of month from numerical 
    public String getMonthName (int m){
        switch (m) {
            case 1:
            return "January";
            case 2:
            return "February";
            case 3:
            return "March";
            case 4:
            return "April";
            case 5:
            return "May";
            case 6:
            return "June";
            case 7:
            return "July";
            case 8: 
            return "August";
            case 9:
            return "September";
            case 10:
            return "October";
            case 11:
            return "November";
            case 12:
            return "December";
        }
        return "";
    }
    
    //toString method overload to print dates out in various formats 
    public String toString(int format){
        switch(format) {
            case 1: 
            return ("" + month + "/" + day + "/" + year);
            case 2:
            return (String.format("%02d", month) + "/" + String.format("%02d", day) + "/" + year);
            case 3: 
            String monthDesc = "JanFebMarAprMayJunJulAugSepOctNovDec";
            return (monthDesc.substring(((month - 1) * 3),(month * 3)) + " " + day + ", " + year);
            case 4:
            return (getMonthName(month) + " " + day + ", " + year);
            default: 
            break;
        }
        return "";
    }

    //add one day to current date, check to make sure its within range
    public void nextDay(){
        if ((day + 1) <= getLastDayOfMonth(month, year) ) {
            day = day + 1;
        }
        else if ((month + 1) <= 12) {
            day = 1;
            month = month + 1;
        }
        else {
            day = 1;
            month = 1;
            year = year + 1;
        }
    }

    //use a loop to run "nextDay" x number of times
    public void skipAhead(int numOfDays){   
        for (int i = 0; i < numOfDays; ++i) {
            nextDay();

        }
    }

    //equals method overload to compare two dates
    public boolean equals(GVdate otherDate) {
        if (otherDate.day == this.day && otherDate.month == this.month && otherDate.year == this.year) {
            return true;
        }
        else {
            return false;
        }
    }

    
}
