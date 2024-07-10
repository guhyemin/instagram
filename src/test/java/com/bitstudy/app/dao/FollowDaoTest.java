package com.bitstudy.app.dao;

import com.bitstudy.app.domain.FollowDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class FollowDaoTest {
    @Autowired
    FollowDao followDao;


    @Test
    public void follower_count() {
        Integer aaa = followDao.follower_count("구혜민");
        System.out.println("여기에요: "+ aaa);

    }

    @Test
    public void following_count() {
        Integer aaa = followDao.following_count("나상민");
        System.out.println("여기에요: "+ aaa);
    }

    @Test
    public void deleteMyfollower() {
        followDao.deleteMyfollower("나상민");
    }

    @Test
    public void deleteMyfollowing() {
        followDao.deleteMyfollowing("구혜민");
    }

    @Test
    public void followerList() {
        List<String> aaa = followDao.followerList("나상민");
        System.out.println("여기에요: "+ aaa);
    }

    @Test
    public void inserFollow() {
        FollowDto followDto = new FollowDto("user1001","hyemin99");
        followDao.inserFollow(followDto);
    }
}