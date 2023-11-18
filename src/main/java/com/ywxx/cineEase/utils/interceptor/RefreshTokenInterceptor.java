package com.ywxx.cineEase.utils.interceptor;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;

import com.ywxx.cineEase.entity.dto.UserDTO;
import com.ywxx.cineEase.utils.Constants;
import com.ywxx.cineEase.utils.UserHolder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.ywxx.cineEase.utils.Constants.LOGIN_USER_KEY;

// LoginInterceptor is manually registered in Spring, we cannot use @Autowired here
public class RefreshTokenInterceptor implements HandlerInterceptor {
    private StringRedisTemplate stringRedisTemplate;

    public RefreshTokenInterceptor(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // get the token from request header
        String token = request.getHeader("authorization");
        // 1. check if token exists
        if (StrUtil.isBlank(token)) {
            return true;
        }
        // 3. if token exists, get user id from redis, return a hasp map
        Map<Object, Object> map = stringRedisTemplate.opsForHash().entries(LOGIN_USER_KEY + token);
        if (map.isEmpty()) {
            return true;
        }
        // 5. convert map to userDTO
        UserDTO userDTO = BeanUtil.fillBeanWithMap(map, new UserDTO(), false);
        // 6. save userDTO to thread local
        UserHolder.saveUser(userDTO);
        // 7. refresh token expire time
        // if the user is inactive for 30 minutes, the token will expire, indicating that the user has not interacted with the interceptor.
        stringRedisTemplate.expire(LOGIN_USER_KEY + token, Constants.LOGIN_USER_TTL, TimeUnit.SECONDS);
        // 8. if token exists, return true
        return true;
    }

}
