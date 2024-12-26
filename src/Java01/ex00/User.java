package Java01.ex00;

public class User {
    private Integer Identifier;
    private String  Name;
    private Integer Balance;

    public User(String name, Integer balance){
        if (balance < 0)
            throw new IllegalArgumentException("Balance can't be negative.");
        this.Name = name;
        this.Balance = balance;
    }

    public String getName(){
        return this.Name;
    }

    public Integer getBalance(){
        return this.Balance;
    }
}