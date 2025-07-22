package com.codewithkartik.kstore.contollers;

import com.codewithkartik.kstore.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/")
    public String index() {
        orderService.placeOrder("Order details for Kstore");
        return "index.html";
    }
}
