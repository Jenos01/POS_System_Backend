package com.example.demo.Controllers;


import com.example.demo.Entity.Payement;
import com.example.demo.Service.PayementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("payment")
public class PaymentController {


    private final PayementService payementService;


    @PostMapping
    public Payement addPayment(@RequestBody Payement payment) {
        return payementService.addPayment(payment);
    }
}
