package com.ywxx.cineEase.utils;


import com.ywxx.cineEase.entity.dto.UserDTO;

public class UserHolder {
    private static final ThreadLocal<UserDTO> tl = new ThreadLocal<>();
    // Private constructor to prevent external instantiation with new UserHolder(),
    // making it conform to the Singleton Pattern
//    private UserHolder() {
//    }
    public static void saveUser(UserDTO user){
        tl.set(user);
    }

    public static UserDTO getUser(){
        return tl.get();
    }

    public static void removeUser(){
        tl.remove();
    }
}
