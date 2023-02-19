package com.mos.author.mapper;

import com.alibaba.fastjson.JSON;
import com.mos.author.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersMapperTest {

    @Resource
    UsersMapper usersMapper;

    @Test
    public void test01(){
        User user = usersMapper.selectById(1);
        System.out.println("=================");
        System.out.println(JSON.toJSONString(user));
    }

}
