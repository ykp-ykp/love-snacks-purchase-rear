package com.ykp.snacks.Dao;


import com.ykp.snacks.domain.goods;
import com.ykp.snacks.domain.order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper   /*@Mapper不可以省略*/
public interface OrderDao {


    @Insert("INSERT INTO `order`(`orderId`, `openid`, `nickName`, `goodsName`, `price`, `weight`, `totalPrice`, `state`, `time`) VALUES (#{orderId},#{openid},#{nickName},#{goodsName},#{price},#{weight},#{totalPrice},#{state},#{time})")
    public void addOrder(order order);

//    @Insert("insert into order (orderId,openid,nickName,goodsName,price,weight,totalPrice,state,time) values(#{orderId},#{openid},#{nickName},#{goodsName},#{price},#{weight},#{totalPrice},#{state},#{time})")
//    public void addOrder(order order);

    @Select("SELECT * FROM `order`")
    public List<order> getAllOrders();

    @Select("SELECT * FROM `order` where state = #{state} and openid = #{openid}")
    public List<order> getSpecialOrdersByOpenid(String state,String openid);

    @Select("SELECT * FROM `order` where openid=#{openid}")
    public List<order> getOrderByOpenid(String openid);

    @Select("SELECT * FROM `order` where orderId=#{orderId}")
    public order getOrderByOrderId(String orderId);

    @Select("SELECT * FROM `order` where openid=#{openid} and (state=1 or state=5)")
    public List<order> getTobeReceived(String openid);

    @Update("UPDATE `order` set state= #{state} where orderId = #{orderId}")
    public void updateState(Integer state,String orderId);  //更新订单的状态

}
