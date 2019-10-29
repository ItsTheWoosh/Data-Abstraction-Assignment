import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class test {
    private Customer Zoey; //Making new Customer
    private Deposit checkDeposit;
    private Withdraw checkWithdraw;
    private Deposit savingDeposit;
    private Withdraw savingWithdraw;
    private Date da;

    @Before
    public void setup() { //Customer Construction and new Deposits/Withdraws for toString tests
        da = new Date();
        Zoey = new Customer("Zoey", 42, 0.0, 0.0);
        checkDeposit = new Deposit(100.0, da, Customer.CHECKING);
        checkWithdraw = new Withdraw(100.0, da, Customer.CHECKING);
        savingDeposit = new Deposit(100.0, da, Customer.SAVING);
        savingWithdraw = new Withdraw(100.0, da, Customer.SAVING);
    }

    @Test
    public void testString() { //Testing that the Deposits work
        assertEquals("You have deposited " + 100.0 + " into Checking on " + da, checkDeposit.toString());
        assertEquals("You have withdrawn " + 100.0 + " from Checking on " + da, checkWithdraw.toString());
        assertEquals("You have deposited " + 100.0 + " into Saving on " + da, savingDeposit.toString());
        assertEquals("You have withdrawn " + 100.0 + " from Saving on " + da, savingWithdraw.toString());
    }

    @Test
    public void depositTest() { //Testing that doing more deposits increases the size of the deposits list
        assertEquals(2, Zoey.getDeposits().size());
        assertEquals(0, Zoey.deposit(0, da, Customer.CHECKING), 0);
        assertEquals(0, Zoey.deposit(0, da, Customer.SAVING),0);
        assertEquals(4, Zoey.getDeposits().size());
        assertEquals(100, Zoey.deposit(100, da, Customer.CHECKING), 0);
        assertEquals(100, Zoey.deposit(100, da, Customer.SAVING),0);

    }

    @Test
    public void testWithdraw() { //Testing that doing more Withdraws increases the size of the Withdraws list
        assertEquals(0, Zoey.getWithdraws().size());
        assertEquals(0, Zoey.withdraw(0, da, Customer.CHECKING), 0);
        assertEquals(0, Zoey.withdraw(0, da, Customer.SAVING), 0);
        assertEquals(2, Zoey.getWithdraws().size());
        assertEquals(-50, Zoey.withdraw(50, da, Customer.CHECKING), 0); //Testing if the OVERDRAFT lets me do this
        assertEquals(-50, Zoey.withdraw(50, da, Customer.SAVING), 0);
        assertEquals(0, Zoey.withdraw(500, da, Customer.CHECKING),0); //This should not work
        assertEquals(0, Zoey.withdraw(500, da, Customer.SAVING),0); //It's over the OVERDRAFT
    }
}
