package com.codewithkartik.kstore;

import com.codewithkartik.kstore.services.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.codewithkartik.kstore", "com.codewithkartik.knotification"})
public class KstoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(KstoreApplication.class, args);

		OrderService orderService = (OrderService) context.getBean("orderService");
		orderService.placeOrder("Order details for Kstore");
	}


}
