package Java01.ex03;

import static Java01.ex03.Transaction.TransferCategory.DEBIT;

public class Program {
    public static void main(String[] args) {
        try {
            User user = new User("Ayoub", 1000);

            // Create and add transactions
            Transaction t1 = new Transaction(user, new User("Radwa", 500),
                    DEBIT, -100);
            Transaction t2 = new Transaction( user, new User("Houmam", 800),
                    DEBIT, -200);

            user.getTransactions().addTransaction(t1);
            user.getTransactions().addTransaction(t2);

            TransactionNode tmp = user.getTransactions().getHead();


            // Print all transactions
            Transaction[] transactions = user.getTransactions().toArray();
            for (Transaction t : transactions) {
                System.out.println("Transaction: " + t.getIdentifier() + ", Amount: " + t.getAmount());
            }

            // Remove transaction
            user.getTransactions().removeTransactionById("uuid1");

        } catch (TransactionNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}