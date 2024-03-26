package com.enoca.service;

import com.enoca.builder.ProductBuilder;
import com.enoca.converter.ProductConverter;
import com.enoca.domain.Product;
import com.enoca.exception.ProductNotFoundException;
import com.enoca.model.request.product.CreateProductRequest;
import com.enoca.model.request.product.UpdateProductRequest;
import com.enoca.model.response.product.ProductResponse;
import com.enoca.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductBuilder productBuilder;

    private final ProductConverter productConverter;

    public String createProduct(CreateProductRequest createCarRequest) {
        List<Product> allProduct = productRepository.findAll();
        boolean isMatch = allProduct.stream().anyMatch(p -> createCarRequest.getName().equals(p.getName()));
        if (isMatch) {
            return "Product is not added due to have same product name";
        }
        Product product = productBuilder.createProduct(createCarRequest);
        productRepository.save(product);
        return "Product added";
    }

    public ProductResponse getProduct(Integer productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException();
        }
        Product product = optionalProduct.get();
        return productConverter.apply(product);
    }

    public Product updateProduct(UpdateProductRequest updateProductRequest) {
        Optional<Product> optionalProduct = productRepository.findById(updateProductRequest.getId());
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException();
        }
        Product product = optionalProduct.get();
        productConverter.apply(updateProductRequest,product);
        return productRepository.save(product);
    }

    public String deleteProduct(Integer productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException();
        }
        Product product = optionalProduct.get();
        productRepository.delete(product);
        return "Product deleted";
    }

    public void saveProduct(Product product) {
        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        Product saveProduct = optionalProduct.get();
        productRepository.save(saveProduct);
    }

    public Product getProductById(Integer productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException();
        }
        return optionalProduct.get();
    }
}
