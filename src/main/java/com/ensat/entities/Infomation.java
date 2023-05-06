package com.ensat.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Infomation")
public class Infomation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iID;

    @OneToOne(targetEntity = Account.class)
    @JoinColumn(name = "uID")
    private Account uID;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "gmail")
    private String gmail;
}
