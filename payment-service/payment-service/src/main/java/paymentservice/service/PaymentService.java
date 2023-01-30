package paymentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paymentservice.converter.PaymentConverter;
import paymentservice.model.Payment;
import paymentservice.repository.PaymentRepository;
import paymentservice.request.PaymentRequest;
import paymentservice.response.PaymentResponse;

import java.util.List;
import java.util.Optional;


@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentConverter paymentConverter;

    public PaymentResponse pay(PaymentRequest paymentRequest) {
        Payment payment = paymentConverter.convert(paymentRequest);
        Payment savedPayment = paymentRepository.save(payment);
        return paymentConverter.convert(savedPayment);
    }


    public List<PaymentResponse> getAll(){
        return paymentConverter.convert(paymentRepository.findAll());
    }

    public double getBalanceByUserId(int userId) {
        Payment payment = paymentRepository.findByUserId(userId);
        return payment.getBalance();
    }
    public Optional<Payment> getById(Integer paymentId) {
        return paymentRepository.findById(paymentId);
    }
}

