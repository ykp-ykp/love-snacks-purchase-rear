package com.ykp.snacks.Controller;

import com.ykp.snacks.Service.Impl.CartServiceImpl;
import com.ykp.snacks.Service.Impl.GoodsServiceImpl;
import com.ykp.snacks.domain.cart;
import com.ykp.snacks.domain.goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/CartController")
public class CartController {
    @Autowired
    private CartServiceImpl cartService;

    @ResponseBody
    @RequestMapping(path="/getAllCart")
    public List<cart> getAllCart() {
        return cartService.getAllCart();
    }

    @ResponseBody
    @PostMapping(path="/getPersonalCart")
    public List<cart> getPersonalCart(String openid){
        List<cart> cartList =  cartService.getPersonalCart(openid);
        return cartList;
    }

    @ResponseBody
    @PostMapping(path="/addCart")
    public String addCart(cart cart){
        cartService.addCart(cart);
        return "1";
    }

    @ResponseBody
    @PostMapping(path="/updateItem")   //更新购物车里面的某一项的商品个数
    public String updateItem(String openid,String goodsName,String weight){
        System.out.println(openid+"--"+goodsName+"--"+weight);
        cartService.updateItem(openid,goodsName,weight);
        return "1";
    }

    @ResponseBody
    @PostMapping(path="/deleteItemFromCart")   //更新购物车里面的某一项的商品个数
    public String deleteItemFromCart(String openid,String goodsName){
        cartService.deleteItemFromCart(openid,goodsName);
        return "1";
    }


}
