package com.bitstudy.app.dao;

import com.bitstudy.app.domain.CommentCountDto;
import com.bitstudy.app.domain.CommentDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CommentDaoImpl implements CommentDao {
    @Autowired
    SqlSession session;

    String namespace = "com.bitstudy.app.dao.CommentMapper.";

    @Override
    public int comment_delete(Integer C_seqno, String C_writer) {
        Map map = new HashMap();
        map.put("C_seqno", C_seqno);
        map.put("C_writer", C_writer);

        return session.delete(namespace + "comment_delete", map);
    }

    @Override
    public int deleteMyComment(String C_write) {

        return session.delete(namespace + "deleteMyComment", C_write);
    }

    @Override
    public int comment_insert(CommentDto commentDto) {

        return session.insert(namespace + "comment_insert", commentDto);
    }

    @Override
    public int comment_update(CommentDto commentDto) {
        return session.update(namespace + "comment_update", commentDto);
    }

    @Override
    public int comment_count(Integer FK_A_seqno) {
        return session.selectOne(namespace + "comment_count", FK_A_seqno);
    }

    @Override
    public List<CommentDto> comment_user(Integer FK_A_seqno) {
        return session.selectList(namespace + "comment_user", FK_A_seqno);
    }

    @Override
    public List<CommentDto> comment_c(Map map) {
        return session.selectList(namespace + "comment_c", map);
    }

    @Override
    public int MyArticleComment(String user_id) {
        return session.delete(namespace + "MyArticleComment", user_id);
    }

    @Override
    public List<CommentCountDto> commentCount(){
        return session.selectList(namespace + "commentCount");
    }

    @Override
    public Integer getGroup(Integer FK_A_seqno){
        return session.selectOne(namespace + "getGroup",FK_A_seqno);
    }

    @Override
    public CommentDto selectComment(Integer C_seqno){
        return session.selectOne(namespace+"selectComment",C_seqno);
    }

    @Override
    public int parentdelete(Map map){
//        System.out.println("다오 왔어요");
        return session.delete(namespace+"parentdelete",map);
    }

    @Override
    public  CommentCountDto countOne (Integer FK_A_seqno){
        return session.selectOne(namespace+"countOne",FK_A_seqno);
    }

}
