package com.mitkodonev.config;

import com.mitkodonev.authentication.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] PUBLIC_MATCHERS = {
            "/webjars/**",
            "/css/**",
            "/js/**",
            "/images/**",
            "/",
            "/details/**",
            "/checkout",
            "/docheckout",
            "/login",
            "/logout"
    };

    private final CustomAuthenticationProvider authProvider;

    @Autowired
    public SecurityConfig(CustomAuthenticationProvider authProvider) {
        this.authProvider = authProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers(PUBLIC_MATCHERS).permitAll()
                .antMatchers("/weather/**").fullyAuthenticated()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/weather").permitAll()
                .and().logout()
                .deleteCookies("remove")
                .invalidateHttpSession(true)
                .logoutUrl("/logout")
                .logoutSuccessUrl("/logout-success")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }

    @Bean
    public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
    }
}
