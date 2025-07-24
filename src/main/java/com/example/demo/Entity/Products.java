package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private boolean avaliable;
    private Integer qteStock; //this is for the inventory ! w nwalli fi kol marra yetechra w 7asb l qte li tchret inna9esHa w btbi3a 9bl hedha lkol ysir test aal qteStock bon mouch bch t7el mawdho3 l'inventroy à 100% hakka

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_id")
    private Category category;

//    @ManyToOne
//    @JoinColumn(name = "orderItems_id")
//    private OrderItems orderItems;


    //means why the product would know in which order he is in !!
//    @OneToMany(mappedBy = "products")
//    @JsonManagedReference
//    private List<OrderItems> orderItems;


}
