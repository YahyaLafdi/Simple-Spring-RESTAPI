package com.testwebapp.service;

import com.testwebapp.Entity.Customer;

import java.util.List;

public interface CustomerService {
public List<Customer> getCustomers();
    public void deleteCustomer(int id);

}
