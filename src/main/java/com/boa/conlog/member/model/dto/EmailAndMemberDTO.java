package com.boa.conlog.member.model.dto;

public class EmailAndMemberDTO {
    private String email;
    private int memberNo;
    private String memberName;
    private String nickname;
    private String id;
    private String pw;
    private String phone;

    public EmailAndMemberDTO() {
    }

    public EmailAndMemberDTO(String email, int memberNo, String memberName, String nickname, String id, String pw, String phone) {
        this.email = email;
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.nickname = nickname;
        this.id = id;
        this.pw = pw;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "EmailAndMemberDTO{" +
                "email='" + email + '\'' +
                ", memberNo=" + memberNo +
                ", memberName='" + memberName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}