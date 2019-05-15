package com.example.exemplu4.repository;

import com.example.exemplu4.model.Card;
import com.example.exemplu4.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CardRepository {
    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
            cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void updateCard(int cardId, Card card) {
        for(Card c : cards) {
            if(c.getCardId() == cardId) {
                c.setOwnerName(card.getOwnerName());
                break;
            }
        }
    }

    public void deleteCard(int cardId) {
        for(Card card : cards) {
            if(card.getCardId() == cardId) {
                cards.remove(card);
                break;
            }
        }
    }

    public void addCardTransaction(int cardId, Transaction transaction) {
        for(Card card : cards) {
            if(card.getCardId() == cardId) {
                card.getTransactionList().add(transaction);
            }
        }
    }

    public List<Transaction> getCardTransactions(int cardId) {
        for(Card card : cards) {
            if(card.getCardId() == cardId) {
                return card.getTransactionList();
            }
        }
        return null;
    }

    public void updateCardTransaction(int cardId, int transactionId, Card card) {
        for(Card c : cards) {
            if(c.getCardId() == card.getCardId() && card.getCardId() == cardId) {
                if(c.getTransactionList().isEmpty()) {
                    c.setOwnerName(card.getOwnerName());
                } else {
                    for(Transaction t : c.getTransactionList()) {
                        if(t.getTransactionId() == transactionId) {
                            c.setOwnerName(card.getOwnerName());
                            c.setTransactionList(card.getTransactionList());
                            break;
                        }
                    }
                }
            }
        }
    }

    public void deleteCardTransaction(int cardId, int transactionId) {
        for(Card card : cards) {
            if(card.getCardId() == cardId) {
                if(!card.getTransactionList().isEmpty()) {
                    for(Transaction transaction : card.getTransactionList()) {
                        if(transaction.getTransactionId() == transactionId) {
                            card.getTransactionList().remove(transaction);
                        }
                    }
                }
            }
        }
    }
}
