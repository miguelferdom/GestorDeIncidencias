package es.urjc.code.gdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserRepositoryAuthenticationProvider authenticationProvider;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {

    	// Public pages
    	http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/loginerror").permitAll();
        http.authorizeRequests().antMatchers("/logout").permitAll();

        // Private pages (all other pages)
        // Antiguo control para páginas privadas si todo funciona con la nueva 
        // expresión borrar estas lineas en siguientes actualizaciones
        //http.authorizeRequests().anyRequest().authenticated();
        
        // Cortamos el acceso a la página /consultarcomentario a usuarios y lo permitimos para técnicos y administradores
        // Cortamos el acceso a la página /nuevousuario a usuarios y tecnicos y lo permitimos solo para administradores
        // el resto de páginas privadas son accesibles con una autenticación válida
        http.authorizeRequests()
        	.antMatchers("/consultarcomentario").access("hasRole('tecnico')")
        	.antMatchers("/nuevousuario").access("hasRole('administrador')")
        	.anyRequest().authenticated();

        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("usuario");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/bienvenida");
        http.formLogin().failureUrl("/loginerror");

        // Logout
        // Las siguientes tres lineas no me funcionan como espero
        //http.logout().logoutUrl("/logout");
        //http.logout().logoutSuccessUrl("/logout");
        //http.logout().invalidateHttpSession(true);
        
        // Encuentro la solución para hacer logout en:
        //https://stackoverflow.com/questions/24108585/spring-security-java-config-not-generating-logout-url
        http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout", "PUT"));
        
        // Disable CSRF at the moment
        //http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	//Database authentication provider
    	auth.authenticationProvider(authenticationProvider);
    }

}
