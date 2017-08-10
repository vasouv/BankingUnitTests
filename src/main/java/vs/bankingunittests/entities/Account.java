package vs.bankingunittests.entities;

/**
 *
 * @author vasouv
 */
public class Account {

    private String owner;
    private int balance;
    private String accountType;

    public Account(String owner, int balance, String accountType) {
        this.owner = owner;
        this.balance = balance;
        this.accountType = accountType;
    }

    public String getOwner() {
        return owner;
    }

//    public void setOwner(String owner) {
//        this.owner = owner;
//    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

//    public void setAccountType(String accountType) {
//        this.accountType = accountType;
//    }

    @Override
    public String toString() {
        return "entities.Account{"
                + "owner='" + owner + '\''
                + ", balance=" + balance
                + ", accountType='" + accountType + '\''
                + '}';
    }
}
