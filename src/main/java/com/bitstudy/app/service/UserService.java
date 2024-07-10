package com.bitstudy.app.service;

import com.bitstudy.app.dao.CommentDao;
import com.bitstudy.app.dao.FollowDao;
import com.bitstudy.app.dao.HeartDao;
import com.bitstudy.app.dao.UserDao;
import com.bitstudy.app.domain.CommentDto;
import com.bitstudy.app.domain.UserDto;
import com.bitstudy.app.domain.UserImgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 할일: 서비스 계층 만들기
 *      컨트롤러에서 서비스로, 서비스에서 boardDao로 DTO를 이용해서 정보의 전달 가능
 *      (다 하고 인터페이스 만들기)
 */

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    HeartDao heartDao;

    @Autowired
    FollowDao followDao;

    @Autowired
    CommentDao commentDao;

    /* 회원정보 뽑아오기 */
    public UserDto getUser(String id) {
        return userDao.selectUser(id);
    }

    /* pw 찾기 전 확인 하는 방법 */
    public String findPw(String id, String name, String ph_num) {
        System.out.println("service" + id + name + ph_num);
        Map map = new HashMap<>();
        map.put("user_id", id);
        map.put("user_name", name);
        map.put("ph_num", ph_num);
        System.out.println("map" + map);

        return userDao.findPw(map);
    }

    public String findImg(String id) {
        return userDao.findImg(id);
    }

    /* 비번 변경 */
    public int updatePw(String user_id, String user_pw) {
        Map map = new HashMap<>();
        map.put("user_id", user_id);
        map.put("user_pw", user_pw);
        return userDao.updatePw(map);
    }

    /* 회원가입 */
    public int insertUser(UserDto userDto) {
        return userDao.insertUser(userDto);
    }

    /* 회원정보 수정 */
    public int updateUser(UserDto userDto) {

        userDao.updateUser(userDto);

        return userDao.updateUser(userDto);
    }


    /* 서치용 : 검색하기 밑에 나상민 뜨는거 */
    public  List<UserDto>  searchUser(String keyword) {
        return userDao.searchUser(keyword);
    }


    /* 회원탈퇴 */
    public int deleteUser(String id) {
        return userDao.deleteUser(id);
    }

    /* 회원 탈퇴시 나머지 */
    public int deleteMyLike(String id) {
        return heartDao.deleteMyLike(id);
    }


    public int deleteMyfollower(String id) {
        return followDao.deleteMyfollower(id);
    }

    /* <!--이건 내가 쓴 댓글 지우기--> */
    public int deleteMyComment(String id) {
        return commentDao.deleteMyComment(id);
    }

    public List<UserImgDto> user_img( ) {
        return userDao.user_img();
    }

    public String user_img_2(String userIMG) {
        return userDao.user_img_2(userIMG);
}

}




















