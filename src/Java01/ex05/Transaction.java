package Java01.ex05;

public class Transaction {
    private String Identifier;
    private User Sender;
    private User Recipient;
    private TransferCategory Category;
    private Integer Amount;
    public enum  TransferCategory{
        DEBIT,
        CREDIT
    }

    public String getIdentifier() {
        return Identifier;
    }

    public User getSender() {
        return Sender;
    }

    public User getRecipient() {
        return Recipient;
    }

    public TransferCategory getCategory() {
        return Category;
    }

    public Integer getAmount() {
        return Amount;
    }

    public Transaction(String id, User sender, User recipient, TransferCategory category, Integer amount){
        this.Identifier = id;
        this.Sender = sender;
        this.Recipient = recipient;
        this.Category = category;

        if (category == TransferCategory.DEBIT && amount >= 0)
            throw new IllegalArgumentException("The Debits have to be negative.");
        if (category == TransferCategory.CREDIT && amount <= 0)
            throw new IllegalArgumentException("The Debits have to be positive.");
        this.Amount = amount;
    }
}