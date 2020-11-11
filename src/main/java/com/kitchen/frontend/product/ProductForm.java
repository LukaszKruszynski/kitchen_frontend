package com.kitchen.frontend.product;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.PropertyId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ProductForm extends FormLayout {
    @Autowired
    ProductService productService;

    private TextField name = new TextField("Name");
    private TextField quantity = new TextField("Quantity");
    private TextField note = new TextField("Note");
    private ComboBox type = new ComboBox<>("Product place");
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    private Binder<Product> binder = new Binder<>(Product.class);

    public ProductForm() {
        setVisible(false);
        type.setItems(StorageType.values());
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(name, quantity, note, type, buttons);
        binder.bindInstanceFields(this);
        name.setReadOnly(false);
        quantity.setReadOnly(false);
        note.setReadOnly(false);
        save.addClickListener(event -> updateProduct());
        delete.addClickListener(event -> deleteProduct());
    }

    private void updateProduct() {
        Product product = binder.getBean();
        product = buildProduct(product);
        productService.updateProduct(product);
        setProduct(null);
        //UI.getCurrent().getPage().reload();
        Notification notification = new Notification("SAVE SUCESSFULLY", 3000);
        notification.open();
    }

    private void deleteProduct() {
        Product product = binder.getBean();
        productService.deleteProduct(product);
        setProduct(null);
        //UI.getCurrent().getPage().reload();
        Notification notification = new Notification("DELETE SUCESSFULLY", 3000);
        notification.open();
    }


    public void setProduct(Product product) {
        binder.setBean(product);
        if (product == null) {
            setVisible(false);
        } else {
            setVisible(true);
            name.focus();
        }
    }

    private Product buildProduct(Product product) {
        product.setName(name.getValue());
        product.setNote(note.getValue());
        product.setQuantity(quantity.getValue());
        product.setProductType((StorageType)type.getValue());
        product.setExpiryDate(LocalDate.now());
        return product;
    }

    public void addActionForm(Grid<Product> gridFridge, Grid<Product> gridFreezer, Grid<Product> gridPantry, Grid<Product> gridShopping) {
        gridFridge.asSingleSelect().addValueChangeListener(e -> this.setVisible(true));
        gridFridge.asSingleSelect().addValueChangeListener(e -> this.setProduct(gridFridge.asSingleSelect().getValue()));
        gridFreezer.asSingleSelect().addValueChangeListener(e -> this.setVisible(true));
        gridFreezer.asSingleSelect().addValueChangeListener(e -> this.setProduct(gridFreezer.asSingleSelect().getValue()));
        gridPantry.asSingleSelect().addValueChangeListener(e -> this.setVisible(true));
        gridPantry.asSingleSelect().addValueChangeListener(e -> this.setProduct(gridPantry.asSingleSelect().getValue()));
        gridShopping.asSingleSelect().addValueChangeListener(e -> this.setVisible(true));
        gridShopping.asSingleSelect().addValueChangeListener(e -> this.setProduct(gridShopping.asSingleSelect().getValue()));
    }
}
