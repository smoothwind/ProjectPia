package com.rdd.pia.services;

import com.rdd.pia.dao.UserDao;
import com.rdd.pia.model.ArchiveReason;
import com.rdd.pia.model.ArchivedPiaUser;
import com.rdd.pia.model.PiaUser;

import com.rdd.pia.repositories.ArchiveUserJpaRepository;
import com.rdd.pia.repositories.UserJpaRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @author mic
 */
@Service

public class UserService {
    private final static Log log = LogFactory.getLog(UserService.class);

    @Autowired
    UserJpaRepository userJpaRepository;
    @Autowired
    ArchiveUserJpaRepository archiveUserJpaRepository;

    public PiaUser getUserById(int id){
        if (log.isTraceEnabled()){
            log.trace("getUserById():"+"获取用户");
        }
        return userJpaRepository.findById(id);
    }

    public PiaUser getUserByName(String name) {
        if (log.isTraceEnabled()){
            log.trace("getUserByName():"+"获取用户");
        }
        return userJpaRepository.findByUserName(name);
    }

    public boolean createUser(PiaUser piaUser) {
        if (log.isTraceEnabled()){
            log.trace("getUserByName():"+"获取用户");
        }
        try {userJpaRepository.save(piaUser);}
        catch(Exception e){
            log.trace(e.getMessage());
            return false;
        }

        return  true;
    }

    public boolean deleteUserById(Integer id) {
        return false;
    }


    /****
     * 归档用户信息
     * @param id
     * @return
     */
    public  boolean archiveUserById(Integer id,ArchiveReason reason) {
        PiaUser user = userJpaRepository.findById(id);
        ArchivedPiaUser archivedPiaUser = new ArchivedPiaUser(user);
        archivedPiaUser.setArchiveReason(reason);
        if (archivedPiaUser != null) {
            archiveUserJpaRepository.save(archivedPiaUser);
            return true;
        }
        return false;
    }
}
