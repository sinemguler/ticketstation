package paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import paymentservice.request.PaymentRequest;
import paymentservice.response.PaymentResponse;
import paymentservice.service.PaymentService;

import java.util.List;


@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public PaymentResponse pay(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.pay(paymentRequest);
    }

    @GetMapping
    public ResponseEntity<List<PaymentResponse>> getAll() {
        return ResponseEntity.ok(paymentService.getAll());
    }

    @GetMapping("/balance/{userId}")
    public double getUserBalance(@PathVariable int userId) {
        return paymentService.getBalanceByUserId(userId);
    }

}
