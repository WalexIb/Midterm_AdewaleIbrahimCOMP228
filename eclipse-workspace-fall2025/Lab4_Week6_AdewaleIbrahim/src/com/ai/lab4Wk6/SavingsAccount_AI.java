package com.ai.lab4Wk6;

public class SavingsAccount_AI extends BankAccount_AI {

    private double interestRate;

    // Constructor
    public SavingsAccount_AI(String firstName, String lastName, String accountNo, double initialBalance, double interestRate) {
        super(firstName, lastName, accountNo, initialBalance);
        this.interestRate = interestRate;
    }

    // Override abstract method
    public double calculateInterest(double rate) {
        double interest = balance * rate;
        System.out.println("Interest for 1 year at rate " + rate + ": $" + String.format("%.2f", interest));
        return interest;
    }

   
}