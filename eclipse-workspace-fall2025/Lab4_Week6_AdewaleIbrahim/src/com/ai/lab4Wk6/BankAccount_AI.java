package com.ai.lab4Wk6;

public abstract class BankAccount_AI {

	// Final attributes
    protected final String firstName;
    protected final String lastName;
    protected final String accountNo;
    protected double balance;

    // Constructor
    public BankAccount_AI(String firstName, String lastName, String accountNo, double initialBalance) {
        if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (accountNo == null || accountNo.isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be null or empty.");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNo = accountNo;
        this.balance = initialBalance;
    }

    // Abstract method to calculate interest (to be overridden)
    public abstract double calculateInterest(double rate);

    // Method overloading: different parameters
    public double calculateInterest(double rate, int years) {
        return balance * rate * years;
    }

    // Deposit method (optional static version)
    public static void deposit(double amount) {
        System.out.println("Depositing $" + amount + " successfully!");
    }

    public void depositInstance(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("You deposited: $" + amount + ", Previous balance: $" + String.format("%.2f", (balance - amount)));
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds for withdrawal.");
            return;
        }
        balance -= amount;
        System.out.println("You withdrew: $" + amount + ", Previous balance: $" + String.format("%.2f", (balance + amount)));
    }

    // Display account info
    public void displayAccountInfo() {
        System.out.println("Account Holder: " + firstName + " " + lastName);
        System.out.println("Account Number: " + accountNo);
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
    }

    // Getter
    public double getBalance() {
        return balance;
    }
}
