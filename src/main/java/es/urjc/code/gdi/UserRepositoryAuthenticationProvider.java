package es.urjc.code.gdi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private RepositorioCrudUsuario repoCrudUsuarios;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		//System.out.println("[UserRepositoryAuthenticationProvider] He entrado en el método para autenticar a un usuario!!! ");
		
		Usuario user = repoCrudUsuarios.findByNombre(authentication.getName());
		
		if (user == null) {
			throw new BadCredentialsException("[UserRepositoryAuthenticationProvider] Usuario no encontrado");
		}

		String password = (String) authentication.getCredentials();
		//System.out.println("[UserRepositoryAuthenticationProvider] user nombre: " + user.getNombre());
		//System.out.println("[UserRepositoryAuthenticationProvider] password user: " + user.getPassword());
		//System.out.println("[UserRepositoryAuthenticationProvider] vble password: " + password);
		
		if (!new BCryptPasswordEncoder().matches(password, user.getPassword())) {
			throw new BadCredentialsException("[UserRepositoryAuthenticationProvider] Password erronea!");
		}

		List<GrantedAuthority> roles = new ArrayList<>();

		for (String role : user.getPerfiles()) {
			roles.add(new SimpleGrantedAuthority(role));
		}

		return new UsernamePasswordAuthenticationToken(user.getNombre(), password, roles);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
