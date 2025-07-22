package com.codewithkartik.kstore.services.impl;

import com.codewithkartik.kstore.services.OrderService;
import com.codewithkartik.kstore.services.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    private final PaymentService paymentService;

    public OrderServiceImpl(@Qualifier("paypal") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void placeOrder(String orderDetails) {
        // Logic to place an order
        System.out.println("Placing order: " + orderDetails);
       this.paymentService.processPayment("10 $");
    }

}
