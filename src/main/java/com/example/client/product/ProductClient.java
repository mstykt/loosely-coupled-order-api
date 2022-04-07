package com.example.client.product;

import com.example.client.product.response.ProductResponse;
import com.example.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-api", url = "${client.url.product}", configuration = FeignConfig.class)
public interface ProductClient {

    @GetMapping("/products/{id}")
    ResponseEntity<ProductResponse> getProduct(@PathVariable("id") Long id);
}
