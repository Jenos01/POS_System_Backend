package com.example.demo.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItems {   //a join-table

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer  quantity;

    private BigDecimal unitPrice; //this is for the part of price -500 etc ... not sure about it

    //no need to store it, i'll calculate it when i need it :)
//    private BigDecimal totalPrice; // = quantity * unitPrice3

    @ManyToOne
    @JoinColumn(name = "order_id")
   // @JsonBackReference
    //@JsonIgnore
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "product_id")
  //  @JsonBackReference
    private Products products;
}

