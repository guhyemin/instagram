package com.bitstudy.app.dao;

import com.bitstudy.app.domain.FollowDto;

import java.util.List;

public interface FollowDao {
    int follower_count(String user_id);
    int following_count(String user_id);
    int deleteMyfollower(String user_id);
    int deleteMyfollowing(String user_id);
    List<String> followerList(String user_id);
    int inserFollow(FollowDto followDto);
    int deleteFollow(FollowDto followDto);
    FollowDto selectFollow(FollowDto followDto);
}
