package main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final UserDetailsService userDetailsService;

  @Autowired
  public SecurityConfig(@Qualifier("userDetailsServiceImpl")
      UserDetailsService userDetailsService) {
    this.userDetailsService = userDetailsService;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/**").permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin().disable()
        .httpBasic();
  }

  @Bean
  protected DaoAuthenticationProvider daoAuthenticationProvider(){
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    daoAuthenticationProvider.setUserDetailsService(userDetailsService);
    return daoAuthenticationProvider;
  }


  @Bean
  protected PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(12);
  }

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
}














//        .antMatchers("/api/post/search&query=test").hasAnyRole("MODERATOR")

  /*
   @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/css/*", "/js/*", "/api/init", "/api/post/*").permitAll()
                .antMatchers("/api/search*").hasAnyRole("MODERATOR")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().disable()
                .httpBasic().disable();
    }
   */




//  @Bean
//  protected UserDetailsService userDetailsService() {
////    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
////    return super.userDetailsService();
////    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    return new InMemoryUserDetailsManager(
//        User.builder()
//            .username("user")
//            .password(passwordEncoder().encode("user"))
////          .roles(Role.USER.toString())
//            .authorities(Role.USER.getAuthorities())
//            .build(),
//        User.builder()
//            .username("moderator")
//            .password(passwordEncoder().encode("moderator"))
////          .roles(Role.MODERATOR.toString())
//            .authorities(Role.MODERATOR.getAuthorities())
//            .build()
//    );
//  }



/*
  @Override
  protected void configure(HttpSecurity http) throws Exception {
//    super.configure(http);
    http
        .csrf().disable()
        .authorizeRequests()
//        .antMatchers("/", "/api/init, /api/post/*").permitAll()
//        .antMatchers("/", "/api/login").permitAll()
//        .antMatchers("/", "/css/*", "/js/*", "/api/init", "/api/post/*").permitAll()
//----------++++++++++        .antMatchers("/", "/css/*", "/js/*", "/api/init", "/api/**").permitAll()
        .antMatchers("/**").permitAll()
//        .antMatchers("/api/search*").hasAnyRole("MODERATOR")
//        .antMatchers("/", "/api/post").permitAll()
//        .antMatchers(HttpMethod.GET, "/api/post/*").hasAnyRole(Role.USER.toString(), Role.MODERATOR.toString())
//        .antMatchers(HttpMethod.GET, "/api/post/*").hasAuthority(Permission.USER.getPermission())
//        .antMatchers("/api/post/search*").hasAnyRole("MODERATOR")
//        .antMatchers(HttpMethod.GET, "/api/search*").hasAnyRole(Role.MODERATOR.toString())
//        .antMatchers(HttpMethod.GET, "/api/search*").hasAuthority(Permission.MODERATE.getPermission())
        .anyRequest()
        .authenticated()
        .and()
//        .formLogin().permitAll()
        .formLogin().disable()
//        .and()
        .httpBasic();
//        .httpBasic().disable();

  }
 */