package uzduotis.service;

import org.springframework.stereotype.Service;

import com.cardinity.model.Card;
import com.cardinity.model.Payment;


@Service
public class MerchantService {

	private PaymentService paymentService;
	private CardinityService cardinityService;
	public MerchantService(PaymentService paymentService, CardinityService cardinityService) {
		this.paymentService = paymentService;
		this.cardinityService = cardinityService;
	}
	
	public boolean paymentRequest(double price, Card card) {
		Payment payment = paymentService.setPayment(price);
		return cardinityService.createNewPayment(payment, card);
		
	}
}
