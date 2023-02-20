package com.testwebapp.DAO;

import com.testwebapp.Entity.Customer;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DAO {
    public void saveCustomer(Customer temp);
    public List< Customer > getCustomers();
    public void deleteCustomer(int id);

}
