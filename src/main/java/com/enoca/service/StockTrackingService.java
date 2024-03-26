package com.enoca.service;

import com.enoca.domain.Product;
import com.enoca.util.MathUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockTrackingService {

    private final ProductService productService;

    public boolean isProductAvailableInStock(Integer productId) {
        Product product = productService.getProductById(productId);
        return product.getStock() > 0;
    }

    @Transactional
    public void decreaseStockForProduct(Integer productId, Integer quantity) {
        Product product = productService.getProductById(productId);
        Integer currentStock = product.getStock();
        Integer newStock = MathUtils.decreaseStock(currentStock, quantity);
        product.setStock(newStock);
        productService.saveProduct(product);
    }

    @Transactional
    public void increaseStockForProduct(Integer productId, Integer quantity) {
        Product product = productService.getProductById(productId);
        Integer currentStock = product.getStock();
        Integer newStock = MathUtils.increaseStock(currentStock, quantity);
        product.setStock(newStock);
        productService.saveProduct(product);
    }
}
