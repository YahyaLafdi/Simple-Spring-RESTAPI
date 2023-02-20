package com.testwebapp.configuration;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SpringSecurityConfig  {


    @Bean

            public DataSource dataSource() {
                DriverManagerDataSource dataSource = new DriverManagerDataSource();
                dataSource.setDriverClassName("com.mysql.jdbc.Drive");
                dataSource.setUrl("jdbc:mysql://localhost:3306/customersb?useSSL=false");
                dataSource.setUsername("root");
                dataSource.setPassword("root");
                return dataSource;
            }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeHttpRequests()
                .antMatchers("/Customer/**")
                //.hasRole("USER")
                //.anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .logout().permitAll()
                .deleteCookies("JSESSIONID")

                .and()
                .httpBasic(withDefaults());

        return http.build();
    }


    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USERs")
                .build();
        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("yahya")
                .password("yahya")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user,user2);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource())
                .usersByUsernameQuery("select username,email"
                        + "from  customersb.customer_users "
                        + "where username = ?")
                .authoritiesByUsernameQuery("select email "
                        + "from  customersb.customer_users "
                        + "where email = ?");
    }
}
