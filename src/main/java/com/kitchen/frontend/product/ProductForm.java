package com.kitchen.frontend.product;

import com.kitchen.frontend.MainView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import org.springframework.beans.factory.annotation.Autowired;

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
        type.setItems(ProductType.values());
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(name, quantity, note, type, buttons);
        binder.bindInstanceFields(this);
        delete.addClickListener(event -> deleteProduct(binder.getBean().getId()));
    }

    private void updateProduct(final Product product) {
        productService.updateProduct(product);
    }

    private void deleteProduct(final Long id) {
        productService.deleteProduct(id);
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
}
