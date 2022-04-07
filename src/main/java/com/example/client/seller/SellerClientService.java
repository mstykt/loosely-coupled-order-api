package com.example.client.seller;

import com.example.client.seller.response.SellerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellerClientService {

    private final SellerClient sellerClient;

    public SellerResponse getSeller(Long id) {
        ResponseEntity<SellerResponse> sellerResponse = sellerClient.getSeller(id);
        return sellerResponse.getBody();
    }
}
