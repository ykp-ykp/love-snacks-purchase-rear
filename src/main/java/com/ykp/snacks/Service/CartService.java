package com.ykp.snacks.Service;

import com.ykp.snacks.domain.cart;

import java.util.List;

public interface CartService {

    public List<cart> getPersonalCart(String openid);
    public List<cart> getAllCart();
    public String addCart(cart cart);
    public String updateItem(String openid,String goods_name,String weight);
    public String deleteItemFromCart(String openid,String goodsName);
}
