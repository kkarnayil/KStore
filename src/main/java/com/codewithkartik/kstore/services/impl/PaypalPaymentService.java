package com.codewithkartik.kstore.services.impl;

import com.codewithkartik.kstore.services.PaymentService;

public class PaypalPaymentService implements PaymentService {

    @Override
    public void processPayment(String paymentDetails) {
        // Logic to process payment using Stripe API
        System.out.println("Processing payment with Paypal: " + paymentDetails);
        // Here you would typically call the Stripe API to handle the payment
    }   
}
