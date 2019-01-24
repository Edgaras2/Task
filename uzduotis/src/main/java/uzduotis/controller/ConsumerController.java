package uzduotis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cardinity.model.Card;

import uzduotis.entity.Product;
import uzduotis.service.MerchantService;

@Controller
public class ConsumerController {

	private MerchantService merchantService;
	private static double number;

	public ConsumerController(MerchantService merchantService) {
		this.merchantService = merchantService;
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("product", new Product(139.99));
		return "index";
	}

	@GetMapping("/buyProduct/{price}")
	public String buyProduct(@PathVariable double price, Model model) {
		model.addAttribute("price", price);
		number = price;
		return "shoppingCart";
	}

	@GetMapping("/process")
	public String processForm(Model model) {
		model.addAttribute(new Card());
		return "process";
	}

	@PostMapping("/process")
	public String process(@ModelAttribute Card card) {
		if (merchantService.paymentRequest(number, card)) {
			return "response";
		}
		return "redirect:/process";
	}
}
