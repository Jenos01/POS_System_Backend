package com.example.demo.Controllers;


import com.example.demo.Entity.Invoice;
import com.example.demo.Service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("invoice")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService ;

    @PostMapping
    public Invoice addInvoice(@RequestBody Invoice invoice) {
        return invoiceService.addInvoice(invoice);
    }


    @GetMapping("/{issueDate}")
    public Invoice getInvoiceByIssueDate(@PathVariable Timestamp issueDate) {
        return invoiceService.getInvoiceByIssueDate(issueDate);
    }


//    @GetMapping("/{clientLastName")
//    public List<Invoice> getInvoiceByClientLastName(@PathVariable String clientLastName) {
//        return invoiceService.getInvoiceByClientLastName(clientLastName);
//    }
}
