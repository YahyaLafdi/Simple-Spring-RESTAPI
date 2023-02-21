package com.testwebapp.DAO;



import com.testwebapp.Entity.Customer;
import com.testwebapp.configuration.HibernateConfiguration;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DAOImpl implements DAO{

    private static SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
    Transaction transaction = null;
    @Override
    public void saveCustomer(Customer temp) {

        Session session = sessionFactory.openSession();

        try  {


            transaction = session.beginTransaction();
            // save the student object
            session.persist(temp);

            // commit transaction
            transaction.commit();



        } catch (Exception e) {

            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }


    @Override
    public List< Customer > getCustomers() {

        Session session = sessionFactory.openSession();
        try {

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> rootEntry = cq.from(Customer.class);
        rootEntry.fetch("orders", JoinType.LEFT);
            return session.createQuery(cq).getResultList();


        } catch (Exception e) {

            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }

    @Override
    public void deleteCustomer(int id) {

        Session session = sessionFactory.openSession();
        try {

            transaction = session.beginTransaction();
            // save the student object
            Customer customer = session.get(Customer.class, id);
            session.remove(customer);
            // commit transaction
            transaction.commit();






        }catch (Exception e){
            e.printStackTrace();

        }
        finally {
            session.close();
        }


    }


    @Override
    public  Customer  getCustomer(int id){
        Session session = sessionFactory.openSession();
        try {

            transaction = session.beginTransaction();
            // save the student object
            Customer customer = session.get(Customer.class, id);

            // commit transaction
            transaction.commit();


    return customer;



        }catch (Exception e){
            e.printStackTrace();

        }
        finally {
            session.close();
        }
return null;

    }


}
