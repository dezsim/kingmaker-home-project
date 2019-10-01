package hu.flowacademy.kingmakerbackend.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AuthConfig extends WebSecurityConfigurerAdapter {

  /*  @Autowired
    private BCryptPasswordEncoder passwordEncoder;*/

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    public void globalUserDetails(final AuthenticationManagerBuilder auth) throws Exception {
        // @formatter:off
       /* auth.inMemoryAuthentication()
                .withUser("john").password(passwordEncoder.encode("123")).roles("USER");
*/
        System.out.println("aaaaa");
        auth.userDetailsService(customUserDetailsService);
    }// @formatter:on

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http.authorizeRequests()
                .antMatchers("/", "/login", "/oauth/**", "/tokens/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().permitAll()
                .and().csrf().disable();
        // @formatter:on
    }

}
