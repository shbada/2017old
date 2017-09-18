package com.flowershop.login.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@ComponentScan("example")
@Configuration
@EnableWebSecurity  //웹보안 설정
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig  extends WebSecurityConfigurerAdapter{


    @Autowired
    DataSource dataSource;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Autowired
    private UserDetailService userDetailService;
	
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws  Exception {
        http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login")
                .loginProcessingUrl("/login").failureUrl("/login?error=true").successHandler(loginSuccessHandler)
                .usernameParameter("username").passwordParameter("password").permitAll().and().logout().deleteCookies("remove")
                .invalidateHttpSession(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").and().csrf().disable();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailService);
        return authenticationProvider;
    }


    
}
