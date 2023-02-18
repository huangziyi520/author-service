package com.canteencenter.utils.exceptionHanler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalExceptionHandler {

    private Integer code;
    private String error;
}
