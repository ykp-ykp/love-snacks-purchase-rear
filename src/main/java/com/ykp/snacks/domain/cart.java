package com.ykp.snacks.domain;

public class cart {

    private String openid;
    private String nickName;
    private String goodsName;
    private double price;
    private int weight;  //该商品的在购物车中的数量
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "cart{" +
                "openid='" + openid + '\'' +
                ", nickName='" + nickName + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", image='" + image + '\'' +
                '}';
    }
}
