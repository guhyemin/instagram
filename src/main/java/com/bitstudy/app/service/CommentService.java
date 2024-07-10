package com.bitstudy.app.service;


import com.bitstudy.app.dao.CommentDao;
import com.bitstudy.app.domain.CommentCountDto;
import com.bitstudy.app.domain.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {
    @Autowired
    CommentDao commentDao;


    public int comment_delete(Integer C_seqno, String C_writer){
        return commentDao.comment_delete(C_seqno,C_writer);
    };

    public int deleteMyComment(String C_write){
        return commentDao.deleteMyComment(C_write);
    };

    public int comment_insert(CommentDto commentDto){
        return commentDao.comment_insert(commentDto);
    };

    public int comment_update(CommentDto commentDto){
        return commentDao.comment_update(commentDto);
    };

    public int comment_count(Integer FK_A_seqno){
        return commentDao.comment_count(FK_A_seqno);
    };

    public List<CommentDto> comment_user(Integer FK_A_seqno){
        return commentDao.comment_user(FK_A_seqno);
    };

    public List<CommentDto> comment_c(Integer FK_A_seqno,Integer C_group_num) {
        Map map = new HashMap();
        map.put("FK_A_seqno",FK_A_seqno) ;
        map.put("C_group_num",C_group_num);
        return commentDao.comment_c(map);
    };

    public int MyArticleComment(String user_id){
        return  commentDao.MyArticleComment(user_id);
    };

    public List<CommentCountDto> commentCount() {
        return commentDao.commentCount();
    }

    public Integer getGroup(Integer FK_A_seqno){
        return commentDao.getGroup(FK_A_seqno);
    }
    public CommentDto selectComment(Integer C_seqno){
        return commentDao.selectComment(C_seqno);
    }

    public int parentdelete(Integer FK_A_seqno,Integer C_group_num){

        Map map = new HashMap();
        map.put("FK_A_seqno",FK_A_seqno);
        map.put("C_group_num",C_group_num);
        return commentDao.parentdelete(map);

    }

    public CommentCountDto countOne (Integer FK_A_seqno){
        return commentDao.countOne(FK_A_seqno);
    }


}
