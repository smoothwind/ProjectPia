package com.rdd.pia.controller;

import com.rdd.pia.model.PiaUser;
import com.rdd.pia.services.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mic
 */
@RestController
@RequestMapping("Account")
public class AccountController {

    public final static Log log = LogFactory.getLog(AccountController.class);
    @Autowired
    private UserService userService;

    @GetMapping("user/{userId}")
    public PiaUser getUser(@PathVariable("userId") int id){
        if(log.isTraceEnabled()){
            log.trace("getUser():获取用户");
        }
        return userService.getUserById(id);
    }

    @GetMapping("username/{userName}")
    public PiaUser getUser(@PathVariable("userName") String name){
        if(log.isTraceEnabled()){
            log.trace("getUser():获取到用户");
        }
        return userService.getUserByName(name);
    }

    /** 注册成功返回注册的对象
     * @param piaUser JSON 表单 包含注册用户所需要的所有信息
     * @return piaUser
     */
    @PostMapping("/signUp")
    public Map<String,PiaUser> createUser(@Valid @RequestBody PiaUser piaUser){
        if (log.isTraceEnabled())
        {
            log.trace("createUser(): 创建用户");
        }

        Map<String,PiaUser> map = new HashMap<>();
        if (userService.createUser(piaUser)){
            map.put("Message",piaUser);
            if (log.isTraceEnabled())
            {
                log.trace("createUser(): 创建成功");
            }
            return map;
        }
        map.put("Error",null);
        if (log.isTraceEnabled())
        {
            log.trace("createUser(): 创建失败");
        }
        return map;
    }
  //org.apache.ibatis.type.EnumOrdinalTypeHandler

}
