package task.ATM;


import java.util.Scanner;

public class ATM {
    private UserAccount account;
    private Scanner scanner;

    public ATM(UserAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nWelcome to the ATM");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }
        if (account.withdraw(amount)) {
            System.out.printf("Successfully withdrew $%.2f\n", amount);
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }
        account.deposit(amount);
        System.out.printf("Successfully deposited $%.2f\n", amount);
    }

    private void checkBalance() {
        System.out.printf("Current balance: $%.2f\n", account.getBalance());
    }

    public static void main(String[] args) {
        UserAccount userAccount = new UserAccount(1000.0); // Initial balance
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
