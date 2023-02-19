package com.mos.author.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mos.author.entity.User;
import com.mos.author.mapper.UsersMapper;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestSecurityDemo {

    @Resource
    UsersMapper usersMapper;

    @Test
    public void test() {
        User user = usersMapper.selectById(1);
        System.out.println("===========================================");
        System.out.println(JSONObject.toJSONString(user));
    }

//    @Test
//    //生成token
//    public void testJwt() throws IOException {
//        JwtBuilder jwtBuilder = Jwts.builder()
//                .setId("888")//唯一id
//                .setSubject("Rose")//接受的用户
//                .setIssuedAt(new Date())//签发时间
//                .signWith(SignatureAlgorithm.HS256, "xxxx");//算法和密钥
//        String token = jwtBuilder.compact();
//        System.out.println("================");
//        System.out.println(token);
//        System.out.println("================");
//        String[] strings = token.split("\\.");
//        System.out.println(Base64Codec.BASE64.decodeToString(strings[0]));
//        System.out.println(Base64Codec.BASE64.decodeToString(strings[1]));
//    }
//    @Test
//    //解析token
//    public void testJwtDE() throws IOException {
//        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiJSb3NlIiwiaWF0IjoxNjQzODY4MzA5fQ.HkA6Bd_SUmTRIXrtZNR17tl9Vq3WXfbfILwNW24TowA";
//        Claims claims = (Claims)Jwts.parser().setSigningKey("xxxx").parse(token).getBody();
//        System.out.println("id:"+claims.getId());
//        System.out.println("sub:"+claims.getSubject());
//        System.out.println("iat:"+claims.getIssuedAt());
//    }
}
