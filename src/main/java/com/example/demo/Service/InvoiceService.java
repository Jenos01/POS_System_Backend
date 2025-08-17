package com.example.demo.Service;

import com.example.demo.Entity.Invoice;
import com.example.demo.Repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public Invoice addInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public Invoice getInvoiceByIssueDate(Timestamp issueDate) {
        return invoiceRepository.findByIssueDate(issueDate);
    }

//    public List<Invoice> getInvoiceByClientLastName(String clientLastName) {
//        return invoiceRepository.findByClientLastName(clientLastName);
//    }
}
