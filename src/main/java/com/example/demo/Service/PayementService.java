package com.example.demo.Service;

import com.example.demo.Entity.Payement;
import com.example.demo.Repository.PayementRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PayementService {

    private final PayementRepository payementRepository;




    public Payement addPayment(Payement payment) {
        return payementRepository.save(payment);
    }

    public List<Payement> getAllPayments() {
        return payementRepository.findAll();
    }
}
