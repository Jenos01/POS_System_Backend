package com.example.demo.Repository;

import com.example.demo.Entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    Invoice findByIssueDate(Timestamp issueDate);

//    List<Invoice> findByClientLastName(String clientLastName);
}
