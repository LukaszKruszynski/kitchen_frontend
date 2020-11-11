package com.kitchen.frontend.product;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import org.springframework.stereotype.Component;

@Component
public class FreezerComponent {

    private final ProductService productService;

    private Grid<Product> gridFreezer = new Grid<>();
    private TextField filterFreezer = new TextField();

    public FreezerComponent(ProductService productService) {
        this.productService = productService;
    }

    public Grid<Product> buildTable() {
        gridFreezer.addColumn(Product::getName).setHeader("Name").setKey("name");
        gridFreezer.addColumn(Product::getQuantity).setHeader("Quantity").setKey("quantity");
        gridFreezer.addColumn(Product::getExpiryDate).setHeader("Expiry Date").setKey("exp");
        gridFreezer.addColumn(Product::getNote).setHeader("Note").setKey("note");
        gridFreezer.addColumn(Product::getBarcode).setHeader("Barcode").setKey("barcode");
        gridFreezer.setItems(this.productService.fetchProductsFreezer());
        gridFreezer.setVisible(false);
        return gridFreezer;
    }

    public TextField buildFilterModule() {
        filterFreezer.setVisible(false);
        filterFreezer.setPlaceholder("Filter by name");
        filterFreezer.setClearButtonVisible(true);
        filterFreezer.setValueChangeMode(ValueChangeMode.EAGER);
        filterFreezer.addValueChangeListener(event -> {
            updateFreezer();
            emptyFilterFetchFreezer();
        });
        return filterFreezer;
    }

    private void emptyFilterFetchFreezer() {
        if (filterFreezer.isEmpty()) {
            gridFreezer.setItems(productService.fetchProductsFreezer());
        }
    }

    private void updateFreezer() {
        if (!filterFreezer.isEmpty()) {
            gridFreezer.setItems(productService.fetchFreezerProductsByName(filterFreezer.getValue()));
        }
    }


}
