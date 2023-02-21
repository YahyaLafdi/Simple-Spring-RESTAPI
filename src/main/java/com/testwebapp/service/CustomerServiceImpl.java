package com.testwebapp.service;

import com.testwebapp.DAO.DAO;
import com.testwebapp.Entity.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private DAO CustomerDAO;


    public List<Customer> getCustomers() {
        return CustomerDAO.getCustomers();
    }

    public  Customer  getCustomer(int id){
        return  CustomerDAO.getCustomer(id);
    };


    public void deleteCustomer(int id) {
        CustomerDAO.deleteCustomer(id);
    }
}
