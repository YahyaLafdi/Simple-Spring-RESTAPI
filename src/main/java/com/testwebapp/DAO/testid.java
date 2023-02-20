package com.testwebapp.DAO;

import com.testwebapp.Entity.Customer;
import com.testwebapp.Entity.Order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class testid {
    public static void main(String[] args) {
        DAOImpl test = new DAOImpl();

            test.deleteCustomer(15);
    }
}
