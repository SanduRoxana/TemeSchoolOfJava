package com.example.exemplu4.model;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private int cardId;
    private String ownerName;
    private List<Transaction> transactionList = new ArrayList<>();

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", ownerName='" + ownerName + '\'' +
                ", transactionList=" + transactionList +
                '}';
    }
}
