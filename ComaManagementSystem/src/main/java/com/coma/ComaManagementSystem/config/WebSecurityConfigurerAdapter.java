package com.coma.ComaManagementSystem.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

public class WebSecurityConfigurerAdapter {

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password("{noop}password") // {noop} is used to indicate no password encoding
                .roles("USER")
                .and()
                .withUser("admin")
                .password("{noop}adminpass")
                .roles("ADMIN");
    }



}
