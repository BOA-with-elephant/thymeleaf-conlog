package com.boa.conlog.content.model.dto;

public class ContentAndCategoryDTO {

    private int no;
    private String contentsName;
    private String creatorName;
    private int year;
    private String url;
    private CategoryDTO category;

    public ContentAndCategoryDTO() {}

    public ContentAndCategoryDTO(int no, String contentsName, String creatorName, int year, String url, CategoryDTO category) {
        this.no = no;
        this.contentsName = contentsName;
        this.creatorName = creatorName;
        this.year = year;
        this.url = url;
        this.category = category;
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

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
}
