package com.example.contacts;

import java.io.Serializable;
import java.util.Date;

public class Contact implements Serializable {
    private String mFullname;
    private String mCompany;
    private String mTitle;
    private String mMobile;
    private String mEmail;
    private String mCreated;
    private int mId;

    public Contact(){}

    public Contact(int mId, String mFullname, String mCompany, String mTitle, String mMobile, String mEmail){
        this.mId = mId;
        this.mFullname = mFullname;
        this.mCompany = mCompany;
        this.mTitle = mTitle;
        this.mMobile = mMobile;
        this.mEmail = mEmail;
        this.mCreated = mCreated;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmFullname() {
        return mFullname;
    }

    public void setmFullname(String mFullname) {
        this.mFullname = mFullname;
    }

    public String getmCompany() {
        return mCompany;
    }

    public void setmCompany(String mCompany) {
        this.mCompany = mCompany;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmMobile() {
        return mMobile;
    }

    public void setmMobile(String mMobile) {
        this.mMobile = mMobile;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmCreated() {
        return mCreated;
    }

    public void setmCreated(String mCreated) {
        this.mCreated = mCreated;
    }

}