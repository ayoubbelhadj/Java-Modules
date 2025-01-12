package Java01.ex05;

public interface TransactionsList {
    void addTransaction(Transaction t);
    void removeTransactionById(String uuid) throws TransactionNotFoundException;
    Transaction[] toArray();
}