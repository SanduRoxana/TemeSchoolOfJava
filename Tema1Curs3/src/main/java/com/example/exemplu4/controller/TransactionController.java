package com.example.exemplu4.controller;

import com.example.exemplu4.model.Transaction;
import com.example.exemplu4.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class TransactionController {
    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(path = "/add/transaction")
    public void addTransaction(@RequestBody Transaction transaction, HttpServletResponse response) {
        transactionService.addTransaction(transaction, response);
    }

    @GetMapping(path = "/get/transaction")
    public List<Transaction> getTransactions() {
        return transactionService.getTransactions();
    }

    @PutMapping(path = "/update/transaction/{transactionId}")
    public void updateTransaction(@PathVariable int transactionId, @RequestBody Transaction transaction,
                                  HttpServletResponse response) {
        transactionService.updateTransaction(transactionId, transaction, response);
    }

    @DeleteMapping(path = "/delete/transaction/{transactionId}")
    public void deleteTransaction(@PathVariable int transactionId, HttpServletResponse response) {
        transactionService.deleteTransaction(transactionId, response);
    }
}
