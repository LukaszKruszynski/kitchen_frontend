package com.kitchen.frontend.product;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import org.springframework.stereotype.Component;

@Component
public class AddButtonComponent {

    private Button addProduct = new Button("Add product");

    public Button addBtn(Grid<Product> gridFridge, Grid<Product> gridFreezer, Grid<Product> gridPantry, Grid<Product> gridShopping, ProductForm form) {
        addProduct.addClickListener(e ->
        {
            gridFridge.asSingleSelect().clear();
            gridFreezer.asSingleSelect().clear();
            gridPantry.asSingleSelect().clear();
            gridShopping.asSingleSelect().clear();
            form.setProduct(new Product());
        });
        addProduct.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        return addProduct;
    }
}
