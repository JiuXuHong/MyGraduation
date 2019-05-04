package com.hong.qrcode.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {

    @NotBlank(message = "username can`t be empty")
    @JsonProperty(value = "username")
    String username;

    @NotBlank(message = "password can`t be empty")
    @JsonProperty(value = "password")
    String password;
}
