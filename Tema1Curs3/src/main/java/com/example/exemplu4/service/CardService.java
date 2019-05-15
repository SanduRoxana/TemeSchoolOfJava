package com.example.exemplu4.service;

import com.example.exemplu4.model.Card;
import com.example.exemplu4.model.Transaction;
import com.example.exemplu4.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class CardService {
    private CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public void addCard(Card card, HttpServletResponse response) {
        int goodRequest = 1;
        if ((card.getCardId() > 0) && (!card.getOwnerName().equals(""))) {
            if(card.getTransactionList().isEmpty()) {
                goodRequest = 0;
            } else {
                for (Transaction transaction : card.getTransactionList()) {
                    if (transaction.getTransactionId() > 0 && (!transaction.getStore().equals(""))
                            && transaction.getAmount() > 0) {
                        goodRequest = 0;
                    }
                }
            }
        }
        if(goodRequest == 0) {
            cardRepository.addCard(card);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    public List<Card> getCards() {
        return cardRepository.getCards();
    }

    public void updateCard(int cardId, Card card, HttpServletResponse response) {
        String ownerName = card.getOwnerName();
        if ((cardId > 0) && (!ownerName.equals(""))) {
            cardRepository.updateCard(cardId, card);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    public void deleteCard(int cardId, HttpServletResponse response) {
        if (cardId > 0) {
            cardRepository.deleteCard(cardId);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    public void addCardTransaction(int cardId, Transaction transaction, HttpServletResponse response) {
        if (cardId > 0 && transaction.getTransactionId() > 0 &&
                (!transaction.getStore().equals("")) && transaction.getAmount() > 0) {
            cardRepository.addCardTransaction(cardId, transaction);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    public List<Transaction> getCardTransactions(int cardId, HttpServletResponse response) {
        if (cardId > 0) {
            return cardRepository.getCardTransactions(cardId);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
    }

    public void updateCardTransaction(int cardId, int transactionId, Card card, HttpServletResponse response) {
        int goodRequest = 1;
        if (cardId > 0 && transactionId > 0 && (card.getCardId() > 0) && (!card.getOwnerName().equals(""))) {
            if(card.getTransactionList().isEmpty()) {
                goodRequest = 0;
            } else  {
                for (Transaction transaction : card.getTransactionList()) {
                    if((transaction.getTransactionId() > 0) && (!transaction.getStore().equals("")) && transaction.getAmount() > 0) {
                        goodRequest = 0;
                    }
                }
            }
        }
        if (goodRequest == 0) {
            cardRepository.updateCardTransaction(cardId, transactionId, card);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    public void deleteCardTransaction(int cardId, int transactionId, HttpServletResponse response) {
        if(cardId > 0 && transactionId > 0) {
            cardRepository.deleteCardTransaction(cardId, transactionId);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
