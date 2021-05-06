package com.ykp.snacks.Controller;


import com.ykp.snacks.Service.Impl.GoodsServiceImpl;
import com.ykp.snacks.domain.goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/GoodsController")
public class GoodsController {

    @Autowired
    private GoodsServiceImpl goodsService;

    @ResponseBody
    @PostMapping(path="/addGoods")
    public String addGoods(goods goods) {
        System.out.println("开始添加数据");
        System.out.println(goods);
        goodsService.addGoods(goods);
        return "1";
    }

    @ResponseBody
    @RequestMapping(path="/getAllGoods")
    public List<goods> getAllGoods(){
        List<goods> goodsList =  goodsService.getAllGoods();
        return goodsList;
    }

    @ResponseBody
    @PostMapping(path="/getGoodsByname")
    public goods getGoodsByname(String name){
        System.out.println("name = "+name);
        return  goodsService.getGoodsByname(name);
    }

    @ResponseBody
    @RequestMapping(path="/FuzzyQuery")
    public List<goods> FuzzyQuery(String name){
        System.out.println("name = "+name);
        List<goods> goodsList = goodsService.FuzzyQuery(name);
        System.out.println(goodsList);
        return goodsList;
    }

    @ResponseBody
    @RequestMapping(path="/updateSurplus")
    public void updateSurplus(String name, int surplus) {
        goodsService.updateSurplus(name,surplus );
    }

    @ResponseBody
    @RequestMapping(path="/updateSales")
    public void updateSales(String name, int sales) {
        goodsService.updateSales(name,sales );
    }
}
