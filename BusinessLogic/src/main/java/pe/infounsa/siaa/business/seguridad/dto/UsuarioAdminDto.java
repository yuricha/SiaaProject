/**
 * 
 */
package pe.infounsa.siaa.business.seguridad.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author 
 *
 */
@SuppressWarnings("serial")
public class UsuarioAdminDto extends UsuarioDto implements UserDetails {
 
	private String contrasena;
	
	
	public UsuarioAdminDto(){}

	public UsuarioAdminDto(String username, String password, PerfilDto perfiles) {
		usuario = username;
		contrasena = password;
		perfil = perfiles;
	}
	
	

//	@Override
//	public List<PerfilDto> getAuthorities() {
//		// TODO Auto-generated method stub
//		return usuariosPerfil;
//	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return contrasena;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

}
