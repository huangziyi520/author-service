package com.mos.author.config;

import com.mos.author.handler.MyAuthenticationFailureHandler;
import com.mos.author.handler.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * 权限配置类
 */
@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler myAccessDeniedHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder getPW(){
        return new BCryptPasswordEncoder();
    }

    //认证
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表单提交
        http.formLogin().loginPage("/login.html").loginProcessingUrl("/loginIndex")
//                .successForwardUrl("/loginSuccess")//登陆成功后跳转的页面
                .successHandler(new MyAuthenticationSuccessHandler("/author-service/main.html"))//使用自定义错误处理器
//                .failureForwardUrl("/toError");//登陆失败跳转页
                .failureHandler(new MyAuthenticationFailureHandler("/author-service/error.html"));//使用自定义错误处理器

        //所有的请求都必须认证访问
        http.authorizeRequests()
                        .antMatchers("/login.html").permitAll()
                        .antMatchers("/main.html").permitAll()
                        .antMatchers("/error.html").permitAll()
                .antMatchers("/author-service/user/*").hasAnyRole("super_admin","admin","sale","normal")
                .anyRequest().authenticated();

        //权限异常处理类
        http.exceptionHandling().accessDeniedPage("/author-service/unauthor.html");
        //关闭csrf防护
            http.csrf().disable();
    }

    //授权
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/oauth/**", "/login/**", "/logout/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .permitAll()
//                .and()
//                .csrf().disable();
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManager();
//    }


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
////        String encode = passwordEncoder.encode("123");
////        auth.inMemoryAuthentication().withUser("lucy").password(encode).roles("admin");
//        auth.userDetailsService(userDetailsService).passwordEncoder(getPW());
//    }
}
