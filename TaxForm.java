/**
 * CIS 162 - Lab 6 - Tax Form
 * Written by Austin Ellsworth
 */

import java.util.*;
import java.text.*;

public class TaxForm {
    //initiate w2 variables
    private double w2Wages;
    private double w2TaxableInterest;
    private double w2Unemployment;
    private int w2Exemptions;
    private double w2Withheld;
    
    //call methods to get outputs and use toCurrency method to format the doubles
    public void estimateTaxes(){
        System.out.println("");
        System.out.println("Your results");
        System.out.println("AGI: " + toCurrency(getAGI()));
        System.out.println("Taxable income: " + toCurrency(getTaxable()));
        System.out.println("Federal Tax: " + toCurrency(getTaxLiability()));
        //if the balance is a negative number, that means the tax payer receives a refund instead
        if (getBalance() >= 0) {
            System.out.println("Amount Due: " + toCurrency(getBalance()));
        }
        else {
            System.out.println("Your refund: " + toCurrency(-1 * getBalance()));
        }
        
        

    }    

    //Calculate adjusted gross income by adding all income sources
    public double getAGI() {
        return (w2Wages + w2TaxableInterest + w2Unemployment);
    }
    //Get tax balance by substracting the amount withheld on the w2 from the total tax liability
    public double getBalance() {
        return getTaxLiability() - w2Withheld;
    }

    /* get taxable income by subtracting the exemption-corresponding 
     * deduction from the adjusted gross income. Taxable income becomes 
     * zero if a negative number is calculated.
     */
    public double getTaxable () {
        double taxableIncome = getAGI();

        switch (w2Exemptions) {
            case 0:
            taxableIncome -= 6350;
            break;
            case 1:
            taxableIncome -= 10400;
            break;
            case 2:
            taxableIncome -= 20800;
            break;
        }
        if (taxableIncome < 0) {
            return 0;
        }
        else {
            return taxableIncome;
        }
    }
    /* calculate the total tax liability, the two higher-level if statements determine the tax
     * brackets to be used based on the number of excemptions claimed on the tax payer's w2
     */
    public double getTaxLiability() {
        final double TEN_PCT = 0.10;
        final double FIFTEEN_PCT = 0.15;
        final double TWENTYFIVE_PCT = 0.25;
        final double TWENTYEIGHT_PCT = 0.28;
        double tax = 0;
        double taxable = getTaxable();

        //for single filers
        if (w2Exemptions == 0 || w2Exemptions == 1){
            //single income bracket 1
            if (taxable <= 9325) {
                tax = Math.round(taxable * TEN_PCT);
            }
            //single income bracket 2
            if (taxable > 9325 && taxable <= 37950) {
                tax = Math.round((taxable - 9325) * FIFTEEN_PCT + 932.5);
            }
            //single income bracket 3
            if (taxable > 37950 && taxable <= 91900) {
                tax = Math.round((taxable - 37950) * TWENTYFIVE_PCT + 5226.25);
            }
            //single income bracket 4
            if (taxable > 91900) {
                tax = Math.round((taxable - 91900) * TWENTYEIGHT_PCT + 18713.75);
            }
        }

        //for married filers
        else if (w2Exemptions == 2) {
            //married income bracket 1
            if (taxable <= 18650) {
                tax = Math.round(taxable * TEN_PCT);
            }
            //married income bracket 2
            if (taxable > 18650 && taxable <= 75900) {
                tax = Math.round((taxable - 18650) * FIFTEEN_PCT + 1865);
            }
            //married income bracket 3
            if (taxable > 75900) {
                tax = Math.round((taxable - 75900) * TWENTYFIVE_PCT + 10452.5);
            }
        }

        return tax;

    }
        //Collect w2 method variables from user
    public TaxForm() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Your information");
        System.out.print("Wages, salaries, and tips: $");
        w2Wages = scnr.nextInt();
        System.out.print("Taxable interest: $");
        w2TaxableInterest = scnr.nextInt();
        System.out.print("Unemployment compensation: $");
        w2Unemployment = scnr.nextInt();
        System.out.print("Exemptions (0, 1, or 2): ");
        w2Exemptions = scnr.nextInt();
        System.out.print("Federal income tax withheld: $");
        w2Withheld = scnr.nextInt();

    }
    //take a double as an input, format it for currency, and output a string
    public String toCurrency(double input) {
        DecimalFormat fmt = new DecimalFormat("$#,##0.00");
        String output = fmt.format(input);
        return output;
    }

    // do not change this method
    public static void main(String[] args) {
        TaxForm form = new TaxForm();
        form.estimateTaxes();
    }
}