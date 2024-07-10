package com.bitstudy.app.controller;

import com.bitstudy.app.domain.*;
import com.bitstudy.app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DetailController {
    @Autowired
    ArticleService articleService;
    @Autowired
    HeartService heartService;
    @Autowired
    UserService userService;
    @Autowired
    FollowService followService;
    @Autowired
    CommentService commentService;

    @GetMapping("/detailArticle")
    public String detailArticle(String user, Model m, HttpSession session) {
        String user_id = (String) session.getAttribute("id");
        System.out.println(user_id);
        System.out.println(user);
        if(user_id == null) {
            return "redirect:/";
        }

//        // 업데이트하기 (3개)
//        List<HeartDto> heartDto = heartService.heartCount();
//
//        List<CommentCountDto> commentCountDto = commentService.commentCount();
//




        List<UserImgDto> userImgDto = userService.user_img();


        for (UserImgDto num:userImgDto) {
            articleService.userImgUpdate(num);
        }



//        // for문으로 업데이트 해주기
//        for (HeartDto num:heartDto) {
//            articleService.heartCountUpdate(num);
//        }
//        for (CommentCountDto num:commentCountDto) {
//            articleService.commentCountUpdate(num);
//        }




        UserDto userdto = userService.getUser(user);
        List<ArticleDto> articledto = articleService.user_Article(user, user_id);

        Integer article_count = articledto.size();
        Integer follower_count = followService.follower_count(user);
        Integer following_count = followService.following_count(user);

        FollowDto followDto = new FollowDto(user_id,user);
        FollowDto follow = followService.selectFollow(followDto);



        m.addAttribute("follow",follow); // 팔로우 상태 확인
        m.addAttribute("userdto", userdto);
        m.addAttribute("articledto", articledto);
        m.addAttribute("article_count", article_count);
        m.addAttribute("follower_count", follower_count);
        m.addAttribute("following_count", following_count);

//        String user_img = userService.user_img(user);
//        m.addAttribute("user_img", user_img);

        System.out.println("user : " + user);

        System.out.println("articledto : " + articledto);

        if(user_id.equals(user)) {

            System.out.println("일단들어와서 돌았음.");
            List<ArticleDto> articledto2 = articleService.user_heartArticle(user_id);
            m.addAttribute("modify","modify");
            m.addAttribute("articledto2", articledto2);
        }

        return "instagram(detail)";
    }

    @PatchMapping("/follow/{user_id}")
    public ResponseEntity<String> follow(@PathVariable String user_id, HttpSession session){

        try {
//            System.out.println("일단 넘어는 왔어요");
            String id = (String) session.getAttribute("id");

            FollowDto followDto = new FollowDto(id,user_id);

            Integer followResult= articleService.follow_modify(followDto);
//            System.out.println(followResult);


            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.add("content-type","text/html; charset=UTF-8");

            if (followResult == 1){
                return new ResponseEntity<String>("팔로우 추가",responseHeader, HttpStatus.OK);
            }
            else if(followResult == 0){
                return new ResponseEntity<String>("팔로우 취소",responseHeader,HttpStatus.OK);
            }
            else {
                return new ResponseEntity<String>("로그인 후 이용해주세요.",responseHeader,HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<String> (HttpStatus.BAD_REQUEST);// 400
        }


    }



}
