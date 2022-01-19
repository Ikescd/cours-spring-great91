package fr.greta91.coursSpring.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebServiceSecurity extends WebSecurityConfigurerAdapter {

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println(passwordEncoder().encode("user"));
		System.out.println(passwordEncoder().encode("user"));
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
			.withUser("user").password(passwordEncoder().encode("user")).roles("USER")
			.and()
			.withUser("admin").password(passwordEncoder().encode("admin")).roles("USER", "ADMIN");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		super.configure(http);
	}

}
