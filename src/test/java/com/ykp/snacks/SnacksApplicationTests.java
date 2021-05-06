package com.ykp.snacks;

import com.ykp.snacks.Dao.CartDao;
import com.ykp.snacks.Dao.OrderDao;
import com.ykp.snacks.Service.Impl.CartServiceImpl;
import com.ykp.snacks.Service.Impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
class SnacksApplicationTests {

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    CartServiceImpl cartService;

    @Autowired
    OrderDao orderDao;

    @Autowired
    CartDao cartDao;

    @Test
    void contextLoads() {
        String openid = "ov-SK5EiJPL9w3GxRnGO28Cl-1Kc";
        String goodsName = "佳龙";
        String weight = "3";
        cartService.updateItem(openid,goodsName,weight);
}

}
