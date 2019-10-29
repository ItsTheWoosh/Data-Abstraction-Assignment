import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){ //Default Constructor
        this.name = "";
        this.accountNumber = 0;
        this.checkBalance = 0;
        this.savingBalance = 0;
        this.deposits = new ArrayList<>();
        this.withdraws = new ArrayList<>();
    }

    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit) { //Other constructor
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
        this.deposits = new ArrayList<>();
        this.withdraws = new ArrayList<>();
        Deposit checking = new Deposit(checkDeposit, new Date(), CHECKING);
        Deposit saving = new Deposit(savingDeposit, new Date(), SAVING);
        this.deposits.add(checking);
        this.deposits.add(saving);
    }

    public double deposit(double amt, Date date, String account) { //Deposit method
        if (account.equals(CHECKING)) {
            Deposit one = new Deposit(amt, date, account);
            deposits.add(one);
            checkBalance = checkBalance + amt;
            return checkBalance;
        } else if (account.equals(SAVING)) {
            Deposit two = new Deposit(amt, date, account);
            deposits.add(two);
            savingBalance = savingBalance + amt;
            return savingBalance;
        }
        return 0;
    }

    public double withdraw(double amt, Date date, String account) { //Withdraw Method
        if (account.equals(CHECKING) || account.equals(SAVING)) {
            if (!checkOverdraft(amt, account)) { //Checking overdraft
                Withdraw e = new Withdraw(amt, date, account);
                withdraws.add(e);
                if (account.equals(CHECKING)) {
                    checkBalance = checkBalance - amt;
                    return checkBalance;
                }
                else {
                    savingBalance = savingBalance - amt;
                    return savingBalance;
                }
            }
        }
        return 0;
    }

    private boolean checkOverdraft(double amt, String account) {
        if (account.equals(CHECKING)) return (checkBalance - amt <= OVERDRAFT);
        else if (account.equals(SAVING)) return (savingBalance - amt <= OVERDRAFT);
        return false;
    }

    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    public ArrayList<Withdraw> getWithdraws() {
        return withdraws;
    }
}