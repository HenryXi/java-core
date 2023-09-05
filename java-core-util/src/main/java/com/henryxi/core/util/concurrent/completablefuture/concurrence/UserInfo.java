package com.henryxi.core.util.concurrent.completablefuture.concurrence;

public class UserInfo {
    private String companyName;
    private String address;
    private String familyInfo;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFamilyInfo() {
        return familyInfo;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", familyInfo='" + familyInfo + '\'' +
                '}';
    }

    public void setFamilyInfo(String familyInfo) {
        this.familyInfo = familyInfo;
    }
}
