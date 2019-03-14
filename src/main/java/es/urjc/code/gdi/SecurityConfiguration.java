package es.urjc.code.gdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserRepositoryAuthenticationProvider authenticationProvider;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {

    	// Public pages
    	http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/bienvenida").permitAll();
        //http.authorizeRequests().antMatchers("/portaltecnico").permitAll();
        http.authorizeRequests().antMatchers("/loginerror").permitAll();
        http.authorizeRequests().antMatchers("/logout").permitAll();

        // Private pages (all other pages)
        http.authorizeRequests().anyRequest().authenticated();

        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("usuario");
        http.formLogin().passwordParameter("password");
        //http.formLogin().passwordParameter("perfil");
        http.formLogin().defaultSuccessUrl("/bienvenida");
        http.formLogin().failureUrl("/loginerror");

        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/logout");

        // Disable CSRF at the moment
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	//Database authentication provider
    	auth.authenticationProvider(authenticationProvider);
    }
    
    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    	// User
        auth.inMemoryAuthentication().withUser("user").password("pass").roles("USER");
    }*/
}
