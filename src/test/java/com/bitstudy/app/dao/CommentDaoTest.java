package com.bitstudy.app.dao;

import com.bitstudy.app.domain.CommentDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CommentDaoTest {
    @Autowired
    CommentDao commentDao;

    @Test
    public void comment_delete() {
        commentDao.comment_delete(1,"나상민");
    }

    @Test
    public void deleteMyComment() {
        commentDao.deleteMyComment("나상민");
    }

    @Test
    public void comment_insert() {
        CommentDto commentDto = new CommentDto("나상민", "안녕하세요", 0,1,14);
        commentDao.comment_insert(commentDto);
    }

    @Test
    public void comment_update() {
        CommentDto commentDto = new CommentDto("나상민", "반갑습니다.", 1,1,1);
        commentDto.setC_seqno(2);
        commentDao.comment_update(commentDto);
    }

    @Test
    public void comment_count() {
        Integer aaa = commentDao.comment_count(1);
        System.out.println("여기에요: "+ aaa);

    }

    @Test
    public void comment_user() {
        List<CommentDto> commentDto = commentDao.comment_user(1);
        System.out.println("여기에요: "+ commentDto);
    }

    @Test
    public void comment_c() {
//        List<CommentDto> commentDto = commentDao.map(1);
//        System.out.println("여기에요: "+ map);
    }

}