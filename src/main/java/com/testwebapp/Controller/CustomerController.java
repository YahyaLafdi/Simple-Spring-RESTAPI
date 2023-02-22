package com.testwebapp.Controller;

import com.testwebapp.DAO.*;
import com.testwebapp.DAO.DAOImpl;
import com.testwebapp.Entity.Customer;
import com.testwebapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping  ("/customers")
public class CustomerController {
    @Autowired
    private CustomerService CustomerService;
    @GetMapping("/list")
    public List<Customer> listCustomers(){

        return CustomerService.getCustomers();

    }
    @GetMapping("/list/{Id}")
    public Customer listCustomers(@PathVariable int Id){

        return CustomerService.getCustomer(Id);

    }
    @DeleteMapping ("/delete/{id}")
    public void deleteCustomers(@PathVariable int id){

        CustomerService.deleteCustomer(id);


    }
    @PostMapping("/post")
    public Customer addCustomer(@RequestBody Customer theCustomer){
        CustomerService.saveCustomer(theCustomer);
        return  theCustomer;
    }
}
