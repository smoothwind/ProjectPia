package com.rdd.pia.repositories;

import com.rdd.pia.model.PiaUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author mic
 */
@Repository
public interface UserJpaRepository extends CrudRepository<PiaUser,Long> {
    /** 返回用户
     * @param idUser
     * @return
     */
   @Query
   PiaUser findById(Integer idUser);

    /** 返回用户
     * @param username
     * @return
     */
   @Query
   PiaUser findByUserName(String username);


    /** 获取所有归档用户信息
     * @param username
     * @return
     */
    @Query("SELECT id_user,  user_name, alias,   password,  e_mail,   gender, address,    bio  from  user u where u.user_name = ?1")
   List<PiaUser> findAllByUserName(String username);


    /** 更新 用户
     * @param piaUser
     * @return
     */
   @Modifying
   @Query("update user u set u.alias = #{#alias}," +
           "u.password = #{#password}, " +
           "u.e_mail=#{#eMail}," +
           "u.gender = #{#gender}," +
           "u.address=#{#address}," +
           "u.bio = #{#bio},"+
           "u.update_time= #{#updateTime} " +
           "where u.id_user = #{#idUser}")
    PiaUser updateUser(PiaUser piaUser);
}
