package com.bitstudy.app.domain;

public class HeartDto {
    private Integer H_seqno = null;
    private Integer FK_A_seqno;
    private String H_writer;
    private Integer H_count;

    public HeartDto() {
    }

    public HeartDto(Integer FK_A_seqno, String h_writer) {
        this.FK_A_seqno = FK_A_seqno;
        H_writer = h_writer;
    }

    public Integer getH_seqno() {

        return H_seqno;
    }

    public void setH_seqno(Integer h_seqno) {
        H_seqno = h_seqno;
    }

    public Integer getFK_A_seqno() {
        return FK_A_seqno;
    }

    public void setFK_A_seqno(Integer FK_A_seqno) {
        this.FK_A_seqno = FK_A_seqno;
    }

    public String getH_writer() {
        return H_writer;
    }

    public void setH_writer(String h_writer) {
        H_writer = h_writer;
    }

    public Integer getH_count() {
        return H_count;
    }

    public void setH_count(Integer h_count) {
        H_count = h_count;
    }

    @Override
    public String toString() {
        return "HeartDto{" +
                "H_seqno=" + H_seqno +
                ", FK_A_seqno=" + FK_A_seqno +
                ", H_writer='" + H_writer + '\'' +
                ", H_count=" + H_count +
                '}';
    }
}

