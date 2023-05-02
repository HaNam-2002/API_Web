package com.ensat.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CartID")
    private Integer cartId;

    @OneToOne
    @JoinColumn(name = "uID")
    @JsonIgnore
    private Account account;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;


}
