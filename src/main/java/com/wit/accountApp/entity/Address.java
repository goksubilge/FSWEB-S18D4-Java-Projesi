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
    private int no;

    @Column(name="city")
    private String city;

    @Column(name="country")
    private String country;

    @Column(name="description")
    private String description;

    @OneToOne(mappedBy = "address", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="address_id")
    // @JoinColumn => foriegn key
    private Customer customer;

    // bir customer bir adrese sahip olabilir.
    // address silinince customer silinmesin.

    /*
    {
    "street":"banana street",
    "no":"2",
    "city":"Boston",
    "country":"USA",
    "description":"near by market"
    }
     */
}
