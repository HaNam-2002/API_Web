package com.ensat.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer OrderItem_ID;
    private int price;
    private int amount;
    @ManyToOne(targetEntity = OrderDetail.class)
    private OrderDetail orderDetail;
    @ManyToOne(targetEntity = Product.class)
    private Product product;
}

