package com.dna.entity;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by peng on 18/3/9.
 */
public class Puppy implements java.io.Serializable {
    private String id;
    private String name;
    private String breed;
    private String breeder;
    private int gender;  //0-母；1-公；2-已阉割
    private LocalDateTime birthday;
    private String color;
    private String certiNo;
    private List<String> snp;
    private String fatherId;
    private String motherId;
    private String ownerName;
    private String ownerCertiType;
    private String ownerCertiNo;
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBreeder() {
        return breeder;
    }

    public void setBreeder(String breeder) {
        this.breeder = breeder;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCertiNo() {
        return certiNo;
    }

    public void setCertiNo(String certiNo) {
        this.certiNo = certiNo;
    }

    public List<String> getSnp() {
        return snp;
    }

    public void setSnp(List<String> snp) {
        this.snp = snp;
    }

    public String getFatherId() {
        return fatherId;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

    public String getMotherId() {
        return motherId;
    }

    public void setMotherId(String motherId) {
        this.motherId = motherId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerCertiType() {
        return ownerCertiType;
    }

    public void setOwnerCertiType(String ownerCertiType) {
        this.ownerCertiType = ownerCertiType;
    }

    public String getOwnerCertiNo() {
        return ownerCertiNo;
    }

    public void setOwnerCertiNo(String ownerCertiNo) {
        this.ownerCertiNo = ownerCertiNo;
    }
}
