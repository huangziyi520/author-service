package com.canteencenter.security.security;

import com.canteencenter.utils.utils.ResponseUtils;
import com.canteencenter.utils.utils.Result;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//退出处理器
public class TokenLogOutHandler implements LogoutHandler {

    private TokenManager tokenManager;
    private RedisTemplate redisTemplate;

    public TokenLogOutHandler(TokenManager tokenManager, RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.tokenManager = tokenManager;
    }

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        //1 从header里面获取token
        //2 token不为空，移除token，从redis删除token
        String token = httpServletRequest.getHeader("token");
        if (token != null) {
            //移除
            tokenManager.removeToken(token);
            //从token获取用户名
            String username = tokenManager.getUserInfoFromToken(token);
            redisTemplate.delete(username);
        }
        ResponseUtils.out(httpServletResponse, Result.ok());
    }
}
