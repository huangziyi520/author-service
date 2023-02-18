package com.canteencenter.utils.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Result {

    private Boolean success;
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    private Result() {
    }

    //成功的静态方法
    public static Result ok() {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(20001);
        result.setMessage("失败");
        return result;
    }

    public Result data(String key, Object value) {
        data.put(key, value);
        return this;
    }

}
