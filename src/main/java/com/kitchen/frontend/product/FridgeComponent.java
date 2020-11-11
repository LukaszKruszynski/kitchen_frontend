package com.kitchen.frontend.product;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import org.springframework.stereotype.Component;

@Component
public class FridgeComponent {

    private final ProductService productService;

    private Grid<Product> gridFridge = new Grid<>();
    private TextField filterFridge = new TextField();

    public FridgeComponent(ProductService productService) {
        this.productService = productService;
    }

    public Grid<Product> buildTable() {
        gridFridge.addColumn(Product::getName).setHeader("Name").setKey("name");
        gridFridge.addColumn(Product::getQuantity).setHeader("Quantity").setKey("quantity");
        gridFridge.addColumn(Product::getExpiryDate).setHeader("Expiry Date").setKey("exp");
        gridFridge.addColumn(Product::getNote).setHeader("Note").setKey("note");
        gridFridge.addColumn(Product::getBarcode).setHeader("Barcode").setKey("barcode");
        gridFridge.setItems(productService.fetchProductsFridge());
        gridFridge.setVisible(true);
        return gridFridge;
    }

    public TextField buildFilterModule() {
        filterFridge.setVisible(false);
        filterFridge.setPlaceholder("Filter by name");
        filterFridge.setClearButtonVisible(true);
        filterFridge.setValueChangeMode(ValueChangeMode.EAGER);
        filterFridge.addValueChangeListener(event -> {
            updateFridge();
            emptyFilterFetchFridge();
        });
        return filterFridge;
    }

    private void emptyFilterFetchFridge() {
        if (filterFridge.isEmpty()) {
            gridFridge.setItems(productService.fetchProductsFridge());
        }
    }

    private void updateFridge() {
        if (!filterFridge.isEmpty()) {
            gridFridge.setItems(productService.fetchFridgeProductsByName(filterFridge.getValue()));
        }
    }


}
