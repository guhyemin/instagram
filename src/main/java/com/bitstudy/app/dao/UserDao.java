package com.bitstudy.app.dao;

import com.bitstudy.app.domain.UserDto;
import com.bitstudy.app.domain.UserImgDto;

import java.util.List;
import java.util.Map;

public interface UserDao {
    // 사용자 정보 뽑아내는것
    UserDto selectUser(String user_id);

    // 로그인용 (로그인+자동로그인)
    UserDto selectLogin(Map map);

    // 비번찾기 전 확인하는 과정
    String findPw(Map map);

    String findImg(String id);

    // 비번 변경
    int updatePw(Map map);

    // 회원가입
    int insertUser(UserDto userDto);

    // 마이페이지 정보 업데이트
    int updateUser(UserDto userDto);

    // 회원탈퇴
    int deleteUser(String user_id);


    // 아이디 검색용(검색창에 아이디 검색하여 결과 나오는 거)
    // ?????이거 맞음??? keyword 들어가는 거 맞음??????
    List<UserDto> searchUser(String keyword);

    List<UserImgDto> user_img( );

    String user_img_2(String userIMG);
}
