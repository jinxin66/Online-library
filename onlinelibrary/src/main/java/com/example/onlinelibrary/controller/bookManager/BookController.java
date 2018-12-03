package com.example.onlinelibrary.controller.bookManager;

import com.example.onlinelibrary.entity.Book;
import com.example.onlinelibrary.service.bookManager.BookService;
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
@RequestMapping(value = "/book")
public class BookController extends BaseController {

    @Autowired
    private BookService bookService;
//    @Autowired
//    private ShiroUserService shiroUserService;

    @RequestMapping(value = {"/index"})
    public String index(Model model, HttpServletRequest request, HttpServletResponse response, Integer nowPage) {
        Map map = MapUtil.convert(request.getParameterMap());
//        User curUser = shiroUserService.getLoginUser();
//        if (!curUser.isSuperAdmin()) {
//            map.put("tenantId", curUser.getTenantId());
//        }
//        model.addAttribute("pageView", new PageView(bookService.findByMap(map, nowPage)));
        return "book/index";
    }

    @ResponseBody
    @RequestMapping(value = {"/list"})
    public Map<String, Object> bookList(HttpServletRequest request, Integer nowPage) {
        Map<String, Object> result = new HashMap();
        Map map = MapUtil.convert(request.getParameterMap());

//        User curUser = shiroUserService.getLoginUser();
//        if (!curUser.isSuperAdmin()) {
//            map.put("tenantId", curUser.getTenantId());
//        }

        result.put("pageView", new PageView(bookService.findByMap(map, nowPage)));
        return result;
    }

    @ResponseBody
    @RequestMapping(value = {"/to_create"})
    public Map<String, Object> toCreate(HttpServletRequest request) {
        Map<String, Object> result = new HashMap();

//        User curUser = shiroUserService.getLoginUser();
//        if (curUser.isSuperAdmin())
//            result.put("tree", bookService.getTree(null));
//        else
//            result.put("tree", bookService.getTree(null));
        return result;
    }
    @RequestMapping(value = {"/create"})
    public String create(Model model, HttpServletRequest request, HttpServletResponse response, Book book) {
        return ajaxReturn(response, bookService.save(book));
    }

    @ResponseBody
    @RequestMapping(value = {"/to_edit"})
    public Map<String, Object> toEdit(HttpServletRequest request, String id) {
        Map<String, Object> result = new HashMap();
        result.put("obj", bookService.findById(id));

//        User curUser = shiroUserService.getLoginUser();
//        if (curUser.isSuperAdmin())
//            result.put("tree", bookService.getTree(null));
//        else
//            result.put("tree", bookService.getTree(null));
        return result;
    }
    @RequestMapping(value = {"update"})
        public String update(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session
            , Book book) throws IOException {
        bookService.update(book);
        return ajaxReturn(response, 1);
    }

    @ResponseBody
    @RequestMapping(value = {"/delete"})
    public String delete(Model model, HttpServletRequest request, HttpServletResponse response, String[] id) {
        return ajaxReturn(response, bookService.deletebyIds(id));
    }

    @ResponseBody
    @RequestMapping(value = {"/details"})
    public Map<String, Object> details(HttpServletRequest request, Integer nowPage) {
        Map<String, Object> result = new HashMap();
        Map map = MapUtil.convert(request.getParameterMap());

        if (map.get("bookId")==null)
            return result;

        result.put("pageView", bookService.getDetailsByMap(map));
        return result;
    }

}
