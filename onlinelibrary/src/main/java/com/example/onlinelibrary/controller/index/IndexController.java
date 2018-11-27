package com.example.onlinelibrary.controller.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Value("${PAGE_SIZE}")
    private int PAGE_SIZE;

//    @Autowired
//    private UserService userService;
//    @Autowired
//    private ShiroUserService shiroUserService;

    @ResponseBody
    @RequestMapping(value={"/" , "/index" , "/login" , "/index/login"})
    public String index(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
//        Subject user = SecurityUtils.getSubject();
//        if(user.isRemembered()||user.isAuthenticated()){
//            return "index/index";
//        }
        return "测试成功";
    }

}
