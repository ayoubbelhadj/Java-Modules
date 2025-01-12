package Java01.ex04;

public class User {
    private final Integer Identifier;
    private String  Name;
    private double Balance;
    private TransactionsLinkedList transactions;

    public User(String name, double balance){
        if (balance < 0)
            throw new IllegalArgumentException("Balance can't be negative.");
        this.Identifier = UserIdsGenerator.getInstance().generateId();
        this.Name = name;
        this.Balance = balance;
        this.transactions = new TransactionsLinkedList();
    }

    public TransactionsLinkedList getTransactions() {
        return transactions;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public String getName(){
        return this.Name;
    }
    public Integer getIdentifier(){
        return this.Identifier;
    }
    public double getBalance(){
        return this.Balance;
    }
}