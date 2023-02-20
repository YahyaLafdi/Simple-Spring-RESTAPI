package com.testwebapp.DAO;

import com.testwebapp.Entity.Customer;
import com.testwebapp.Entity.Order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class testing {
    public static void main(String[] args) {
         DAOImpl test = new DAOImpl();

        Customer customer = new Customer();
        customer.setName("John");
        customer.setUsername("Doe");
        customer.setEmail("sss");

        Customer customer2 = new Customer();
        customer2.setName("yhy");
        customer2.setUsername("lf");
        customer2.setEmail("ss@g.com");


        Order order1 = new Order();
        order1.setName("lp");
        order1.setQuantity(22);
        order1.setCustomer(customer);

        Order order2 = new Order();
        order2.setName("lps");
        order2.setQuantity(22);
        order2.setCustomer(customer);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        customer.setOrders(orders);
        test.saveCustomer(customer);
        test.saveCustomer(customer2);
        Iterator it = test.getCustomers().iterator();

        while(it.hasNext())
        {
            Object o = (Object)it.next();
            Customer p = (Customer) o;
            System.out.println("Product id : "+p.getId());
            System.out.println("Product Name : "+p.getName());
            System.out.println("Product Price : "+p.getEmail());
            System.out.println("----------------------");
        }

    }
}
