package com.rdd.pia.repositories;

import com.rdd.pia.model.PiaUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * @author mic
 */
public interface UserJpaRepository extends Repository {
    /** 返回用户
     * @param id
     * @return
     */
   @Query("select u from user u where u.id_user = ?1")
   PiaUser findById(Integer id);

    /** 返回用户
     * @param name
     * @return
     */
   @Query("select u from user u where u.user_name = ?1")
   PiaUser findByUserName(String name);

   @Modifying
   @Query("update user u set u. where u.id_user = ")
   PiaUser updateUser(PiaUser piaUser);
}
