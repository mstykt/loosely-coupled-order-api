package com.example.client.seller;

import com.example.client.seller.response.SellerResponse;
import com.example.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "seller-api", url = "${client.url.seller}", configuration = FeignConfig.class)
public interface SellerClient {

    @GetMapping("/sellers/{id}")
    ResponseEntity<SellerResponse> getSeller(@PathVariable("id") Long id);
}
