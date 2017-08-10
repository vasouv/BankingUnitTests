package vs.bankingunittests;

import vs.bankingunittests.entities.Account;
import vs.bankingunittests.entities.LimitedAccount;

/**
 *
 * @author vasouv
 */
public class Main {
    public static void main(String[] args) {
        Account account = new Account("vasouv", 1000, "regular");
        Account withLimit = new LimitedAccount("mixos", 300, "limit", 500);
    }
    
}
