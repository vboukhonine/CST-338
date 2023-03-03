import java.util.ArrayList;

public class Customer {
    private String name;
    private int PIN;
    private double customerBalance;
    private String banksAt;
    ArrayList<Customer> customers = new ArrayList<>();

    public Customer(String name, int PIN, double customerBalance, String banksAT) {
        this.name = name;
        this.PIN = PIN;
        this.customerBalance = customerBalance;
        this.banksAt = banksAT;
    }

    public Customer() {
        //arraylist of customers
        customers.add(new Customer("Alice", 1234, 5000.00, "OtterUnion"));
        customers.add(new Customer("Tom", 2000, 200.00, "OtterUnion"));
        customers.add(new Customer("Monica", 3000, 50.00, "OtterUnion"));
        customers.add(new Customer("Michael", 7777, 0.00, "OtterUnion"));
        customers.add(new Customer("John", 8000, 500.00, "OtterUnion"));
        customers.add(new Customer("Jane", 2222, 500.00, "OtterUnion"));
        customers.add(new Customer("Robert", 2323, 200.00, "BOA"));
        customers.add(new Customer("Owen", 4455, 50.00, "BOA"));
        customers.add(new Customer("Chris", 8787, 10.00, "BOA"));
        customers.add(new Customer("Rebecca", 8080, 555.55, "BOA"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public double getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(double customerBalance) {
        this.customerBalance = customerBalance;
    }

    public String getBanksAt() {
        return banksAt;
    }

    public void setBanksAt(String banksAt) {
        this.banksAt = banksAt;
    }

    @Override
    public String toString() {
        return name+": Balance: $"+customerBalance;
    }
}
