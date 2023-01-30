package paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import paymentservice.model.Payment;


public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    Payment findByUserId(int userId);

}
