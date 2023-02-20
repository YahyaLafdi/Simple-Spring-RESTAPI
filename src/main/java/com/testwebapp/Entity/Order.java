package com.testwebapp.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double quantity ;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private  Customer customer;

    public Order() {
    }
    public Order( String name, double quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;

    }
    public Order( String name, double quantity,Customer customer) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
