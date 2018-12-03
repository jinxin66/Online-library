package com.example.onlinelibrary.controller.admin.collection;

import com.example.onlinelibrary.entity.Collection;
import com.example.onlinelibrary.service.admin.collection.CollectionService;
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
@RequestMapping(value = "/collection")
public class CollectionController extends BaseController {

    @Autowired
    private CollectionService collectionService;
//    @Autowired
//    private ShiroUserService shiroUserService;

    @RequestMapping(value = {"/index"})
    public String index(Model model, HttpServletRequest request, HttpServletResponse response, Integer nowPage) {
        Map map = MapUtil.convert(request.getParameterMap());
//        User curUser = shiroUserService.getLoginUser();
//        if (!curUser.isSuperAdmin()) {
//            map.put("tenantId", curUser.getTenantId());
//        }
//        model.addAttribute("pageView", new PageView(collectionService.findByMap(map, nowPage)));
        return "collection/index";
    }

    @ResponseBody
    @RequestMapping(value = {"/list"})
    public Map<String, Object> collectionList(HttpServletRequest request, Integer nowPage) {
        Map<String, Object> result = new HashMap();
        Map map = MapUtil.convert(request.getParameterMap());
        if (map.get("userId")==null)
            return result;

//        User curUser = shiroUserService.getLoginUser();
//        if (!curUser.isSuperAdmin()) {
//            map.put("tenantId", curUser.getTenantId());
//        }

        result.put("pageView", new PageView(collectionService.findByMap(map, nowPage)));
        return result;
    }

    @ResponseBody
    @RequestMapping(value = {"/to_create"})
    public Map<String, Object> toCreate(HttpServletRequest request) {
        Map<String, Object> result = new HashMap();

//        User curUser = shiroUserService.getLoginUser();
//        if (curUser.isSuperAdmin())
//            result.put("tree", collectionService.getTree(null));
//        else
//            result.put("tree", collectionService.getTree(null));
        return result;
    }
    @RequestMapping(value = {"/create"})
    public String create(Model model, HttpServletRequest request, HttpServletResponse response, Collection collection) {
        return ajaxReturn(response, collectionService.save(collection));
    }

    @ResponseBody
    @RequestMapping(value = {"/to_edit"})
    public Map<String, Object> toEdit(HttpServletRequest request, String id) {
        Map<String, Object> result = new HashMap();
        result.put("obj", collectionService.findById(id));

//        User curUser = shiroUserService.getLoginUser();
//        if (curUser.isSuperAdmin())
//            result.put("tree", collectionService.getTree(null));
//        else
//            result.put("tree", collectionService.getTree(null));
        return result;
    }
    @RequestMapping(value = {"update"})
    public String update(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session
            , Collection collection) throws IOException {
        collectionService.update(collection);
        return ajaxReturn(response, 1);
    }

    @ResponseBody
    @RequestMapping(value = {"/delete"})
    public String delete(Model model, HttpServletRequest request, HttpServletResponse response, String[] id) {
        return ajaxReturn(response, collectionService.deletebyIds(id));
    }

    @ResponseBody
    @RequestMapping(value = {"/deleteByUserIdAndId"})
    public String deleteByUserIdAndId( HttpServletResponse response, HttpServletRequest request) {
        Map map = MapUtil.convert(request.getParameterMap());

        return ajaxReturn(response, collectionService.deleteByUserIdAndId(map));
    }

}
