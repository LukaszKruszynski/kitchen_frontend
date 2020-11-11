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

    @JsonProperty(value = "storageType")
    private StorageType storageType;

    public Product() {
    }

    public Product(Long id, String name, String quantity, String note, Long barcode, LocalDate expiryDate, StorageType storageType) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.note = note;
        this.barcode = barcode;
        this.expiryDate = expiryDate;
        this.storageType = storageType;
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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getNote() {
        return note;
    }

    public Long getBarcode() {
        return barcode;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public StorageType getStorageType() {
        return storageType;
    }

    public void setProductType(StorageType storageType) {
        this.storageType = storageType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
