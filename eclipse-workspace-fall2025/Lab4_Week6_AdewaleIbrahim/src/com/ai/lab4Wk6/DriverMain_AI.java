package com.ai.lab4Wk6;

import java.util.Scanner;

public class DriverMain_AI {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Create a Savings Account ===");

        System.out.print("Enter First Name: ");
        String first = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String last = scanner.nextLine();

        System.out.print("Enter Account Number: ");
        String accNo = scanner.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initBalance = scanner.nextDouble();

        System.out.print("Enter Interest Rate (e.g., 0.05 for 5%): ");
        double rate = scanner.nextDouble();

        // Create SavingsAccount object
        SavingsAccount_AI account = new SavingsAccount_AI(first, last, accNo, initBalance, rate);

        // Display account info
        account.displayAccountInfo();

        // Deposit using instance method
        System.out.print("\nEnter deposit amount: ");
        double depositAmt = scanner.nextDouble();
        account.depositInstance(depositAmt);
        System.out.println("New Balance: $" + account.getBalance());

        // Withdraw
        System.out.print("\nEnter withdrawal amount: ");
        double withdrawAmt = scanner.nextDouble();
        account.withdraw(withdrawAmt);
        System.out.println("New Balance: $" + account.getBalance());

        // Calculate interest (1 year)
        account.calculateInterest(rate);

        // Calculate interest (over 3 years using overloaded method)
        double interest3Years = account.calculateInterest(rate, 3);
        System.out.println("Interest over 3 years: $" + String.format("%.2f", interest3Years));

        // Static deposit method
        BankAccount_AI.deposit(1000.00);

        scanner.close();
    }
}