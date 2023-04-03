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
    private Integer cID ;
    private  Long cname;

    public Category() {}

    public Category(Integer cID, Long cname) {
        this.cID = cID;
        this.cname = cname;
    }

    public Integer getcID() {
        return cID;
    }

    public void setcID(Integer cID) {
        this.cID = cID;
    }

    public Long getCname() {
        return cname;
    }

    public void setCname(Long cname) {
        this.cname = cname;
    }
}
