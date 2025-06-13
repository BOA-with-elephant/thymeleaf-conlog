package com.boa.conlog.ott.model.dto;

public class OttDTO {

    private int ottNo;
    private String ottName;

    public OttDTO(){}

    public OttDTO(int ottNo, String ottName) {
        this.ottNo = ottNo;
        this.ottName = ottName;
    }

    public int getOttNo() {
        return ottNo;
    }

    public void setOttNo(int ottNo) {
        this.ottNo = ottNo;
    }

    public String getOttName() {
        return ottName;
    }

    public void setOttName(String ottName) {
        this.ottName = ottName;
    }

    @Override
    public String toString() {
        return "OttDTO{" +
                "ottNo=" + ottNo +
                ", ottName='" + ottName + '\'' +
                '}';
    }
}
