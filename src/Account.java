import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    private static final int STANDARD_AGENCY = 1;
    private static int SEQUENCE = 1;

    protected int agency;
    protected int number;
    protected double balance;
    protected Client client;
    protected List<String> transactionHistory;
    private boolean isLocked;

    public Account(Client client) {
        this.agency = Account.STANDARD_AGENCY;
        this.number = SEQUENCE++;
        this.client = client;
        this.transactionHistory = new ArrayList<>();
        this.isLocked = false;
    }

    public void withdraw(double value) {
        if (!isLocked && balance >= value) {
            balance -= value;
            transactionHistory.add("Withdrawal: " + value);
        } else if (isLocked) {
            System.out.println("Account is locked.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(double value) {
        if (!isLocked) {
            balance += value;
            transactionHistory.add("Deposit: " + value);
        } else {
            System.out.println("Account is locked.");
        }
    }

    public void transfer(double value, Account recipientAccount) {
        if (!isLocked && balance >= value) {
            this.withdraw(value);
            recipientAccount.deposit(value);
            transactionHistory.add("Transfer to account " + recipientAccount.getNumber() + ": " + value);
        } else if (isLocked) {
            System.out.println("Account is locked.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public int getAgency() {
        return agency;
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void printExtract() {
        displayInfo();
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    protected void displayInfo() {
        System.out.println(String.format("Owner: %s", this.client.getName()));
        System.out.println(String.format("Agency: %d", this.agency));
        System.out.println(String.format("Number: %d", this.number));
        System.out.println(String.format("Balance: %.2f", this.balance));
    }

    public void lockAccount() {
        this.isLocked = true;
    }

    public void unlockAccount() {
        this.isLocked = false;
    }

    public boolean isLocked() {
        return isLocked;
    }
}
