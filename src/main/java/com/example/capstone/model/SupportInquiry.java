package com.example.capstone.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "supportInquiries")
public class SupportInquiry {
    @Id
    private String id;
    private String email;
    private String inquiry;
    private String status;
    private Date date; // Adding the date field

    // Constructors, Getters, and Setters
    public SupportInquiry() {
    }

    public SupportInquiry(String id, String email, String inquiry, Date date) {
        this.id = id;
        this.email = email;
        this.inquiry = inquiry;
        this.date = date; // Set the date in constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInquiry() {
        return inquiry;
    }

    public void setInquiry(String inquiry) {
        this.inquiry = inquiry;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}