package paymentservice.converter;

import org.springframework.stereotype.Component;
import paymentservice.model.Payment;
import paymentservice.request.PaymentRequest;
import paymentservice.response.PaymentResponse;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentConverter {

    public PaymentResponse convert(Payment payment) {
        PaymentResponse response = new PaymentResponse();
        response.setId(payment.getId());
        response.setUserId(payment.getUserId());
        response.setBalance(payment.getBalance());

        return response;

    }

    public Payment convert(PaymentRequest paymentRequest) {
        Payment payment = new Payment();
        payment.setUserId(paymentRequest.getUserId());
        payment.setBalance(paymentRequest.getBalance());
        payment.setCvv(paymentRequest.getCvv());
        payment.setAccountNumber(paymentRequest.getAccountNumber());
        payment.setCardNumber(paymentRequest.getCardNumber());
        return payment;
    }


    public List<PaymentResponse> convert(List<Payment> paymentList) {
        List<PaymentResponse> paymentResponse = new ArrayList<>();

        for (Payment payment : paymentList) {
            paymentResponse.add(convert(payment));
        }
        return paymentList.stream().map(this::convert).toList();
    }
}
