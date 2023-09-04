package org.acme.service;

import java.util.List;

import org.acme.entity.Product;
import org.acme.repository.ProductRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class ProductService {
    
    @Inject
    ProductRepository productRepository;

    public List<Product> listAllProducts() {
        return productRepository.findAll().list();
    }

    public Product findProductById(Integer id) {
        return productRepository.find("id", id).firstResult();
    }

    public Product findProduct(String name) {
        return productRepository.find("name", name).firstResult();
    }

    @Transactional
    public void createProduct(Product product) {
        productRepository.persist(product);
    }

    @Transactional
    public void deleteProduct(Integer id) {
        productRepository.delete("id", id);
    }

    @Transactional
    public void editProduct(@Valid Product newProduct, Integer id) {
        Product product = productRepository.find("id", id).firstResult();

        if(product != null) {
            product.setName(newProduct.getName());
            product.setPrice(newProduct.getPrice());

            productRepository.persist(product);
        }
    }
}
