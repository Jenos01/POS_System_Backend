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
    @JsonBackReference
    private Users user;


    private BigDecimal totalPrice; //could be removed since it's already exist in the orderItems !
    private Timestamp orderTime;
    //private Long orderNumber; //hedha lezmo ykoun automatique incrementation mte3o w unique w kol new day yet'reset'a
    private String orderNumber;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<OrderItems> orderItems;


    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Payement payment;

}

