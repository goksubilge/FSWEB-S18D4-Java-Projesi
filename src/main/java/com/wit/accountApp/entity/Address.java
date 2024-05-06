package com.wit.accountApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="address", schema="fsweb")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="street")
    private String street;

    @Column(name="no")
    private String no;

    @Column(name="city")
    private String city;

    @Column(name="country")
    private double country;

    @Column(name="description")
    private double description;

    @OneToOne(mappedBy = "address", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Customer customer;
}
