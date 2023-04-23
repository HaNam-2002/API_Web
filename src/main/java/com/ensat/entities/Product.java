package com.ensat.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Product entity.
 */
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pID;
    private String name;
    private  String image;
    private BigDecimal price;
    private String title;
    private String description;

    @Column(name = "cID")
    private Integer cID; // khai báo khoá ngoiaj đến categoru: xài @OneToMany, @manytoone j đó


    public  Product() {}



    public Product(Integer pID, String name, String image, BigDecimal price, String title, String description, Integer cID, Integer uID) {
        this.pID = pID;
        this.name = name;
        this.image = image;
        this.price = price;
        this.title = title;
        this.description = description;
        this.cID = cID;
    }

    public Integer getcID() {
        return cID;
    }

    public void setcID(Integer cID) {
        this.cID = cID;
    }
    public Integer getpID() {
        return pID;
    }
    public void setpID(Integer pID) {
        this.pID = pID;
    }




}

