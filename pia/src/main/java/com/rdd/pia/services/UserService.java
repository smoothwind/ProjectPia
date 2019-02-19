package com.rdd.pia.services;

import com.rdd.pia.model.ArchiveReason;
import com.rdd.pia.model.ArchivedPiaUser;
import com.rdd.pia.model.PiaUser;
import com.rdd.pia.repositories.ArchivePiaUserJapRepository;
import com.rdd.pia.repositories.PiaUserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author mic
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserService {
    private final static Log log = LogFactory.getLog(UserService.class);

    @Autowired
    private PiaUserRepository piaUserRepository;

    @Autowired
    private ArchivePiaUserJapRepository archiveUserJpaRepository;

    @CachePut(cacheNames = "user",key = "#id")
    public PiaUser getUserById(Integer id){
        if (log.isTraceEnabled()){
            log.trace("getUserById():"+"获取用户");
        }
        return piaUserRepository.findTop1ByIdUser(id);
    }

    @Cacheable(cacheNames = "user")
    public PiaUser getUserByName(String name) {
        if (log.isTraceEnabled()){
            log.trace("getUserByName():" + "获取用户");
        }
        return piaUserRepository.findByUserName(name);
    }

    @Cacheable(cacheNames = "user",key = "#piaUser")
    public boolean updateUser(PiaUser piaUser){
        if (log.isTraceEnabled()){
            log.trace("updateUser():"+"更新用户信息");
        }
        PiaUser tmp = piaUserRepository.findTop1ByIdUser(piaUser.getIdUser());
        if(piaUser.equals(tmp)){
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

    @CachePut(cacheNames = "user",key = "#piaUser.idUser")
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
    @CacheEvict(cacheNames = "user")
    public boolean deleteUserById(Integer id) {
        return false;
    }

    /****
     * 归档用户信息
     * @param id
     * @return
     */
    public  boolean archiveUserById(Integer id,ArchiveReason reason) {
        PiaUser user = piaUserRepository.findTop1ByIdUser(id);
        ArchivedPiaUser archivedPiaUser = new ArchivedPiaUser(user);
        archivedPiaUser.setArchiveReason(reason);
        if (archivedPiaUser != null) {
            archiveUserJpaRepository.save(archivedPiaUser);
            return true;
        }
        return false;
    }
}
