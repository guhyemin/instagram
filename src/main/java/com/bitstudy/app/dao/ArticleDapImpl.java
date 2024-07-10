package com.bitstudy.app.dao;

import com.bitstudy.app.domain.*;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ArticleDapImpl implements ArticleDao {
    @Autowired
    SqlSession session;

    String namespace = "com.bitstudy.app.dao.ArticleMapper.";


    @Override
    public int madeArticle(ArticleDto articleDto) {
        return session.insert(namespace + "madeArticle", articleDto);
    }

    @Override
    public List<ArticleDto> search_article(String A_writer) {
        return session.selectList(namespace + "search_article", A_writer);
    }

    @Override
    public int deleteArticle(String A_writer) {
        return session.delete(namespace + "deleteArticle", A_writer);
    }

    @Override
    public int d_delete(Integer A_seqno, String A_writer) {
        Map map = new HashMap();
        map.put("A_seqno", A_seqno);
        map.put("A_writer", A_writer);

        return session.delete(namespace + "d_delete", map);
    }

    @Override
    public List<ArticleDto> user_heartArticle(String H_writer) {
        return session.selectList(namespace + "user_heartArticle", H_writer);
    }

    @Override
    public List<ArticleDto> user_Article(String A_writer,String user_id) {
        Map map = new HashMap();
        map.put("A_writer", A_writer);
        map.put("user_id", user_id);
        return session.selectList(namespace + "user_Article", map);
    }

    @Override
    public int article_count(String A_writer) {
        return session.selectOne(namespace + "article_count", A_writer);
    }


    //새로 추가 업데이트
    @Override
    public int heartCountUpdate(HeartDto heartDto){
        return session.update(namespace + "heartCountUpdate", heartDto);
    }

    @Override
    public int commentCountUpdate(CommentCountDto commentCountDto){
        return session.update(namespace + "commentCountUpdate" ,commentCountDto );
    }

    @Override
    public int userImgUpdate(UserImgDto UserImgDto) {
        return session.update(namespace + "userImgUpdate", UserImgDto);
    }


    @Override
    public List<ArticleDto> main_article(Map map) {
        return session.selectList(namespace + "main_article" , map);
    }



}
