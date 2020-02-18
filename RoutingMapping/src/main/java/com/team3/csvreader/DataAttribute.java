package com.team3.csvreader;

public class DataAttribute {

    private String attribute;
    private String data;

    public DataAttribute(String attribute, String data) {
        this.attribute = attribute;
        this.data = data;
    }

    public String getAttribute() {
        return attribute;
    }
    public String getData() {
        return data;
    }
}
