package com.ykp.snacks.Service.Impl;

import com.ykp.snacks.Dao.CartDao;
import com.ykp.snacks.Service.CartService;
import com.ykp.snacks.domain.cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public List<cart> getPersonalCart(String openid) {
        return cartDao.getPersonalCart(openid);
    }

    @Override
    public List<cart> getAllCart() {
        return cartDao.getAllCart();
    }

    @Override
    public String addCart(cart cart) {
        cartDao.addCart(cart);
        return "1";
    }

    @Override
    public String updateItem(String openid,String goodsName,String weight){
        cartDao.updateItem(openid,goodsName,weight);
        return "1";
    }

    @Override
    public String deleteItemFromCart(String openid, String goodsName) {
        cartDao.deleteItemFromCart(openid,goodsName);
        return "1";
    }

}
