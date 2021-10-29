package ir.maktab56.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*InMemoryUserDetailsManager userDetailsService =
                new InMemoryUserDetailsManager();

        UserDetails userDetails = User
                .withUsername("ali")
                .password("erfagh")
                .authorities("read")
                .build();

        userDetailsService.createUser(userDetails);

        auth.userDetailsService(userDetailsService);*/

        auth.inMemoryAuthentication()
                .withUser("milad")
                .password("123456")
                .authorities("read")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    /*@Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsService =
                new InMemoryUserDetailsManager();

        UserDetails userDetails = User
                .withUsername("ali")
                .password("erfagh")
                .authorities("read")
                .build();

        userDetailsService.createUser(userDetails);

        return userDetailsService;
    }*/

    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated();
        http.httpBasic();
        http.formLogin();
    }
}