package com.bitstudy.app.dao;

import com.bitstudy.app.domain.*;

import java.util.List;
import java.util.Map;

public interface ArticleDao {
    int madeArticle(ArticleDto articleDto);
    List<ArticleDto> search_article(String A_writer);
    int deleteArticle(String A_writer);
    int d_delete(Integer A_seqno, String A_writer);
    List<ArticleDto> user_heartArticle(String H_writer);
    List<ArticleDto> user_Article(String A_writer,String user_id);
    int article_count(String A_writer);

    int heartCountUpdate(HeartDto heartDto);

    int commentCountUpdate(CommentCountDto commentCountDto);

    int userImgUpdate(UserImgDto UserImgDto);

    List<ArticleDto> main_article(Map map);
}
