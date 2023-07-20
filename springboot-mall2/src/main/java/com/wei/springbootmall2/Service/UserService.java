package com.wei.springbootmall2.Service;

import com.wei.springbootmall2.dto.UserLoginRequest;
import com.wei.springbootmall2.dto.UserRegisterRequest;
import com.wei.springbootmall2.model.User;

public interface UserService {
    User getUserById(Integer userId);
    Integer register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);
}
