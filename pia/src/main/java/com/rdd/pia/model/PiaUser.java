package com.rdd.pia.model;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

/**
 * @author mic
 */
public class PiaUser {

    private String userName;
    private String password;

    private Integer idUser;
    private String alias;
    private String eMail;
    private Integer gender;
    private String address;
    private String bio;
    private Date updateTime;

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public PiaUser(Integer idUser,String userName, String password,  String alias, String eMail, Integer gender, String address, String bio, java.sql.Timestamp updateTime) {
        this.userName = userName;
        this.password = password;
        this.idUser = idUser;
        this.alias = alias;
        this.eMail = eMail;
        this.gender =  gender;
        this.address = address;
        this.bio = bio;
        this.updateTime = updateTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
