package com.rdd.pia.model;



//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

/**
 * @author mic
 */
@Entity //JPA用的到
@Table(name = "user_archive",schema = "app")
public class ArchivedPiaUser {

    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;

    @Id
    @Column(name="id_user")
    private Integer idUser;

    @Column(name = "alias")
    private String alias;
    @Column(name = "e_mail")
    private String eMail;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "address")
    private String address;
    @Column(name = "bio")
    private String bio;


    @Temporal(value = TemporalType.TIMESTAMP)//日期+时间
    @Column(name = "update_time")
    private Date updateTime;

    @Temporal(value = TemporalType.TIMESTAMP)//日期+时间
    @Column(name = "archive_time")
    private  Date archiveTime;


    @Enumerated(EnumType.ORDINAL)
    @Column(name = "archive_reason")
    private ArchiveReason archiveReason;


    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    /**
     * @param piaUser
     */
    public ArchivedPiaUser(PiaUser piaUser) {
        this.userName = piaUser.getUserName();
        this.password = piaUser.getPassword();
        this.alias = piaUser.getAlias();
        this.eMail = piaUser.geteMail();
        this.gender = piaUser.getGender();
        this.address = piaUser.getAddress();
        this.bio = piaUser.getBio();
        this.updateTime = piaUser.getUpdateTime();
        this.archiveTime = new Date();
    }

    public Date getArchiveTime() {
        return archiveTime;
    }

    public void setArchiveTime(Date archiveTime) {
        this.archiveTime = archiveTime;
    }

    public ArchiveReason getArchiveReason() {
        return archiveReason;
    }

    public void setArchiveReason(ArchiveReason archiveReason) {
        this.archiveReason = archiveReason;
    }

    public ArchivedPiaUser(String userName, String password, String alias, String eMail, Gender gender, String address, String bio, Date updateTime) {
        this.userName = userName;
        this.password = password;
        this.alias = alias;
        this.eMail = eMail;
        this.gender = gender;
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
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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
