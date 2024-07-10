package com.bitstudy.app.controller;//package com.bitstudy.app.controller;

import com.bitstudy.app.domain.UserDto;
import com.bitstudy.app.service.UserService;
import com.fasterxml.jackson.core.JsonToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    UserService userService;

    /*검색했을 때 밑에 사용자 뜨게하는 거*/
    @GetMapping("/searchForm")
    public String search(String keyword, Model mm, HttpSession session) {
        String id = (String) session.getAttribute("id");
        if (id == null) {
            return "redirect:/";
        }

        List<UserDto> searchList = userService.searchUser(keyword);

        mm.addAttribute("searchList",searchList);
        /* 뷰파일에서 찍을때 써야하는 값은 ""에 있는 searchList */




        String user_img = userService.findImg(id);
        mm.addAttribute("user_img", user_img);

        return "instagram(search)";

    }
}

