package com.ykp.snacks.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ykp.snacks.Service.Impl.OrderServiceImpl;
import com.ykp.snacks.domain.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path="/OrderController")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @ResponseBody
    @PostMapping(path="/addOrder")
    public String addOrder(order order){
        System.out.println("开始添加数据"+order);
        orderService.addOrder(order);
        return "1";
    }

    @ResponseBody
    @RequestMapping(path="/getAllOrders")
    public Map<String, Object> getAllOrders(){

        List<order> orderList = orderService.getAllOrders();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", orderList.size());
        result.put("data", orderList);
        return result;
    }

    @ResponseBody
    @PostMapping(path="/getOrderByOpenid")
    public List<order> getOrderByOpenid(String openid){
        System.out.println("getOrderByOpenid"+"openid = "+openid);
        return orderService.getOrderByOpenid(openid);
    }

    @ResponseBody
    @PostMapping(path="/getOrderByOrderId")
    public order getOrderByOrderId(String orderId){
        return orderService.getOrderByOrderId(orderId);
    }

    @ResponseBody
    @PostMapping(path="/getSpecialOrdersByOpenid")
    public List<order> getSpecialOrdersByOpenid(String state,String openid){
        System.out.println("getSpecialOrdersByOpenid"+"openid = "+openid+"   state = "+state);
        return orderService.getSpecialOrdersByOpenid(state,openid);
    }

    //["等待发货","待评价","退货中","已评价","已发货","已完成退货"]，其中0和4下标对应的是待收货,对应数据库中的state是1和5
    @ResponseBody
    @PostMapping(path="/getTobeReceived")  //获取某人的待收货订单
    public List<order> getTobeReceived(String openid){
        return orderService.getTobeReceived(openid);
    }


    @ResponseBody
    @PostMapping(path="/updateState")
    public String updateState(Integer state,String orderId){
        orderService.updateState(state,orderId);
        return "1";
    }

}
