import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){ //More constructors
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public String toString() {
        return "You have withdrawn " + this.amount + " from " + this.account + " on " + this.date;
    }
}
