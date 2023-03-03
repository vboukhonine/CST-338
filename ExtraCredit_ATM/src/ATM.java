/*
Title: ATM.java
Abstract: Creates an ATM to which can withdraw funds, deposit funds, and
transfer funds between customers
Author: Vera Boukhonine
Date: 03/06/2022

Sample Output:
--------------------------------------------------------
===== Welcome to Demo Program =====
Serial Number: 0
Bank Name: OtterUnion
Location: UNKNOWN
Balance: 100.0

Serial Number: 200
Bank Name: BOA
Location: Library
Balance: 100.0

===== Equality Checking =====
false

Serial Number: 100
Bank Name: OtterUnion
Location: BIT
Balance: 500.0

===== ATM Transaction Menu =====
1. Withdrawal
2. Deposit
3. Transfer

Fail – withdrawal
Succeed – withdrawal
Fail – withdrawal
Succeed – withdrawal
Fail – withdrawal

===== Machine Status =====
Serial Number:100
Bank Name: OtterUnion
Location: BIT
Balance: 479.5
5 Transactions so far:
Withdrawal: 5( 2 success, 3 fail)
Deposit: 0( 0 success, 0 fail)
Transfer: 0( 0 success, 0 fail)


Alice: Balance: $4990.0

Succeed – deposit

===== Machine Status =====
Serial Number:100
Bank Name: OtterUnion
Location: BIT
Balance: 479.5
6 Transactions so far:
Withdrawal: 5( 2 success, 3 fail)
Deposit: 1( 1 success, 0 fail)
Transfer: 0( 0 success, 0 fail)


Good transfer!!!


===== Machine Status =====
Serial Number:100
Bank Name: OtterUnion
Location: BIT
Balance: 479.5
6 Transactions so far:
Withdrawal: 5( 2 success, 3 fail)
Deposit: 1( 1 success, 0 fail)
Transfer: 2( 2 success, 0 fail)


===== Thank you! =====
--------------------------------------------------------
* */


public class ATM extends Customer {
    private int serialNumber = 0;
    private String bankName = "UNKNOWN";
    private String location = "UNKNOWN";
    private double atmBalance;
    private int withdrawalSuccess = 0;
    private int withdrawalFail = 0;
    private int depositSuccess = 0;
    private int depositFail = 0;
    private int transferSuccess = 0;
    private int transferFail = 0;

    public ATM(String bankName) {
        super();
        this.bankName = bankName;
        atmBalance = 100.0;
    }

    public ATM(int serialNumber, String bankName, String location) {
        super();
        this.serialNumber = serialNumber;
        this.bankName = bankName;
        this.location = location;
        atmBalance = 100.0;
    }

    public void setATM(int serialNumber, String location) {
        this.location = location;
        this.serialNumber = serialNumber;
    }

    public void addFund(double amount) {
        if (amount > 0) {
            atmBalance += amount;
        } else {
            System.out.println("Add a number greater than zero.");
        }
    }

    public String displayMenu() {
        System.out.println("===== ATM Transaction Menu =====\n" +
                "1. Withdrawal\n" +
                "2. Deposit\n" +
                "3. Transfer\n");
        return "===== ATM Transaction Menu =====\n" +
                "1. Withdrawal\n" +
                "2. Deposit\n" +
                "3. Transfer\n";
    }

    public String withdrawal(String name, int PIN, double amount) {
        double balance;
        for (Customer customer : customers) {
            if (customer.getName().equals(name) && customer.getPIN() == PIN) {
                balance = customer.getCustomerBalance();
                if (balance > 0 && amount <= balance && amount <= atmBalance) {
                    balance -= amount;
                    atmBalance -= amount;
                    customer.setCustomerBalance(balance);
                    System.out.println("Succeed – withdrawal");
                    withdrawalSuccess++;
                    return "Succeed – withdrawal";
                }
            }
        }
        withdrawalFail++;
        System.out.println("Fail – withdrawal");
        return "Fail – withdrawal";
    }

    public String status() {
        int transactions = withdrawalFail + withdrawalSuccess + depositSuccess + depositFail;
        int totalDeposits = depositFail + depositSuccess;
        int totalWithdrawals = withdrawalFail + withdrawalSuccess;
        int totalTransfers = transferFail + transferSuccess;
        System.out.println(
                "Serial Number:" + serialNumber + "\n" +
                        "Bank Name: " + bankName + "\n" +
                        "Location: " + location + "\n" +
                        "Balance: " + atmBalance + "\n" +
                        transactions + " Transactions so far:\n" +
                        "Withdrawal: " + totalWithdrawals + "( " + withdrawalSuccess + " success, " + withdrawalFail + " fail)\n" +
                        "Deposit: " + totalDeposits + "( " + depositSuccess + " success, " + depositFail + " fail)\n" +
                        "Transfer: " + totalTransfers + "( " + transferSuccess + " success, " + transferFail + " fail)\n");
        return "Serial Number:" + serialNumber + "\n" +
                "Bank Name: " + bankName + "\n" +
                "Location: " + location + "\n" +
                "Balance: " + atmBalance + "\n" +
                transactions + " Transactions so far:\n" +
                "Withdrawal: " + totalWithdrawals + "( " + withdrawalSuccess + " success, " + withdrawalFail + " fail)\n" +
                "Deposit: " + totalDeposits + "( " + depositSuccess + " success, " + depositFail + " fail)\n" +
                "Transfer: " + totalTransfers + "( " + transferSuccess + " success, " + transferFail + " fail)";
    }

    public boolean isCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Customer getCustomer(String name) {
        Customer customer;
        for (Customer value : customers) {
            if (value.getName().equals(name)) {
                customer = value;
                return customer;
            }
        }
        System.out.println("Sorry they are not a customer. ");
        return null;
    }

    public String deposit(String name, int PIN, double amount) {
        double balance;
        for (Customer customer : customers) {
            if (customer.getName().equals(name) && customer.getPIN() == PIN) {
                balance = customer.getCustomerBalance();
                balance += amount;
                customer.setCustomerBalance(balance);
                atmBalance+=amount; // probably I should add to ATM Balance
                System.out.println("Succeed – deposit");
                depositSuccess++;
                return "Succeed – deposit";
            }
        }
        depositFail++;
        System.out.println("Fail - deposit");
        return "Fail - deposit";
    }

    //transfer from name1 to name2
    public boolean transfer(String name1, int PIN1, double amount, String name2, int PIN2) {
        double balance1;
        double balance2;
        for (int i = 0; i < customers.size(); i++) {
            for (Customer customer : customers) {
                if (customers.get(i).getName().equals(name1) && customers.get(i).getPIN() == PIN1 && customer.getName().equals(name2) && customer.getPIN() == PIN2) {
                    balance1 = customers.get(i).getCustomerBalance();
                    balance2 = customer.getCustomerBalance();
                    balance1 -= amount;
                    balance2 += amount;
                    customers.get(i).setCustomerBalance(balance1);
                    customer.setCustomerBalance(balance2);
                    System.out.println(balance1);
                    System.out.println(balance2);
                    transferSuccess++;
                    return true;
                }
            }
        }
        transferFail++;
        return false;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(double atmBalance) {
        this.atmBalance = atmBalance;
    }

    @Override
    public String toString() {
        return "Serial Number: " + serialNumber + "\n" + "Bank Name: " + bankName + "\n" +
                "Location: " + location + "\n" + "Balance: " + atmBalance;
    }
}
