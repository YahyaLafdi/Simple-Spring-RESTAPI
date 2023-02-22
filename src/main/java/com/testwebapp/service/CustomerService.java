package com.testwebapp.service;

import com.testwebapp.Entity.Customer;

import java.util.List;

public interface CustomerService {
    public void saveCustomer(Customer temp);
public List<Customer> getCustomers();
    public  Customer  getCustomer(int id);
    public void deleteCustomer(int id);

}
