package com.bitstudy.app.controller;

import com.bitstudy.app.domain.UserDto;
import com.bitstudy.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String loginform(HttpServletRequest request) {
        String c_id = "";  //세션 만들기위해 쿠키에있는 벨류값 저장해줄려고 만든 변수
        Cookie[] cookies =request.getCookies(); // 쿠키 전부들고와서 배열로 저장
        if (cookies != null){
            for(Cookie c : cookies) {  //배열 돌리면서 우리가 넣은 쿠키 이름이랑 같은 애(instagram_id) value 값저장.
                if (c.getName().equals("instagram_id")){
                    c_id = c.getValue();
                }
            }
        }

        System.out.println("여기에요: " + c_id); //확인

        if (!c_id.equals("")){  //! 붙여서 같지않다면
            HttpSession session = request.getSession();
            session.setAttribute("id",c_id);
            return "redirect:/mainPage"; //그걸로 세션만들어서 바로 메인으로
        }

        return "instagram(login)";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        String id = request.getParameter("user_id");
        String pw = request.getParameter("user_pw");

        if(!loginchk(id,pw)) {
            String msg = URLEncoder.encode("일치하는 정보가 없습니다.", "UTF-8");
            return "redirect:/?msg=" +msg+"&mode=false";
        }

        Cookie cookie = new Cookie("instagram_id", id);
        response.addCookie(cookie);

        HttpSession session = request.getSession();
        session.setAttribute("id", id);


        return "redirect:/mainPage";
    }



    @GetMapping("/logout")
    public String logout(HttpSession session,HttpServletResponse response) {

        session.invalidate();

        Cookie myCookie = new Cookie("instagram_id", null);  // 쿠키 값을 null로 설정
        myCookie.setMaxAge(0);  // 남은 만료시간을 0으로 설정
        response.addCookie(myCookie);

        return "redirect:/";
    }


    private boolean loginchk(String id, String pw) {

        UserDto userDto1 = userService.getUser(id);

        if(userDto1 == null) return false;

        if(userDto1.getUser_pw().equals(pw)) {
            return true;
        }
        else {
            return false;
        }
    }

}
