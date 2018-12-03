package com.example.onlinelibrary.controller.admin.user;

import com.example.onlinelibrary.entity.User;
import com.example.onlinelibrary.service.admin.user.UserService;
import com.example.onlinelibrary.utils.MapUtil;
import com.example.onlinelibrary.utils.PageView;
import flybear.hziee.core.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private UserService useryService;
//    @Autowired
//    private ShiroUserService shiroUserService;

    @RequestMapping(value = {"/index"})
    public String index(Model model, HttpServletRequest request, HttpServletResponse response, Integer nowPage) {
        Map map = MapUtil.convert(request.getParameterMap());
//        User curUser = shiroUserService.getLoginUser();
//        if (!curUser.isSuperAdmin()) {
//            map.put("tenantId", curUser.getTenantId());
//        }
//        model.addAttribute("pageView", new PageView(useryService.findByMap(map, nowPage)));
        return "user/index";
    }

    @ResponseBody
    @RequestMapping(value = {"/list"})
    public Map<String, Object> userList(HttpServletRequest request, Integer nowPage) {
        Map<String, Object> result = new HashMap();
        Map map = MapUtil.convert(request.getParameterMap());

//        User curUser = shiroUserService.getLoginUser();
//        if (!curUser.isSuperAdmin()) {
//            map.put("tenantId", curUser.getTenantId());
//        }

        result.put("pageView", new PageView(useryService.findByMap(map, nowPage)));
        return result;
    }

    @ResponseBody
    @RequestMapping(value = {"/to_create"})
    public Map<String, Object> toCreate(HttpServletRequest request) {
        Map<String, Object> result = new HashMap();

//        User curUser = shiroUserService.getLoginUser();
//        if (curUser.isSuperAdmin())
//            result.put("tree", useryService.getTree(null));
//        else
//            result.put("tree", useryService.getTree(null));
        return result;
    }
    @RequestMapping(value = {"/create"})
    public String create(Model model, HttpServletRequest request, HttpServletResponse response, User user) {
        return ajaxReturn(response, useryService.save(user));
    }

    @ResponseBody
    @RequestMapping(value = {"/to_edit"})
    public Map<String, Object> toEdit(HttpServletRequest request, String id) {
        Map<String, Object> result = new HashMap();
        result.put("obj", useryService.findById(id));

//        User curUser = shiroUserService.getLoginUser();
//        if (curUser.isSuperAdmin())
//            result.put("tree", useryService.getTree(null));
//        else
//            result.put("tree", useryService.getTree(null));
        return result;
    }
    @RequestMapping(value = {"update"})
    public String update(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session
            , User user) throws IOException {
        useryService.update(user);
        return ajaxReturn(response, 1);
    }

    @ResponseBody
    @RequestMapping(value = {"/delete"})
    public String delete(Model model, HttpServletRequest request, HttpServletResponse response, String[] id) {
        return ajaxReturn(response, useryService.deletebyIds(id));
    }
}
