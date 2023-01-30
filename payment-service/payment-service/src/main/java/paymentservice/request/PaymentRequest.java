package paymentservice.request;

public class PaymentRequest {
    private int userId;
    private String cardNumber;
    private String cvv;
    private String accountNumber;
    private Double balance;


    public PaymentRequest() {
    }

    public PaymentRequest(int userId, String cardNumber, String cvv, String accountNumber, Double balance) {
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.accountNumber = accountNumber;
        this.balance = balance;
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
