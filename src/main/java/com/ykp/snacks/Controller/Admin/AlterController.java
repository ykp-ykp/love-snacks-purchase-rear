package com.ykp.snacks.Controller.Admin;


import com.ykp.snacks.Service.GoodsService;
import com.ykp.snacks.Service.Impl.AdminServiceImpl;
import com.ykp.snacks.Service.Impl.GoodsServiceImpl;
import com.ykp.snacks.Service.Impl.OrderServiceImpl;
import com.ykp.snacks.Service.Impl.UserServiceImpl;
import com.ykp.snacks.Service.OrderService;
import com.ykp.snacks.domain.admin;
import com.ykp.snacks.domain.goods;
import com.ykp.snacks.domain.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.Socket;
import java.util.List;
import java.util.zip.CheckedOutputStream;

@Controller
@RequestMapping("/AlterController")
public class AlterController {
    @Autowired
    private AdminServiceImpl adminServicel;
    @Autowired
    private GoodsServiceImpl goodsService;
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/Alteradmin")
    public String Alteradmin(HttpServletRequest request, HttpSession session){
        String password = (String)request.getParameter("password");
        String phone = (String)request.getParameter("phone");
        String name = (String)session.getAttribute("name");
        admin admin = new admin();
        admin.setPassword(password);admin.setPhone(phone);admin.setName(name);
        adminServicel.update(admin);
        session.removeAttribute("name");
        return  "login";
    }

    @PostMapping("/Alteruser")
    public String Alteruser(HttpServletRequest request, HttpSession session){
        String openid = (String)request.getParameter("openid");
        String phone = (String)request.getParameter("phone");
        String address = (String)request.getParameter("address");
        user user= new user();
        user.setOpenid(openid);user.setPhone(phone);user.setAddress(address);
        userService.updatePWDADD(user);

        return  "redirect:/AdminController/to_admin_center_alluser";
    }

    @RequestMapping("/admine_delete_goods")
    public String admine_delete_goods(HttpServletRequest request, HttpSession session,String goodsName){
        System.out.println(goodsName);
        goodsService.deleteGoods(goodsName);
        List<goods> goodsList = goodsService.getAllGoods();
//      request.setAttribute("allgoods", goodsList);
        session.setAttribute("allgoods", goodsList);
        return "admin_center_allGoods";
    }

    @PostMapping("/admin_alter_goods")
    public String admin_alter_goods(HttpServletRequest request, HttpSession session,String goodsName){
        String altered_goodsName = (String)request.getParameter("altered_goodsName");
        System.out.println(altered_goodsName);
        goods goods = goodsService.getGoodsByname(altered_goodsName);
        request.setAttribute("alter_goods",goods );
        return "admin_alter_goods";
    }

    @PostMapping("/admin_alter_user")
    public String admin_alter_user(HttpServletRequest request){
        String altered_openid = (String)request.getParameter("openid");
        System.out.println(altered_openid);
        user user = userService.getUserByOpenid(altered_openid);
        request.setAttribute("alter_user",user );
        //跳转到显示单个用户信息的页面
        return "admin_alter_user";
    }

    //发货
    @RequestMapping("/DeliverGoods")
    public String DeliverGoods(HttpServletRequest request,String orderId){

        System.out.println(orderId);
        orderService.updateState(5,orderId );
        //使用重定向可以进入下面那个方法再次重新加载数据
        return "redirect:/AdminController/to_admin_center_allorder";
    }

    @RequestMapping("/ReturnGoods")
    public String ReturnGoods(HttpServletRequest request,String orderId){

        System.out.println(orderId);
        orderService.updateState(6,orderId );
        return "redirect:/AdminController/to_admin_center_allorder";
    }

}
