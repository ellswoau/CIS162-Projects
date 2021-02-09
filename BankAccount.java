
/**
 * Lab 5 "Bank Account"
 * By Austin Ellsworth
 * CIS 162 Section 06
 */
import java.text.DecimalFormat;
public class BankAccount {
    private int accountNum;
    private String customerName;
    private double accountBalance;

    public BankAccount() {
        customerName = "TBA";
        accountNum = 0;
        accountBalance = 0;
    }

    public BankAccount(String name, int acct, double bal) {
        customerName = name;
        accountNum = acct;
        accountBalance = bal;

    }

    public void makeDeposit(double amount) {
        accountBalance += amount;
    }

    public void makeWithdrawal(double amount) {
        accountBalance -= amount;
    }

    public double getBalance() {
        return accountBalance;
    }

    public String getName() {
        return customerName;
    }

    public int getID() {
        return accountNum;
    }

    public String toString() {
        DecimalFormat fmt = new DecimalFormat("$#,##0.00");
        String balance = fmt.format(accountBalance);
        return (customerName + "\t" + accountNum + "\t" + balance);
    }

    public static void main(String args[]) {
        //Examples provided in google doc
        BankAccount joe = new BankAccount("Joe Smith", 5643, 1000.0); 
        joe.makeDeposit(247.35);
        System.out.println(joe);

        BankAccount heidi = new BankAccount("Heidi Lee", 1946, 2000.0); 
        heidi.makeWithdrawal(247.35);
        System.out.println(heidi);
        
        //Testing constructor with no parameters
        BankAccount newaccount = new BankAccount();
        System.out.println(newaccount);
        
        BankAccount austin = new BankAccount("Austin Ellsworth", 42069, 500);
        austin.makeWithdrawal(2000);
        
        //Test return methods by calling them into variables and printing variables
        String austinsName = austin.getName();
        int austinsID = austin.getID();
        String austinsBal = "$" + austin.getBalance();
        System.out.println(austinsName + "\t" + austinsID + "\t" + austinsBal);
        
        
        
        
        
    }

}
