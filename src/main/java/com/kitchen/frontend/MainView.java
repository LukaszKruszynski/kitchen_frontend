package com.kitchen.frontend;

import com.kitchen.frontend.product.Product;
import com.kitchen.frontend.product.ProductForm;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Route(value = "products")
@SpringComponent
public class MainView extends VerticalLayout {
    private RestTemplate restTemplate;
    private Grid<Product> gridFreezer = new Grid<>();
    private Grid<Product> gridFridge = new Grid<>();
    private Grid<Product> gridPantry = new Grid<>();
    private Grid<Product> gridShopping = new Grid<>();
    private Button button1 = new Button("click me", e -> Notification.show("siema"));
    private TextField filterFreezer = new TextField();
    private TextField filterFridge = new TextField();
    private TextField filterPantry = new TextField();
    private TextField filterShopping = new TextField();
    private TextField saveFridge = new TextField();
    private ProductForm form = new ProductForm();

    public MainView(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        Map<Tab, Component> tabsToPages = new HashMap<>();

        gridFreezer.addColumn(Product::getName).setHeader("Name").setKey("name");
        gridFreezer.addColumn(Product::getNote).setHeader("Note").setKey("note");
        gridFreezer.addColumn(Product::getExpiryDate).setHeader("Expiry Date").setKey("exp");
        gridFreezer.setItems(fetchProductsFreezer());

        gridFridge.addColumn(Product::getName).setHeader("Name");
        gridFridge.addColumn(Product::getNote).setHeader("Note");
        gridFridge.addColumn(Product::getExpiryDate).setHeader("Expiry Date");
        gridFridge.setItems(fetchProductsFridge());

        gridPantry.addColumn(Product::getName).setHeader("Name");
        gridPantry.addColumn(Product::getNote).setHeader("Note");
        gridPantry.addColumn(Product::getExpiryDate).setHeader("Expiry Date");
        gridPantry.setItems(fetchProductsPantry());

        gridShopping.addColumn(Product::getName).setHeader("Name");
        gridShopping.addColumn(Product::getNote).setHeader("Note");
        gridShopping.addColumn(Product::getExpiryDate).setHeader("Expiry Date");
        gridShopping.setItems(fetchProductsShopping());

        Tab tabFridge = new Tab("Fridge");
        Tab tabFreezer = new Tab("Freezer");
        Tab tabPantry = new Tab("Pantry");
        Tab tabShopping = new Tab("Shopping List");
        Tabs tabs = new Tabs(tabFridge, tabFreezer, tabPantry, tabShopping);

        tabsToPages.put(tabFridge, gridFridge);
        tabsToPages.put(tabFreezer, gridFreezer);
        tabsToPages.put(tabPantry, gridPantry);
        tabsToPages.put(tabShopping, gridShopping);

        gridShopping.setVisible(false);
        gridPantry.setVisible(false);
        gridFreezer.setVisible(false);

        filterFreezer.setVisible(false);
        filterPantry.setVisible(false);
        filterShopping.setVisible(false);

        filterFridge.setPlaceholder("Filter fridge products by name");
        filterFreezer.setPlaceholder("Filter freezer products by name");
        filterPantry.setPlaceholder("Filter pantry products by name");
        filterShopping.setPlaceholder("Filter shopping products by name");

        filterFridge.setClearButtonVisible(true);
        filterFreezer.setClearButtonVisible(true);
        filterPantry.setClearButtonVisible(true);
        filterShopping.setClearButtonVisible(true);

        filterFridge.setValueChangeMode(ValueChangeMode.EAGER);
        filterFreezer.setValueChangeMode(ValueChangeMode.EAGER);
        filterPantry.setValueChangeMode(ValueChangeMode.EAGER);
        filterShopping.setValueChangeMode(ValueChangeMode.EAGER);

        filterFridge.addValueChangeListener(event -> {
            updateFridge();
            emptyFilterFetchFridge();
        });

        filterFreezer.addValueChangeListener(event -> {
            updateFreezer();
            emptyFilterFetchFreezer();
        });

        filterPantry.addValueChangeListener(event -> {
            updatePantry();
            emptyFilterFetchPantry();
        });

        filterShopping.addValueChangeListener(event -> {
            updateShopping();
            emptyFilterFetchShopping();
        });

        gridFridge.asSingleSelect().addValueChangeListener(e -> form.setVisible(true));


        tabs.addSelectedChangeListener(event -> {
            tabsToPages.values().forEach(page -> page.setVisible(false));
            Component selectedPage = tabsToPages.get(tabs.getSelectedTab());
            selectedPage.setVisible(true);
            if (gridFridge.isVisible()) {
                filterShopping.setVisible(false);
                filterFreezer.setVisible(false);
                filterPantry.setVisible(false);
                filterFridge.setVisible(true);
            }
            if (gridFreezer.isVisible()) {
                filterShopping.setVisible(false);
                filterFridge.setVisible(false);
                filterPantry.setVisible(false);
                filterFreezer.setVisible(true);
            }
            if (gridPantry.isVisible()) {
                filterShopping.setVisible(false);
                filterFridge.setVisible(false);
                filterFreezer.setVisible(false);
                filterPantry.setVisible(true);
            }
            if (gridShopping.isVisible()) {
                filterFridge.setVisible(false);
                filterFreezer.setVisible(false);
                filterPantry.setVisible(false);
                filterShopping.setVisible(true);
            }
        });
        VerticalLayout mainContent = new VerticalLayout(gridFreezer, gridFridge, gridPantry, gridShopping,form);
        add(mainContent,tabs, filterFridge, filterFreezer, filterPantry, filterShopping);
    }

    private List<Product> fetchProducts() {
        ResponseEntity<Product[]> products = restTemplate.getForEntity("http://localhost:9090/v1/products", Product[].class);
        Product[] body = products.getBody();
        return Arrays.asList(body);
    }

    private List<Product> fetchProductsFridge() {
        ResponseEntity<Product[]> products = restTemplate.getForEntity("http://localhost:9090/v1/products/fridge", Product[].class);
        Product[] body = products.getBody();
        return Arrays.asList(body);
    }

    private List<Product> fetchProductsFreezer() {
        ResponseEntity<Product[]> products = restTemplate.getForEntity("http://localhost:9090/v1/products/freezer", Product[].class);
        Product[] body = products.getBody();
        return Arrays.asList(body);
    }

    private List<Product> fetchProductsPantry() {
        ResponseEntity<Product[]> products = restTemplate.getForEntity("http://localhost:9090/v1/products/pantry", Product[].class);
        Product[] body = products.getBody();
        return Arrays.asList(body);
    }

    private List<Product> fetchProductsShopping() {
        ResponseEntity<Product[]> products = restTemplate.getForEntity("http://localhost:9090/v1/products/shopping", Product[].class);
        Product[] body = products.getBody();
        return Arrays.asList(body);
    }

    private List<Product> fetchFridgeProductsByName(String name) {
        ResponseEntity<Product[]> products = restTemplate.getForEntity("http://localhost:9090/v1/products/fridge/search/" + name, Product[].class);
        Product[] body = products.getBody();
        return Arrays.asList(body);
    }

    private List<Product> fetchFreezerProductsByName(String name) {
        ResponseEntity<Product[]> products = restTemplate.getForEntity("http://localhost:9090/v1/products/freezer/search/" + name, Product[].class);
        Product[] body = products.getBody();
        return Arrays.asList(body);
    }

    private List<Product> fetchPantryProductsByName(String name) {
        ResponseEntity<Product[]> products = restTemplate.getForEntity("http://localhost:9090/v1/products/pantry/search/" + name, Product[].class);
        Product[] body = products.getBody();
        return Arrays.asList(body);
    }

    private List<Product> fetchShoppingProductsByName(String name) {
        ResponseEntity<Product[]> products = restTemplate.getForEntity("http://localhost:9090/v1/products/shopping/search/" + name, Product[].class);
        Product[] body = products.getBody();
        return Arrays.asList(body);
    }

    private void updateFridge() {
        if (!filterFridge.isEmpty()) {
            gridFridge.setItems(this.fetchFridgeProductsByName(filterFridge.getValue()));
        }
    }

    private void updateFreezer() {
        if (!filterFreezer.isEmpty()) {
            gridFreezer.setItems(this.fetchFreezerProductsByName(filterFreezer.getValue()));
        }
    }

    private void updatePantry() {
        if (!filterPantry.isEmpty()) {
            gridPantry.setItems(this.fetchPantryProductsByName(filterPantry.getValue()));
        }
    }

    private void updateShopping() {
        if (!filterShopping.isEmpty()) {
            gridShopping.setItems(this.fetchShoppingProductsByName(filterShopping.getValue()));
        }
    }

    private void emptyFilterFetchFridge() {
        if (filterFridge.isEmpty()) {
            gridFridge.setItems(this.fetchProductsFridge());
        }
    }

    private void emptyFilterFetchFreezer() {
        if (filterFreezer.isEmpty()) {
            gridFreezer.setItems(this.fetchProductsFreezer());
        }
    }

    private void emptyFilterFetchPantry() {
        if (filterPantry.isEmpty()) {
            gridPantry.setItems(this.fetchProductsPantry());
        }
    }

    private void emptyFilterFetchShopping() {
        if (filterShopping.isEmpty()) {
            gridShopping.setItems(this.fetchProductsShopping());
        }
    }
}