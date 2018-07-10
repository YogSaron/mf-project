package com.company.project.cache;

import com.company.project.model.SysUser;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Logan on 2018/7/10.
 */
@Component
public class UserLoginCache {

    /**
     * session
     */
    private static Map<String,LoginUser> userLoginMap = new HashMap<>();

    public static SysUser getUser(String token) {

        if (userLoginMap.containsKey(token)) {
            LoginUser loginUser = userLoginMap.get(token);
            long expireTime = Calendar.getInstance().getTime().getTime() + 60*30*1000;
            loginUser.setExpire(expireTime);
            return loginUser.getSysUser();
        }
        return null;
    }

    /**
     * 移除过期的token
     */
    public static void remove() {
        for (Iterator<Map.Entry<String, LoginUser>> it = userLoginMap.entrySet().iterator(); it.hasNext();){
            Map.Entry<String, LoginUser> item = it.next();
            LoginUser value = item.getValue();
            long expire = value.getExpire();
            if (expire < System.currentTimeMillis()){
                userLoginMap.remove(it);
            }
        }
    }
    public static void remove(String token) {

        userLoginMap.remove(token);
    }

    public static void put(String token, SysUser sysUser, long expire ) {
        long expireTime = Calendar.getInstance().getTime().getTime() + expire * 1000;
        LoginUser loginUser = new LoginUser();
        loginUser.setExpire(expireTime);
        loginUser.setSysUser(sysUser);
        userLoginMap.put(token, loginUser);
    }

    /**
     * 设置过期时间
     */
    private static class LoginUser {
        private  long expire;
        private SysUser sysUser;

        public long getExpire() {
            return expire;
        }

        public void setExpire(long expire) {
            this.expire = expire;
        }

        public SysUser getSysUser() {
            return sysUser;
        }

        public void setSysUser(SysUser sysUser) {
            this.sysUser = sysUser;
        }
    }
}
