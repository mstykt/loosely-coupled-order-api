package com.example.client.product.response;

import com.example.client.product.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductClientService {

    private final ProductClient productClient;

    public ProductResponse getProduct(Long id) {
        ResponseEntity<ProductResponse> productResponse = productClient.getProduct(id);
        return productResponse.getBody();
    }
}
