package com.ensat.entities;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CartID")
    private Integer cartId;

    @OneToOne
    @JoinColumn(name = "uID")
    private Account account;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;

    public Cart(Integer cartId, Account account, List<CartItem> cartItems) {
        this.cartId = cartId;
        this.account = account;
        this.cartItems = cartItems;
    }
    public  Cart() {

    }


}
