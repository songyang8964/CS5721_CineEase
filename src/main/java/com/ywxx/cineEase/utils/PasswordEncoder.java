package com.ywxx.cineEase.utils;

import cn.hutool.core.util.RandomUtil;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

public class PasswordEncoder {


    public static String encode(String password) {
        // generate salt
        String salt = RandomUtil.randomString(20);
        // encode
        return encode(password,salt);
    }
    private static String encode(String password, String salt) {
        return salt + "@" + DigestUtils.md5DigestAsHex((password + salt).getBytes(StandardCharsets.UTF_8));
    }
    public static Boolean matches(String encodedPassword, String rawPassword) {
        if (encodedPassword == null || rawPassword == null) {
            return false;
        }
        if(!encodedPassword.contains("@")){
            throw new RuntimeException("the format of Password is wrong");
        }
        String[] arr = encodedPassword.split("@");
        // get salt
        String salt = arr[0];
        // compare
        return encodedPassword.equals(encode(rawPassword, salt));
    }
}