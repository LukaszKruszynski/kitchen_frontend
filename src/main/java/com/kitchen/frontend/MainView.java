package com.kitchen.frontend;

import com.kitchen.frontend.product.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

@Route(value = "products")
@SpringComponent(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@VaadinSessionScope
public class MainView extends VerticalLayout {

    private ProductService productService;
    private FreezerComponent freezerComponent;
    private FridgeComponent fridgeComponent;
    private PantryComponent pantryComponent;
    private ShoppingComponent shoppingComponent;
    private TabComponent tabComponent;
    private ProductForm form;
    private LinkComponent linkComponent;
    private AddButtonComponent addButtonComponent;

    public MainView(ProductService productService, FreezerComponent freezerComponent, FridgeComponent fridgeComponent, PantryComponent pantryComponent, ShoppingComponent shoppingComponent, TabComponent tabComponent, ProductForm form, LinkComponent linkComponent, AddButtonComponent addButtonComponent) {
        this.productService = productService;
        this.freezerComponent = freezerComponent;
        this.fridgeComponent = fridgeComponent;
        this.pantryComponent = pantryComponent;
        this.shoppingComponent = shoppingComponent;
        this.tabComponent = tabComponent;
        this.form = form;
        this.linkComponent = linkComponent;
        this.addButtonComponent = addButtonComponent;
        this.buildContextFacade();
    }

    public void buildContextFacade() {
        Anchor linkMeal = linkComponent.createLinkMeal();
        Anchor linkCocktail = linkComponent.createLinkCocktail();
        Grid<Product> gridFreezer = freezerComponent.buildTable();
        TextField filterFreezer = freezerComponent.buildFilterModule();
        Grid<Product> gridFridge = fridgeComponent.buildTable();
        TextField filterFridge = fridgeComponent.buildFilterModule();
        Grid<Product> gridPantry = pantryComponent.buildTable();
        TextField filterPantry = pantryComponent.buildFilterModule();
        Grid<Product> gridShopping = shoppingComponent.buildTable();
        TextField filterShopping = shoppingComponent.buildFilterModule();
        Tabs tabs = tabComponent.prepareTab(gridFridge, gridFreezer, gridPantry, gridShopping,
                filterShopping, filterFreezer, filterPantry, filterFridge);
        form.addActionForm(gridFridge, gridFreezer, gridPantry, gridShopping);
        Button addBtn = addButtonComponent.addBtn(gridFridge, gridFreezer, gridPantry, gridShopping, form);

        HorizontalLayout linkContent = new HorizontalLayout(linkMeal, linkCocktail);
        VerticalLayout mainContent = new VerticalLayout(gridFreezer, gridFridge, gridPantry, gridShopping, addBtn, this.form);
        add(linkContent, tabs, filterFridge, filterFreezer, filterPantry, filterShopping, mainContent);
    }
}