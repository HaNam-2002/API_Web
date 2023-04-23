package com.ensat.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail    {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  OrderItem_ID;

    private LocalDateTime dateOrder;
    private int totalPrice;
    @ManyToOne(targetEntity = Account.class)
    private Account user;
    @OneToMany(mappedBy = "orderDetail")
    private List<OrderItem> orderItems;

}
