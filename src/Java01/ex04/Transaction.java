package Java01.ex04;

import java.util.UUID;

public class Transaction {
    private String Identifier;
    private User Sender;
    private User Recipient;
    public enum  TransferCategory{
        DEBIT,
        CREDIT
    }

    public String getIdentifier() {
        return Identifier;
    }

    private TransferCategory Category;
    private Integer Amount;

    public Integer getAmount() {
        return Amount;
    }

    public Transaction(User sender, User recipient, TransferCategory category, Integer amount){
        this.Identifier = UUID.randomUUID().toString();
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