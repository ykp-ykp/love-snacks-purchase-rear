package com.ykp.snacks;

import com.ykp.snacks.Service.Impl.GoodsServiceImpl;
import com.ykp.snacks.utils.util;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SnacksApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnacksApplication.class, args);
        System.out.println("hello");

        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        //System.out.println(goodsService.FuzzyQuery("茶"));
        util util = new util();
        //util.sendPost();
    }


}
