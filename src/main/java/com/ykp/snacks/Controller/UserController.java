package com.ykp.snacks.Controller;

import com.ykp.snacks.Service.Impl.UserServiceImpl;
import com.ykp.snacks.domain.Account;
import com.ykp.snacks.domain.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/UserController")
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @ResponseBody
    @PostMapping(path="/addUser")
    public String addUser(user user) {
        System.out.println("开始添加数据");
        //System.out.println(account);
        userService.addUser(user);
        return "1";
    }

    @ResponseBody
    @PostMapping(path="/getUserByOpenid")
    public user getUserByOpenid(String openid) {
        return userService.getUserByOpenid(openid);
    }

    @ResponseBody
    @PostMapping(path="/updateUser")
    public String updateUser(String phone,String openid) {
        userService.updateUser(phone,openid);
        return "1";
    }

    @ResponseBody
    @PostMapping(path="/updateAddress")
    public void updateAddress(String address,String openid){
        userService.updateAddress(address, openid);
    }
}
