package com.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private String describes;
    private String image;
    private String type;
    private int quantity;

    public Product() {
    }

    public Product(int id, String name, double price, String describes, String image, String type, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describes = describes;
        this.image = image;
        this.type = type;
        this.quantity = quantity;
    }

    public Product(String name, double price, String describes, String image, String type, int quantity) {
        this.name = name;
        this.price = price;
        this.describes = describes;
        this.image = image;
        this.type = type;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", describes='" + describes + '\'' +
                ", image='" + image + '\'' +
                ", type='" + type + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
