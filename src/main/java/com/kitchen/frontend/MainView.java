package com.kitchen.frontend;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

import java.util.Set;

@Route
public class MainView extends VerticalLayout {

    private BookService bookService = BookService.getInstance();
    private Grid grid = new Grid<>(Book.class);
    private TextField filterByTitle = new TextField();
    private TextField filterByAuthor = new TextField();
    private Button button = new Button();
    DateTimePicker labelDateTimePicker = new DateTimePicker();



    public MainView() {
        filterByTitleInit();
        filterByAuthorInit();
        grid.setColumns("title", "author", "publicationYear", "type");
        refresh();
        add(filterByTitle, filterByAuthor,labelDateTimePicker, grid);
    }

    public void refresh() {
        grid.setItems(bookService.getBooks());
    }

    private void updateFindByTitle() {
        grid.setItems(bookService.findByTitle(filterByTitle.getValue()));
    }

    private void updateFindByAuthor() {
        grid.setItems(bookService.findByAuthor(filterByAuthor.getValue()));
    }

    private void filterByTitleInit() {
        filterByTitle.setPlaceholder("Filter by title");
        filterByTitle.setClearButtonVisible(true);
        filterByTitle.setValueChangeMode(ValueChangeMode.EAGER);
        filterByTitle.addValueChangeListener(e -> updateFindByTitle());
    }
    private void filterByAuthorInit() {
        filterByAuthor.setPlaceholder("Filter by author");
        filterByAuthor.setValueChangeMode(ValueChangeMode.EAGER);
        filterByAuthor.addValueChangeListener(e -> updateFindByAuthor());
    }
    private void buttonEvent() {
    }
}
