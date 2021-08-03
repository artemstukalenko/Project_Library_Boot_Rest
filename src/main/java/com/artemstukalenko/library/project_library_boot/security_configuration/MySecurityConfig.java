package com.artemstukalenko.library.project_library_boot.security_configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        auth.jdbcAuthentication().dataSource(dataSource);

        /*auth.inMemoryAuthentication()
                .withUser(userBuilder.username("artem").password("artem").roles("ADMIN"))
                .withUser(userBuilder.username("valera").password("valera").roles("USER"))
                .withUser(userBuilder.username("maria").password("maria").roles("LIBRARIAN"));*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("USER", "ADMIN", "LIBRARIAN")
                .antMatchers("/librarian-entry-page").hasRole("LIBRARIAN")
                .antMatchers("/admin-entry-page").hasRole("ADMIN")
                .and().formLogin().loginPage("/login").permitAll();
    }

}
