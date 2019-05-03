package com.hong.qrcode.controller;

import com.hong.qrcode.form.UserForm;
import com.hong.qrcode.service.UserService;
import com.hong.qrcode.utils.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResultVO Register(@RequestBody UserForm u) {
        try {
            userService.UserRegister(u);
            return ResultVO.success();

        } catch (Exception e) {
            return ResultVO.error(1, e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResultVO Login(@RequestBody UserForm u) {
        try {
            userService.UserLogin(u);
            return ResultVO.success();

        } catch (Exception e) {
            return ResultVO.error(1, e.getMessage());
        }
    }

    @GetMapping("/test")
    public ResultVO TestConnection() {
        return ResultVO.success("haha");
    }
}

