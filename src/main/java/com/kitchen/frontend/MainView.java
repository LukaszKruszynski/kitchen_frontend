package com.kitchen.frontend;

import com.kitchen.frontend.config.CoreConfiguration;
import com.kitchen.frontend.product.Product;
import com.kitchen.frontend.product.ProductList;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Route(value = "/products")
public class MainView extends VerticalLayout {
    @Autowired
    private RestTemplate restTemplate;
    Grid<Product> grid = new Grid();
    Button button = new Button();
    public MainView() {
//        grid.setItems(fetchProducts());
        button.setText("hello word");
        add(grid,button);
    }
    private List<Product> fetchProducts() {
        ProductList productList = restTemplate.getForObject("http://localhost:9090/v1/products", ProductList.class);
        List<Product> products = productList.getProducts();
        return products;
    }
}
