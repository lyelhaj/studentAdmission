package com.CGS.admission.studentAdmission.config;

import com.CGS.admission.studentAdmission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfigurartion extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth=new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{



        http
                .authorizeRequests()
                .antMatchers("/view**/**").hasAnyAuthority("USER","TEACHER","ADMIN","PROGADMIN")
                .antMatchers("/tupdate","/tsave").hasAnyAuthority("TEACHER","ADMIN")
                .antMatchers("/updateCourse","deleteCourse").hasAnyAuthority("PROGADMIN","ADMIN")
                .antMatchers("/registration**/**","/save**/**","/delete**/**","/add**/**","/update**/**").hasAuthority("ADMIN")
                .antMatchers("/", "/js/**", "/css/**", "/img/**","/webjars/**").permitAll()
                .anyRequest().authenticated()


                .and()
                .formLogin().loginPage("/login").permitAll()
                .and().logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
//        .and()
//        .exceptionHandling().accessDeniedPage("/notAuthorized");
    }

}
