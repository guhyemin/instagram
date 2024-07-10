package com.bitstudy.app.dao;

import com.bitstudy.app.domain.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserDaoTest {
    @Autowired
    UserDao userDao;

    @Test
    public void selectUser() {
        UserDto userDto =userDao.selectUser("나상민");
        System.out.println("여기에요: " + userDto);
    }

    @Test
    public void selectLogin() {
        Map map=new HashMap<>();
        map.put("user_pw","5678");
        map.put("user_id","나상민");

        UserDto userDto =userDao.selectLogin(map);
        System.out.println("여기에요: " + userDto);

    }

    @Test
    public void findPw() {
        Map map=new HashMap<>();
        map.put("ph_num",12345);
        map.put("user_id","나상민");
        map.put("user_name","나상민");
        String aaa = userDao.findPw(map);
        System.out.println(aaa);

    }

    @Test
    public void updatePw() {
        Map map=new HashMap<>();
        map.put("user_pw","5678");
        map.put("user_id","나상민");
        userDao.updatePw(map);

    }

    @Test
    public void insertUser() {
        UserDto userDto = new UserDto("dayoung","1234","다영","01072556864",1);
        UserDto userDto1 = new UserDto("heymin","1234","혜민","01072556864",1);
        UserDto userDto2 = new UserDto("sungkm","1234","성경모","01072556864",1);


    userDao.insertUser(userDto);
    userDao.insertUser(userDto1);
    userDao.insertUser(userDto2);
    }

    @Test
    public void updateUser() {
        UserDto userDto = new UserDto("나상민","1234","나상민","12345",1);
        userDao.updateUser(userDto);
    }

    @Test
    public void deleteUser() {
        userDao.deleteUser("나상민");
    }

    @Test
    public void searchUser() {

        List<UserDto> userDto = userDao.searchUser("s");
        System.out.println(userDto);
    }
}