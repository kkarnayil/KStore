package com.codewithkartik.kstore.services.impl;

import com.codewithkartik.kstore.services.OrderService;
import com.codewithkartik.kstore.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.codewithkartik.knotification.NotificationManager;

public class OrderServiceImpl implements OrderService {

    private final PaymentService paymentService;

    private final NotificationManager notificationManager;

    public OrderServiceImpl(PaymentService paymentService, NotificationManager notificationManager) {
        this.paymentService = paymentService;
        this.notificationManager = notificationManager;
    }

    @Override
    public void placeOrder(String orderDetails) {
        // Logic to place an order
        System.out.println("Placing order: " + orderDetails);
       this.paymentService.processPayment("10 $");
       this.notificationManager.sendNotification("Order placed successfully");
    }

}
