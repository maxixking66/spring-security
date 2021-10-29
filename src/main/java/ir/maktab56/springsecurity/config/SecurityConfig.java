package ir.maktab56.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        InMemoryUserDetailsManager userDetailsService =
                new InMemoryUserDetailsManager();

        UserDetails userDetails = User
                .withUsername("ali")
                .password("erfagh")
                .authorities("read")
                .build();

        userDetailsService.createUser(userDetails);

        auth.userDetailsService(userDetailsService);

        auth.inMemoryAuthentication()
                .withUser("milad")
                .password("123456")
                .authorities("read")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());

        *//*auth.authenticationProvider();*//*
    }*/

    /*@Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsService =
                new InMemoryUserDetailsManager();

        userDetailsService.createUser(User
                .withUsername("ali")
                .password("erfagh")
                .authorities("read")
                .build());
        userDetailsService.createUser(User
                .withUsername("milad")
                .password("123456")
                .authorities("read")
                .build());

        return userDetailsService;
    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated();
//        http.authorizeRequests().anyRequest().denyAll();
/*        http.authorizeRequests().anyRequest()
                .hasAuthority("delete");  */
        /*http.authorizeRequests().anyRequest()
                .hasAnyAuthority("delete", "read");*/
/*        http.authorizeRequests().anyRequest()
                .access("hasAnyAuthority('delete')");*/
        /*http.authorizeRequests().anyRequest()
                .hasRole("ROLE_ADMIN");*/

        http.authorizeRequests()
                .mvcMatchers("/admin")
                .hasRole("ADMIN")
                .mvcMatchers("/manager")
                .hasRole("MANAGER")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();

        http.httpBasic();
        http.formLogin();
    }
}