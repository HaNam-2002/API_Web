package com.ensat.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Product entity.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pID;
    private String name;
    private  String image;
    private BigDecimal price; // xem lại kiểu dữ liệu thử có cần dùng BigDecimal không :v Int là đủ :v -> 2^32  2 tỷ 1
    private String title;
    private String description;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "cID")
    private Category category;
}

