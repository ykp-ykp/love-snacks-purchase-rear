package com.ykp.snacks.Service;

import com.ykp.snacks.domain.order;

import java.util.List;

public interface OrderService {

    public List<order> getAllOrders();
    public List<order> getSpecialOrdersByOpenid(String state,String openid);
    public List<order> getOrderByOpenid(String openid);   //获取个人的所有订单
    public List<order> getOrderByOpenid_State(String openid,int state);  //个人获取自己的订单类型
    public List<order> getOrderByState(int state);   //管理员获取订单类型
    public String addOrder(order order);
    public List<order> getTobeReceived(String openid);
    public void updateState(Integer state,String orderId);
    public order getOrderByOrderId(String orderId);
}
