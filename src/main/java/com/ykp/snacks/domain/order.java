package com.ykp.snacks.domain;

public class order {
    private String orderId;
    private String openid;
    private String nickName;
    private String goodsName;
    private double price;
    private int weight;
    private double totalPrice;
    private int state;    //0：全部(管理员查看所有用户的所有订单，用户查看自己的所有订单)，
    private String time;    // 1：待发货，2：待评价，3：退货，4：已评价，5：已发货，6：已完成退货
//orderId,openid,nickName,goodsName,price,weight,totalPrice,state,time
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "order{" +
                "orderId='" + orderId + '\'' +
                ", openid='" + openid + '\'' +
                ", nickName='" + nickName + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", totalPrice=" + totalPrice +
                ", state=" + state +
                ", time='" + time + '\'' +
                '}';
    }

}
