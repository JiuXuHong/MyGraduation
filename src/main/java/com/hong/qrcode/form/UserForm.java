package com.hong.qrcode.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class UserForm {

    @NotBlank(message = "username can`t be empty")
    @JsonProperty(value = "username")
    String username;

    @NotBlank(message = "password can`t be empty")
    @JsonProperty(value = "password")
    String password;
}
