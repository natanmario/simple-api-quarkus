package org.acme.repository;

import org.acme.entity.Customer;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {
    
    /*public void deleteCustomer(String email) {
      //  delete("email", email);
    }*/
}
