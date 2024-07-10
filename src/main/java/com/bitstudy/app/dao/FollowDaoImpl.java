package com.bitstudy.app.dao;

import com.bitstudy.app.domain.FollowDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class  FollowDaoImpl implements FollowDao {
    @Autowired
    SqlSession session;

    String namespace = "com.bitstudy.app.dao.FollowMapper.";

    @Override
    public int follower_count(String user_id) {
        return session.selectOne(namespace + "follower_count", user_id);
    }

    @Override
    public int following_count(String user_id) {
        return session.selectOne(namespace + "following_count", user_id);
    }

    @Override
    public int deleteMyfollower(String user_id) {
        return session.delete(namespace + "deleteMyfollower", user_id);
    }

    @Override
    public int deleteMyfollowing(String user_id) {
        return session.delete(namespace + "deleteMyfollowing", user_id);
    }

    @Override
    public List<String> followerList(String user_id) {
        return session.selectList(namespace + "followerList", user_id);
    }

    @Override
    public int inserFollow(FollowDto followDto) {
        return session.insert(namespace + "inserFollow", followDto);
    }

    @Override
    public int deleteFollow(FollowDto followDto) {
        return session.delete(namespace + "deleteFollow", followDto);
    }

    @Override
    public FollowDto selectFollow(FollowDto followDto) {
        return session.selectOne(namespace + "selectFollow", followDto);
    }
}
