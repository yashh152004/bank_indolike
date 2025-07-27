public class BankManager {
    private final int MAX_ACCOUNTS = 10;
    private final BankAccount[] accounts = new BankAccount[MAX_ACCOUNTS];
    private int accountCount = 0;
    private int nextAccountNumber = 101;

    public void createAccount(String holderName, double initialDeposit) {
        if (accountCount >= MAX_ACCOUNTS) {
            System.out.println("Account has reached its limit.");
            return;
        }
        accounts[accountCount++] = new BankAccount(nextAccountNumber++, holderName, initialDeposit);
        System.out.println("Account has been created successfully!");
    }

    public void viewAccounts() {
        if (accountCount == 0) {
            System.out.println("No accounts are currently available.");
            return;
        }
        for (int i = 0; i < accountCount; i++) {
            System.out.println(accounts[i]);
        }
    }

    public BankAccount findAccount(int accNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accNumber) {
                return accounts[i];
            }
        }
        return null;
    }

    public void deposit(int accNumber, double amount) {
        BankAccount acc = findAccount(accNumber);
        if (acc != null) {
            acc.deposit(amount);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(int accNumber, double amount) {
        BankAccount acc = findAccount(accNumber);
        if (acc != null) {
            if (acc.withdraw(amount)) {
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }
}
