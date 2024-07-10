package com.bitstudy.app.dao;

import com.bitstudy.app.domain.ArticleDto;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class ArticleDaoTest {
    @Autowired
    ArticleDao articleDao;


    @Test
    public void madeArticle() {
        ArticleDto articleDto = new ArticleDto("sungkm","아반떼화이트2","이미지", "");
        articleDao.madeArticle(articleDto);
    }

    @Test
    public void search_article() {
        List<ArticleDto> aaa =  articleDao.search_article("조다영");
        System.out.println("여기"+ aaa);
    }

    @Test
    public void deleteArticle() {
        articleDao.deleteArticle("조다영");
    }

    @Test
    public void d_delete() {
        articleDao.d_delete(5,"나상민");
    }

    @Test
    public void user_heartArticle() {
        List<ArticleDto> aaa = articleDao.user_heartArticle("조다영");
        System.out.println("한국어여기" + aaa);
    }

    @Test
    public void user_Article() {
        List<ArticleDto> aaa = articleDao.user_Article("구혜민","혜민스님");
        System.out.println("한국어여기" + aaa);
    }

    @Test
    public void article_count() {
        Integer aaa = articleDao.article_count("구혜민");
        System.out.println("한국어여기" + aaa);
    }
}