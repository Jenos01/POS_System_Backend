package com.example.demo.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryNote { ///Bon de Livraison

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private Timestamp deliveryDate;

    private String deliveryAdress; // the client adress

   // private String status; //

    @OneToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    protected void setDeliveryAdress(){
        setDeliveryAdress(client.getAdresse());
    }
}
