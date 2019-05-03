package com.hong.qrcode.service;

import com.hong.qrcode.form.UserForm;

public interface UserService {

    void UserRegister(UserForm u) throws Exception;

    Boolean UserLogin(UserForm u) throws Exception;
}
