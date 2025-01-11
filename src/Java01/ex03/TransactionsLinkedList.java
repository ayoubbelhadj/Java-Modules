package Java01.ex03;

import java.util.Objects;

class TransactionNode{
	Transaction data;
	TransactionNode	next;
	TransactionNode(Transaction t){
		this.data = t;
		this.next = null;
	}
}
public class TransactionsLinkedList implements TransactionsList{
	private TransactionNode head;
	private int	size;

	TransactionsLinkedList(){
		this.head = null;
	}

	public int getSize(){
		return size;
	}

	public TransactionNode getHead() {
		return head;
	}

	@Override
	public void addTransaction(Transaction t) {
		TransactionNode newNode = new TransactionNode(t);
		if (this.head == null){
			this.head = newNode;
			this.size++;
			return;
		}
		TransactionNode tmp = this.head;
		while (tmp.next != null){
			tmp = tmp.next;
		}
		tmp.next = newNode;
		this.size++;
	}


	@Override
	public void removeTransactionById(String uuid) throws TransactionNotFoundException {
		if (this.head == null)
			throw new TransactionNotFoundException("Transaction list is empty.");

		if (this.head.data.getIdentifier().equals(uuid)) {
			this.head = this.head.next;
			size--;
			return;
		}
		TransactionNode tmp = head;
		while (tmp.next != null){
			if (tmp.next.data.getIdentifier().equals(uuid)){
				tmp.next = tmp.next.next;
				size--;
				return;
			}
			tmp = tmp.next;
		}
		throw new TransactionNotFoundException("Transaction: " + uuid + " not found.");
	}

	@Override
	public Transaction[] toArray() {
		Transaction[] transactionsArray = new Transaction[size];
		TransactionNode tmp = head;
		int i = 0;

		while (tmp != null){
			transactionsArray[i] = tmp.data;
			i++;
			tmp = tmp.next;
		}
		return transactionsArray;
	}
}