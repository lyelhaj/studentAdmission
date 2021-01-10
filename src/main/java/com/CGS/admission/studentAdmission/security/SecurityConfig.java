package com.CGS.admission.studentAdmission.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception{
PasswordEncoder passwordEncoder=passwordEncoder();
auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select username as principal, password as credentials, enabled from F_USERS where username=?")
        .authoritiesByUsernameQuery("select user_id, role_id from users_rules where use=?")
.passwordEncoder(passwordEncoder);

        System.out.println(passwordEncoder);

    }


    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.formLogin().loginPage("/login");
        http.authorizeRequests().antMatchers("/admin/**","/save**/**","/delete**/**","/from**/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/user/**","/login","/css/**","/addUser","/register").permitAll();
        http.exceptionHandling().accessDeniedPage("/notAthorized");
        http.authorizeRequests().anyRequest().authenticated();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();

    }

}
