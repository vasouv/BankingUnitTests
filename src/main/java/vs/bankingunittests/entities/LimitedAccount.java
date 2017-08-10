package vs.bankingunittests.entities;

/**
 *
 * @author vasouv
 */
public class LimitedAccount extends Account {

    private int limit;

    public LimitedAccount(String owner, int balance, String accountType, int limit) {
        super(owner, balance, accountType);
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "entities.Account{"
                + "owner='" + getOwner() + '\''
                + ", balance=" + getBalance()
                + ", accountType='" + getAccountType() + '\''
                + ", limit='" + getLimit() + '\''
                + '}';
    }

}
