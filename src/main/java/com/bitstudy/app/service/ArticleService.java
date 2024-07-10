package com.bitstudy.app.service;


import com.bitstudy.app.dao.*;
import com.bitstudy.app.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleService {
    @Autowired
    ArticleDao articleDao;

    @Autowired
    UserDao userDao;

    @Autowired
    CommentDao commentDao;

    @Autowired
    HeartDao heartDao;

    @Autowired
    FollowDao followDao;



    public int madeArticle(ArticleDto articleDto){
        return articleDao.madeArticle(articleDto);
    }

    public List<ArticleDto> search_article(String A_writer){
        return articleDao.search_article(A_writer);
    }

    public int deleteArticle(String A_writer) {
        return articleDao.deleteArticle(A_writer);
    }

    public int d_delete(Integer A_seqno, String A_writer) {
        return articleDao.d_delete(A_seqno, A_writer);
    }

    public List<ArticleDto> user_Article(String A_writer, String user_id){return articleDao.user_Article(A_writer, user_id);}

    public List<ArticleDto> user_heartArticle(String user_id) {
        return articleDao.user_heartArticle(user_id);
    }

    public int article_count(String A_writer) {
        return articleDao.article_count(A_writer);
    }

    public int heartCountUpdate(HeartDto heartDto){
        return articleDao.heartCountUpdate(heartDto);
    }

    public int commentCountUpdate(CommentCountDto commentCountDto){
        return articleDao.commentCountUpdate(commentCountDto);
    }

    public  int userImgUpdate(UserImgDto UserImgDto){
        return  articleDao.userImgUpdate(UserImgDto);
    }

    public List<ArticleDto> main_article(Map map) {
        return articleDao.main_article(map);
    }


    public int heart_modify (String id,Integer A_seqno){
        System.out.println("일단 서비스 넘어옴");

        // 이사람의 이름 , a_seqno 로 하트게시물 눌렀는지 확인하기
        // 안눌렸으면 추가하기
        // 눌렀으면 삭제하기
        // 하트업데이트 했으면
        // 그 게시물 아티클테이블의 하트 수 업데이트 해주기


        Map map = new HashMap();
        map.put("id",id);
        map.put("A_seqno",A_seqno);
        HeartDto aaa = heartDao.heartSelect(map);


        if(aaa == null){
            heartDao.insertMyLike(A_seqno,id);
            HeartDto bbb = heartDao.heartCountOne(A_seqno);
            bbb.setFK_A_seqno(A_seqno);//이거 0개면 게시글 고유번호를 직접 안전하게 넣어둠.
            articleDao.heartCountUpdate(bbb);
            return 1;

        }

        else {
            heartDao.deleteLikeOne(A_seqno,id);
            HeartDto bbb = heartDao.heartCountOne(A_seqno);
            bbb.setFK_A_seqno(A_seqno); //이거 0개면 게시글 고유번호를 직접 안전하게 넣어둠.
            articleDao.heartCountUpdate(bbb);
            return 0;
        }

    }

    public int follow_modify (FollowDto followDto){


        FollowDto aaa = followDao.selectFollow(followDto);


        if(aaa == null){
            followDao.inserFollow(followDto);

            return 1;
        }
        else {
            followDao.deleteFollow(followDto);

            return 0;
        }

    }


}
