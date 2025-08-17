package com.example.demo.Entity;


import com.example.demo.Enums.PaymentStatus;
import com.example.demo.Enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {  ///Facture

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private Timestamp issueDate;

    private Timestamp dueDate;

    private BigDecimal subtotal; // 9bl tax

    private BigDecimal taxAmount;

    private BigDecimal totalAmount; // b3d tax

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Orders order;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    @PrePersist
    public void generateInvoiceNumber() { //just exemple w barra  and i wanted to use prepersist hh :)
        if (this.number == null) {
            this.number = "INV-" + System.currentTimeMillis();
        }
    }


//    private void test(){
//        order.getOrderItems().forEach(item -> {item.getProductName();});
//    }
}
