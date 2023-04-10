package com.example.home0304;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppAutoContext {
    @Autowired
    private Order order;

    @Bean

    public PaymentGateway gateway1(){
    PaymentGateway paymentGateway=new PaymentGateway(order,1);

    return paymentGateway;
}
    @Bean
    public PaymentGateway gateway2(){

        return new PaymentGateway(order,2);
    }
}
