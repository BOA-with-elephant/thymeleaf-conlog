package com.boa.conlog.member.model.dto;

import com.boa.conlog.member.model.service.MemberService;

public class MemberDTO {
    private int memberNo;
    private String memberName;
    private String nickname;
    private String id;
    private String pw;
    private String email;
    private String phone;

    public MemberDTO(){}

    public MemberDTO(int memberNo, String memberName, String nickname, String id, String pw, String email, String phone) {
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.nickname = nickname;
        this.id = id;
        this.pw = pw;
        this.email = email;
        this.phone = phone;
    }


    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberNo=" + memberNo +
                ", memberName='" + memberName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
    //9) MemberDTO 완성. 이제 email-member-list.html.html 만들고 채우러 간다.
}