package com.bitstudy.app.service;


import com.bitstudy.app.dao.HeartDao;
import com.bitstudy.app.domain.HeartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HeartService {
    @Autowired
    HeartDao heartDao;

    public int deleteMyLike(String user_id){
        return heartDao.deleteMyLike(user_id);
    };

    public int deleteLikeOne(Integer FK_A_seqno, String H_writer){
        return heartDao.deleteLikeOne(FK_A_seqno,H_writer);
    };

    public int insertMyLike(Integer FK_A_seqno, String H_writer){
        return heartDao.insertMyLike(FK_A_seqno,H_writer);
    };


    public int MyArticleHeart(String user_id){
        return heartDao.MyArticleHeart(user_id);
    };

    public List<HeartDto> heartCount( ) {
        return heartDao.heartCount();
    }

    public  HeartDto heartSelect (Integer A_seqno, String id){
        Map map = new HashMap();
        map.put("A_seqno",A_seqno);
        map.put("id",id);
        return heartDao.heartSelect(map);
    }

    public  HeartDto heartCountOne (Integer A_seqno){
        return heartDao.heartCountOne(A_seqno);
    }


}
