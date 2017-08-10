package vs.bankingunittests.controller;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import vs.bankingunittests.entities.Account;
import vs.bankingunittests.entities.LimitedAccount;
import vs.bankingunittests.exceptions.InsufficientFundsException;

/**
 *
 * @author vasouv
 */
public class ATMTest {

    Account regular;
    Account limited;
    Account regularSource1;
    Account regularTarget1;
    ATM atm;

    @Before
    public void init() {
        regular = new Account("vasouv", 1000, "regular");
        limited = new LimitedAccount("mixos", 300, "limit", 500);
        regularSource1 = new Account("chris", 2000, "regular");
        regularTarget1 = new Account("geo", 5000, "regular");
        atm = new ATM();
    }

    @Test
    public void deposit_regular_account_zero_amount() throws InsufficientFundsException {
        int expected = regular.getBalance();
        atm.deposit(regular, 0);
        int actual = regular.getBalance();
        assertEquals(expected, actual);
    }

    @Test
    public void deposit_limited_account_zero_amount() throws InsufficientFundsException {
        int expected = limited.getBalance();
        atm.deposit(limited, 0);
        int actual = limited.getBalance();
        assertEquals(expected, actual);
    }

    @Test
    public void deposit_regular_account_some_amount() throws InsufficientFundsException {
        int initialBalance = regular.getBalance();
        int amount = 100;
        int expected = initialBalance + amount;
        atm.deposit(regular, amount);
        int actual = regular.getBalance();
        assertEquals(expected, actual);
    }

    @Test
    public void deposit_limited_account_amount_below_limit() throws InsufficientFundsException {
        int initialBalance = limited.getBalance();
        int amount = 100;
        int expected = initialBalance + amount;
        atm.deposit(limited, amount);
        int actual = limited.getBalance();
        assertEquals(expected, actual);
    }

    @Test
    public void deposit_limited_account_amount_at_limit() throws InsufficientFundsException {
        int initialBalance = limited.getBalance();
        int amount = 200;
        int expected = initialBalance + amount;
        atm.deposit(limited, amount);
        int actual = limited.getBalance();
        assertEquals(expected, actual);
    }

    @Test(expected = InsufficientFundsException.class)
    public void deposit_limited_account_amount_above_limit() throws InsufficientFundsException {
        int initialBalance = limited.getBalance();
        int amount = 500;
        int expected = initialBalance;
        atm.deposit(limited, amount);
        int actual = initialBalance;
        assertEquals(expected, actual);
    }

    @Test
    public void withdraw_regular_account_zero_amount() throws InsufficientFundsException {
        int initialBalance = regular.getBalance();
        int amount = 0;
        int expected = initialBalance;
        atm.withdraw(regular, amount);
        int actual = initialBalance;
        assertEquals(expected, actual);
    }

    @Test
    public void withdraw_limited_account_zero_amount() throws InsufficientFundsException {
        int initialBalance = limited.getBalance();
        int amount = 0;
        int expected = initialBalance;
        atm.withdraw(limited, amount);
        int actual = initialBalance;
        assertEquals(expected, actual);
    }

    @Test
    public void withdraw_regular_account_normal_amount() throws InsufficientFundsException {
        int initialBalance = regular.getBalance();
        int amount = 250;
        int expected = initialBalance - amount;
        atm.withdraw(regular, amount);
        int actual = regular.getBalance();
        assertEquals(expected, actual);
    }

    @Test
    public void withdraw_regular_account_amount_exactly_balance() throws InsufficientFundsException {
        int initialBalance = regular.getBalance();
        int amount = 1000;
        int expected = 0;
        atm.withdraw(regular, amount);
        int actual = regular.getBalance();
        assertEquals(expected, actual);
    }

    @Test(expected = InsufficientFundsException.class)
    public void withdraw_regular_account_amount_more_than_balance() throws InsufficientFundsException {
        int initialBalance = regular.getBalance();
        int amount = 1200;
        int expected = initialBalance;
        atm.withdraw(regular, amount);
        int actual = regular.getBalance();
        assertEquals(expected, actual);
    }

    @Test
    public void transfer_regular_source_regular_target_zero_amount() throws InsufficientFundsException {
        int initialSource1Balance = regularSource1.getBalance();
        int initialTarget1Balance = regularTarget1.getBalance();
        int amount = 0;
        int expectedSource1Balance = initialSource1Balance;
        int expectedTarget1Balance = initialTarget1Balance;
        atm.transfer(regularSource1, regularTarget1, amount);
        int resultSource1Balance = regularSource1.getBalance();
        int resultTarget1Balance = regularTarget1.getBalance();
        assertEquals(expectedSource1Balance, resultSource1Balance);
        assertEquals(expectedTarget1Balance, resultTarget1Balance);
    }

    @Test
    public void transfer_regular_source_regular_target_normal_amount() throws InsufficientFundsException {
        int initialSource1Balance = regularSource1.getBalance();
        int initialTarget1Balance = regularTarget1.getBalance();
        int amount = 350;
        int expectedSource1Balance = initialSource1Balance - amount;
        int expectedTarget1Balance = initialTarget1Balance + amount;
        atm.transfer(regularSource1, regularTarget1, amount);
        int resultSource1Balance = regularSource1.getBalance();
        int resultTarget1Balance = regularTarget1.getBalance();
        assertEquals(expectedSource1Balance, resultSource1Balance);
        assertEquals(expectedTarget1Balance, resultTarget1Balance);
    }

    @Test(expected = InsufficientFundsException.class)
    public void transfer_regular_source_regular_target_amount_more_than_balance() throws InsufficientFundsException {
        int initialSource1Balance = regularSource1.getBalance();
        int initialTarget1Balance = regularTarget1.getBalance();
        int amount = 2350;
        int expectedSource1Balance = initialSource1Balance;
        int expectedTarget1Balance = initialTarget1Balance;
        atm.transfer(regularSource1, regularTarget1, amount);
        int resultSource1Balance = initialSource1Balance;
        int resultTarget1Balance = initialTarget1Balance;
        assertEquals(expectedSource1Balance, resultSource1Balance);
        assertEquals(expectedTarget1Balance, resultTarget1Balance);
    }

    @Test
    public void transfer_regular_source_limited_target_zero_amount() throws InsufficientFundsException {

    }

}
