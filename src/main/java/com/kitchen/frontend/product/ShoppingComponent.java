package com.kitchen.frontend.product;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import org.springframework.stereotype.Component;

@Component
public class ShoppingComponent {
    private final ProductService productService;

    private Grid<Product> gridShopping = new Grid<>();
    private TextField filterShopping = new TextField();

    public ShoppingComponent(ProductService productService) {
        this.productService = productService;
    }

    public Grid<Product> buildTable() {
        gridShopping.addColumn(Product::getName).setHeader("Name").setKey("name");
        gridShopping.addColumn(Product::getQuantity).setHeader("Quantity").setKey("quantity");
        gridShopping.addColumn(Product::getExpiryDate).setHeader("Expiry Date").setKey("exp");
        gridShopping.addColumn(Product::getNote).setHeader("Note").setKey("note");
        gridShopping.addColumn(Product::getBarcode).setHeader("Barcode").setKey("barcode");
        gridShopping.setItems(productService.fetchProductsShopping());
        gridShopping.setVisible(false);
        return gridShopping;
    }

    public TextField buildFilterModule() {
        filterShopping.setVisible(false);
        filterShopping.setPlaceholder("Filter by name");
        filterShopping.setClearButtonVisible(true);
        filterShopping.setValueChangeMode(ValueChangeMode.EAGER);
        filterShopping.addValueChangeListener(event -> {
            updateShopping();
            emptyFilterFetchShopping();
        });
        return filterShopping;
    }

    private void emptyFilterFetchShopping() {
        if (filterShopping.isEmpty()) {
            gridShopping.setItems(productService.fetchProductsShopping());
        }
    }

    private void updateShopping() {
        if (!filterShopping.isEmpty()) {
            gridShopping.setItems(productService.fetchShoppingProductsByName(filterShopping.getValue()));
        }
    }
}
