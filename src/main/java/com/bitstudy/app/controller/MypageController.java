package com.bitstudy.app.controller;


import com.bitstudy.app.domain.UserDto;
import com.bitstudy.app.service.UserService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.File;

@Controller
public class MypageController {

    @Autowired
    UserService userService;

    @GetMapping("/myPage")
    public String myPage(HttpSession session, Model model) {
        String currentID = (String) session.getAttribute("id");

        if (currentID == null) {
            return "redirect:/";
        }

        System.out.println("currentID : " + currentID);
        UserDto userInfo = userService.getUser(currentID);

        System.out.println("userInfo : " + userInfo);

        model.addAttribute("userInfo", userInfo);
        return "instagram(modify)";
    }



    private static final String F_PATH = "C:/Users/나상민/OneDrive/바탕 화면/instagram_이미지만나오면끝/src/main/webapp/resources/img/";

    @PostMapping("/myPage/save")
    public String myPageSave
            (@RequestPart(value="filename1", required = false) MultipartFile mf,
             UserDto userDto, HttpSession session) throws Exception {

        System.out.println("여기1");

        if (mf != null && !mf.isEmpty()) {
            String originalFileName = mf.getOriginalFilename();
            String safeFile = F_PATH + originalFileName;

            try {
                mf.transferTo(new File(safeFile));
                userDto.setUser_photo(safeFile);
                userDto.setUser_photo(originalFileName);

                System.out.println("이미지업로드 : " + userDto);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("여기2");
            }
        }else {
            System.out.println("No File Uploaded");
        }
        userService.updateUser(userDto);

        System.out.println("여기3");
        String prevPage = String.valueOf(session.getAttribute("prevPage"));

        return "redirect:"+(("null".equals(prevPage))?"/mainPage":prevPage);

    }
}
