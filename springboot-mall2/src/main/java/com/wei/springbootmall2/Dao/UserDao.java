package com.wei.springbootmall2.Dao;

import com.wei.springbootmall2.dto.UserRegisterRequest;
import com.wei.springbootmall2.model.User;

public interface UserDao {

    User getUserById(Integer userId);
    User getUserByEmail(String email);
    Integer createUser(UserRegisterRequest userRegisterRequest);
}
