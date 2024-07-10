package com.bitstudy.app.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class HeartDaoTest {
    @Autowired
    HeartDao heartDao;


    @Test
    public void deleteMyLike() {
        heartDao.deleteMyLike("나상민");
    }

    @Test
    public void deleteLikeOne() {
        heartDao.deleteLikeOne(1,"나상민");

    }

    @Test
    public void insertMyLike() {

        heartDao.insertMyLike(11,"나상민");

    }
}