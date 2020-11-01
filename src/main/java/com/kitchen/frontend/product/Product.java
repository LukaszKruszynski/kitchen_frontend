package com.kitchen.frontend.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String quantity;
    @JsonProperty
    private String note;
    @JsonProperty
    private Long barcode;
    @JsonProperty
    private LocalDate expiryDate;

    public Product() {
    }

    public Product(Long id, String name, String quantity, String note, Long barcode, LocalDate expiryDate) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.note = note;
        this.barcode = barcode;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", note='" + note + '\'' +
                ", barcode=" + barcode +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
