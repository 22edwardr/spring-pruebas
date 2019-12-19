package com.bolsadeideas.springboot.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bolsadeideas.springboot.app.auth.filter.JWTAuthenthicationFilter;
import com.bolsadeideas.springboot.app.auth.filter.JWTAuthorizationFilter;
import com.bolsadeideas.springboot.app.auth.handler.LoginSuccessHandler;
import com.bolsadeideas.springboot.app.models.service.JpaUserDetailsService;


@EnableGlobalMethodSecurity(securedEnabled=true,prePostEnabled=true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private LoginSuccessHandler successHandler;
	@Autowired
	private BCryptPasswordEncoder passwordEncorder;
	@Autowired
	private DataSource datasource;
	@Autowired
	private JpaUserDetailsService userDetailsService;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","/css/**","/js/**","/images/**","/listar**","/locale").permitAll()
		//.antMatchers("/ver/**").hasAnyRole("USER")
		.anyRequest().authenticated()
		/*.and()
		.formLogin().
		successHandler(successHandler).
		loginPage("/login").permitAll()
		.and()
		.logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/error_403")*/
		.and()
		.addFilter(new JWTAuthenthicationFilter(authenticationManager()))
		.addFilter(new JWTAuthorizationFilter(authenticationManager()))
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
		/*PasswordEncoder encoder = passwordEncorder;
		UserBuilder users = User.builder().passwordEncoder(encoder::encode);
		
		//Autentificacion en memoria
		 * 
		 * 
		 * 
		 * 
		builder.inMemoryAuthentication()
		.withUser(users.username("admin").password("12345").roles("ADMIN","USER"))
		.withUser(users.username("andres").password("12345").roles("USER"));
		
		
		//Autentificacion jdbc
		 * 
		 * 
		 * 
		 * 
		builder.jdbcAuthentication().dataSource(datasource).passwordEncoder(passwordEncorder)
		.usersByUsernameQuery("select username,password, enabled from users where username=?")
		.authoritiesByUsernameQuery("select u.username, a.authority from authorities a inner join users u on a.user_id = u.id where u.username = ?");
		
		
		//Autentificacion Jpa
		 * 
		 * 
		 * 
		 * 
		*/
		
		builder.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncorder);
		
		
	}
}