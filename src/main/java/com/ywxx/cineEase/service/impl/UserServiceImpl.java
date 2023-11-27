package com.ywxx.cineEase.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.ywxx.cineEase.entity.User;
import com.ywxx.cineEase.entity.dto.LoginFormDTO;
import com.ywxx.cineEase.entity.dto.UserDTO;
import com.ywxx.cineEase.repository.UserRepository;
import com.ywxx.cineEase.utils.RegexUtils;
import com.ywxx.cineEase.utils.Result;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

import java.util.concurrent.TimeUnit;

import static com.ywxx.cineEase.utils.Constants.*;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private IUserService userService;
    @Resource
    private UserRepository userRepository;

    @Override
    public Result sendCode(String phone, HttpSession session) {

        //validate phone
        if (RegexUtils.isPhoneInvalid(phone)) {
            //phone is invalid
            return Result.fail("phone is invalid");
        }
        //if phone is valid, generate code
        String code = RandomUtil.randomNumbers(6);
        //save code to redis
        stringRedisTemplate.opsForValue().set(LOGIN_CODE_KEY + phone, code, LOGIN_CODE_TTL, TimeUnit.MINUTES);
        //send code
        log.debug("success to send code,code: {}", code);
        //return ok
        return Result.ok();
    }

    @Override
    public Result login(@RequestBody LoginFormDTO loginForm, HttpSession session) {
        // implement login logic
        // 1. validate phone
        String phone = loginForm.getPhone();
        if (RegexUtils.isPhoneInvalid(phone)) {
            // 2. if phone is invalid, return error message
            return Result.fail("phone is invalid");
        }
        // 3. validate code
        String cacheCode = stringRedisTemplate.opsForValue().get(LOGIN_CODE_KEY + phone);
        log.info("cacheCode: {}", cacheCode);
        if (cacheCode == null || !cacheCode.equals(loginForm.getCode())) {
            // 4. if code is invalid, return error message
            return Result.fail("code is invalid");
        }
        // 5. if code is valid
        User user = userRepository.findByPhone(phone);
        // 6.check if the user exist
        if (user == null) {
            // 7. if user is not exist, create user
            user = createUserWithPhone(phone);
        }
        // use UUID to create token
        String token = UUID.randomUUID().toString();
        // save  user object as hash map to redis
        UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);
        Map<String, Object> map = BeanUtil.beanToMap(userDTO);
        // String key = "login:user:" + token;
        String key = LOGIN_USER_KEY + token;
        stringRedisTemplate.opsForHash().putAll(key, map);
        // set expire time
        stringRedisTemplate.expire(key, LOGIN_USER_TTL, TimeUnit.SECONDS);
        // if the user is inactive for 30 minutes, the token will expire, indicating that the user has not interacted with the interceptor.
        return Result.ok(token);
    }

    /**
     * create user with phone
     *
     * @param phone
     * @return
     */
    private User createUserWithPhone(String phone) {
        User user = new User();
        user.setPhone(phone);
        user.setName(USER_NAME_PREFIX + RandomUtil.randomString(6));
        return user;
    }
}
