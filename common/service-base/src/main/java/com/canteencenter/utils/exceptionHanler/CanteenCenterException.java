package com.canteencenter.utils.exceptionHanler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CanteenCenterException extends RuntimeException {
    private Integer code;//状态码
    private String msg;//异常信息
}
