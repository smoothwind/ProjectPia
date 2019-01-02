package com.rdd.pia.controller;

import com.rdd.pia.model.PiaUser;
import com.rdd.pia.model.UserLoginParams;
import com.rdd.pia.services.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mic
 */
@CrossOrigin(allowCredentials = "false") //jiejue "CORS 头缺少 'Access-Control-Allow-Origin'"
@RestController
@RequestMapping("/Account")
public class AccountController {

    public final static Log log = LogFactory.getLog(AccountController.class);
    @Autowired
    private UserService userService;

    @GetMapping("user/{userId}")
    public PiaUser getUser(@PathVariable("userId") Integer id){
        if(log.isTraceEnabled()){
            log.trace("getUser():获取用户");
        }
        return  userService.getUserById(id);
    }

    @GetMapping(value = "username/{userName}")
    public PiaUser getUser(@PathVariable("userName") String name){
        log.trace("getUser():获取到用户");
        if(log.isTraceEnabled()){
            log.trace("getUser():获取到用户");
        }
        return userService.getUserByName(name);
    }

    /** 注册成功返回注册的对象
     * @param piaUser JSON 表单 包含注册用户所需要的所有信息
     * @return piaUser
     *  //@RequestBody 是将json描述的对象绑定到相应的bean上
     */
    @PostMapping(value = "/signUp")
    public Map<String,Object> createUser(@Valid @RequestBody PiaUser piaUser){
        if (log.isTraceEnabled())
        {
            log.trace("createUser(): 创建用户");
        }

        Map<String,Object> map = new HashMap<>();
        if (userService.createUser(piaUser)){
            map.put("retCode","success");
            map.put("Message",piaUser);
            if (log.isTraceEnabled())
            {
                log.trace("createUser(): 创建成功");
            }
            return map;
        }
        map.put("retCode","false");
        if (log.isTraceEnabled())
        {
            log.trace("createUser(): 创建失败");
        }
        return map;
    }
  // org.apache.ibatis.type.EnumOrdinalTypeHandler
    @GetMapping("/sayhi")
    public String sayHi(){
        return "Hi";
    }

    @PostMapping("/signIn")
    public Map<String,Object> signIn(@RequestBody UserLoginParams userLoginParams){
        Map<String, Object> response = new HashMap<>();
        if(log.isTraceEnabled()){
            log.trace("getUser():获取用户");
        }

        if(userLoginParams.getPassword().trim().equals("") || userLoginParams.getUsername().trim().equals(""))
        {
            response.put("retCode", new String("用户名或密码为空!"));
            return response;
        }

        PiaUser user = userService.getUserByName(userLoginParams.getUsername());

        if(!userLoginParams.getPassword().equals(user.getPassword()) || !userLoginParams.getUsername().equals(user.getUserName())){
            response.put("retCode", new String("用户名或密码错误!"));
            if(log.isTraceEnabled()){
                log.trace("");
            }
            return response;
        }
        response.put("retCode","success");
        response.put("user", user);
        return response;
    }

}
