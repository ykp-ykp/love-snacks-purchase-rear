package com.ykp.snacks.domain;

public class goods {

    private String name;
    private double price;
    private String type;
    private int surplus;
    private double discount;
    private int sales;
    private String image;
    private String information;
    public goods(){}

    public goods(String name, double price, String type, int surplus, double discount, int sales, String image, String information) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.surplus = surplus;
        this.discount = discount;
        this.sales = sales;
        this.image = image;
        this.information = information;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSurplus() {
        return surplus;
    }

    public void setSurplus(int surplus) {
        this.surplus = surplus;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", surplus=" + surplus +
                ", discount=" + discount +
                ", sales=" + sales +
                ", image='" + image + '\'' +
                ", information='" + information + '\'' +
                '}';
    }
}
