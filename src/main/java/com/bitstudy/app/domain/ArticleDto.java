package com.bitstudy.app.domain;


import java.util.Date;

public class ArticleDto {
    private Integer A_seqno = null;
    private String A_writer;
    private String A_contents;
    private String A_img;
    private Date A_reg_date;
    private String A_userPhoto;
    private Integer A_Heart;
    private Integer A_comment;
    private String H_condition;
    private String User_photo;

    public ArticleDto() {
    }



    public ArticleDto(String a_writer, String a_contents, String a_img, String user_photo) {
        A_writer = a_writer;
        A_contents = a_contents;
        A_img = a_img;
        User_photo = user_photo;
    }

    public String getUser_photo() {
        return User_photo;
    }

    public void setUser_photo(String user_photo) {
        this.User_photo = user_photo;
    }

    public Integer getA_seqno() {
        return A_seqno;
    }

    public void setA_seqno(Integer a_seqno) {
        A_seqno = a_seqno;
    }

    public String getA_writer() {
        return A_writer;
    }

    public void setA_writer(String a_writer) {
        A_writer = a_writer;
    }

    public String getA_contents() {
        return A_contents;
    }

    public void setA_contents(String a_contents) {
        A_contents = a_contents;
    }

    public String getA_img() {
        return A_img;
    }

    public void setA_img(String a_img) {
        A_img = a_img;
    }

    public Date getA_reg_date() {
        return A_reg_date;
    }

    public void setA_reg_date(Date a_reg_date) {
        A_reg_date = a_reg_date;
    }

    public String getA_userPhoto() {
        return A_userPhoto;
    }

    public void setA_userPhoto(String a_userPhoto) {
        A_userPhoto = a_userPhoto;
    }

    public Integer getA_Heart() {
        return A_Heart;
    }

    public void setA_Heart(Integer a_Heart) {
        A_Heart = a_Heart;
    }

    public Integer getA_comment() {
        return A_comment;
    }

    public void setA_comment(Integer a_comment) {
        A_comment = a_comment;
    }

    public String getH_condition() {
        return H_condition;
    }

    public void setH_condition(String h_condition) {
        H_condition = h_condition;
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "A_seqno=" + A_seqno +
                ", A_writer='" + A_writer + '\'' +
                ", A_contents='" + A_contents + '\'' +
                ", A_img='" + A_img + '\'' +
                ", A_reg_date=" + A_reg_date +
                ", A_userPhoto='" + A_userPhoto + '\'' +
                ", A_Heart=" + A_Heart +
                ", A_comment=" + A_comment +
                ", H_condition='" + H_condition + '\'' +
                '}';
    }
}
