package com.boa.conlog.content.model.dto;

import jakarta.validation.constraints.NotBlank;

public class ContentDTO {
    private int no;

    @NotBlank(message = "컨텐츠 이름은 비어있을 수 없습니다.")
    private String contentsName;

    @NotBlank(message = "감독/제작자 이름은 비어있을 수 없습니다.")
    private String creatorName;
    private int year;
    private String url;
    private int categoryCode;

    public ContentDTO() {}

    public ContentDTO(int no, String contentsName, String creatorName, int year, String url, int categoryCode) {
        this.no = no;
        this.contentsName = contentsName;
        this.creatorName = creatorName;
        this.year = year;
        this.url = url;
        this.categoryCode = categoryCode;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getContentsName() {
        return contentsName;
    }

    public void setContentsName(String contentsName) {
        this.contentsName = contentsName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    @Override
    public String toString() {
        return "ContentDTO{" +
                "no=" + no +
                ", contentsName='" + contentsName + '\'' +
                ", creatorName='" + creatorName + '\'' +
                ", year=" + year +
                ", url='" + url + '\'' +
                ", categoryCode=" + categoryCode +
                '}';
    }
}
