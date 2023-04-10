package com.example.home0304;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Home0304Application {

    public static void main(String[] args) {
        SpringApplication.run(Home0304Application.class, args);
        //а) С применением xml конфигурации
  //      ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      // ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class); //б) С применением java-конфигурации
       ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppAutoContext.class); //) С применением Auto
//        Order order1= (Order) context.getBean("order");
//        Order order2= (Order) context.getBean("order1");
//
//        System.out.println(order1);
//        System.out.println(order2);

       PaymentGateway paymentGateway1= (PaymentGateway) context.getBean("gateway1");
        System.out.println(paymentGateway1 + " Buyer -"+ paymentGateway1.getId());
//        Order order2= (Order) context.getBean("order2");
//        System.out.println(order2);
        PaymentGateway paymentGateway2= (PaymentGateway) context.getBean("gateway2");
        System.out.println(paymentGateway2 + " Buyer -"+ paymentGateway2.getId());
    }

}
// 1 уровень сложности: 1.Создайте класс Order с полями item и price. Добавьте бин в свой файл конфигурации.
//Создайте класс PaymentGateway, в котором будет присутствовать поле Order.
//
//public class PaymentGateway {
//    private Order order;
//    @Override
//    public String toString(){
//        return "ordering "+this.order.getItem()+" | price: "+this.order.getPrice();
//    }
//}