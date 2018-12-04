package com.rdd.pia.services;

import com.rdd.pia.dao.UserDao;
import com.rdd.pia.model.ArchiveReason;
import com.rdd.pia.model.PiaUser;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author mic
 */
@Service

public class UserService {
    private final static Log log = LogFactory.getLog(UserService.class);

    @Autowired
    private UserDao userDao;

    public PiaUser getUserById(int id){
        return userDao.getUserById(id);
    }

    public  PiaUser getUserByName(String name){
        return  userDao.getUserByName(name);
    }


    /** 新建用户
     * @param user PiaUser
     * @return  成功 True
     */
    public boolean createUser(PiaUser user){
        return userDao.createUser(user);
    }

    /** 修改用户信息  todo: 需要加入 旧密码验证/查询用户是否存在 等功能
     * @param user PiaUser
     * @return 成功 True
     */
    public boolean updateUser(PiaUser user) {
        if (log.isTraceEnabled()){
            log.trace("updateUser():更新用户信息");
        }
        // 先归档
        if (userDao.archiveUserById(user.getIdUser(), ArchiveReason.UPDATE_PROFILE)) {
            return  userDao.updateUser(user);
        }

        return false;
    }

    public boolean deleteUserById(Integer id){
        if (log.isTraceEnabled()){
            log.trace("deleteUserById():删除用户信息");
        }
        // 先归档
        if (userDao.archiveUserById(id, ArchiveReason.DELETE)) {
            return  userDao.deleteUserById(id);
        }

        return false;
    }

}
