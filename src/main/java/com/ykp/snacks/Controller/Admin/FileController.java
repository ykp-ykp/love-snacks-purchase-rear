package com.ykp.snacks.Controller.Admin;


import com.alibaba.fastjson.JSONObject;
import com.ykp.snacks.Service.Impl.GoodsServiceImpl;
import com.ykp.snacks.domain.goods;
import com.ykp.snacks.utils.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.awt.*;
import java.io.*;

@Controller("FileController")
@RequestMapping("/FileController")
public class FileController {

    @Autowired
    private util util;
    @Autowired
    private GoodsServiceImpl goodsService;

    @RequestMapping("/addGoods")
    public String UploadImg(MultipartFile file, HttpServletRequest request, HttpSession session) throws Exception {
        String goodsName = request.getParameter("goodsName");
        double price = Double.parseDouble(request.getParameter("price"));
        String type = request.getParameter("type");
        int surplus = Integer.parseInt(request.getParameter("surplus"));
        double discount = Double.parseDouble(request.getParameter("discount"));
        String information = request.getParameter("information");
        String imgUrl = "";
        JSONObject jsonObject = null;
        if(file.isEmpty()){
            System.out.println("请选择图片");
        }else{
            //调用工具类的上传图片的方法，并返回服务器返回的jsonObject对象
            jsonObject = util.uploadImg(file);
            imgUrl = jsonObject.getJSONObject("data").getJSONObject("url").getString("distribute");
        }
        System.out.println(goodsName+"-"+price+"-"+surplus+"-"+information+"-"+imgUrl);
        /*
        *   将蔬菜添加到数据库中
        * */
        goods goods = new goods(goodsName,price,type,surplus,discount,0,imgUrl,information);
        System.out.println("goods = "+goods);
        goodsService.addGoods(goods);

        return "redirect:/AdminController/to_admin_center_allGoods";
    }


    @RequestMapping("/UpdateGoods")
    public String UpdateImg(MultipartFile file, HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception {
        response.setContentType("text/html; charset=UTF-8"); //转码
        response.setCharacterEncoding("utf-8");

        String goodsName = (String)request.getParameter("goodsName");
        double price = Double.parseDouble(request.getParameter("price"));
        //String type = request.getParameter("type");
        int surplus = Integer.parseInt(request.getParameter("surplus"));
        double discount = Double.parseDouble(request.getParameter("discount"));
        String information = request.getParameter("information");
        //可以更新价格、余量、折扣、描述信息、图片
        String imgUrl = "";
        JSONObject jsonObject = null;

        goods currentgoods = goodsService.getGoodsByname(goodsName);
        if(file.isEmpty()){
            imgUrl = currentgoods.getImage();
        }else{
            jsonObject = util.uploadImg(file);
            imgUrl = jsonObject.getJSONObject("data").getJSONObject("url").getString("distribute");
        }

        goods goods = new goods(goodsName,price,"",surplus,discount,0,imgUrl,information);
        goodsService.updateGoods(goods);
//        session.setAttribute("allgoods", goodsService.getAllGoods());
//        PrintWriter out = response.getWriter();
//        out.flush();
//        out.println("<script>");
//        out.println("alert('修改成功！');");
//        out.println("</script>");

        return "redirect:/AdminController/to_admin_center_allGoods";
    }
}







