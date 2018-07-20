package com.company.project.configurer.MyInterceptor;

import com.company.project.cache.UserLoginCache;
import com.company.project.core.ResultGenerator;
import com.company.project.model.SysUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Logan on 2018/7/9.
 */
public class ParamInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String token = httpServletRequest.getHeader("X-Token");
        httpServletResponse.setContentType("application/json;charset=UTF-8");

        if ( StringUtils.isEmpty(token) ) {
//            ResultGenerator.genOutResult("token过期");
            httpServletResponse.getWriter().print(ResultGenerator.genSuccessResult("token过期"));
            return false;
        }

        SysUser sysUser = UserLoginCache.getUser(token);

        if (sysUser==null) {
            httpServletResponse.getWriter().print(ResultGenerator.genSuccessResult("用户过期"));
            return false;
        }

        //成功
        httpServletRequest.setAttribute("token", token);
        httpServletRequest.setAttribute("user", sysUser);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
