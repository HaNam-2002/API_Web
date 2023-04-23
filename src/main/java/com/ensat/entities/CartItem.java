package com.ensat.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemID;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "pID", referencedColumnName = "pID")
    private Product product;

    @ManyToOne(targetEntity = Cart.class)
    @JoinColumn(name = "cartID", referencedColumnName = "cartID")
    private Cart cart;

    private Integer amount;


}
