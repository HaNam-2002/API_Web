package com.ensat.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uID;

    private String user;

    private String pass;

    private Integer phone;

    private String address;

    @ManyToOne
    @JoinColumn(name = "rID")
    private Role role;
    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public  Account() {}
    public Account(String user, String pass, Integer phone, String address) {
        this.user = user;
        this.pass = pass;
        this.phone = phone;
        this.address = address;
    }




}
