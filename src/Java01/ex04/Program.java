package Java01.ex04;

class Program {
    public static void main(String[] args) {
        TransactionsService service = new TransactionsService();

        // Add users
        service.addUser("Ayoub", 1000.0);
        service.addUser("Radwa", 500.0);

        // Make a transfer
        try {
            // Print balances
            System.out.println("Ayoub's balance: " + service.getBalance(1));
            System.out.println("Radwa's balance: " + service.getBalance(2));

            service.executeTransaction(1, 2, 300.0);
            System.out.println("\nTransfer successful! Ayoub send 300 DH to Radwa.");
            service.executeTransaction(2, 1, 500.0);
            System.out.println("Transfer successful! Radwa send 500 DH to Ayoub.");
            service.executeTransaction(1, 2, 600.0);
            System.out.println("Transfer successful! Ayoub send 600 DH to Radwa.");



            // Print transactions
            System.out.println("\nAyoub's transactions:");
            Transaction[] ayoubTransactions = service.getUserTransactions(1);
            for (Transaction t : ayoubTransactions) {
                System.out.println("Amount: " + t.getAmount() + ", Type: " + t.getCategory());
            }
            // Print transactions
            System.out.println("\nRadwa's transactions:");
            Transaction[] radwaTransactions = service.getUserTransactions(2);
            for (Transaction t : radwaTransactions) {
                System.out.println("Amount: " + t.getAmount() + ", Type: " + t.getCategory());
            }
            // Print balances
            System.out.println("\nCheck balance:");
            System.out.println("Ayoub's balance: " + service.getBalance(1));
            System.out.println("Radwa's balance: " + service.getBalance(2));

        } catch (IllegalTransactionException e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }
    }
}