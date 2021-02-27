package main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
//    super.configure(http);
    http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/", "/api/init").permitAll()
//        .antMatchers("/", "/api/post").permitAll()
        .antMatchers("/api/post/*").hasAnyRole("USER")
//        .antMatchers("/api/post/search*").hasAnyRole("MODERATOR")
        .antMatchers("/api/search*").hasAnyRole("MODERATOR")
    .anyRequest()
    .authenticated()
    .and()
    .formLogin().permitAll()
    .and()
    .httpBasic();

  }
//        .antMatchers("/api/post/search&query=test").hasAnyRole("MODERATOR")

  @Bean
  protected UserDetailsService userDetailsService(){
//    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    return super.userDetailsService();
//    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
  return new InMemoryUserDetailsManager(
      User.builder()
          .username("user")
          .password(passwordEncoder().encode("user"))
          .roles("USER")
          .build(),
      User.builder()
          .username("moderator")
          .password(passwordEncoder().encode("moderator"))
          .roles("MODERATOR")
          .build()
      );
  }

  @Bean
  protected PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder(12);
  }

}
