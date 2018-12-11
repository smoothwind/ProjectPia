package com.rdd.pia.repositories;

import com.rdd.pia.model.Gender;
import com.rdd.pia.model.PiaUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


/**
 * @author mic
 */
@Repository
public interface PiaUserRepository extends CrudRepository<PiaUser,Long> {
    /** 返回用户
     * @param idUser
     * @return
     * Warning: 如果方法不写具体的SQl 在@Query注解里，那么请遵守jpa方法命名规则
     */
   @Query
   PiaUser findTop1ByIdUser(Integer idUser);

    /** 返回用户
     * @param userName
     * @return
     */
   @Query
   PiaUser findByUserName(String userName);


    /** 获取所有归档用户信息
     * @param userName
     * @return
     */
    @Query(value = "SELECT id_user,  user_name, alias,   password,  e_mail,   gender, address,    bio  from  user u where u.user_name = ?1",nativeQuery = true)
   List<PiaUser> findAllByUserName(String userName);



    /**
     * 更新信息
     * @param alias
     * @param password
     * @param eMail
     * @param gender
     * @param address
     * @param bio
     * @param updateTime
     * @param idUser
     * @return
     */
   @Modifying
   @Query(value = "UPDATE User u SET u.alias = ?1 ," +
           "u.password = ?2 , " +
           "u.e_mail= ?3, " +
           "u.gender = ?4, " +
           "u.address= ?5, " +
           "u.bio = ?6, " +
           "u.update_time= ?7 " +
           "WHERE u.id_user = ?8",nativeQuery = true)
    PiaUser updateUser(String alias, String password, String eMail, Gender gender,
                       String address, String bio, Date updateTime,Integer idUser);
}
