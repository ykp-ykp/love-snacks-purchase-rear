package com.ykp.snacks.Controller.Admin;

import com.ykp.snacks.Dao.UserDao;
import com.ykp.snacks.Service.Impl.AdminServiceImpl;
import com.ykp.snacks.Service.Impl.GoodsServiceImpl;
import com.ykp.snacks.Service.Impl.OrderServiceImpl;
import com.ykp.snacks.Service.Impl.UserServiceImpl;
import com.ykp.snacks.domain.admin;
import com.ykp.snacks.domain.goods;
import com.ykp.snacks.domain.order;
import com.ykp.snacks.domain.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/AdminController")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;
    @Autowired
    private GoodsServiceImpl goodsService;
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private UserServiceImpl userService;


    @RequestMapping("/vertifyAdmin")
    public admin vertifyAdmin(String name,String password){
        return adminService.vertifyAdmin(name, password);
    }

    @RequestMapping("/getAdminByName")
    public admin getAdminByName(String name){
        return adminService.getAdminByName(name);
    }

    @RequestMapping("/Login")
    public String Login(String name, String password, HttpServletRequest request,HttpSession session){
        System.out.println("name = "+name+"----password = "+password);
        admin admin =  adminService.vertifyAdmin(name, password);
        if(admin!=null){
            session.setAttribute("name",admin.getName() );
            session.setAttribute("admin",admin );
            return "admin_center_info";
        }else{
            request.setAttribute("info","登陆失败" );
            request.setAttribute("pagename","login" );
            return "TransferPage";
        }
    }

    @RequestMapping("/Quit")
    public String Quit(HttpServletRequest request, HttpSession session){
        session.setAttribute("name",null );
        session.removeAttribute("name");
        return "redirect:/";
    }


    @RequestMapping("/to_admin_center_info")
    public String to_admin_center_info(HttpServletRequest request,HttpSession session){
        String name = (String) session.getAttribute("name");

        if(name==null|| name.equals("")){
            //提示未登录
            return "redirect:/AdminController/notlogin";
        }else{
            admin admin = adminService.getAdminByName(name);
            request.setAttribute("admin", admin);
        }
        return "admin_center_info";
    }

    @RequestMapping("/to_alter_admin_info")
    public String to_alter_admin_info(HttpServletRequest request,HttpSession session){
        String name = (String) session.getAttribute("name");
        if(name==null|| name.equals("")){
            return "redirect:/AdminController/notlogin";
        }else{
            admin admin = adminService.getAdminByName(name);
            request.setAttribute("admin", admin);
        }
        return "alter_admin_info";
    }


    @RequestMapping("/to_admin_center_allGoods")
    public String to_admin_center_allGoods(HttpServletRequest request,HttpSession session){
        String username = (String) session.getAttribute("name");
        if(username==null|| username.equals("")){
            return "redirect:/AdminController/notlogin";
        }else{
            List<goods> goodsList = goodsService.getAllGoods();
            session.setAttribute("allgoods", goodsList);
        }
        return "admin_center_allGoods";
    }

    @RequestMapping("/to_admin_center_allorder")
    public String to_admin_center_allorder(HttpServletRequest request,HttpSession session){
        String username = (String) session.getAttribute("name");
        if(username==null|| username.equals("")){
            return "redirect:/AdminController/notlogin";
        }else{
            List<order>  allorder = orderService.getAllOrders();
            session.setAttribute("allorder", allorder);
        }
        return "admin_center_allorder";
    }


    @RequestMapping("/to_admin_center_alluser")
    public String to_admin_center_alluser(HttpServletRequest request,HttpSession session){
        String username = (String) session.getAttribute("name");
        if(username==null|| username.equals("")){
            return "redirect:/AdminController/notlogin";
        }else{
            List<user>  userList = userService.getAllUser();
            session.setAttribute("allusers", userList);
        }
        return "admin_center_alluser";
    }



    @RequestMapping("/orderDetail")
    public String orderDetail(HttpServletRequest request,HttpSession session,String orderId){
        System.out.println("orderId = "+orderId);
        request.setAttribute("orderDetail",orderService.getOrderByOrderId(orderId) );
        return "orderDetail";
    }

    @RequestMapping("/notlogin")
    public String notlogin(HttpServletRequest request){
            request.setAttribute("info","你还未登录，请去登录！" );
            request.setAttribute("pagename","login" );
            return "TransferPage";
    }

}
