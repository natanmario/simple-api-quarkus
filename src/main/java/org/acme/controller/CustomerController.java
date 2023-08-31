package org.acme.controller;

import java.util.ArrayList;
import java.util.List;

import org.acme.entity.Customer;
import org.acme.service.CustomerService;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/api/customer")
public class CustomerController {
    
    @Inject
    CustomerService customerService;

    @GET
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();

        try {
            customers = customerService.findAllCustomers();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customers;
    }

    @POST
    public Customer postCustomer(Customer customer) {
        
        try {
            customerService.addCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return customer;
    }

    @DELETE
    @Path("/{id}")
    public void deleteCustomer(@PathParam("id") Integer id) {
        try {
            customerService.removeCustomer(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PUT
    @Path("/{id}")
    public void putCustomer(@PathParam("id") Integer id, Customer customer) {
        try {
            customerService.updateCustomer(id, customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
