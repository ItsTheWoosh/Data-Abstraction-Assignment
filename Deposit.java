import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    Deposit(double amount, Date date, String account){ //Even more constructors
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public String toString(){
        return "You have deposited " + this.amount + " into " + this.account + " on " + this.date;
    }
}
