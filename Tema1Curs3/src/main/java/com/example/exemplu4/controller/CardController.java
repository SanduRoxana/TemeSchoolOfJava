package com.example.exemplu4.controller;

import com.example.exemplu4.model.Card;
import com.example.exemplu4.model.Transaction;
import com.example.exemplu4.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class CardController {
    private CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping(path = "/add/card")
    public void addCard(@RequestBody Card card, HttpServletResponse response) {
        cardService.addCard(card, response);
    }

    @GetMapping(path = "/get/card")
    public List<Card> getCards() {
        return cardService.getCards();
    }

    @PutMapping(path = "/update/card/{cardId}")
    public void updateCard(@PathVariable int cardId, @RequestBody Card card, HttpServletResponse response) {
        cardService.updateCard(cardId, card, response);
    }

    @DeleteMapping(path = "/delete/card/{cardId}")
    public void deleteCard(@PathVariable int cardId, HttpServletResponse response) {
        cardService.deleteCard(cardId, response);
    }

    @PostMapping(path = "/add/cardTransaction/{cardId}")
    public void addCardTransaction(@PathVariable int cardId, @RequestBody Transaction transaction, HttpServletResponse response) {
        cardService.addCardTransaction(cardId, transaction, response);
    }

    @GetMapping(path = "/get/cardTransaction/{cardId}")
    public List<Transaction> getCardTransactions(@PathVariable int cardId, HttpServletResponse response) {
        return cardService.getCardTransactions(cardId, response);
    }

    @PutMapping(path = "/update/cardTransaction/{cardId}/{transactionId}")
    public void updateCardTransaction(@PathVariable int cardId, @PathVariable int transactionId,
                                      @RequestBody Card card, HttpServletResponse response) {
        cardService.updateCardTransaction(cardId, transactionId, card, response);
    }

    @DeleteMapping(path = "/delete/cardTransaction/{cardId}/{transactionId}")
    public void deleteCardTransaction(@PathVariable int cardId, @PathVariable int transactionId,
                                      HttpServletResponse response) {
        cardService.deleteCardTransaction(cardId, transactionId,response);
    }
}