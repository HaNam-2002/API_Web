package com.ensat.entities;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Getter
@Setter
public class Category {
    @Id
    private Long cID ;
    private  Long cname;

    public Category() {}

    public Category(Long cID, Long cname) {
        this.cID = cID;
        this.cname = cname;
    }
}
