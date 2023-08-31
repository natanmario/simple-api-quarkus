package org.acme.service;

import java.util.List;

import org.acme.entity.Customer;

import org.acme.repository.CustomerRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CustomerService {
    
    @Inject
    CustomerRepository customerRepository;

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll().list();
    }

    public Customer findCustomer(String email) {
        return customerRepository.find("email", email).firstResult();
    }
    
    @Transactional
    public void addCustomer(Customer customer) {
        customerRepository.persist(customer);
    }

    @Transactional
    public void removeCustomer(Integer id) {
        customerRepository.delete("id", id);
    }

    @Transactional
    public void updateCustomer(Integer id, Customer newCustomer) {
        Customer customer = customerRepository.find("id", id).firstResult();

        if(customer != null) {
            customer.setName(newCustomer.getName());
            customer.setLastName(newCustomer.getLastName());
            customer.setEmail(newCustomer.getEmail());
            customer.setAge(newCustomer.getAge());

            customerRepository.persist(customer);
        }
    }

}
