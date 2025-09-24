package com.example.ecommerce.pay.domain.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name= "order_items")
@Builder
@Setter
@Getter
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="item_idx")
    private int itemIdx;

    private Order order;

    private UUID productId;

    private String productName;

    private int price;

    private String size;

    private int amount;

    private int quantity;

    @Column(name = "order_status")
    @Convert(converter = OrderStatusConverter.class)
    private OrderStatus state;

    protected OrderItem() {

    }

    public void update(OrderStatus state){
        this.state = state;
    }

    public int calculateAmount(){
        int totalPrice = price * quantity;
        this.amount = totalPrice;
        return totalPrice;
    }


}
