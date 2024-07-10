package com.bitstudy.app.domain;

public class UserImgDto {
    private String user_id;
    private String user_photo;

    public UserImgDto() {
    }

    public UserImgDto(String user_id, String user_photo) {
        this.user_id = user_id;
        this.user_photo = user_photo;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    @Override
    public String toString() {
        return "UserImgDto{" +
                "user_id='" + user_id + '\'' +
                ", user_photo='" + user_photo + '\'' +
                '}';
    }
}
