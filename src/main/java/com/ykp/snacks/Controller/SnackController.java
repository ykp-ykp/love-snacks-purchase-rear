package com.ykp.snacks.Controller;

import com.ykp.snacks.domain.user;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/SnackController")
public class SnackController {


    @ResponseBody
    @RequestMapping(path="/getSnacks")
    public List<user> getSnacks(){
        return null;
    }


    @ResponseBody
    @PostMapping(path="/AddSnack")
    public String AddSnack(){
        return null;
    }
}
