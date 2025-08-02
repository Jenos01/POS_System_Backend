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

    private BigDecimal unitPrice;

    private BigDecimal totalItemPrice; // = quantity * unitPrice

    @ManyToOne
    @JoinColumn(name = "order_id")   // 5allitHa w zedt @JsonIgnore 5tr ki inna7eha ywalli ma3ach y3rf l'order (nrmlmnt)  w ywalli ma3ach y'recoogniz'i fi setOrder(this) fl method li fi Orders class
   // @JsonBackReference
    @JsonIgnore
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "product_id")
  //  @JsonBackReference
    private Products products;


   public BigDecimal calculateTotalItemPrice() {
       return totalItemPrice = unitPrice.multiply(BigDecimal.valueOf(quantity));
   }
}

