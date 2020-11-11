package com.kitchen.frontend.product;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;

import java.util.*;

@org.springframework.stereotype.Component
public class TabComponent {

    Tab tabFridge = new Tab("Fridge");
    Tab tabFreezer = new Tab("Freezer");
    Tab tabPantry = new Tab("Pantry");
    Tab tabShopping = new Tab("Shopping List");
    Tabs tabs;

    public void addTabs() {
        tabs = new Tabs(tabFridge, tabFreezer, tabPantry, tabShopping);
    }

    public Tabs prepareTab(Grid gridFridge, Grid gridFreezer, Grid gridPantry, Grid gridShopping,
                           TextField filterShopping, TextField filterFreezer, TextField filterPantry,
                           TextField filterFridge) {
        addTabs();
        Map<Tab, Component> tabsToPages = new HashMap<>();
        tabsToPages.put(tabFridge, gridFridge);
        tabsToPages.put(tabFreezer, gridFreezer);
        tabsToPages.put(tabPantry, gridPantry);
        tabsToPages.put(tabShopping, gridShopping);
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
        return tabs;
    }
}
