package Java01.ex05;

public class User {
    private final Integer Identifier;
    private String  Name;
    private Integer Balance;
    private TransactionsLinkedList transactions;

    public User(String name, Integer balance){
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

    public void setBalance(Integer balance) {
        Balance = balance;
    }

    public String getName(){
        return this.Name;
    }
    public Integer getIdentifier(){
        return this.Identifier;
    }
    public Integer getBalance(){
        return this.Balance;
    }
}