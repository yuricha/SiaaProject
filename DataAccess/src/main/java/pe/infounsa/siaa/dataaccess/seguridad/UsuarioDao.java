package pe.infounsa.siaa.dataaccess.seguridad;

import java.util.List;

import pe.infounsa.siaa.business.seguridad.dto.UsuarioAdminDto;
import pe.infounsa.siaa.business.seguridad.dto.UsuarioDto;

public interface UsuarioDao {
	
	public UsuarioDto saveUsuario(UsuarioAdminDto usuario);
	public List<UsuarioDto> getAllUsuario();
	public void changeEstadoUsuario(Integer codigoUsuario,Integer estado );
	public UsuarioDto getUsuarioCodigo(Integer codigoUsuario);
	public UsuarioDto getUsuariobyUsuario(String user);
	
	public UsuarioAdminDto getUsuarioAdminByName(String username);
	public UsuarioAdminDto getUsuarioAdminByCodigo(Integer codigoUsuario);
	
	public UsuarioDto cambiarUsuarioPasswrod(UsuarioAdminDto usuario);
	
	public void deleteUsuario(Integer codUsuario);
	public UsuarioDto cambiarPermisosAccesoSistemaUsuario(UsuarioDto usuario);

}
