package com.canteencenter.security.security;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenManager {

    //1根据用户名生成token
    private long tokenEcpiration = 24 * 60 * 60 * 1000;
    //编码的密钥
    private String tokenSignKey = "123456";

    public String createToken(String username) {
        String token = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + tokenEcpiration))//设置过期时间
                .signWith(SignatureAlgorithm.HS512, tokenSignKey)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }

    //2根据token字符串得到用户信息
    public String getUserInfoFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(tokenSignKey)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    public void removeToken(String token) {
        //jwtToken无需删除，客户端扔掉即可
    }
}
