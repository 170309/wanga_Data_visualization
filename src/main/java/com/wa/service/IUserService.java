package com.wa.service;

import com.wa.common.ServerResponse;
import com.wa.pojo.User;

public interface IUserService {

    ServerResponse<User> login(String name , String password);
    ServerResponse<String> register(User user);
//    ServerResponse<String> updatePassword(String newPasssword);
}
