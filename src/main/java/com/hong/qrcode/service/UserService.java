package com.hong.qrcode.service;

import com.hong.qrcode.domain.User;
import com.hong.qrcode.form.UserForm;

import java.util.List;

public interface UserService {

    void UserRegister(UserForm u) throws Exception;

    Boolean UserLogin(UserForm u) throws Exception;

    List<User> GetUserList();
}
