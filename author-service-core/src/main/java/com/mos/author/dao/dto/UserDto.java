package com.mos.author.dao.dto;

import lombok.Data;

@Data
public class UserDto extends BaseData{
    //用户状态 1正常 2注销 3冻结 4黑名单
    private int status;
    //用户id
    private int userId;
    //用户角色 2正常用户 3禁言用户 4虚拟用户 5运营
    private int userRole;
    //'注册来源：1手机号 2邮箱 3用户名 4qq 5微信 6腾讯微博 7新浪微博',
    private int registerSource;
    //用户账号，必须唯一
    private String userName;
    //用户昵称
    private String nickName;
    //用户密码
    private String password;
    //用户密码确认
    private String passWordConfirm;
    //'用户性别 0-female 1-male'
    private int gender;
    private String birthDay;
    //用户个人签名
    private String signature;
    //手机号码(唯一)
    private String mobilePhone;
    //手机号码绑定时间
    private String mobileBindTime;
    //邮箱(唯一)
    private String email;
    //邮箱绑定时间
    private String emailBindTime;
    //头像
    private String faceUrl;
    //用户设备push_token
    private String pushToken;
}
