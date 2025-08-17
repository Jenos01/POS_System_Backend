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



    //product snapshot
    private String productName;
    private BigDecimal productPrice;
    private BigDecimal productTaxRate;





    @ManyToOne
    @JoinColumn(name = "order_id")   // 5allitHa w zedt @JsonIgnore 5tr ki inna7eha ywalli ma3ach y3rf l'order (nrmlmnt)  w ywalli ma3ach y'recoogniz'i fi setOrder(this) fl method li fi Orders class
   // @JsonBackReference
    @JsonIgnore
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "product_id")
  //  @JsonBackReference
    private Products products;


    ///  if i add here @Prepersist and @PreUpdate, ill remove [this line] cuz it will be called each time i update quantity for exemple (ynjm tsir mn mba3ed fl real life,someone order 2 pizza w mba3ed dhHorlo bch yzid ka3ba o5ra so ena ki ena bch nmodifi w nrodHom 3 lezem l calcul ysir l'appel marra o5ra lel function w tetbdl w tet'sav'a) (so it's a better solytion in this case walla da5eltHa baadhHa ena hh !)(nchlh manatl3ch overthink'itHa l7aja kl3ada hhh)  ,
   ///  w idha manest3mlch @Prepersist w @PreUpdate nwalli lezmni fl service i called it, idha klemi lkol s7i7, ywalliw l'annotations 5ir (base mouch fl 7alet lkol, mais en cas li ena met2aked mn enno bch nl9a lresult li 7achti beha) akkeka nb3d aal boilerplat w katben logique w ostra zeyda, kima n9olo madem aandi 7aja 7adhra why naaml feha w7di
    protected void calculateTotalItemPrice() {
       setTotalItemPrice(unitPrice.multiply(BigDecimal.valueOf(quantity)));
   }

   public void productSnapshot(Products product) {
       this.products = product;
       this.productName = product.getName();
       this.productPrice = product.getPrice();
       this.productTaxRate = product.getTaxRate();
       calculateTotalItemPrice(); /// [this line]
   }


}

