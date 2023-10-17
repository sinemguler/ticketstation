package com.ticketstation.client;


import com.ticketstation.request.PaymentRequest;
import com.ticketstation.response.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@FeignClient(value = "payment-service", url = "http://localhost:8080")
public interface PaymentServiceClient {
    @PostMapping
    PaymentResponse pay(@RequestBody PaymentRequest paymentRequest);

    @GetMapping
    public ResponseEntity<List<PaymentResponse>> getAll();

    @GetMapping("/amount/{userId}")
    public double getUserAmount(@PathVariable int userId);

}
