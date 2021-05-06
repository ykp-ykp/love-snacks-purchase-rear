package com.ykp.snacks.Controller;


import com.ykp.snacks.domain.goods;
import com.ykp.snacks.domain.user;
import com.ykp.snacks.utils.util;
import com.ykp.snacks.Service.AccountService;
import com.ykp.snacks.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.Locale;


@Controller
@RequestMapping("/Controller")
public class HelloController {

    @Autowired
    private AccountService accountService;
//这个accountService是在AccountServiceImp上面的注释@Service("accountService")同名

    @RequestMapping(path = "/findAll")
    public String findAll(HttpSession session){
        List<Account> accountList =  accountService.findAll();
        System.out.println("accountList = "+accountList);
        session.setAttribute("accountList",accountList );
        return "allAccounts";
    }

    @ResponseBody
    @RequestMapping(path="/getAllAccounts")
    public List<Account> getAllAccounts(){
        List<Account> accountList =  accountService.findAll();
        return accountList;
    }


    //spring 接受请求参数的方法
    @ResponseBody
    @PostMapping(path="/insert")
    public String insert(Account account) {
        System.out.println("开始添加数据");
        //System.out.println(account);
        accountService.saveAccount(account);
        return "1";
    }

    @ResponseBody
    @PostMapping(path="/insertUser")
    public String insert(user user) {
        System.out.println("开始添加数据");
        //System.out.println(account);
        accountService.saveUser(user);
        return "1";
    }

    //获取用户的小程序唯一标识openid
    @ResponseBody
    @PostMapping(path="/getopenid")
    public String getOpenid(String code) {
        util util = new util();
        //System.out.println("code = "+code);
        return util.getOpenid(code);
    }

    @ResponseBody
    @PostMapping(path="/addGoods")
    public String addGoods(goods goods) {
        System.out.println("开始添加数据");
        System.out.println(goods);

        return "1";
    }

    @RequestMapping("/to_success")
    public String hello() {
        return "success";
    }
}