package com.rdd.pia.model;


//import org.springframework.data.annotation.Id;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author mic
 */
@Entity // JPA用的到
@Table(name = "user")
public class PiaUser implements Serializable {

    private static final long serialVersionUID = -9102021104172019999L;

    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    /**
     * MySQL自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
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

    /**
     * 日期+时间
     */
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    private Date updateTime;

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    /**
     * @param idUser 用户ID
     * @param userName 用户名
     * @param password 密码
     * @param alias 别称
     * @param eMail 邮箱
     * @param gender 性别
     * @param address 地址
     * @param bio 签名
     * @param updateTime 更新时间
     */
    public PiaUser(Integer idUser,String userName, String password,  String alias, String eMail, Gender gender, String address, String bio, java.sql.Timestamp updateTime) {
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

    public PiaUser() {
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
