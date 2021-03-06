package com.hong.qrcode.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsForm {

    @NotBlank(message = "goods name can`t be empty")
    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "nums", defaultValue = "0")
    private Integer nums;

    @JsonProperty(value = "price", defaultValue = "0")
    private Integer price;

    @JsonProperty(value = "description")
    private String Description;
}
