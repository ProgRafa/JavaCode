package com.team3.routemapping.domain.Models;

import com.team3.csvreader.CsvAttributeSetter;

public class Product {

    String id;
    String description;
    String restaurantId;

    public Product() {
    }

    @CsvAttributeSetter(attributeName = "item_id")
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @CsvAttributeSetter(attributeName = "item_description")
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @CsvAttributeSetter(attributeName = "restaurant_id")
    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

}
