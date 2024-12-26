package Java01.ex00;

public class Program {
    public static void main(String[] args) {
        // Create users
        User user1 = new User("Ahmed", 200);
        User user2 = new User("Fatima", 500);

        // Create transaction
        Transaction debitTransaction = new Transaction(
                user1, user2, Transaction.TransferCategory.DEBIT, -200
        );
        Transaction creditTransaction = new Transaction(
                user1, user2, Transaction.TransferCategory.CREDIT, 200
        );

        // Print results
        System.out.println("Transaction created!");
    }
}