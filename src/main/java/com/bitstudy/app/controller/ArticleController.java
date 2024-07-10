package com.bitstudy.app.controller;

import com.bitstudy.app.dao.ArticleDao;
import com.bitstudy.app.domain.ArticleDto;
import com.bitstudy.app.domain.UserDto;
import com.bitstudy.app.domain.UserImgDto;
import com.bitstudy.app.service.ArticleService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {
    @Autowired
    ArticleDao articleDao;

    @Autowired
    ArticleService articleService;

    @GetMapping("/write")
    public String articleForm(HttpSession session)
    {
        String id = (String) session.getAttribute("id");
        if (id == null){
            return "redirect:/";
        }
        return "instagram2";
    }

    private static final String F_PATH = "C:/Users/나상민/OneDrive/바탕 화면/instagram_이미지만나오면끝/src/main/webapp/resources/img/";

    @PostMapping("/write/save")
    public String save
            (@RequestPart(value="filename", required = false) MultipartFile mf,
             ArticleDto articleDto, HttpSession session, UserImgDto userImgDto) throws Exception {


        articleService.userImgUpdate(userImgDto);
        String articleWriter = (String) session.getAttribute("id");
        articleDto.setA_writer(articleWriter);


        /* 파일 업로드 */
        String originalFileName = mf.getOriginalFilename();
//        String safeFile = F_PATH + System.currentTimeMillis() + originalFileName;
        String safeFile = F_PATH + originalFileName;

        mf.transferTo(new File(safeFile));
        articleDto.setA_img(originalFileName);

        articleService.madeArticle(articleDto);

        return "redirect:/mainPage";
    }

}

/* 이건 사진 여러장 올릴때 */
//    @PostMapping("/write/save")
//    public String save
//            (@RequestPart(value="filename", required = false)
//             MultipartFile[] mf, ArticleDto articleDto) throws Exception {
//
//        List<Map<String, Object>> fileList = new ArrayList<Map<String, Object>>();
//
//        /* 파일 업로드 */
//        for(int i = 0; i< mf.length;i++) {
//            String originalFileName = mf[i].getOriginalFilename();
//            String safeFile = F_PATH + System.currentTimeMillis() + originalFileName;
//            Map<String, Object> fileInfo = new HashMap<String, Object>();
//            fileInfo.put("aaa", originalFileName);
//            fileList.add(fileInfo);
//            mf[i].transferTo(new File(safeFile));
//            articleDto.setA_img(originalFileName);
//        }
//
//
//        for(int i = 0 ; i<mf.length; i++){
//            articleDto.setA_img(mf[i].getOriginalFilename());
//            if(!(articleDto.getA_img().equals(""))){
//                articleService.madeArticle(articleDto);
//            }
//        }
//
//        return "redirect:/";
//    }

