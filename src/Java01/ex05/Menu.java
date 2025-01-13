package Java01.ex05;

import java.util.Scanner;

public class Menu {
	private TransactionsService servise;
	private boolean	devMode;
	private Scanner scanner;

	Menu(boolean devMode){
		this.servise = new TransactionsService();
		this.scanner = new Scanner(System.in);
		this.devMode = devMode;
	}

	public void display(){
		while(true){
			System.out.println("	1. Add a user");
			System.out.println("	2. View user balances");
			System.out.println("	3. Perform a transfer");
			System.out.println("	4. View all transactions for a specific user");
			if(devMode){
				System.out.println("	5. DEV - remove a transfer by ID");
				System.out.println("	6. DEV - check transfer validity");
			}
			System.out.println("	7. Finish execution");
			try {
				System.out.print("->	");
				int nbr = scanner.nextInt();
				if (check(nbr))
					break;
				System.out.println("	---------------------------------------------------------");
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				scanner.nextLine();
			}
		}
	}
	private boolean check(int nbr){
		try {
			switch (nbr){
				case 1:
					AddUser();
					break;
				case 2:
					checkBalance();
					break;
				case 3:
					PerformTransfer();
					break;
				case 4:
					viewTransactions();
					break;
				case 5:
					removeTransaction();
					break;
				case 6:
					transferValidity();
					break;
				case 7:
					return true;
				default:
					System.out.println("Invalid choice");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			scanner.nextLine();
		}
		return false;
	}

	private void AddUser(){
		System.out.println("	Enter a user name and a balance");
		System.out.print("->	");
		String name = scanner.next();
		int balance = scanner.nextInt();
		User user = servise.addUser(name, balance);
		System.out.println("User with id = "+ user.getIdentifier() +" is added");
	}

	private void checkBalance(){
		System.out.println("	Enter a user ID");
		System.out.print("->	");
		int id = scanner.nextInt();
		User user = servise.getUsersList().getUserById(id);
		System.out.println(user.getName() +" - " + user.getBalance());
	}

	private void  PerformTransfer(){
		System.out.println("	Enter a sender ID, a recipient ID, and a transfer amount");
		System.out.print("->	");
		int id1 = scanner.nextInt();
		int id2 = scanner.nextInt();
		int balance = scanner.nextInt();
		this.servise.executeTransaction(id1, id2, balance);
		System.out.println("The transfer is completed");
	}
	private void viewTransactions(){
		System.out.println("Enter a user ID");
		System.out.print("->	");
		int id = scanner.nextInt();
		Transaction[] transactions = servise.getUserTransactions(id);
		for (Transaction transaction : transactions) {
			if(transaction.getCategory().equals(Transaction.TransferCategory.DEBIT))
				System.out.println("To "+transaction.getRecipient().getName() +"(id = "+ transaction.getRecipient().getIdentifier() +
						") "+transaction.getAmount() + " with id = "+ transaction.getIdentifier());
			else
				System.out.println("From "+transaction.getSender().getName() +"(id = "+ transaction.getSender().getIdentifier() +
						") "+transaction.getAmount() + " with id = "+ transaction.getIdentifier());
		}
	}

	private void removeTransaction(){
		System.out.println("Enter a user ID and a transfer ID");
		System.out.print("->	");
		int userId = scanner.nextInt();
		String transferId = scanner.next();
		User user = servise.getUsersList().getUserById(userId);
		Transaction t = user.getTransactions().getTransactionById(transferId);
		this.servise.removeTransaction(userId, transferId);
		if (t.getCategory().equals(Transaction.TransferCategory.DEBIT))
			System.out.println("Transfer To "+t.getRecipient().getName()+"(id = "+t.getRecipient().getIdentifier()+
					") "+Math.abs(t.getAmount())+" removed");
		else
			System.out.println("Transfer From "+t.getSender().getName()+"(id = "+t.getSender().getIdentifier()+
					") "+Math.abs(t.getAmount())+" removed");
	}

	private void transferValidity(){
		System.out.println("Check results:");
		Transaction[] transactions = servise.validityTransactionsCheck();
		for (Transaction transaction : transactions) {
			boolean check = transaction.getCategory().equals(Transaction.TransferCategory.DEBIT);
			if(check)
				System.out.println(transaction.getSender().getName() + "(id = "+transaction.getSender().getIdentifier()+") has an unacknowledged transfer id = "
						+transaction.getIdentifier()+ " to "+ transaction.getRecipient().getName()+"(id =" +
						transaction.getRecipient().getIdentifier() + ") for "+ Math.abs(transaction.getAmount()));
			else
				System.out.println(transaction.getRecipient().getName() + "(id = "+transaction.getRecipient().getIdentifier()+") has an unacknowledged transfer id = "
						+transaction.getIdentifier()+ " from "+ transaction.getSender().getName()+"(id =" +
						transaction.getSender().getIdentifier() + ") for "+ Math.abs(transaction.getAmount()));
		}
	}
}
