package com.bitstudy.app.domain;

import java.util.Date;

public class CommentDto {
    private Integer C_seqno = null;
    private Integer FK_A_seqno;
    private String C_writer;
    private String C_txt;
    private Date C_reg_date;
    private Integer C_class;
    private Integer C_group_num;
    private Integer C_order;
    private String userPhoto;

    public CommentDto() {
    }

    public CommentDto(String c_writer, String c_txt, Integer c_class, Integer c_group_num, Integer FK_A_seqno) {
        C_writer = c_writer;
        C_txt = c_txt;
        C_class = c_class;
        C_group_num = c_group_num;
        this.FK_A_seqno = FK_A_seqno;
    }


    public Integer getC_seqno() {
        return C_seqno;
    }

    public void setC_seqno(Integer c_seqno) {
        C_seqno = c_seqno;
    }

    public Integer getFK_A_seqno() {
        return FK_A_seqno;
    }

    public void setFK_A_seqno(Integer FK_A_seqno) {
        this.FK_A_seqno = FK_A_seqno;
    }

    public String getC_writer() {
        return C_writer;
    }

    public void setC_writer(String c_writer) {
        C_writer = c_writer;
    }

    public String getC_txt() {
        return C_txt;
    }

    public void setC_txt(String c_txt) {
        C_txt = c_txt;
    }

    public Date getC_reg_date() {
        return C_reg_date;
    }

    public void setC_reg_date(Date c_reg_date) {
        C_reg_date = c_reg_date;
    }

    public Integer getC_class() {
        return C_class;
    }

    public void setC_class(Integer c_class) {
        C_class = c_class;
    }

    public Integer getC_group_num() {
        return C_group_num;
    }

    public void setC_group_num(Integer c_group_num) {
        C_group_num = c_group_num;
    }

    public Integer getC_order() {
        return C_order;
    }

    public void setC_order(Integer c_order) {
        C_order = c_order;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "C_seqno=" + C_seqno +
                ", FK_A_seqno=" + FK_A_seqno +
                ", C_writer='" + C_writer + '\'' +
                ", C_txt='" + C_txt + '\'' +
                ", C_reg_date=" + C_reg_date +
                ", C_class=" + C_class +
                ", C_group_num=" + C_group_num +
                ", C_order=" + C_order +
                ", userPhoto='" + userPhoto + '\'' +
                '}';
    }
}

