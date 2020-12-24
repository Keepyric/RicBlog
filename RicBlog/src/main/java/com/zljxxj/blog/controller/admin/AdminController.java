package com.zljxxj.blog.controller.admin;

import com.zljxxj.blog.entity.Article;
import com.zljxxj.blog.entity.Comment;
import com.zljxxj.blog.entity.User;
import com.zljxxj.blog.service.ArticleService;
import com.zljxxj.blog.service.CommentService;
import com.zljxxj.blog.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.zljxxj.blog.utils.MyUtils.getIpAddr;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    ArticleService articleService;

    @Autowired
    CommentService commentService;

    @RequestMapping(value = {"/","login"})
    public String loginPage(){
        return "Admin/login";
    }
    @RequestMapping("/admin/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/login";
    }

    @RequestMapping("/admin")
    public String index(Model model){
        List<Article> articleList = articleService.listRecentArticle(5);
        List<Comment> commentList = commentService.listRecentComment(5);
        model.addAttribute("articleList",articleList);
        model.addAttribute("commentList", commentList);
        return "Admin/index";
    }

    @RequestMapping(value = "/loginVerify", method = RequestMethod.POST, produces = {"text/plain;charset=UTF-8"} )
    @ResponseBody
    public String loginVerify(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> map = new HashMap<String, Object>();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberme = request.getParameter("rememberme");
        User user = userService.getUserByName(username);
        if(user == null){
            map.put("code",0);
            map.put("msg", "用户名错误");
            System.out.println(username);
        }else if(!user.getUserPass().equals(password)){
            map.put("code",0);
            map.put("msg","密码错误");
            System.out.println(password);
        }else{
            map.put("code",1);
            map.put("msg","登陆成功");
            request.getSession().setAttribute("user",user);
            if(rememberme!=null){
                Cookie nameCookie = new Cookie("username",username);
                Cookie pwdCookie = new Cookie("password",password);
                nameCookie.setMaxAge(60*60*24*3);
                pwdCookie.setMaxAge(60*60*24*3);
                response.addCookie(nameCookie);
                response.addCookie(pwdCookie);
            }
            user.setUserLastLoginTime(new Date());
            user.setUserLastLoginIp(getIpAddr(request));
            userService.updateUser(user);
        }
        String result = new JSONObject(map).toString();
        return result;
    }
}
