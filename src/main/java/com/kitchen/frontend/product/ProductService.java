package com.kitchen.frontend.product;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private final RestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:9090/v1/products";

    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Product> fetchProducts() {
        ResponseEntity<Product[]> products = restTemplate.getForEntity("http://localhost:9090/v1/products", Product[].class);
        Product[] body = products.getBody();
        return Arrays.asList(body);
    }

    public List<Product> fetchProductsFridge() {
        ResponseEntity<Product[]> products = restTemplate.getForEntity("http://localhost:9090/v1/products/fridge", Product[].class);
        Product[] body = products.getBody();
        return Arrays.asList(body);
    }

    public List<Product> fetchProductsFreezer() {
        ResponseEntity<Product[]> products = restTemplate.getForEntity("http://localhost:9090/v1/products/freezer", Product[].class);
        Product[] body = products.getBody();
        return Arrays.asList(body);
    }

    public List<Product> fetchProductsPantry() {
        ResponseEntity<Product[]> products = restTemplate.getForEntity("http://localhost:9090/v1/products/pantry", Product[].class);
        Product[] body = products.getBody();
        return Arrays.asList(body);
    }

    public List<Product> fetchProductsShopping() {
        ResponseEntity<Product[]> products = restTemplate.getForEntity("http://localhost:9090/v1/products/shopping", Product[].class);
        Product[] body = products.getBody();
        return Arrays.asList(body);
    }

    public List<Product> fetchFridgeProductsByName(String name) {
        ResponseEntity<Product[]> products = restTemplate.getForEntity("http://localhost:9090/v1/products/fridge/search/" + name, Product[].class);
        Product[] body = products.getBody();
        return Arrays.asList(body);
    }

    public List<Product> fetchFreezerProductsByName(String name) {
        ResponseEntity<Product[]> products = restTemplate.getForEntity("http://localhost:9090/v1/products/freezer/search/" + name, Product[].class);
        Product[] body = products.getBody();
        return Arrays.asList(body);
    }

    public List<Product> fetchPantryProductsByName(String name) {
        ResponseEntity<Product[]> products = restTemplate.getForEntity("http://localhost:9090/v1/products/pantry/search/" + name, Product[].class);
        Product[] body = products.getBody();
        return Arrays.asList(body);
    }

    public List<Product> fetchShoppingProductsByName(String name) {
        ResponseEntity<Product[]> products = restTemplate.getForEntity("http://localhost:9090/v1/products/shopping/search/" + name, Product[].class);
        Product[] body = products.getBody();
        return Arrays.asList(body);
    }

    public void updateProduct(final Product product) {
        restTemplate.put("http://localhost:9090/v1/products", product);
    }

    public void deleteProduct(final Product product) {
        restTemplate.delete(buildUrlDeleteProduct(product.getId()));
    }

    private URI buildUrlUpdateProduct() {
        return UriComponentsBuilder.fromHttpUrl("http://localhost:9090/v1/products")
                .build()
                .encode()
                .toUri();
    }

    private URI buildUrlDeleteProduct(final Long id) {
        return UriComponentsBuilder.fromHttpUrl("http://localhost:9090/v1/products/" + id)
                .build()
                .encode()
                .toUri();
    }

}
