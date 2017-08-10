package vs.bankingunittests.controller;

import vs.bankingunittests.entities.Account;
import vs.bankingunittests.entities.LimitedAccount;
import vs.bankingunittests.exceptions.InsufficientFundsException;

/**
 *
 * @author vasouv
 */
public class ATM {

    public void deposit(Account account, int amount) throws InsufficientFundsException {
        if (account instanceof LimitedAccount) {
            if (amount > (((LimitedAccount) account).getLimit() - account.getBalance())) {
                throw new InsufficientFundsException("Cannot deposit more than your account can hold");
            } else {
                System.out.println("Depositing " + amount + " to " + account.toString());
                account.setBalance(account.getBalance() + amount);
                System.out.println("New account balance: " + account.toString());
            }
        } else {
            account.setBalance(account.getBalance() + amount);
        }
    }

    public void withdraw(Account account, int amount) throws InsufficientFundsException {
        if (amount > account.getBalance()) {
            throw new InsufficientFundsException("Cannot withdraw more money than you have");
        } else {
            System.out.println("Withdrawing " + amount + " from " + account.toString());
            account.setBalance(account.getBalance() - amount);
            System.out.println("New account balance: " + account.toString());
        }
    }

    public void transfer(Account source, Account target, int amount) throws InsufficientFundsException {
        if (amount < source.getBalance()) {
            if (target instanceof LimitedAccount) {
                if (amount <= ((LimitedAccount) target).getLimit() - target.getBalance()) {
                    System.out.println("Transferring " + amount + " from " + source + " to " + target);
                    withdraw(source, amount);
                    deposit(target, amount);
                    System.out.println("Transfer successfull");
                } else {
                    throw new InsufficientFundsException("Target account can't hold that amount");
                }
            } else {
                System.out.println("Transferring " + amount + " from " + source + " to " + target);
                withdraw(source, amount);
                deposit(target, amount);
                System.out.println("Transfer successfull");
            }
        } else {
            throw new InsufficientFundsException("Can't transfer more money than your balance");
        }
    }

}
