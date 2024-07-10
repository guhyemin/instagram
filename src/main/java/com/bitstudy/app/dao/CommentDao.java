package com.bitstudy.app.dao;

import com.bitstudy.app.domain.CommentCountDto;
import com.bitstudy.app.domain.CommentDto;

import java.util.List;
import java.util.Map;

public interface CommentDao {
    int comment_delete (Integer C_seqno, String C_writer);
    int deleteMyComment(String C_write);
    int comment_insert(CommentDto commentDto);
    int comment_update(CommentDto commentDto);
    int comment_count(Integer FK_A_seqno);
    List<CommentDto> comment_user(Integer FK_A_seqno);
    List<CommentDto> comment_c(Map map);
    int MyArticleComment(String user_id);

    List<CommentCountDto> commentCount();

    Integer getGroup(Integer FK_A_seqno);

    CommentDto selectComment(Integer C_seqno);

    int parentdelete(Map map);

    CommentCountDto countOne(Integer FK_A_seqno);
}
