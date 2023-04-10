package com.example.home0304;

public class PaymentGateway {
    private Order order;
    private Integer idBuyer;

    public PaymentGateway(Order order, Integer id) {
        this.order = order;
        this.idBuyer = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getId() {
        return idBuyer;
    }

    public void setId(Integer id) {
        this.idBuyer = id;
    }

    public PaymentGateway(String order1, int id) {
    }

    @Override
    public String toString(){
       return "ordering "+this.order.getItem()+" | price: "+this.order.getPrice();
  }
}
