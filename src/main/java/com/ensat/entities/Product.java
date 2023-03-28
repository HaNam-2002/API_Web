package com.ensat.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Product entity.
 */
@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pID;
    private String name;
    private  String image;
    private BigDecimal price;
    private String title;
    private String description;

    public  Product() {}
    public Product(String name, String image, BigDecimal price, String title, String description) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.title = title;
        this.description = description;
    }
}

