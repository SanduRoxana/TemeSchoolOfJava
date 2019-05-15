package com.example.exemplu4.service;

import com.example.exemplu4.model.Transaction;
import com.example.exemplu4.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void addTransaction(Transaction transaction, HttpServletResponse response) {
        if(transaction.getTransactionId() > 0 && (!transaction.getStore().equals("")) && transaction.getAmount() > 0) {
            transactionRepository.addTransaction(transaction);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.getTransactions();
    }

    public void updateTransaction(int transactionId, Transaction transaction, HttpServletResponse response) {
        int goodRequest = 1;
        if(transactionId > 0) {
            if ((transaction.getTransactionId() > 0) && (!transaction.getStore().equals("")) && (transaction.getAmount() > 0)) {
                goodRequest = 0;
            }
        }
        if(goodRequest == 0) {
            transactionRepository.updateTransaction(transactionId, transaction);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    public void deleteTransaction(int transactionId, HttpServletResponse response) {
        if(transactionId > 0) {
            transactionRepository.deleteTransaction(transactionId);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
