package com.rdd.pia.services;


import com.rdd.pia.model.PiaUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
 * @author mic
 */
public class TokenService {
    private final static Log log = LogFactory.getLog(TokenService.class);
    //一般是把token和用户对应关系放置在数据库或高速缓存(例如readis/memcache等),放在一个单例的成员变量里只适合很小规模的情形
    //TODO: 采用redis缓存方案改写token存储方案
    private Map<String, UserDetails> tokenMap = new HashMap<>();
    @Autowired
    private UserService userService;


    /**
     * TODO 一般为了提高效率应该使用@Cacheable注解缓存。
     * @param token
     * @return
     */
    public UserDetails getUserFromToken(String token){
        if(token == null){
            return null;
        }
        return tokenMap.get(token);
    }

    //TODO ： 请改写
    public String login(String userName, String password){
        UserDetails ud = null;

        //此例中支持三个用户:author/admin/reader 密码都是 password;
        // author 具有author角色; reader具有reader角色； admin则2个角色都有。
        /*if("author".equals(userName) && "password".equals(password))
        {
            ud = createUser(userName,password,new String[]{"author"});
        } else if ("reader".equals(userName) && "password".equals(password)){
            ud = createUser(userName,password,new String[]{"reader"});
        } else if ("admin".equals(userName) && "password".equals(password)) {
            ud = createUser(userName,password,new String[]{"author","reader"});
        }*/
        //按照名称查找用户
        PiaUser piaUser = userService.getUserByName(userName);

        if(log.isTraceEnabled()){
            log.trace(piaUser);
        }
        //todo:改写密码认证方式
        if (piaUser != null && piaUser.getPassword().equals(password))
        {
            ud =  createUser(userName,password,new String[]{"qurey"});
            if(log.isTraceEnabled()){
                log.trace(ud.toString());
            }
        }

        if(ud != null){
            String token = UUID.randomUUID().toString();
            tokenMap.put(token, ud);
            return token;
        }
        return null;
    }

    public void logout(String token){

        tokenMap.remove(token);
    }

    public UserDetails createUser(String userName, String password, String[] roles){
        return new UserDetails() {
            private static final  long serialVersionUID = 6905138725952656074L;
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

                //这是增加了一种名为query的权限 可以使用@hasAuthority("query")来判断
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority("query");
                authorities.add(authority);

                //添加到xxx角色，可以使用hasRole("xxx")来判断；
                // 需要注意所有的角色在这里增加时都必须以ROLE_作为前缀
                // 使用时则没有ROLE_前缀
                for (String role: roles){
                    SimpleGrantedAuthority sga = new SimpleGrantedAuthority("ROLE_"+role);
                    authorities.add(sga);
                }
                return authorities;
            }
            @Override
            public String getPassword() {
                return null;
            }

            @Override
            public String getUsername() {
                return null;
            }

            @Override
            public boolean isAccountNonExpired() {
                return false;
            }

            @Override
            public boolean isAccountNonLocked() {
                return false;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return false;
            }

            @Override
            public boolean isEnabled() {
                return false;
            }
        };
    }
}
