package com.boa.conlog.review.model.dto;

public class MemberDTO {

    private int memberNo;
    private String nickname;
    private String memberName;

    public MemberDTO() {
    }

    public MemberDTO(int memberNo, String nickname, String memberName) {
        this.memberNo = memberNo;
        this.nickname = nickname;
        this.memberName = memberName;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
            "memberNo=" + memberNo +
            ", nickname='" + nickname + '\'' +
            ", memberName='" + memberName + '\'' +
            '}';
    }
}

