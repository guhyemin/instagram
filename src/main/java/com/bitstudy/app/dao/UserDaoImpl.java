package com.bitstudy.app.dao;

import com.bitstudy.app.domain.UserDto;
import com.bitstudy.app.domain.UserImgDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    SqlSession Session;

    String namespace = "com.bitstudy.app.dao.UserMapper.";



    @Override
    public UserDto selectUser(String user_id) {
        return Session.selectOne(namespace + "selectUser", user_id);
    }

    @Override
    public UserDto selectLogin(Map map) {
        return Session.selectOne(namespace+"selectLogin",map);
    }

    @Override
    public String findPw(Map map) {
        return Session.selectOne(namespace + "findPw", map);}

    @Override
    public String findImg(String id) {
        return Session.selectOne(namespace + "findImg", id);}


    @Override
    public int updatePw(Map map) {
        return Session.update(namespace + "updatePw", map); }

    @Override
    public int insertUser(UserDto userDto) {
        return Session.insert(namespace + "insertUser", userDto); }

    @Override
    public int updateUser(UserDto userDto) {

        return Session.update(namespace + "updateUser", userDto);
    }

    @Override
    public int deleteUser(String user_id) {
        return Session.delete(namespace + "deleteUser", user_id);
    }


    @Override
    public List<UserDto> searchUser(String keyword) {
        return Session.selectList(namespace + "searchUser", keyword);
    }

    @Override
    public List<UserImgDto> user_img( ) {
        return  Session.selectList(namespace + "user_img");
    }

    @Override
    public String user_img_2(String userIMG) {
        return  Session.selectOne(namespace + "user_img_2", userIMG);
    }
}
