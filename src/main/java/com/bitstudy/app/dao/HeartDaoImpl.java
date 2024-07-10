package com.bitstudy.app.dao;

import com.bitstudy.app.domain.HeartDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HeartDaoImpl implements HeartDao {
    @Autowired
    SqlSession session;

    String namespace = "com.bitstudy.app.dao.HeartMapper.";

    @Override
    public int deleteMyLike(String user_id) {
        return session.delete(namespace + "deleteMyLike", user_id);
    }

    @Override
    public int deleteLikeOne(Integer FK_A_seqno, String H_writer) {
        Map map = new HashMap();
        map.put("FK_A_seqno", FK_A_seqno);
        map.put("H_writer", H_writer);
        return session.delete(namespace + "deleteLikeOne", map);
    }



    @Override
    public int insertMyLike(Integer FK_A_seqno, String H_writer) {
        Map map = new HashMap();
        map.put("FK_A_seqno", FK_A_seqno);
        map.put("H_writer", H_writer);
        return session.insert(namespace + "insertMyLike", map);
    }


    @Override
    public int MyArticleHeart(String user_id) {
        return session.delete(namespace + "MyArticleHeart", user_id);
    }

    @Override
    public List<HeartDto> heartCount(){
        return session.selectList(namespace + "heartCount");
    }


    @Override
    public HeartDto heartSelect (Map map){
        return session.selectOne(namespace + "heartSelect",map);
    }

    @Override
    public  HeartDto heartCountOne (Integer A_seqno){
        return session.selectOne(namespace + "heartCountOne",A_seqno);
    }
}
