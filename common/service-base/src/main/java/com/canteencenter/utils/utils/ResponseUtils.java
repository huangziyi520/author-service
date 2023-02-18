package com.canteencenter.utils.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtils {
    private static final Log log = LogFactory.getLog(ResponseUtils.class);

    public static void out(HttpServletResponse response, Result result) {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        try {
            objectMapper.writeValue(response.getWriter(), result);
        } catch (IOException e) {
            log.warn("输出异常，e={}", e);
        }

    }
}
