package com.hr.controller;

import com.hr.entity.AoaUser;
import com.hr.service.AoaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @ClassName：AoaUserController
 * @Description：TODO
 * @Author：HuangZhen
 * @Date 2020/8/1 15:28
 * @Versopn：1.0
 */

@Controller
@RequestMapping("/user")
public class AoaUserController {

    @Autowired
    private AoaUserService aoaUserService;

    @RequestMapping("LoginCheck")
    public String LoginCheck(AoaUser u, HttpSession session){
        AoaUser aoaUser = aoaUserService.LoginCheck(u);
        if (aoaUser != null){
            session.setAttribute("user",aoaUser);
        }
        return "index";
    }


}
