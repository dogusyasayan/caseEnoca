package com.enoca.controller;

import com.enoca.domain.Product;
import com.enoca.model.request.product.CreateProductRequest;
import com.enoca.model.request.product.UpdateProductRequest;
import com.enoca.model.response.product.ProductResponse;
import com.enoca.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * Yeni bir ürün oluşturmak için kullanılan endpoint.
     *
     * @param createCarRequest Oluşturulacak ürünün bilgilerini içeren istek nesnesi
     * @return Oluşturulan ürünün kimliğini temsil eden bir mesaj veya hata durumunda ilgili bilgiyi içeren bir mesaj
     */
    @PostMapping("/create")
    public String createProduct(@RequestBody CreateProductRequest createCarRequest) {
        return productService.createProduct(createCarRequest);
    }

    /**
     * Belirli bir ürünü getirmek için kullanılan endpoint.
     *
     * @param productId Getirilecek ürünün kimliği
     * @return Belirli ürünü temsil eden bir yanıt nesnesi
     */
    @GetMapping("/get/{productId}")
    public ProductResponse getProduct(@PathVariable Integer productId) {
        return productService.getProduct(productId);
    }

    /**
     * Bir ürünü güncellemek için kullanılan endpoint.
     *
     * @param productId            Güncellenecek ürünün kimliği
     * @param updateProductRequest Güncelleme isteğini içeren istek nesnesi
     * @return Güncellenmiş ürünü temsil eden bir nesne
     */
    @PutMapping("/update/{productId}")
    public Product updateProduct(@PathVariable Integer productId, @RequestBody UpdateProductRequest updateProductRequest) {
        updateProductRequest.setId(productId);
        return productService.updateProduct(updateProductRequest);
    }

    /**
     * Bir ürünü silmek için kullanılan endpoint.
     *
     * @param productId Silinecek ürünün kimliği
     * @return Silinen ürünle ilgili bir mesaj veya hata durumunda ilgili bilgiyi içeren bir mesaj
     */
    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable Integer productId) {
        return productService.deleteProduct(productId);
    }
}
