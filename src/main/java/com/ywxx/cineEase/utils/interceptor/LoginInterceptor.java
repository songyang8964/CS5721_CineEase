package com.ywxx.cineEase.utils.interceptor;


import com.ywxx.cineEase.entity.dto.UserDTO;
import com.ywxx.cineEase.utils.UserHolder;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * login interceptor, implement HandlerInterceptor
 */
public class LoginInterceptor implements HandlerInterceptor {
    //

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1. Check if interception is needed
        // check if used is exist in threadLocal
        UserDTO userDTO = UserHolder.getUser();
        if (userDTO != null) {
            // user exist, no need to intercept
            return true;
        } else {
            response.setStatus(401);
            return false;
        }
    }
}
