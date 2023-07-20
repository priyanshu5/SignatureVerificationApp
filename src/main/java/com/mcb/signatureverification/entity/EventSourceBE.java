package com.mcb.signatureverification.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "event_source")
@Data
public class EventSourceBE extends BaseAuditBE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "business_key")
    private String businessKey;

    @Column(name = "application")
    private String application;

    @Column(name = "comments")
    private String comments;

    @Column(name = "transaction_currency")
    private String transactionCurrency;

    @Column(name = "transaction_amount")
    private Double transactionAmount;

    @Column(name = "amount_in_mur")
    private Double amountInMur;

    @Column(name = "debit_account_number")
    private String debitAccountNumber;

    @Column(name = "account_short_name")
    private String accountShortName;

    @Column(name = "debit_account_ccy")
    private String debitAccountCcy;

    @Column(name = "payment_details_1")
    private String paymentDetails1;

    @Column(name = "payment_details_2")
    private String paymentDetails2;

    @Column(name = "payment_details_3")
    private String paymentDetails3;

    @Column(name = "payment_details_4")
    private String paymentDetails4;

    @Column(name = "verified")
    private String verified;

    @Column(name = "discrepancy_reason")
    private String discrepancyReason;

    @Column(name = "priority")
    private String priority;

    @Column(name = "source_bu")
    private String sourceBu;

    @Column(name = "document_capture_reference")
    private String documentCaptureReference;

    @Column(name = "status")
    private String status;

    @Column(name = "assign_to")
    private String assignTo;


    // Constructors, getters, and setters
}
