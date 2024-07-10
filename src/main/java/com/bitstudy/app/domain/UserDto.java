package com.bitstudy.app.domain;


public class UserDto {
    private Integer U_seqno = null;
    private String user_id;
    private String user_pw;
    private String user_name;
    private String ph_num;
    private Integer gender;
    private String user_desc;
    private String user_photo;


    public UserDto() {
    }


    public UserDto(String user_id, String user_pw, String user_name, String ph_num, Integer gender) {
        this.user_id = user_id;
        this.user_pw = user_pw;
        this.user_name = user_name;
        this.ph_num = ph_num;
        this.gender = gender;
    }

    public UserDto(String user_id, String user_name, String ph_num, Integer gender, String user_desc, String user_photo) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.ph_num = ph_num;
        this.gender = gender;
        this.user_desc = user_desc;
        this.user_photo = user_photo;
    }


    public Integer getU_seqno() {
        return U_seqno;
    }

    public void setU_seqno(Integer u_seqno) {
        U_seqno = u_seqno;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPh_num() {
        return ph_num;
    }

    public void setPh_num(String ph_num) {
        this.ph_num = ph_num;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getUser_desc() {
        return user_desc;
    }

    public void setUser_desc(String user_desc) {
        this.user_desc = user_desc;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "U_seqno=" + U_seqno +
                ", user_id='" + user_id + '\'' +
                ", user_pw='" + user_pw + '\'' +
                ", user_name='" + user_name + '\'' +
                ", ph_num='" + ph_num + '\'' +
                ", gender=" + gender +
                ", user_desc='" + user_desc + '\'' +
                ", user_photo='" + user_photo + '\'' +
                '}';
    }


}

