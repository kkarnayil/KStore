package com.codewithkartik.kstore.config;

import com.codewithkartik.knotification.NotificationManager;
import com.codewithkartik.knotification.services.NotificationService;
import com.codewithkartik.knotification.services.impl.EmailNotificationService;
import com.codewithkartik.knotification.services.impl.MessageNotificationService;
import com.codewithkartik.kstore.services.OrderService;
import com.codewithkartik.kstore.services.PaymentService;
import com.codewithkartik.kstore.services.impl.OrderServiceImpl;
import com.codewithkartik.kstore.services.impl.PaypalPaymentService;
import com.codewithkartik.kstore.services.impl.StripePaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${kstore.notification-type}")
    private String notificationType;

    @Value("${kstore.payment-type}")
    private String paymentType;

    @Bean
    public PaymentService stripe(){
        return new StripePaymentService();
    }

    @Bean
    public PaymentService paypal(){
        return new PaypalPaymentService();
    }

    @Bean
    public OrderService orderService(){
        if(paymentType.equalsIgnoreCase("stripe")){
            return new OrderServiceImpl(stripe(), notificationManager());
        }
        return new OrderServiceImpl(paypal(), notificationManager());
    }


    @Bean
    public NotificationService email(){
        return new EmailNotificationService();
    }

    @Bean
    public NotificationService sms(){
        return new MessageNotificationService();
    }

    @Bean
    public NotificationManager notificationManager(){
        if(notificationType.equalsIgnoreCase("email")){
            return new NotificationManager(email());
        }
        return new NotificationManager(sms());
    }
}
