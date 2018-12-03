package com.example.onlinelibrary.controller.bookManager;

import com.example.onlinelibrary.entity.Category;
import com.example.onlinelibrary.service.bookManager.CategoryService;
import com.example.onlinelibrary.utils.MapUtil;
import com.example.onlinelibrary.utils.PageView;

import flybear.hziee.core.base.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/category")
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService categoryService;
//    @Autowired
//    private ShiroUserService shiroUserService;

    @RequestMapping(value = {"/index"})
    public String index(Model model, HttpServletRequest request, HttpServletResponse response, Integer nowPage) {
        Map map = MapUtil.convert(request.getParameterMap());
//        User curUser = shiroUserService.getLoginUser();
//        if (!curUser.isSuperAdmin()) {
//            map.put("tenantId", curUser.getTenantId());
//        }
//        model.addAttribute("pageView", new PageView(categoryService.findByMap(map, nowPage)));
        return "book/category";
    }

    @ResponseBody
    @RequestMapping(value = {"/list"})
    public Map<String, Object> categoryList(HttpServletRequest request, Integer nowPage) {
        Map<String, Object> result = new HashMap();
        Map map = MapUtil.convert(request.getParameterMap());

//        User curUser = shiroUserService.getLoginUser();
//        if (!curUser.isSuperAdmin()) {
//            map.put("tenantId", curUser.getTenantId());
//        }

        result.put("pageView", new PageView(categoryService.findByMap(map, nowPage)));
        return result;
    }

    @ResponseBody
    @RequestMapping(value = {"/to_create"})
    public Map<String, Object> toCreate(HttpServletRequest request) {
        Map<String, Object> result = new HashMap();

//        User curUser = shiroUserService.getLoginUser();
//        if (curUser.isSuperAdmin())
//            result.put("tree", categoryService.getTree(null));
//        else
//            result.put("tree", categoryService.getTree(null));
        return result;
    }
    @RequestMapping(value = {"/create"})
    public String create(Model model, HttpServletRequest request, HttpServletResponse response, Category category) {
        return ajaxReturn(response, categoryService.save(category));
    }

    @ResponseBody
    @RequestMapping(value = {"/to_edit"})
    public Map<String, Object> toEdit(HttpServletRequest request, String id) {
        Map<String, Object> result = new HashMap();
        result.put("obj", categoryService.findById(id));

//        User curUser = shiroUserService.getLoginUser();
//        if (curUser.isSuperAdmin())
//            result.put("tree", categoryService.getTree(null));
//        else
//            result.put("tree", categoryService.getTree(null));
        return result;
    }
    @RequestMapping(value = {"update"})
    public String update(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session
            , Category category) throws IOException {
        categoryService.update(category);
        return ajaxReturn(response, 1);
    }

    @ResponseBody
    @RequestMapping(value = {"/delete"})
    public String delete(Model model, HttpServletRequest request, HttpServletResponse response, String[] id) {
        return ajaxReturn(response, categoryService.deletebyIds(id));
    }

    @ResponseBody
    @RequestMapping(value = {"/findAll"})
    public Map<String, Object> findAll(HttpServletRequest request, Integer nowPage) {
        Map<String, Object> result = new HashMap();
        result.put("categorys", categoryService.findAll());
        return result;
    }
}
