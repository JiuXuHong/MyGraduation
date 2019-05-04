package com.hong.qrcode.service.impl;

import com.hong.qrcode.domain.User;
import com.hong.qrcode.form.UserForm;
import com.hong.qrcode.repository.UserRepository;
import com.hong.qrcode.service.UserService;
import com.hong.qrcode.utils.Encryption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void UserRegister(UserForm user) throws Exception {

        if (userRepository.findByUsername(user.getUsername()) != null) {
            log.error("this username: " + user.getUsername() + "has been registered");
            throw new Exception("this username " + user.getUsername() + "has been registered");
        }
        String np;
        try {
            np = Encryption.getMD5Str(user.getPassword());
        } catch (Exception e) {
            log.debug("use original password storage ");
            np = user.getPassword();
        }

        userRepository.save(new User(null, user.getUsername(), np));
    }

    @Override
    public Boolean UserLogin(UserForm u) throws Exception {
        User ud = userRepository.findByUsername(u.getUsername());
        if (ud == null) {
            log.error("this user: " + u.getUsername() + "has not been registered");
            throw new Exception("this user: " + u.getUsername() + "has not been registered");
        }

        String np;
        try {
            np = Encryption.getMD5Str(u.getPassword());
            return np.equals(ud.getPassword());
        } catch (Exception e) {
            return ud.getPassword().equals(u.getPassword());
        }
    }

    @Override
    public List<User> GetUserList() {
        return userRepository.findAll();
    }
}
