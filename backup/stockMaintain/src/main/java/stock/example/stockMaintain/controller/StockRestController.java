package stock.example.stockMaintain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import stock.example.stockMaintain.pojo.*;

@RestController
@RequestMapping(value = "/api/stock")
public class StockRestController {
	
	
	
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	
//	@GetMapping(value = "/getpaymentdetail")
//	public PaymentPojo getPaymentDetail() {
//
//		PaymentPojo paymentPojo = new PaymentPojo();
//		paymentPojo.setPaymentId(123);
//		paymentPojo.setPaymentAmount(300000);
//		paymentPojo.setPaymentType("Cash");
//
//		return paymentPojo;
//	}
	
	@GetMapping(value = "/getStockDetail")
	public ResponseEntity<String> welcome() {
		try {
			String welcomeMessage = restTemplate.exchange("http://STOCK/api/stock/stockDashbord",
					HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
					}).getBody();

			System.out.println(welcomeMessage);
			
			return new ResponseEntity<String>(welcomeMessage, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Stock dashboard", HttpStatus.OK);
		}
	}

}
