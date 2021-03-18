package com.example.springboot.config;
import com.example.springboot.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private IAppUserService appUserService;
//    @Bean
//    public UserDetailsService userDetailsServiceƠ(){
//        User.UserBuilder userBuilder=User.withDefaultPasswordEncoder();
//        InMemoryUserDetailsManager memoryUserDetailsManager=new InMemoryUserDetailsManager();
//        memoryUserDetailsManager.createUser(userBuilder.username("tung").password("123456").roles("USER").build());
//        memoryUserDetailsManager.createUser(userBuilder.username("lee").password("123456").roles("ADMIN").build());
//        return memoryUserDetailsManager;
//    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService((UserDetailsService)appUserService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/home").permitAll()
                .and()
                .authorizeRequests().antMatchers("/category").hasRole("USER")
                .and()
                .authorizeRequests().antMatchers("/products").hasRole("ADMIN")
                .and()
                .formLogin()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
        http.csrf().disable();
    }
}
