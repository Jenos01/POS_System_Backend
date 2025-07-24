package com.example.demo.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
//import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Payement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;
    private String payment_type;
    private Timestamp payment_time;


    @OneToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Orders order;
}