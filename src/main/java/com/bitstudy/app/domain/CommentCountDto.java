package com.bitstudy.app.domain;

public class CommentCountDto {
    private Integer C_count;
    private Integer FK_A_seqno;

    public CommentCountDto() {
    }

    public CommentCountDto(Integer c_count, Integer FK_A_seqno) {
        C_count = c_count;
        this.FK_A_seqno = FK_A_seqno;
    }

    public Integer getC_count() {
        return C_count;
    }

    public void setC_count(Integer c_count) {
        C_count = c_count;
    }

    public Integer getFK_A_seqno() {
        return FK_A_seqno;
    }

    public void setFK_A_seqno(Integer FK_A_seqno) {
        this.FK_A_seqno = FK_A_seqno;
    }

    @Override
    public String toString() {
        return "CommentCountDto{" +
                "C_count=" + C_count +
                ", FK_A_seqno=" + FK_A_seqno +
                '}';
    }
}
