package com.rdd.pia.dao;

import com.rdd.pia.model.ArchiveReason;
import com.rdd.pia.model.PiaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author mic
 */
@Mapper
@Repository //添加此注解可以解决UserService中无法自动装配UserDao的问题
public interface UserDao {
    /** 获取用户信息
     * @param id  用户id
     * @return
     */
     PiaUser getUserById(@Param("id") Integer id);

    /** 获取用户信息
     * @param name 用户名
     * @return
     */
     PiaUser getUserByName(@Param("name") String name);

    /** 创建用户
     * @param user PiaUser
     * @return 成功 True
     */
     boolean createUser(@Param("user") PiaUser user);

    /** 修改用户信息
     * @param user PiaUser
     * @return 成功-True
     */
     boolean updateUser(@Param("user") PiaUser user);

    /** 删除用户信息
     * @param id 用户ID
     * @return 成功 True
     */
    boolean deleteUserById(@Param("id") Integer id);

    /**
     *  用户归档(逻辑删除，更新)
     * @param id 用户id
     * @param archiveReason 归档原因
     * @return 成功 True
     */
    boolean archiveUserById(@Param("id") Integer id, @Param("archiveReason") ArchiveReason archiveReason);
}
