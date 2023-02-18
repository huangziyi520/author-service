package com.mos.author.entity;

import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.List;

@Data
public class MyUser extends User{
    private Integer departmentId;   //  举个例子，部门ID

    private String mobile;  //  举个例子，假设我们想增加一个字段，这里我们增加一个mobile表示手机号

    public MyUser(String userName, String encode, List<SimpleGrantedAuthority> authorityList) {
        super(userName,encode,authorityList);
    }
}
