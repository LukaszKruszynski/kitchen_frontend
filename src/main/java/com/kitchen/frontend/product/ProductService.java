package com.kitchen.frontend.product;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class ProductService {
    @Autowired
    private Gson gson = new Gson();
    @Autowired
    private RestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:9090/v1/products";

    public void updateProduct(final Product product) {
        restTemplate.put(BASE_URL, product);
    }

    public void deleteProduct(final Long id) {
        restTemplate.delete(buildUrlDeleteProduct(id));
    }

    private URI buildUrlUpdateProduct() {
        return UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .build()
                .encode()
                .toUri();
    }

    private URI buildUrlDeleteProduct(final Long id) {
        return UriComponentsBuilder.fromHttpUrl(BASE_URL + "/" + id)
                .build()
                .encode()
                .toUri();
    }
}
