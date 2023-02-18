package com.mos.author.config;

//import com.mos.author.oauth2.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

//授权服务器
//@Configuration
//@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

//    @Autowired
//    private MyUserDetailService myUserDetailService;
//    @Bean
//    public PasswordEncoder getPW(){
//        return new BCryptPasswordEncoder();
//    }


//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.authenticationManager(authenticationManager).userDetailsService(myUserDetailService);
//    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()//放在内存里面
                .withClient("client")//客户端id
                .secret(passwordEncoder.encode("112233"))//密钥
                .redirectUris("http://www.baidu.com")//重定向地址
                .scopes("all")//授权范围
                /**
                 *authorization_code：授权码模式
                 * password：密码模式
                 */
                .authorizedGrantTypes("authorization_code","password");//授权类型
    }
}
