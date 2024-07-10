package com.bitstudy.app.domain;

public class FollowDto {
    private Integer F_seqno = null;
    private String follower_id;
    private String following_id;


    public FollowDto() {
    }

    public FollowDto(String follower_id, String following_id) {
        this.follower_id = follower_id;
        this.following_id = following_id;
    }

    public Integer getF_seqno() {
        return F_seqno;
    }

    public void setF_seqno(Integer f_seqno) {
        F_seqno = f_seqno;
    }

    public String getFollower_id() {
        return follower_id;
    }

    public void setFollower_id(String follower_id) {
        this.follower_id = follower_id;
    }

    public String getFollowing_id() {
        return following_id;
    }

    public void setFollowing_id(String following_id) {
        this.following_id = following_id;
    }

    @Override
    public String toString() {
        return "FollowDto{" +
                "F_seqno=" + F_seqno +
                ", follower_id='" + follower_id + '\'' +
                ", following_id='" + following_id + '\'' +
                '}';
    }
}
