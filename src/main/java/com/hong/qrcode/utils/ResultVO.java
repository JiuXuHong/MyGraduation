package com.hong.qrcode.utils;

import lombok.Data;

@Data
public class ResultVO<T> {

    // status code
    private Integer code;

    // result message
    private String msg;

    // result data
    private T data;


    public static ResultVO success(Object obj) {
        ResultVO resultVO = new ResultVO<>();
        resultVO.setData(obj);
        resultVO.setCode(0);
        resultVO.setMsg("success");
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
