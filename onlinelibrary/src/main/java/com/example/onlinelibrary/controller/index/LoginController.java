package com.example.onlinelibrary.controller.index;

import com.example.onlinelibrary.entity.User;
import com.example.onlinelibrary.service.admin.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService useryService;
//    @Autowired
//    private ShiroUserService shiroUserService;

    @RequestMapping(value={"/loginByWechatId"})
    public String loginByWechatId(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session
            , String wechatId) {
        User user = useryService.findByWechatId(wechatId);
        if (user != null){
            //return 进入
            if (user.getStudentId() != null){
                //return 已绑定
            }else{
                //return 未绑定
            }
        }else{
            User newuser = new User();
            newuser.setWechatId(wechatId);
            useryService.save(newuser);
            //return 未绑定
        }

        return "";
    }

    @RequestMapping(value={"/loginByStudentId"})
    public String loginByStudentId(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session
            , String studentId, String password) {
        User user = useryService.findByWechatId(studentId);
        if (user != null){
            //return 进入
        }else{
            //return 学号不存在，可以用微信登录
        }

        return "";
    }

    @RequestMapping(value={"/logout"})
    public String logout(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session
            , String studentId, String password) {
        User user = useryService.findByWechatId(studentId);
        if (user != null){
            //return 进入
        }else{
            //return 学号不存在，可以用微信登录
        }

        return "";
    }
}
