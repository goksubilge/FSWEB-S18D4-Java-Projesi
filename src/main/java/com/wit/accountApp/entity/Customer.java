package com.wit.accountApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer", schema="fsweb")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="salary")
    private double salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "address_id")
    private Address address;

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.ALL})
    private List<Account> accountList;
}
