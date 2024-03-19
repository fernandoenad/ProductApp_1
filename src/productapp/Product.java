/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productapp;

import java.io.Serializable;

/**
 *
 * @author fernandoenad
 */
public class Product implements Serializable{
    private int id;
    private String barcode;
    private String name;
    private Double price;
    private String unit;

    public Product(int id, String barcode, String name, Double price, String unit) {
        this.id = id;
        this.barcode = barcode;
        this.name = name;
        this.price = price;
        this.unit = unit;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }    
}
