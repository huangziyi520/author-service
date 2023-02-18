package com.mos.author.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private final String forwardUrl;

    public MyAuthenticationFailureHandler(String forwardUrl) {
        this.forwardUrl = forwardUrl;
    }


    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletRequest.setAttribute("SPRING_SECURITY_LAST_EXCEPTION", e);
        httpServletResponse.sendRedirect(forwardUrl);
    }
}
