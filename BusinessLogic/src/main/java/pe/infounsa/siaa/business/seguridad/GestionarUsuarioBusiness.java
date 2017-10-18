package pe.infounsa.siaa.business.seguridad;

import java.util.List;

import pe.infounsa.siaa.business.exception.BusinessException;
import pe.infounsa.siaa.business.seguridad.dto.UsuarioAdminDto;
import pe.infounsa.siaa.business.seguridad.dto.UsuarioDto;

public interface GestionarUsuarioBusiness {

	public UsuarioDto ingresarUsuario(UsuarioAdminDto usuario)throws BusinessException ;
	public List<UsuarioDto> obtenerUsuarios();
	public void cambiarEstadoUsuario(Integer codigoUsuario,Integer estado);
	public UsuarioDto editarUsuario(UsuarioAdminDto usuario)throws BusinessException;
	public UsuarioDto obtenerUsuario(Integer codigo);
	public UsuarioDto cambiarPasswordUsuario(UsuarioAdminDto usuario,String password)throws BusinessException;
		
	public UsuarioDto loginUsuario(String user, String password) throws BusinessException;
	
	public void eliminarUsuario(Integer codUsuario);
	
}
