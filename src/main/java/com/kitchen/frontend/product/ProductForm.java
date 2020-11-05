package com.kitchen.frontend.product;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class ProductForm extends FormLayout {
    private TextField name = new TextField("Name");
    private TextField quantity = new TextField("Quantity");
    private TextField note = new TextField("Note");
    private ComboBox type = new ComboBox<>("Product place");
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    public ProductForm() {
        type.setItems(ProductType.values());
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(name, quantity, note, type, buttons);
    }
}
