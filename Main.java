import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            BankManager manager = new BankManager();
            int choice;

            do {
                System.out.println("\n BANK ACCOUNT SYSTEM");
                System.out.println("1. Create Account");
                System.out.println("2. View All Accounts");
                System.out.println("3. Deposit Money");
                System.out.println("4. Withdraw Money");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter holder name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter initial deposit: ");
                        double deposit = sc.nextDouble();
                        manager.createAccount(name, deposit);
                    }
                    case 2 -> manager.viewAccounts();
                    case 3 -> {
                        System.out.print("Enter account number: ");
                        int accNum1 = sc.nextInt();
                        System.out.print("Enter deposit amount: ");
                        double amt1 = sc.nextDouble();
                        manager.deposit(accNum1, amt1);
                    }
                    case 4 -> {
                        System.out.print("Enter account number: ");
                        int accNum2 = sc.nextInt();
                        System.out.print("Enter withdrawal amount: ");
                        double amt2 = sc.nextDouble();
                        manager.withdraw(accNum2, amt2);
                    }
                    case 5 -> System.out.println("Thank you for using our banking system!");
                    default -> System.out.println("Invalid choice.");
                }
            } while (choice != 5);
        }
    }
}
