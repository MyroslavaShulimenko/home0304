package com.example.home0304;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "pen")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public final class Order {
 private String  item;
 private Integer price;

    public Order() {
        item="pen";
        price=33;
    }

    public Order(String item, Integer price) {
        this.item = item;
        this.price = price;
    }




    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "item='" + item + '\'' +
                ", price=" + price +
                '}';
    }
}
