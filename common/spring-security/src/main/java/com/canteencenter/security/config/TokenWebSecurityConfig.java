package com.canteencenter.security.config;

import com.canteencenter.security.filter.TokenAuthFilter;
import com.canteencenter.security.filter.TokenLoginFilter;
import com.canteencenter.security.security.DefaultPasswordEncoder;
import com.canteencenter.security.security.TokenLogOutHandler;
import com.canteencenter.security.security.TokenManager;
import com.canteencenter.security.security.UnauthorizedEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class TokenWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenManager tokenManager;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private DefaultPasswordEncoder defaultPasswordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                .authenticationEntryPoint(new UnauthorizedEntryPoint())//没有权限访问的执行
                .and()
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .logout().logoutUrl("/admin/acl/index/logout")//设置退出的路径
                .addLogoutHandler(new TokenLogOutHandler(tokenManager, redisTemplate))
                .and()
                .addFilter(new TokenLoginFilter(authenticationManager(), tokenManager, redisTemplate))
                .addFilter(new TokenAuthFilter(authenticationManager(), tokenManager, redisTemplate))
                .httpBasic();
    }

    //调用userDetailService和密码处理
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(defaultPasswordEncoder);
    }

    //不进行认证的路径,可以直接访问
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/api/**");
    }
}
