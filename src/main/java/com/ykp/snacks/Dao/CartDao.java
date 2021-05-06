package com.ykp.snacks.Dao;
import com.ykp.snacks.domain.cart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper   /*@Mapper不可以省略*/
public interface CartDao {

    @Select("select * from cart where openid=#{openid}")
    List<cart> getPersonalCart(String openid);

    @Select("select * from cart")
    List<cart> getAllCart();

    @Select("insert into cart (openid,nickName,goodsName,image,price,weight) values(#{openid},#{nickName},#{goodsName},#{image},#{price},#{weight})")
    void addCart(cart cart);

    @Update("update cart set weight=#{weight} where openid=#{openid} and goodsName=#{goodsName}")
    void updateItem(String openid, String goodsName, String weight);  //更新购物车里面的某一项的商品个数


    @Delete("delete from cart where openid=#{openid} and goodsName=#{goodsName} ")
    void deleteItemFromCart(String openid, String goodsName);  //更新购物车里面的某一项的商品个数

}