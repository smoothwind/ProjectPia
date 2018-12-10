package com.rdd.pia.services;

import com.rdd.pia.model.ArchiveReason;
import com.rdd.pia.model.ArchivedPiaUser;
import com.rdd.pia.model.PiaUser;

import com.rdd.pia.repositories.ArchivePiaUserJapRepository;
import com.rdd.pia.repositories.PiaUserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.boot.autoconfigure.data.jpa.*;
/**
 * @author mic
 */
@Service
public class UserService {
    private final static Log log = LogFactory.getLog(UserService.class);

    @Autowired
    private PiaUserRepository piaUserRepository;

    @Autowired
    private ArchivePiaUserJapRepository archiveUserJpaRepository;

    public PiaUser getUserById(Integer id){
        if (log.isTraceEnabled()){
            log.trace("getUserById():"+"获取用户");
        }
        return piaUserRepository.findByIdUser(id);
    }

    public PiaUser getUserByName(String name) {
        if (log.isTraceEnabled()){
            log.trace("getUserByName():"+"获取用户");
        }
        return piaUserRepository.findByUserName(name);
    }

    public boolean updateUser(PiaUser piaUser){
        if (log.isTraceEnabled()){
            log.trace("updateUser():"+"更新用户信息");
        }
        PiaUser tmp = piaUserRepository.findByIdUser(piaUser.getIdUser());
        if(piaUser.equals(tmp) && piaUser != null && tmp != null){
            archiveUserJpaRepository.save(new ArchivedPiaUser(tmp));
            piaUserRepository.updateUser(piaUser.getAlias(),
                    piaUser.getPassword(),
                    piaUser.geteMail(),
                    piaUser.getGender(),
                    piaUser.getAddress(),
                    piaUser.getBio(),
                    piaUser.getUpdateTime(),
                    piaUser.getIdUser());
            return true;
        }
        return false;
    }

    public boolean createUser(PiaUser piaUser) {
        if (log.isTraceEnabled()){
            log.trace("getUserByName():"+"获取用户");
        }
        try {
            piaUserRepository.save(piaUser);}
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
        PiaUser user = piaUserRepository.findByIdUser(id);
        ArchivedPiaUser archivedPiaUser = new ArchivedPiaUser(user);
        archivedPiaUser.setArchiveReason(reason);
        if (archivedPiaUser != null) {
            archiveUserJpaRepository.save(archivedPiaUser);
            return true;
        }
        return false;
    }
}
