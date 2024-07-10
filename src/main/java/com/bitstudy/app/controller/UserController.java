package com.bitstudy.app.controller;

import com.bitstudy.app.dao.ArticleDao;
import com.bitstudy.app.dao.CommentDao;
import com.bitstudy.app.dao.HeartDao;
import com.bitstudy.app.domain.UserDto;
import com.bitstudy.app.service.ArticleService;
import com.bitstudy.app.service.CommentService;
import com.bitstudy.app.service.HeartService;
import com.bitstudy.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


/* pw찾기, 회원탈퇴 */

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ArticleService articleService;

    @Autowired
    CommentService commentService;

    @Autowired
    HeartService heartService;

    @GetMapping("/findPwForm")
    public String findPwForm() {
        return "instagram(pw)";
    }


    @PostMapping("/findPW")
    public String findPW(HttpServletRequest request, Model model) throws UnsupportedEncodingException {

        String user_id = request.getParameter("user_id");
        String user_name = request.getParameter("user_name");
        String ph_num = request.getParameter("ph_num");
        String user_pw = request.getParameter("user_pw");

        String find_user_id = userService.findPw(user_id, user_name, ph_num);


        if(find_user_id == null) {
            String msg = URLEncoder.encode("일치하는 정보가 없습니다.", "UTF-8");
            return "redirect:/findPwForm?msg=" + msg+"&mode=false";
        }
            String msg1 = URLEncoder.encode("성공", "UTF-8");

        if(user_pw != null){
            userService.updatePw(user_id, user_pw);
            return "redirect:/";
        }
        model.addAttribute("user_id",user_id);
        model.addAttribute("user_name",user_name);
        model.addAttribute("ph_num",ph_num);

        return "redirect:/findPwForm?msg1="+msg1+"&mode=true";
    }

    @GetMapping("/test")
    public String test() {
        return "instagram";
    }

    @GetMapping("/deleteUserInfo")
    public String deleteUserInfo(HttpSession session) {

        String currentID = (String) session.getAttribute("id");


        heartService.MyArticleHeart(currentID);
        commentService.MyArticleComment(currentID);
        int test1 = userService.deleteUser(currentID);
        int test2 = userService.deleteMyLike(currentID);
        int test3 = userService.deleteMyfollower(currentID);
        int test4 = userService.deleteMyComment(currentID);
        articleService.deleteArticle(currentID);
        return "redirect:/";
    }

}
