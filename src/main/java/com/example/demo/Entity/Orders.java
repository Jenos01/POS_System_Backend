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
public class Orders { ///owner of relation order - orderItems

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    // @JsonBackReference
    private Users user;


    private BigDecimal orderTotalPrice; // sum of all items price

    private Timestamp orderTime;

    private String orderNumber;


    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItems> orderItems;

    public void addOrderItems(Products products, Integer quantity, BigDecimal unitPrice, BigDecimal totalItemPrice) {
        OrderItems association = new OrderItems();
        association.setProducts(products);
        association.setOrder(this);
        association.setQuantity(quantity);
        association.setUnitPrice(unitPrice);
        association.setTotalItemPrice(totalItemPrice);

        this.orderItems.add(association);
    }


    @ManyToOne
    @JoinColumn(name = "client_id")
    // @JsonBackReference
    private Client client;


    protected void calculateTotalOrderPrice() {

        BigDecimal total = BigDecimal.ZERO;

        for (OrderItems item : orderItems) {
            if (item.getTotalItemPrice() != null) {
                total = total.add(item.getTotalItemPrice());
            }
        }
        //return this.orderTotalPrice = total;
        setOrderTotalPrice(total);
    }


}

//    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference
//    private List<OrderItems> orderItems;


//    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private Payement payment;



