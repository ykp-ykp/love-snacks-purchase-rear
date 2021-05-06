package com.ykp.snacks.Controller.Admin;

import com.ykp.snacks.Service.Impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/PageController")
@Controller
public class PageController {
    @Autowired
    private GoodsServiceImpl goodsService;

    @RequestMapping("/add_goods")
    public String to_add_goods(){
        return "add_goods";
    }

    @RequestMapping("/to_index")
    public String to_index(){
        return "index";
    }

    @RequestMapping("/login")
    public String to_login(){
        return "redirect:/";
    }


}
