package com.ywxx.cineEase.service;

import com.ywxx.cineEase.entity.dto.LoginFormDTO;
import com.ywxx.cineEase.utils.Result;
import jakarta.servlet.http.HttpSession;

public interface IUserService {
    Result sendCode(String phone, HttpSession session);

    Result login(LoginFormDTO loginForm, HttpSession session);
}
