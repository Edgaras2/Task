package uzduotis.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.cardinity.model.Payment;

@Service
public class PaymentService {
	
	public Payment setPayment(double price) {
		Payment payment = new Payment();
		payment.setAmount(BigDecimal.valueOf(price));
		payment.setCurrency("EUR");
		payment.setCountry("LT");
		payment.setOrderId("333333");
		payment.setPaymentMethod(Payment.Method.CARD);
		return payment;
	}
}
