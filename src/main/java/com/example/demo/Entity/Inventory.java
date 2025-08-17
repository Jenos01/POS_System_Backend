package com.example.demo.Entity;


import com.example.demo.Enums.StockStatus;
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
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    private Integer minimumThreshold;

    private Timestamp lastRestock;

    @Enumerated(EnumType.STRING)
    private StockStatus stockStatus;

    private Timestamp expiryDate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;



    /// tw hedha logic, ama awel 7aja tsm3Ha ki tbda fl springboot logic is always in the service layer ama marrat nl9a logic fl entity kima hna mthln kima injm n7otHa hna kima injm n7otHa fl service, my question is : w9teh or kifeh naaref chno l logic li yet7at fl entity w ameho li yet7at fl service
    public void updateStock(int addedQuantity) {
        this.quantity += addedQuantity;
        this.lastRestock = new Timestamp(System.currentTimeMillis());

        if (this.quantity <= this.minimumThreshold) {
            this.stockStatus = StockStatus.LOW_STOCK; // donc bch t3awed tjini alert marra o5ra (fl front) :) // solution (not final one) : n7sb 9addeh ne9sni bch naaref 9adeh nzid lel stock bch n'stocki mrigl ml lawel w n'afficheha fl front maa alert mta3 low stock

        } else {
            this.stockStatus = StockStatus.IN_STOCK;
        }
    }

}
