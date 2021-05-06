package com.ykp.snacks.Service.Impl;

import com.ykp.snacks.Dao.OrderDao;
import com.ykp.snacks.Service.OrderService;
import com.ykp.snacks.domain.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public List<order> getSpecialOrdersByOpenid(String state,String openid) {
        return orderDao.getSpecialOrdersByOpenid(state,openid);
    }

    @Override
    public List<order> getOrderByOpenid(String openid) {
        return orderDao.getOrderByOpenid(openid);
    }

    @Override
    public List<order> getOrderByOpenid_State(String openid, int state) {
        return null;
    }

    @Override
    public List<order> getOrderByState(int state) {
        return null;
    }

    @Override
    public String addOrder(order order) {
        System.out.println("在OrderServiceImpl中order = "+order);
        orderDao.addOrder(order);
        return "1";
    }

    @Override
    public List<order> getTobeReceived(String openid){
        return orderDao.getTobeReceived(openid);
    }

    @Override
    public void updateState(Integer state,String orderId){
        System.out.println("state = "+state);
        orderDao.updateState(state, orderId);
    }

    @Override
    public order getOrderByOrderId(String orderId){
        return orderDao.getOrderByOrderId(orderId);
    }
}
