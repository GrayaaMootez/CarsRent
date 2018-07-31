package com.cars.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyAppUserDetailsService myAppUserDetailsService;

	@Autowired
	CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/client/**").hasRole("USER")
		.and().formLogin()  //login configuration
        .loginPage("/login")
        .usernameParameter("user")
        .passwordParameter("psw")
        .successHandler(customizeAuthenticationSuccessHandler)
		.and().logout()    //logout configuration
		.logoutUrl("/logout")
		.logoutSuccessUrl("/login").and()
        .exceptionHandling().accessDeniedHandler(accessDeniedHandler);


	}
    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(myAppUserDetailsService).passwordEncoder(passwordEncoder);
	}
}