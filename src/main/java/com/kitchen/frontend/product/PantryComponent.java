package com.kitchen.frontend.product;


import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import org.springframework.stereotype.Component;

@Component
public class PantryComponent {
    private final ProductService productService;

    private Grid<Product> gridPantry = new Grid<>();
    private TextField filterPantry = new TextField();

    public PantryComponent(ProductService productService) {
        this.productService = productService;
    }

    public Grid<Product> buildTable() {
        gridPantry.addColumn(Product::getName).setHeader("Name").setKey("name");
        gridPantry.addColumn(Product::getQuantity).setHeader("Quantity").setKey("quantity");
        gridPantry.addColumn(Product::getExpiryDate).setHeader("Expiry Date").setKey("exp");
        gridPantry.addColumn(Product::getNote).setHeader("Note").setKey("note");
        gridPantry.addColumn(Product::getBarcode).setHeader("Barcode").setKey("barcode");
        gridPantry.setItems(productService.fetchProductsPantry());
        gridPantry.setVisible(false);
        return gridPantry;
    }
    public TextField buildFilterModule() {
        filterPantry.setVisible(false);
        filterPantry.setPlaceholder("Filter by name");
        filterPantry.setClearButtonVisible(true);
        filterPantry.setValueChangeMode(ValueChangeMode.EAGER);
        filterPantry.addValueChangeListener(event -> {
            updatePantry();
            emptyFilterFetchPantry();
        });
        return filterPantry;
    }

    private void emptyFilterFetchPantry() {
        if (filterPantry.isEmpty()) {
            gridPantry.setItems(productService.fetchProductsPantry());
        }
    }

    private void updatePantry() {
        if (!filterPantry.isEmpty()) {
            gridPantry.setItems(productService.fetchPantryProductsByName(filterPantry.getValue()));
        }
    }
}
