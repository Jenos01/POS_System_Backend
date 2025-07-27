package com.example.demo.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
   // @JsonBackReference
    private Users user;


    private BigDecimal totalPrice;
    private Timestamp orderTime;
    //private Long orderNumber; //hedha lezmo ykoun automatique incrementation mte3o w unique w kol new day yet'reset'a
    private String orderNumber;


    // i know it's a bidirectional(dont get mad about it cuz u told me to do not use bidirectioanl) but i get no other ideas besides this one, it's a join-table (the OrderItems) either i'll use @ManyToMany (which is not
    // recommended 7sb mana3ref) or i'll implemenet it as it was (with @manytoone in the orderItems class) (and this one is inspired from the scenegameobjects
    // mn projet l VR w manich fehemha barcha l7a9 asln mn projet l VR i was like why we putting a function in the entity ...logic should
    // be in the service (i know we have no service for that entity ama b9it n9oul base famma façon o5ra bch n3mlouha ...3rft heka li 93dt famma 7aja flou fi rasi mouch 3arefha chni w mouch m5alya lfaza hedhi td5l l mo5i hh
    // anw nsit w9tHa mas2ltkch aaleha w9tHa ama ahi jet tw fl projet hedha hh ...
    //btw it's not working properly ... ki nposti an order l products yet7atto mriglin ama l order_id null berra8m li ena 3amel association.setOrder(this); fl function
    //so i'll push this and i'll try fix it tomorrow 
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItems> orderItems;

    public void addOrderItems(Products products) {
        OrderItems association = new OrderItems();
        association.setProducts(products);
        association.setOrder(this);

        this.orderItems.add(association);
    }


    @ManyToOne
    @JoinColumn(name = "client_id")
    // @JsonBackReference
    private Client client;




//    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference
//    private List<OrderItems> orderItems;


//    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private Payement payment;

}

