package com.ticketstation.response;

public class PaymentResponse {
    private int id;
    private int userId;
    private Double balance;


    public PaymentResponse() {
    }

    public PaymentResponse(int id, int userId, Double balance) {
        this.id = id;
        this.userId = userId;
        this.balance = balance;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
