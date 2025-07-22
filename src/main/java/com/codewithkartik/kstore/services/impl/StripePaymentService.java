package com.codewithkartik.kstore.services.impl;

import com.codewithkartik.kstore.services.PaymentService;
import org.springframework.beans.factory.annotation.Value;

public class StripePaymentService implements PaymentService {

    @Value("${stripe.timeout}")
    private String timeout;

    @Override
    public void processPayment(String paymentDetails) {
        // Logic to process payment using Stripe API
        System.out.println("Processing payment with Stripe: " + paymentDetails);
        System.out.println("Timeout setting: " + timeout);
        // Here you would typically call the Stripe API to handle the payment
    }
}
