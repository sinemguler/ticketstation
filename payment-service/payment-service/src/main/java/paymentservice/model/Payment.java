package paymentservice.model;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "cvv")
    private String cvv;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "balance")
    private Double balance;
    public Payment() {
    }

    public Payment(int userId, String cardNumber, String cvv, String accountNumber, Double balance) {
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.accountNumber = accountNumber;
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

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
