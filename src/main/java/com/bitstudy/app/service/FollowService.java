package com.bitstudy.app.service;


import com.bitstudy.app.dao.FollowDao;
import com.bitstudy.app.domain.FollowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {
    @Autowired
    FollowDao followDao;

    public int follower_count(String user_id){
        return followDao.follower_count(user_id);
    };


    public int following_count(String user_id){
        return followDao.following_count(user_id);
    };


    public int deleteMyfollower(String user_id){
        return followDao.deleteMyfollower(user_id);
    };

    public int deleteMyfollowing(String user_id){
        return followDao.deleteMyfollowing(user_id);
    };

    public List<String> followerList(String user_id){
        return followDao.followerList(user_id);
    };


    public int inserFollow(FollowDto followDto){
        return followDao.inserFollow(followDto);
    };

    public int deleteFollow(FollowDto followDto){
        return followDao.deleteFollow(followDto);
    }

    public FollowDto selectFollow(FollowDto followDto){
        return followDao.selectFollow(followDto);
    };



}
