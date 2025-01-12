package Java01.ex05;

import java.util.UUID;

public class TransactionsService {
	private UsersList usersList;

	public TransactionsService(){
		this.usersList = new UsersArrayList();
	}

	public User addUser(String userName, double balance){
		User newUser = new User(userName, balance);
		this.usersList.AddUser(newUser);
		return newUser;
	}

	public double getBalance(int id){
		User user = this.usersList.getUserById(id);
		return user.getBalance();
	}

	public void executeTransaction(int sender, int recipient, double amount){
		User user1 = usersList.getUserById(sender);
		User user2 = usersList.getUserById(recipient);

		if (user1.getBalance() < amount)
			throw new IllegalTransactionException("Sender has insufficient balance.");
		if (amount <= 0)
			throw new IllegalTransactionException("Amount must be positive.");

		String transactionID = UUID.randomUUID().toString();
		Transaction debit = new Transaction(transactionID,user1,user2, Transaction.TransferCategory.DEBIT, -amount);
		Transaction credit = new Transaction(transactionID,user1,user2, Transaction.TransferCategory.CREDIT, amount);

		user1.getTransactions().addTransaction(debit);
		user2.getTransactions().addTransaction(credit);

		user1.setBalance(user1.getBalance()-amount);
		user2.setBalance(user2.getBalance()+amount);
	}

	public Transaction[] getUserTransactions(int id){
		User user = usersList.getUserById(id);
		return user.getTransactions().toArray();
	}

	public void removeTransaction(int userId, String transactionId){
		User user = usersList.getUserById(userId);
		user.getTransactions().removeTransactionById(transactionId);
	}

	public Transaction[] validityTransactionsCheck(){
		TransactionsList unpairedTransactions = new TransactionsLinkedList();
		for (int i = 0; i < this.usersList.getNumberOfUsers(); i++) {
			User currentUser = this.usersList.getUserById(i);
			Transaction[] allTransaction = currentUser.getTransactions().toArray();
			for (Transaction transaction : allTransaction){
				User otherUser = transaction.getSender();
				if (transaction.getSender().getIdentifier().equals(currentUser.getIdentifier())){
					otherUser = transaction.getRecipient();
				}
				boolean hasMatch = false;
				Transaction[] otherUserallTransaction = otherUser.getTransactions().toArray();
				for (Transaction otherTransaction : otherUserallTransaction){
					if (otherTransaction.getIdentifier().equals(transaction.getIdentifier())){
						hasMatch = true;
						break;
					}
				}
				if (!hasMatch)
					unpairedTransactions.addTransaction(transaction);
			}
		}
		return unpairedTransactions.toArray();
	}
}