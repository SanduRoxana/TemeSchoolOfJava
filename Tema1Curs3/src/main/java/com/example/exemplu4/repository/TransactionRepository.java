package com.example.exemplu4.repository;

import com.example.exemplu4.model.Card;
import com.example.exemplu4.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository {
    private List<Transaction> transactions = new ArrayList<>();

    @Autowired
    public TransactionRepository(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void updateTransaction(int transactionId, Transaction transaction) {
        for(Transaction t : transactions) {
            if((t.getTransactionId() == transaction.getTransactionId()) && (transaction.getTransactionId() == transactionId)) {
                t.setStore(transaction.getStore());
                t.setAmount(transaction.getAmount());
                break;
            }
        }
    }

    public void deleteTransaction(int transactionId) {
        for(Transaction t : transactions) {
            if (t.getTransactionId() == transactionId) {
                transactions.remove(t);
                break;
            }
        }
    }
}
