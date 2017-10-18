package pe.infounsa.siaa.business.impl.seguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.infounsa.siaa.business.exception.BusinessException;
import pe.infounsa.siaa.business.seguridad.GestionarUsuarioBusiness;
import pe.infounsa.siaa.business.seguridad.dto.UsuarioAdminDto;
import pe.infounsa.siaa.business.seguridad.dto.UsuarioDto;
import pe.infounsa.siaa.business.seguridad.exception.UsuarioDuplicadoException;
import pe.infounsa.siaa.business.seguridad.exception.UsuarioException;
import pe.infounsa.siaa.dataaccess.seguridad.UsuarioDao;

@Service
public class GestionarUsuarioBusinessImpl implements GestionarUsuarioBusiness{

	@Autowired
	private UsuarioDao usuarioDao;
		
	@Override
	public UsuarioDto ingresarUsuario(UsuarioAdminDto usuario) throws BusinessException {
		
		UsuarioDto usuarioDuplicado = usuarioDao.getUsuariobyUsuario(usuario.getUsuario());
		if (usuarioDuplicado == null ) {
			usuario.setContrasena(new EncryptMD5().cryptMD5(usuario.getContrasena()));
			return usuarioDao.saveUsuario(usuario);
			
		} else {
			
			throw new UsuarioDuplicadoException("00000","exception.usuario.nombre.duplicado");
		}
	}

	@Override
	public List<UsuarioDto> obtenerUsuarios() {
		// TODO Auto-generated method stub
		return usuarioDao.getAllUsuario();
	}

	@Override
	public void cambiarEstadoUsuario(Integer codigoUsuario,Integer estado) {
		// TODO Auto-generated method stub
		usuarioDao.changeEstadoUsuario(codigoUsuario,estado);
	}

	@Override
	public UsuarioDto editarUsuario(UsuarioAdminDto usuario) throws BusinessException {

		UsuarioDto usuarioDto= usuarioDao.getUsuarioCodigo(usuario.getCodigo());
		
		if (usuarioDto != null ) {
			
			if(usuario.getUsuario().equals(usuarioDto.getUsuario())){
				usuario.setContrasena(new EncryptMD5().cryptMD5(usuario.getContrasena()));
				return usuarioDao.saveUsuario(usuario);
			}else{
				
				UsuarioDto usuarioDuplicado = usuarioDao.getUsuariobyUsuario(usuario.getUsuario());
				if (usuarioDuplicado == null ) {
					usuario.setContrasena(new EncryptMD5().cryptMD5(usuario.getContrasena()));
					return usuarioDao.saveUsuario(usuario);
					
				} else {
					
					throw new UsuarioDuplicadoException("00000","exception.usuario.nombre.duplicado");
				}
			}
					
		} else {
			
			throw new UsuarioException("00000","exception.usuario.usuario.existe");
		}
		
	}

	@Override
	public UsuarioDto obtenerUsuario(Integer codigo) {
		// TODO Auto-generated method stub
		return usuarioDao.getUsuarioCodigo(codigo);
	}

	@Override
	public UsuarioDto cambiarPasswordUsuario(UsuarioAdminDto usuario,String password) throws BusinessException {
		
		UsuarioAdminDto usuarioAdminDto = usuarioDao.getUsuarioAdminByCodigo(usuario.getCodigo());
		
		if(usuarioAdminDto != null){
			if(!usuarioAdminDto.getContrasena().equals(new EncryptMD5().cryptMD5(password)))
				throw new UsuarioException("", "bad password");
			usuario.setContrasena(new EncryptMD5().cryptMD5(usuario.getContrasena()));
			return usuarioDao.cambiarUsuarioPasswrod(usuario);
			
		}else
			throw new UsuarioException("", "exception.usuario.usuario.existe");
	} 
	
	public UsuarioDto loginUsuario(String user, String password) throws BusinessException {
		// TODO Auto-generated method stub
		UsuarioAdminDto usuario = usuarioDao.getUsuarioAdminByName(user);
		
		if(usuario==null)
			throw new UsuarioException("002","exception.sinautorizacion"); 
		String cryptpassword = new EncryptMD5().cryptMD5(password);
		if(usuario.getContrasena().equals(cryptpassword) && usuario.getActivo().equals((byte)1)){
			//Calendar cal = Calendar.getInstance();
			//usuario.setTimesession(cal.getTime().getTime());
			usuario.setContrasena(null);
			return usuario;
		}else
			throw new UsuarioException("002","exception.sinautorizacion");
			
	}
	
	@Override
	public void eliminarUsuario(Integer codUsuario) {
		// TODO Auto-generated method stub
		usuarioDao.deleteUsuario(codUsuario);
	}	
	
}
