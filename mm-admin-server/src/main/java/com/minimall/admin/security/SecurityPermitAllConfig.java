package com.minimall.admin.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author yanxubin
 * @Description
 * @date:2019/8/13
 * @mail yxb_825@163.com
 */
@Profile("insecure")
@Configuration
public class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests().anyRequest().permitAll().
               and().csrf().disable();
    }
}
