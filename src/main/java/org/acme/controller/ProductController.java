package org.acme.controller;

import java.util.ArrayList;
import java.util.List;

import org.acme.entity.Product;
import org.acme.service.ProductService;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/api/product")
public class ProductController {
    
    @Inject
    ProductService productService;

    @GET
    public List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();

        try {
           allProducts = productService.listAllProducts(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allProducts;
    }

    @GET
    @Path("/{id}")
    public Product getProduct(@PathParam("id") Integer id) {
        
        Product product = new Product();

        try {
            product = productService.findProductById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return product;
    }

    @POST
    public Product createProduct(@Valid Product product ) {
        try {
            productService.createProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    @DELETE
    @Path("/{id}")
    public void deleteProduct(@PathParam("id") Integer id) {
        try {
            productService.deleteProduct(id);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @PUT
    @Path("/{id}")
    public void updateProduct(@PathParam("id") Integer id, Product product) {
        try {
            productService.editProduct(product, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
