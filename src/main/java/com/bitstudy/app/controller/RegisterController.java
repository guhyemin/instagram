package com.bitstudy.app.controller;


import com.bitstudy.app.domain.UserDto;
import com.bitstudy.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @GetMapping("/register/join")
    public String registerform() {
        return "instagram(register)";
    }


    @PostMapping ("/register/save")
    public String save(UserDto userDto) throws UnsupportedEncodingException {

        if(userService.getUser(userDto.getUser_id()) != null) {
            String msg = URLEncoder.encode("이미 사용중인 아이디 입니다.", "UTF-8");
            return "redirect:/register/join?msg=" +msg+"&mode=false";
        }
        userService.insertUser(userDto);
        return "redirect:/";
    }

}
