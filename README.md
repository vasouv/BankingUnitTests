# BankingUnitTests

A very basic testing idea is to use the ATM operations in a bank. Let's say you can have two account types, a **Regular** that has no limit to the balance it can hold, and a **Limited** that has a limit.

## Operations
The ATM controller can deposit money to an account, withdraw from an account and transfer from an account to another.

### Withdraw
Both accounts throw Exception if **amount > balance**, also balance cannot be negative.

### Deposit
Regular account can deposit money no problem. Limited account must check if the amount is within the **limit - balance** else throws Exception.

### Transfer
If the source account can send money **amount <= balance**, then:
- if the target is Limited, check for **amount + balance <= limit**
- if Regular deposit with no issues

## TODO
Haven't finished the transfer tests. Also, I'm not testing if the amount given is opposite to the operation, meaning negative for deposit and positive for withdrawal.
