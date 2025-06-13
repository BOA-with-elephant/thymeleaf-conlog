package com.boa.conlog.review.model.dto;

import java.sql.Date;

public class ReviewDTO {

    private int reviewNo;
    private int reviewScore;
    private String reviewContent;
    private Date reviewDate;
    private MemberDTO member;

    public ReviewDTO() {
    }

    public ReviewDTO(int reviewNo, int reviewScore, String reviewContent, Date reviewDate,
        MemberDTO member) {
        this.reviewNo = reviewNo;
        this.reviewScore = reviewScore;
        this.reviewContent = reviewContent;
        this.reviewDate = reviewDate;
        this.member = member;
    }

    public int getReviewNo() {
        return reviewNo;
    }

    public void setReviewNo(int reviewNo) {
        this.reviewNo = reviewNo;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
            "reviewNo=" + reviewNo +
            ", reviewScore=" + reviewScore +
            ", reviewContent='" + reviewContent + '\'' +
            ", reviewDate=" + reviewDate +
            ", member=" + member +
            '}';
    }
}
