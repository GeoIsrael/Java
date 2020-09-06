package telran.ashkelon2020.accounting.security.configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import telran.ashkelon2020.accounting.security.service.ExpDateFilter;

//@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityAuthorizationConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/account/register");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.csrf().disable();
		http.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.addFilterAfter(new ExpDateFilter(), BasicAuthenticationFilter.class);
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET).permitAll()
			.antMatchers(HttpMethod.POST, "/forum/posts/**").permitAll()
			.antMatchers("/account/user/{login}/role/{role}**")
				.hasRole("ADMINISTRATOR")
			.antMatchers("/account/login**", "/forum/post/{id}/like**")
				.hasAnyRole("ADMINISTRATOR", "MODERATOR", "USER")
			.antMatchers(HttpMethod.DELETE, "/account/user/{login}**")
				.access("#login==authentication.name")
			.antMatchers(HttpMethod.PUT, "/account/user/{login}**")
				.access("#login==authentication.name and hasAnyRole('ADMINISTRATOR', 'MODERATOR', 'USER')")
			.antMatchers(HttpMethod.DELETE,"/forum/post/{id}**")
				.access("@customSecurity.checkPostAuthority(#id, authentication.name) or hasRole('MODERATOR')")
			.antMatchers(HttpMethod.POST,"/forum/post/{author}**")
				.access("#author==authentication.name and hasAnyRole('ADMINISTRATOR', 'MODERATOR', 'USER')")
			.antMatchers(HttpMethod.PUT,"/forum/post/{id}/comment/{author}**")
				.access("#author==authentication.name and hasAnyRole('ADMINISTRATOR', 'MODERATOR', 'USER')")
			.antMatchers(HttpMethod.PUT,"/forum/post/{id}**")
				.access("@customSecurity.checkPostAuthority(#id, authentication.name) or hasRole('MODERATOR')")			
			.antMatchers("/account/password**")
				.authenticated()
			.anyRequest()
				.authenticated();
		
	}

}
