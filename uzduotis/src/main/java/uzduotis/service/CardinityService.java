package uzduotis.service;

import org.springframework.stereotype.Service;

import com.cardinity.CardinityClient;
import com.cardinity.model.Card;
import com.cardinity.model.Payment;
import com.cardinity.model.Result;

@Service
public class CardinityService {

	private ClientServices clientService;

	public CardinityService(ClientServices clientService) {
		this.clientService = clientService;
	}

	public boolean createNewPayment(Payment payment, Card card) {
		payment.setPaymentInstrument(card);
		CardinityClient client = clientService.getClient();
		Result<Payment> result = client.createPayment(payment);
		
		if (result.isValid() && result.getItem().getStatus() == Payment.Status.APPROVED) {
			return true;
		}
		return false;
	}
}
