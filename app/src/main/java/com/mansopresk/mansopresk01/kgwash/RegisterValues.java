package com.mansopresk.mansopresk01.kgwash;

/**
 * Created by Mansopresk13 on 9/18/2017.
 */

public class RegisterValues
{
    String name;
    String mobile;
    String alternatenum;
    String emailregister;
    String address;
    String landmark;


    public RegisterValues()
    {

    }

    public RegisterValues(String name, String mobile, String alternatenum, String emailregister, String address, String landmark) {
        this.name = name;
        this.mobile = mobile;
        this.alternatenum = alternatenum;
        this.emailregister = emailregister;
        this.address = address;
        this.landmark = landmark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAlternatenum() {
        return alternatenum;
    }

    public void setAlternatenum(String alternatenum) {
        this.alternatenum = alternatenum;
    }

    public String getEmailregister() {
        return emailregister;
    }

    public void setEmailregister(String emailregister) {
        this.emailregister = emailregister;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }
}
